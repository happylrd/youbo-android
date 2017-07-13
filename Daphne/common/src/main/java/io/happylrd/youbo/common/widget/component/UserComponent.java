package io.happylrd.youbo.common.widget.component;

import java.util.Date;

/**
 * Created by Crepusculo-Mri on 2017/7/4.
 * TweetComponent Class : for building Tweet
 *
 * @see User
 * @see io.happylrd.youbo.common.parcels.UserParcelable
 */

public class UserComponent {
    /**
     * Data Field
     *
     */
   private String name;
   private String intro;
   private int follower;
   private int following;
   private int reprinted;
    public UserComponent(){

    }

    public UserComponent setName(String name) {
        this.name = name;
        return this;
    }

    public UserComponent setIntro(String intro) {
        this.intro = intro;
        return this;
    }


    public UserComponent setReprinted(int reprinted) {
        this.reprinted = reprinted;
        return this;
    }

    public UserComponent setFollowing(int following) {
        this.following = following;
        return this;
    }

    public UserComponent setFollower(int follower) {
        this.follower = follower;
        return this;
    }
}
