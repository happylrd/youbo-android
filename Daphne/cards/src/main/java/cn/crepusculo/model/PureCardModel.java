package cn.crepusculo.model;

import java.util.Date;

import cn.crepusculo.cards.R;

/**
 * <h1>modify class name here</h1>
 * cn.crepusculo.model
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/11
 */

public class PureCardModel extends CardModel{
    String mTitle;
    String mContent;
    String mAuthor;
    Date mDate;

    public String getTitle() {
        return mTitle;
    }

    public PureCardModel setTitle(String mTitle) {
        this.mTitle = mTitle;
        return this;
    }

    public String getContent() {
        return mContent;
    }

    public PureCardModel setContent(String mContent) {
        this.mContent = mContent;
        return this;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public PureCardModel setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
        return this;
    }

    public Date getDate() {
        return mDate;
    }

    public PureCardModel setDate(Date mDate) {
        this.mDate = mDate;
        return this;
    }

    @Override
    public int setType() {
        return R.layout.item_card_pure;
    }
}
