package io.happylrd.daphne.adapter;

import android.content.Intent;
import android.view.View;

import java.util.List;

import cn.crepusculo.cards.PureWithAvatarView;
import cn.crepusculo.model.PureCardModelWithAvatar;
import io.happylrd.daphne.R;
import io.happylrd.daphne.activity.ProfileActivity;
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

public class CommentRecyclerAdapter<T> extends RecyclerAdapter {
    private PureWithAvatarView card;

    public CommentRecyclerAdapter(List<T> datalist){
        super(datalist);
    }

    @Override
    protected int getItemViewType(int position, Object data) {
        return R.layout.item_comment;
    }

    @Override
    protected void onCreateItem(final View root, int viewType) {
        card.findViewById(R.id.avatar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(root.getContext(), ProfileActivity.class);
                root.getContext().startActivity(i);
            }
        });
    }

    @Override
    protected ViewHolder onCreateViewHolder(View root, int viewType) {
        return new CommentViewHolder(root);
    }

    @Override
    public void update(Object data, ViewHolder holder) {

    }

    private class CommentViewHolder extends ViewHolder<PureCardModelWithAvatar>{

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
