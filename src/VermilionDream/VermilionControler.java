package VermilionDream;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.UserMentionEntity;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

public class VermilionControler implements Initializable {

	private static VermilionControler instance;
	public static VermilionControler getInstance(){
		return instance;
	}

	private static AsyncTwitter vtwitter;
	private static TwitterStream stwitter;

	/**
	 * 時間でソートするための奴
	 */
	private static final Comparator<Status> comp = new Comparator<Status>() {

		@Override
		public int compare(Status o1, Status o2) {
			return o2.getCreatedAt().compareTo(o1.getCreatedAt());
		}

	};

	private long userId;

	@FXML private Label textLength;

	@FXML private TextArea textArea;

	@FXML private Button tweetButton;

	@FXML private ListView<Status> timeline;
	private ObservableList<Status> list;

	private Long replyId = null;

	private MultipleSelectionModel<Status> sel;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list = timeline.getItems();

		timeline.setCellFactory(new Callback<ListView<Status>, ListCell<Status>>() {
			@Override
			public ListCell<Status> call(ListView<Status> listView) {
				return new TweetChip();
			}
		});
		sel = timeline.getSelectionModel();

		vtwitter = new AsyncTwitterFactory().getInstance();
		vtwitter.addListener(new VermilionTwitterListener());
		vtwitter.getHomeTimeline();								//一応タイムラインを取得しとく

		try {
			userId = vtwitter.getId();
		} catch (IllegalStateException | TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		stwitter = new TwitterStreamFactory().getInstance();
		stwitter.addListener(new VermilionUserListener(userId));
		stwitter.user();

		instance = this;
	}

	/**
	 * 残り文字数を反映させる。
	 */
	private void checkReplyLength(){
		textLength.setText(new Integer(140-textArea.getText().length()).toString());
	}

	/**
	 * Tweetボタンを押した時、CTRL+ENTERを押した時に呼ぶ。
	 * ついーとを行う。リプ先を指定していた時は設定する。
	 * TODO ついーとに失敗したときの処理
	 */
	public void onTweet(){
		if(textArea.getText().length() ==0) return;
		StatusUpdate su = new StatusUpdate(textArea.getText());
		if(replyId != null)
			su.setInReplyToStatusId(replyId);
		vtwitter.updateStatus(su);
		textArea.clear();
		timeline.requestFocus();
		replyId = null;
	}

	/**
	 * timeLineでキーを離した時に呼ぶ。
	 * R	リプライのIDを指定　&　ついーと欄にフォーカス
	 * N	ついーと欄にフォーカス
	 * F	ふぁぼ
	 * J	下移動
	 * K	上移動
	 * TODO 移動したときにview が動かない
	 */
	public void keyList(KeyEvent e){
		switch(e.getCode()){
		case R:
			System.out.println("REP");
			Status s = sel.getSelectedItem();
			StringBuffer sb = new StringBuffer();
			sb.append("@"+s.getUser().getScreenName()+" ");
			UserMentionEntity[] ume = s.getUserMentionEntities();
			for(UserMentionEntity u:ume)
				if(u.getId()!=userId)
					sb.append("@"+u.getScreenName()+" ");
			textArea.setText(sb.toString());
			replyId = s.getId();
		case N:
			textArea.requestFocus();
			checkReplyLength();
			break;
		case F:
			vtwitter.createFavorite(timeline.getSelectionModel().getSelectedItem().getId());
			break;
		case J:
			sel.select(sel.getSelectedIndex()+1);
			break;
		case K:
			sel.select(Math.max(0, sel.getSelectedIndex()-1));
			break;
		default:
			break;
		}
	}

	/**
	 * ついーと欄でキーを離した時に呼ぶ
	 * CTRL+ENTER	ついーとする
	 * ESCAPE		りぷの関連付けとついーと欄を解除　&　timelineにフォーカス
	 * @param e KeyEvent
	 */
	public void keyReleased(KeyEvent e){
		switch(e.getCode()){
		case ENTER:
			if(e.isControlDown())
				onTweet();
			break;
		case ESCAPE:
			replyId=null;
			textArea.clear();
			timeline.requestFocus();
			break;
		default:
			break;
		}
		checkReplyLength();
	}

	/**
	 * ついーとをタイムラインに追加するときに呼ぶ。
	 * @param s 追加するツイート
	 */
	public void addStatus(Status s){
		Platform.runLater(() -> {
			try {
				list.add(s);
				Collections.sort(list, comp);
				int n = sel.getSelectedIndex();
				if(n <= 5){
					sel.select(0);
				}
			} catch (Exception ex){
				ex.printStackTrace();
			}
		});
	}

	/**
	 * ついーとをたくさん追加するときに呼ぶ。
	 * @param arg0 たくさんの追加するツイート
	 */
	public void addStatuses(ResponseList<Status> arg0){
		Platform.runLater(() -> {
			try {
				list.addAll(arg0);
				Collections.sort(list, comp);
			} catch (Exception ex){
				ex.printStackTrace();
			}
		});
	}

	/**
	 * バツボタンでプログラムを終了させるときにApplicationから呼ばれる。
	 * TODO なんか反応が遅い。
	 */
	public static void stop() {
		System.out.println("STOP");
		if(stwitter!=null){
			stwitter.shutdown();
			System.out.println("DOWN");
		}
	}

}
