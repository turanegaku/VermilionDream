package VermilionDream;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import twitter4j.Status;

public class ImageManager {
	/**
	 * ユーザーのアイコンやツイート内の画像を管理するためのクラス
	 * TODO アイコン機能しかつけてない。
	 */
	
	private static Map<Status, Image> icons = new HashMap<>();
	
	/**
	 * アイコンイメージを返す。
	 * 保存していなかった場合はついでに取得する。
	 * @param s アイコンを取得したいUser
	 * @return ユーザーのアイコンイメージ
	 * 
	 * TODO りついーとのことを考えるとUserにした方がいいかも。
	 */
	public static Image getImage(Status s){
		if(!icons.containsKey(s))
			icons.put(s, new Image(s.getUser().getProfileImageURL()));
		return icons.get(s);
	}
}
