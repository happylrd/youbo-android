package cn.crepusculo.model;

import cn.crepusculo.cards.R;

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

public class ExpandableCardModel extends CardModel {
    public ExpandableCardModel(){
    }

    @Override
    public int setType() {
        return R.layout.item_card_expandable;
    }

    public ExpandableCardModel random(){
        this.setId(RandomData.longdata());
        return this;
    }


}
