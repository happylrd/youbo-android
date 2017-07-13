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

public class TweetComponentFactory {
    TweetComponent mTweetComponent;

    public TweetComponentFactory() {
        mTweetComponent = new TweetComponent();
    }

//    // forAPI
//    public TweetComponentFactory(TweetParcelable parcelable) {
//        //TODO
//    }

    public TweetComponentFactory setTitle(String title) {
        mTweetComponent.setTitle(title);
        return this;
    }

    public TweetComponentFactory setAuthor(String author) {
        mTweetComponent.setAuthor(author);
        return this;
    }

    public TweetComponentFactory setDate(Date date) {
        mTweetComponent.setDate(date);
        return this;
    }

    public TweetComponentFactory setContent(String content) {
        mTweetComponent.setContent(content);
        return this;
    }

    public TweetComponentFactory setLike(int like) {
        mTweetComponent.setLike(like);
        return this;
    }

    public TweetComponentFactory setStar(int star) {
        mTweetComponent.setStar(star);
        return this;
    }

    public TweetComponentFactory setReprinted(int reprinted) {
        mTweetComponent.setReprinted(reprinted);
        return this;
    }

    public TweetComponent build() {
        return mTweetComponent;
    }

}
