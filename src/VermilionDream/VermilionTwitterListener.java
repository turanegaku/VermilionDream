package VermilionDream;

import java.util.Map;

import twitter4j.AccountSettings;
import twitter4j.Category;
import twitter4j.DirectMessage;
import twitter4j.Friendship;
import twitter4j.IDs;
import twitter4j.Location;
import twitter4j.OEmbed;
import twitter4j.PagableResponseList;
import twitter4j.Place;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.Status;
import twitter4j.Trends;
import twitter4j.TwitterAPIConfiguration;
import twitter4j.TwitterException;
import twitter4j.TwitterListener;
import twitter4j.TwitterMethod;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.api.HelpResources.Language;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuth2Token;
import twitter4j.auth.RequestToken;

public class VermilionTwitterListener implements TwitterListener {

	@Override
	public void checkedUserListMembership(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkedUserListSubscription(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createdBlock(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createdFavorite(Status arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createdFriendship(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createdMute(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createdSavedSearch(SavedSearch arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createdUserList(UserList arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createdUserListMember(UserList arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createdUserListMembers(UserList arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyedBlock(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyedDirectMessage(DirectMessage arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyedFavorite(Status arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyedFriendship(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyedMute(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyedSavedSearch(SavedSearch arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyedStatus(Status arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyedUserList(UserList arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyedUserListMember(UserList arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotAPIConfiguration(TwitterAPIConfiguration arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotAccountSettings(AccountSettings arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotAvailableTrends(ResponseList<Location> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotBlockIDs(IDs arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotBlocksList(ResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotClosestTrends(ResponseList<Location> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotContributees(ResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotContributors(ResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotDirectMessage(DirectMessage arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotDirectMessages(ResponseList<DirectMessage> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotFavorites(ResponseList<Status> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotFollowersIDs(IDs arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotFollowersList(PagableResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotFriendsIDs(IDs arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotFriendsList(PagableResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotGeoDetails(Place arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * タイムラインを取得
	 * 取得したタイムラインはtimelineに随時追加する
	 */
	@Override
	public void gotHomeTimeline(ResponseList<Status> arg0) {
		VermilionControler.getInstance().addStatuses(arg0);
	}

	@Override
	public void gotIncomingFriendships(IDs arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotLanguages(ResponseList<Language> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotMemberSuggestions(ResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotMentions(ResponseList<Status> arg0) {
		// TODO Auto-generated method stub
		System.out.println("Mentions");
		for(Status s:arg0){
			System.out.println(s);
		}
	}

	@Override
	public void gotMuteIDs(IDs arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotMutesList(ResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotOAuth2Token(OAuth2Token arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotOAuthAccessToken(AccessToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotOAuthRequestToken(RequestToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotOEmbed(OEmbed arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotOutgoingFriendships(IDs arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotPlaceTrends(Trends arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotPrivacyPolicy(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotRateLimitStatus(Map<String, RateLimitStatus> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotRetweets(ResponseList<Status> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotRetweetsOfMe(ResponseList<Status> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotReverseGeoCode(ResponseList<Place> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotSavedSearch(SavedSearch arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotSavedSearches(ResponseList<SavedSearch> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotSentDirectMessages(ResponseList<DirectMessage> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotShowFriendship(Relationship arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotShowStatus(Status arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotShowUserList(UserList arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotSimilarPlaces(ResponseList<Place> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotSuggestedUserCategories(ResponseList<Category> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotTermsOfService(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotUserDetail(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotUserListMembers(PagableResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotUserListMemberships(PagableResponseList<UserList> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotUserListStatuses(ResponseList<Status> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotUserListSubscribers(PagableResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotUserListSubscriptions(PagableResponseList<UserList> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotUserLists(ResponseList<UserList> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotUserSuggestions(ResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gotUserTimeline(ResponseList<Status> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lookedUpFriendships(ResponseList<Friendship> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lookedup(ResponseList<Status> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lookedupUsers(ResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(TwitterException arg0, TwitterMethod arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removedProfileBanner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportedSpam(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retweetedStatus(Status arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searched(QueryResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchedPlaces(ResponseList<Place> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchedUser(ResponseList<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sentDirectMessage(DirectMessage arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribedUserList(UserList arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unsubscribedUserList(UserList arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatedAccountSettings(AccountSettings arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatedFriendship(Relationship arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatedProfile(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatedProfileBackgroundImage(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatedProfileBanner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatedProfileColors(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatedProfileImage(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatedStatus(Status arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatedUserList(UserList arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifiedCredentials(User arg0) {
		// TODO Auto-generated method stub
		
	}
}
