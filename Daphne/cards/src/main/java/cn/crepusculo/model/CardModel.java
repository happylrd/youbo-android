package cn.crepusculo.model;

/**
 * <h1>modify class name here</h1>
 * cn.crepusculo.model
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/9
 */

public abstract class CardModel {
    private int mType;

    public int getLayoutType() {
        return mType;
    }

    public abstract int setType();
    private CardModel setLayoutType() {
        mType = setType();
        return this;
    }

}
