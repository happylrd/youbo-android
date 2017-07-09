package cn.crepusculo.cards;

import android.content.Context;
import android.util.AttributeSet;


import cn.crepusculo.component.ComponentContainer;
import cn.crepusculo.component.ComponentHeader;
import cn.crepusculo.model.GeneralCard;

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

public class GeneralCardView extends BaseCardView implements BaseCardView.bindData<GeneralCard>{
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
        componentContainer =(ComponentContainer) findViewById(R.id.container);
    }

    @Override
    protected int setLayout() {
        return R.layout.item_card_general;
    }

    @Override
    public void bind(GeneralCard data) {
        componentHeader.setHead   (data.getStreamTitle());
        componentHeader.setSubHead(data.getStreamSubtitle());
        componentContainer.setHead   (data.getEventTitle());
        componentContainer.setContent(data.getEventContent());
        componentContainer.setInfo   (data.getEventInfo());
    }

}
