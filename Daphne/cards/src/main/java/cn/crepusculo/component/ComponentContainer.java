package cn.crepusculo.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import cn.crepusculo.cards.BaseCardView;
import cn.crepusculo.cards.R;


/**
 * <h1>modify class name here</h1>
 * cn.crepusculo.view
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/7
 */


public class ComponentContainer extends BaseCardView {
    TextView mHead;
    TextView mInfo;
    TextView mContent;

    private Context mContext;

    public ComponentContainer(Context ctx) {
        super(ctx);
    }

    public ComponentContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ComponentContainer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void initView() {
        this.mHead = (TextView) findViewById(R.id.container_header);
        this.mInfo = (TextView) findViewById(R.id.container_info);
        this.mContent = (TextView) findViewById(R.id.container_content);
    }

    @Override
    protected int setLayout() {
        return R.layout.component_card_container;
    }

    protected static ComponentContainer getNewInstance(Context context) {
        return new ComponentContainer(context);
    }

    public ComponentContainer setHead(String title) {
        mHead.setText(title);
        return this;
    }

    public ComponentContainer setInfo(String info) {
        mInfo.setText(info);
        return this;
    }

    public ComponentContainer setContent(String info) {
        mContent.setText(info);
        return this;
    }

    public ComponentContainer setOnCardHeaderClick(OnClickListener listener) {
        this.setOnClickListener(listener);
        return this;
    }


}
