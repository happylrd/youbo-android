package cn.crepusculo.cards;

import android.content.Context;
import android.util.AttributeSet;

import butterknife.BindView;
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
    private ComponentHeader header;
    private ComponentContainer container;

    public GeneralCardView(Context context) {
        super(context);
    }

    public GeneralCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GeneralCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void initView() {
        header = findViewById(R.id.header);
        container = findViewById(R.id.container);
    }



    @Override
    protected int setLayout() {
        return R.layout.item_card_general;
    }

    @Override
    public void bind(GeneralCard data) {
        header   .setHead   (data.getStreamTitle());
        header   .setSubHead(data.getStreamSubtitle());
        container.setHead   (data.getEventTitle());
        container.setContent(data.getEventContent());
        container.setInfo   (data.getEventInfo());
    }

}
