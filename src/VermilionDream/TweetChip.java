package VermilionDream;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import twitter4j.Status;
import twitter4j.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class TweetChip extends ListCell<Status> {
	
	/**
	 * ListViewのためのセル
	 */
	@FXML private Pane cellContainer;
	@FXML private ImageView icon;
	@FXML private Label screenName;
	@FXML private Label time;
	@FXML private Label text;
	@FXML private Label userName;
	@FXML private Label via;
	
	@FXML private ImageView rtIcon;
	@FXML private Pane rtPane;

	/**
	 * viaを取得するために使う
	 * TODO viaクリックしたらgroup(1)に飛ばす
	 */
	private final Pattern pattern = Pattern.compile("<a href=\"(.*)\" rel=\".*\">(.*)</a>");
	
	public TweetChip(){
		System.out.println("LOAD");
		FXMLLoader fxmlLoader =
				new FXMLLoader(getClass().getResource("TweetChip.fxml"));
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
	}
	
	@Override
	protected void updateItem(Status s, boolean empty) {
		super.updateItem(s, empty);
		if (empty) {
			setText(null);
			setGraphic(null);
			return;
		}
		
		Status rs = s.getRetweetedStatus();
		rtPane.setVisible(rs != null);
		if(rs != null){
			rtIcon.setImage(ImageManager.getImage(s.getUser()));
			s = rs;
		}
		User u = s.getUser();
		
		icon.setImage(ImageManager.getImage(u));
		userName.setText(u.getName());
		screenName.setText(u.getScreenName());
		text.setText(s.getText());
		time.setText(s.getCreatedAt().toString());
		Matcher mc = pattern.matcher(s.getSource());
		if(mc.find())
			via.setText(mc.group(2));
		setGraphic(cellContainer);
	}

}