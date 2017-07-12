package cn.crepusculo.cards;

import android.content.Context;
import android.util.AttributeSet;

import butterknife.BindView;
import cn.crepusculo.component.ComponentContainer;
import cn.crepusculo.model.PureCardModel;

/**
 * <h1>modify class name here</h1>
 * cn.crepusculo.cards
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/11
 */

public class PureCardView extends BaseCardView implements BaseCardView.bindData<PureCardModel>{
    ComponentContainer container;

    public PureCardView(Context context) {super(context);}
    public PureCardView(Context context, AttributeSet attrs) {super(context, attrs);}
    public PureCardView(Context context, AttributeSet attrs, int defStyle) {super(context, attrs, defStyle);}

    public static PureCardView getNewInstance(Context context) {
        return new PureCardView(context);
    }

    @Override
    protected void initView() {
        container = (ComponentContainer)findViewById(R.id.container);
    }

    @Override
    protected int setLayout() {
        return R.layout.item_card_pure;
    }

    @Override
    public void bind(PureCardModel data) {
        container.setHead(data.getTitle());
        container.setInfo(data.getAuthor()+data.getDate().toString());
        container.setContent(data.getContent());
    }
}
