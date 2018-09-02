package com.excellent.knowbookcommon.model.vo;

/**
 * Created by 高楚杭 on 2018/8/7.
 */
public  class FollowVo {
    /**关注**/
    private String followedUserId;
    private String followeuserName;
    private  String followPicture;

    public String getFollowPicture() {
        return followPicture;
    }

    public void setFollowPicture(String followPicture) {
        this.followPicture = followPicture;
    }

    public String getFollowedUserId() {
        return followedUserId;
    }

    public void setFollowedUserId(String followedUserId) {
        this.followedUserId = followedUserId;
    }

    public String getFolloweuserName() {
        return followeuserName;
    }

    public void setFolloweuserName(String followeuserName) {
        this.followeuserName = followeuserName;
    }
}
