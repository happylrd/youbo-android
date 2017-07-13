package io.happylrd.youbo.common.widget.component;

import java.util.Date;

import io.happylrd.youbo.common.parcels.TweetParcelable;

/**
 * Created by Crepusculo-Mri on 2017/7/4.
 * TweetComponent Class : for building Tweet
 *
 * @see Tweet
 * @see TweetParcelable
 */

public class TweetComponent {
    /**
     * Data Field
     *
     */
    private String title;
    private String author;
    private Date date;
    private String content;
    private int like;
    private int star;
    private int reprinted;
    public TweetComponent(){

    }

    public TweetComponent setTitle(String title) {
        this.title = title;
        return this;
    }

    public TweetComponent setAuthor(String author) {
        this.author = author;
        return this;
    }

    public TweetComponent setDate(Date date) {
        this.date = date;
        return this;
    }

    public TweetComponent setContent(String content) {
        this.content = content;
        return this;
    }

    public TweetComponent setLike(int like) {
        this.like = like;
        return this;
    }

    public TweetComponent setStar(int star) {
        this.star = star;
        return this;
    }

    public TweetComponent setReprinted(int reprinted) {
        this.reprinted = reprinted;
        return this;
    }

}
