package cn.crepusculo.component;

import android.content.Context;
import android.util.AttributeSet;

import cn.crepusculo.cards.BaseCardView;
import cn.crepusculo.cards.R;

/**
 * <h1>modify class name here</h1>
 * cn.crepusculo.component
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/10
 */

public class ComponentVideo extends BaseCardView {

    public ComponentVideo(Context context) {super(context);}
    public ComponentVideo(Context context, AttributeSet attrs) {super(context, attrs);}
    public ComponentVideo(Context context, AttributeSet attrs, int defStyle) {super(context, attrs, defStyle);}

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayout() {
        return R.layout.component_card_video;
    }


}
