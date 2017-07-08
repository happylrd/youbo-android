package cn.crepusculo.cards;

import android.content.Context;

import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;


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


public class ComponentHeader extends BaseCardView {
//    @BindView(R.id.header_background)
    ImageView mImage;
//    @BindView(R.id.header_header)
    TextView mHead;
//    @BindView(R.id.header_subheader)
    TextView mSubHead;

    public ComponentHeader(Context ctx) {
        super(ctx);
    }

    public ComponentHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ComponentHeader(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void initView() {
        this.mImage = (ImageView) findViewById(R.id.header_background);
        this.mHead = (TextView) findViewById(R.id.container_header);
        this.mSubHead = (TextView) findViewById(R.id.header_subheader);
    }

    @Override
    protected int setLayout() {
        return R.layout.component_card_header;
    }


    public static ComponentHeader getNewInstance(Context context) {
        return new ComponentHeader(context);
    }

    public ComponentHeader setImage(boolean setTest) {
        if (setTest) {
            mImage.setImageResource(R.mipmap.place_holder);
//            resetSize(mImage);
        }
        return this;
    }

    public ComponentHeader setImage(String uri) {
        /// TODO
        return this;
    }

    public ComponentHeader setHead(String title) {
        mHead.setText(title);
        return this;
    }

    public ComponentHeader setSubHead(String subHead) {
        mSubHead.setText(subHead);
        return this;
    }

    public ComponentHeader setOnCardHeaderClick(OnClickListener listener) {
        this.setOnClickListener(listener);
        return this;
    }

}
