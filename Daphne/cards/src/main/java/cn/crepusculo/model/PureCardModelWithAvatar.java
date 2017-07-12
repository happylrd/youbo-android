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
 * @since 2017/7/12
 */

public class PureCardModelWithAvatar extends PureCardModel {
    public int getPlaceHolderId() {
        return placeHolderId;
    }

    public PureCardModelWithAvatar setPlaceHolderId(int placeHolderId) {
        this.placeHolderId = placeHolderId;
        return this;
    }

    int placeHolderId;
    @Override
    public int setType() {
        return R.layout.item_card_pure_with_avatar;
    }
}
