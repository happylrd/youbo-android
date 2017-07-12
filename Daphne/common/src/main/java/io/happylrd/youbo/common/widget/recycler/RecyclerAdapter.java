package io.happylrd.youbo.common.widget.recycler;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.happylrd.youbo.common.R;
import io.happylrd.youbo.common.util.TestUtil;

public abstract class RecyclerAdapter<T>
        extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder<T>>
        implements
        AdapterCallback<T> {
    protected List<T> mDataList;

    public RecyclerAdapter() {
        this(null);
    }

    public RecyclerAdapter(List<T> dataList) {
        Log.e("Call Root Adapter","constructor"+dataList.size());
        this.mDataList = dataList;
    }

    /**
     * 复写默认的布局类型返回
     *
     * @param position
     * @return 类型, 约定为xml文件的id
     */
    @Override
    public int getItemViewType(int position) {
        return getItemViewType(position, mDataList.get(position));
    }

    @LayoutRes
    protected abstract int getItemViewType(int position, T data);

    /**
     * 创建一个ViewHolder
     *
     * @param parent   RecyclerView
     * @param viewType 界面的类型, 约定为xml布局的id
     * @return ViewHolder
     */
    @Override
    public ViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View root = inflater.inflate(viewType, parent, false);
        ViewHolder<T> holder = onCreateViewHolder(root, viewType);

        // 设置View的Tag为ViewHolder, 进行双向绑定
        root.setTag(R.id.tag_recycler_holder, holder);

//        root.setOnClickListener(this);
//        root.setOnLongClickListener(this);
        // 自定义监听
        onCreateItem(root,viewType);
        // 进行界面注解绑定
        holder.unbinder = ButterKnife.bind(holder, root);
        // 绑定callback
        holder.callback = this;

        return holder;
    }
    // 自定义监听
    protected abstract void onCreateItem(View root, int viewType);

    protected abstract ViewHolder<T> onCreateViewHolder(View root, int viewType);

    @Override
    public void onBindViewHolder(ViewHolder<T> holder, int position) {
        TestUtil.PrintLog("On bind view holder");
        T data = mDataList.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void add(T data) {
        mDataList.add(data);
        notifyItemInserted(mDataList.size() - 1);
    }

    public void add(T... dataArray) {
        if (dataArray != null && dataArray.length > 0) {
            int startPos = mDataList.size();
            Collections.addAll(mDataList, dataArray);
            notifyItemRangeInserted(startPos, dataArray.length);
        }
    }

    public void add(Collection<T> dataList) {
        if (dataList != null && dataList.size() > 0) {
            int startPos = mDataList.size();
            mDataList.addAll(dataList);
            notifyItemRangeInserted(startPos, dataList.size());
        }
    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }

    public void replace(Collection<T> dataList) {
        mDataList.clear();
        if (dataList == null || dataList.size() == 0)
            return;
        mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

//    @Override
//    public void onClick(View v) {
//        ViewHolder viewHolder = (ViewHolder) v.getTag(R.id.tag_recycler_holder);
//        if (this.mListener != null) {
//            int pos = viewHolder.getAdapterPosition();
//            this.mListener.onItemClick(viewHolder, mDataList.get(pos));
//        }
//    }
//
//    @Override
//    public boolean onLongClick(View v) {
//        ViewHolder viewHolder = (ViewHolder) v.getTag(R.id.tag_recycler_holder);
//        if (this.mListener != null) {
//            int pos = viewHolder.getAdapterPosition();
//            this.mListener.onItemLongClick(viewHolder, mDataList.get(pos));
//            return true;
//        }
//        return false;
//    }


    /**
     * 自定义的监听器
     */
    public interface AdapterListener<T> {
        void onItemClick(RecyclerAdapter.ViewHolder holder, T data);

        void onItemLongClick(RecyclerAdapter.ViewHolder holder, T data);
    }

    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
        private Unbinder unbinder;
        private AdapterCallback<T> callback;
        protected T mData;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        /**
         * 触发绑定
         */
        void bind(T data) {
            this.mData = data;
            onBind(data);
        }

        protected abstract void onBind(T data);

        /**
         * holder负责data的更新
         */
        public void updateData(T data) {
            if (this.callback != null) {
                this.callback.update(data, this);
            }
        }
    }
}
