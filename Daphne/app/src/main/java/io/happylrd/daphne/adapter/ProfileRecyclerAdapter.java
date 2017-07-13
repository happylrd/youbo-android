package io.happylrd.daphne.adapter;

import android.view.View;

import java.util.List;

import cn.crepusculo.cards.PureWithAvatarView;
import cn.crepusculo.model.PureCardModelWithAvatar;
import io.happylrd.daphne.R;
import io.happylrd.youbo.common.widget.recycler.RecyclerAdapter;

/**
 * <h1>modify class name here</h1>
 * io.happylrd.daphne.adapter
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/12
 */

public class ProfileRecyclerAdapter<T> extends RecyclerAdapter {
    public ProfileRecyclerAdapter(List<T> datalist){
        super(datalist);
    }

    @Override
    protected int getItemViewType(int position, Object data) {
        return R.layout.item_comment;
    }

    @Override
    protected void onCreateItem(View root, int viewType) {

    }

    @Override
    protected ViewHolder onCreateViewHolder(View root, int viewType) {
        return new CommentViewHolder(root);
    }

    @Override
    public void update(Object data, ViewHolder holder) {

    }

    private class CommentViewHolder extends ViewHolder<PureCardModelWithAvatar>{
        PureWithAvatarView card;

        CommentViewHolder(View itemView) {
            super(itemView);
            card = (PureWithAvatarView)itemView.findViewById(R.id.card);
        }

        @Override
        protected void onBind(PureCardModelWithAvatar data) {
            card.bind(data);
        }

    }
}
