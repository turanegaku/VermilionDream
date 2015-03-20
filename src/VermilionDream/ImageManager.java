package VermilionDream;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import twitter4j.Status;

public class ImageManager {
	private static Map<Status, Image> icons = new HashMap<>();
	
	public static Image getImage(Status s){
		if(!icons.containsKey(s))
			icons.put(s, new Image(s.getUser().getProfileImageURL()));
		return icons.get(s);
	}
}
