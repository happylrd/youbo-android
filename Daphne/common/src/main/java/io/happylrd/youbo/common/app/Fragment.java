package io.happylrd.youbo.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class Fragment extends android.support.v4.app.Fragment {

    protected View mRoot;
    protected Unbinder mRootUnBinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        initArgs(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRoot == null) {
            int layoutId = getContentLayoutId();
            View root = inflater.inflate(layoutId, container, false);
            initWidget(root);
            mRoot = root;
        } else {
            if (mRoot.getParent() != null) {
                // 把当前Root从其父控件中移除
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }

        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
    }

    protected void initArgs(Bundle bundle) {

    }

    protected abstract int getContentLayoutId();

    protected void initWidget(View root) {
        mRootUnBinder = ButterKnife.bind(this, root);
    }

    protected void initData() {

    }

    /**
     * 返回按键触发时调用
     *
     * @return 返回true代表已处理返回逻辑, Activity不用自己finish
     * 返回false代表没有处理逻辑, Activity走自己的逻辑
     */
    public boolean onBackPressed() {
        return false;
    }
}
