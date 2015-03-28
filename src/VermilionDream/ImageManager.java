package VermilionDream;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import twitter4j.Status;
import twitter4j.User;

public class ImageManager {
	/**
	 * ユーザーのアイコンやツイート内の画像を管理するためのクラス
	 * TODO アイコン機能しかつけてない。
	 */
	
	private static Map<User, Image> icons = new HashMap<>();
	
	/**
	 * アイコンイメージを返す。
	 * 保存していなかった場合はついでに取得する。
	 * @param s アイコンを取得したいUser
	 * @return ユーザーのアイコンイメージ
	 */
	public static Image getImage(User u){
		if(!icons.containsKey(u))
			icons.put(u, new Image(u.getProfileImageURL()));
		return icons.get(u);
	}
}
