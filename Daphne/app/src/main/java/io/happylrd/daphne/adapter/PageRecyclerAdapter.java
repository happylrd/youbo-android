package io.happylrd.daphne.adapter;

import android.content.Intent;
import android.view.View;

import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

import cn.crepusculo.cards.ExpandableCardView;
import cn.crepusculo.cards.GeneralCardView;
import cn.crepusculo.component.ComponentContainer;
import cn.crepusculo.component.ComponentHeader;
import cn.crepusculo.model.CardModel;
import cn.crepusculo.model.GeneralCardModel;
import io.happylrd.daphne.R;
import io.happylrd.daphne.activity.TweetActivity;
import io.happylrd.youbo.common.util.TestUtil;
import io.happylrd.youbo.common.widget.recycler.RecyclerAdapter;


/**
 * <h1>modify class name here</h1>
 * io.happylrd.daphne.adapter
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/6
 */

public class PageRecyclerAdapter<T> extends RecyclerAdapter {
    public PageRecyclerAdapter(List<T> dataset) {
        super(dataset);
        mDataList = dataset;
    }

    // 获取 position 所在位置的布局
    @Override
    protected int getItemViewType(int position, Object data) {
        int layoutType = ((CardModel)data).getLayoutType();
        TestUtil.PrintLog("Layout:"+layoutType+"\tPosition:"+position);
        switch (layoutType){
            case R.layout.item_card_general:
                return R.layout.item_card_general;
            case R.layout.item_card_expandable:
                return R.layout.item_card_expandable;
        }
        return layoutType;
    }

    @Override
    protected void onCreateItem(View root, int viewType) {
        switch (viewType){
            case R.layout.item_card_general:
                registerOnClickGeneral(root);
                break;
            case R.layout.item_card_expandable:
                registerOnClickExpandable(root);
                break;
        }
    }

    private void registerOnClickExpandable(View root) {
        final FoldingCell fc = (FoldingCell)root.findViewById(R.id.folding_cell);
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.toggle(false);
            }
        });
    }

    private void registerOnClickGeneral(final View root) {
                root.findViewById(R.id.header).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent();
                        i.setClass(root.getContext(), TweetActivity.class);
                        root.getContext().startActivity(i);
            }
        });
    }


    // inflate 在这里已经完成, 我们只需要根据 viewType 构建 ViewHolder
    @Override
    protected ViewHolder onCreateViewHolder(View root, int viewType) {
        switch (viewType) {
            case R.layout.item_card_general:
                return new GeneralViewHolder(root, viewType);
            case R.layout.item_card_expandable:
                return new ExpandableViewHolder(root, viewType);
            default:
        }
        return null;
    }

    @Override
    public void update(Object data, ViewHolder holder) {
        TestUtil.PrintLog("recycler update");
    }

    /*
     ********************************************
     *
     * View holder
     *
     * ******************************************
     */

    /**
     * GeneralViewHolder
     */
    class GeneralViewHolder extends ViewHolder<CardModel> {
//        GeneralCardView generalCardView;
        ComponentHeader header;
        ComponentContainer container;

        public GeneralViewHolder(View itemView, int viewType) {
            super(itemView);
//            GeneralCardView generalCardView =(GeneralCardView) itemView.findViewById(R.id.general);
            header = (ComponentHeader) itemView.findViewById(R.id.header);
            container = (ComponentContainer) itemView.findViewById(R.id.container);
        }


        @Override
        protected void onBind(CardModel data) {
//            generalCardView.bind((GeneralCardModel)data);
            GeneralCardModel d = (GeneralCardModel)data;
            header.setHead(d.getStreamTitle()).setSubHead(d.getStreamSubtitle());
            container.setHead(d.getEventTitle()).setContent(d.getEventContent()).setInfo(d.getEventInfo());
        }
    }
    /**
     * ExpandableViewHolder
     */
    class ExpandableViewHolder extends ViewHolder<CardModel>{
        ExpandableCardView expandableCardView;

        public ExpandableViewHolder(View itemView, int viewType) {
            super(itemView);
            expandableCardView = ExpandableCardView.getNewInstance(itemView.getContext());
        }
        @Override
        protected void onBind(CardModel data) {
            expandableCardView.bind();
        }
    }

}
