package cn.crepusculo.cards;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;

import cn.crepusculo.component.ComponentContainer;
import cn.crepusculo.component.ComponentHeader;
import cn.crepusculo.model.GeneralCardModel;

/**
 * <h1>modify class name here</h1>
 * io.happylrd.youbo.common.widget.adapter
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/7
 */

public class GeneralCardView extends BaseCardView implements BaseCardView.bindData<GeneralCardModel> {
    public ComponentHeader getComponentHeader() {
        return componentHeader;
    }

    private ComponentHeader componentHeader;
    private ComponentContainer componentContainer;

    public GeneralCardView(Context context) {
        super(context);
    }

    public GeneralCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GeneralCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public static GeneralCardView getNewInstance(Context context) {
        return new GeneralCardView(context);
    }

    @Override
    protected void initView() {
        componentHeader = (ComponentHeader) findViewById(R.id.header);
        componentContainer = (ComponentContainer) findViewById(R.id.container);
    }

    @Override
    protected int setLayout() {
        return R.layout.item_card_general;
    }

    @Override
    public void bind(GeneralCardModel data) {
        componentHeader.setHead(data.getStreamTitle())
                .setSubHead(data.getStreamSubtitle());
        componentContainer.setHead(data.getEventTitle())
                .setContent(data.getEventContent())
                .setInfo(data.getId());
    }

}
