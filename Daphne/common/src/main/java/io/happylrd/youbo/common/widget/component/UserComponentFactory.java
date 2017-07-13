package io.happylrd.youbo.common.widget.component;

import java.util.Date;

/**
 * <h1>modify class name here</h1>
 * io.happylrd.youbo.common.widget.component
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/13
 */

public class UserComponentFactory {
    UserComponent userComponent;

    public UserComponentFactory() {
        userComponent = new UserComponent();
    }

    // forAPI
//    public UserComponentFactory(TweetParcelable parcelable) {
//        //TODO
//    }

    public UserComponentFactory setTitle(String name) {
        userComponent.setName(name);
        return this;
    }

    public UserComponentFactory setIntro(String content) {
        userComponent.setIntro(content);
        return this;
    }

    public UserComponentFactory setFollower(int follower) {
        userComponent.setFollower(follower);
        return this;
    }

    public UserComponentFactory setFollowing(int following) {
        userComponent.setFollowing(following);
        return this;
    }

    public UserComponentFactory setReprinted(int reprinted) {
        userComponent.setReprinted(reprinted);
        return this;
    }

    public UserComponent build() {
        return userComponent;
    }

}
