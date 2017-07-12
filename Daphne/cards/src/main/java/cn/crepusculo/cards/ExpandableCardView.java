package cn.crepusculo.cards;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.ramotion.foldingcell.FoldingCell;

/**
 * <h1>modify class name here</h1>
 * cn.crepusculo.cards
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/9
 */

public class ExpandableCardView extends BaseCardView {
    public ExpandableCardView(Context context) {
        super(context);
    }
    public ExpandableCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public ExpandableCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public static ExpandableCardView getNewInstance(Context context) {
        return new ExpandableCardView(context);
    }

    @Override
    protected void initView() {

    }
    @Override
    protected int setLayout() {
        return R.layout.item_card_expandable;
    }

    public void bind() {
        final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });
    }
}
