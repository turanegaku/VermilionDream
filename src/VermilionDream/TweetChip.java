package VermilionDream;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import twitter4j.Status;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TweetChip extends ListCell<Status> {
	@FXML private HBox cellContainer;
	@FXML private ImageView icon;
	@FXML private Label userName;
	@FXML private Label screenName;
	@FXML private Label via;
	@FXML private Text text;

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
	protected void updateItem(Status s, boolean empty) { // (4)
		super.updateItem(s, empty);
		if (empty) {
			setText(null);
			setGraphic(null);
			return;
		}

		icon.setImage(ImageManager.getImage(s));
		userName.setText(s.getUser().getName());
		screenName.setText(s.getUser().getScreenName());
		text.setText(s.getText());
		Matcher mc = pattern.matcher(s.getSource());
		if(mc.find())
			via.setText(mc.group(2));
		setGraphic(cellContainer);
	}

}