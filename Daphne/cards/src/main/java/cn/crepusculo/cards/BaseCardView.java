package cn.crepusculo.cards;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

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

public abstract class BaseCardView extends FrameLayout{
    Context mContext;

    public interface bindData<T>{
        void bind(T data) ;
    }
    public interface getNewInstance{
        BaseCardView getNewInstance(Context c);
    }

    public BaseCardView(Context context) {
        super(context);
        mContext = context;
        build();
    }
    public BaseCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        build();
    }
    public BaseCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        build();
    }

    protected void build(){
        LayoutInflater.from(mContext).inflate(getLayout(), this);
        initView();
    }

    /**
     * set view component value in implementation
     */
    protected abstract void initView();

    /**
     * set Layout will be inflated
     */
    protected abstract int setLayout();
    protected int getLayout(){
        return setLayout();
    }
    /**
     * bind data here
     */




    /**
     * set height to width * r
     * @param v target view
     */
    public static void resetSize(ImageView v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        layoutParams.height = (int)(layoutParams.width * 0.5625);
        v.setLayoutParams(layoutParams);
    }
}
