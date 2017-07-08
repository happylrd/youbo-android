package io.happylrd.daphne.adapter;

import android.view.View;

import java.util.List;

import butterknife.BindView;
import cn.crepusculo.cards.ComponentContainer;
import cn.crepusculo.cards.ComponentHeader;
import io.happylrd.daphne.R;
import io.happylrd.youbo.common.util.TestUtil;
import io.happylrd.youbo.common.widget.component.FakeModel;
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
    public PageRecyclerAdapter(List<T> dataset, AdapterListener<T> listener) {
        super(dataset, listener);
    }

//    // 进行 view 和 holder 的绑定
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        // bind
//    }

    // 获取 position 所在位置的布局
    @Override
    protected int getItemViewType(int position, Object data) {
//       return data.type;
        return R.layout.item_card_general;
    }

    // inflate 在这里已经完成, 我们只需要根据 viewType 构建 ViewHolder
    @Override
    protected ViewHolder onCreateViewHolder(View root, int viewType) {
        switch (viewType) {
            default:
                return new GeneralViewHolder(root, viewType);
        }
    }

    @Override
    public void update(Object data, ViewHolder holder) {
        TestUtil.PrintLog("recycler update");
    }

    public class GeneralViewHolder extends ViewHolder<FakeModel> {
        @BindView(R.id.header)
        ComponentHeader header;
        @BindView(R.id.container)
        ComponentContainer container;

        int tViewType;

        public GeneralViewHolder(View itemView, int viewType) {
            super(itemView);
            tViewType = viewType;
            header = ComponentHeader.getNewInstance(itemView.getContext());
            container = ComponentContainer.getNewInstance(itemView.getContext());
        }

        @Override
        protected void onBind(FakeModel data) {
            String s = TestUtil.getFakeModel().getTitle();
            TestUtil.PrintLog(s);
            header.setHead(s)
                    .setSubHead(s);
            header.setImage(true);
            container.setHead(s + s)
                    .setInfo(s)
                    .setContent(s+s+s+s);
        }
    }
}
