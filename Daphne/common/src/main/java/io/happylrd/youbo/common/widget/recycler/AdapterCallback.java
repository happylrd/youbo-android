package io.happylrd.youbo.common.widget.recycler;

public interface AdapterCallback<T> {
    void update(T data, RecyclerAdapter.ViewHolder<T> holder);
}
