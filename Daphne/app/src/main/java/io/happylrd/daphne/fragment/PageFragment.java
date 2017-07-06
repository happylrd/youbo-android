package io.happylrd.daphne.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.happylrd.daphne.R;
import io.happylrd.youbo.common.app.Fragment;
import io.happylrd.youbo.common.util.TestUtil;

/**
 * <h1>modify class name here</h1>
 * io.happylrd.daphne.fragment
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/6
 */

public class PageFragment extends Fragment {
    private static final String DISPLAY_PAGE = "DISPLAY_PAGE";
    private static enum TYPE {
        STAR(R.layout.fragment_star),
        SUGGEST(R.layout.fragment_suggest);
        private int value;
        TYPE(int i){
            value = i;
        }
    }
    private int mPageIdx;

    public static PageFragment newInstance(int page) {
        Bundle bundle = new Bundle();
        bundle.putInt(DISPLAY_PAGE,page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getContentLayout() {
        TestUtil.PrintLog("p4:"+ mPageIdx);
        if(mPageIdx == TYPE.STAR.value){
            return R.layout.fragment_star;
        }
        return R.layout.fragment_suggest;
    }

    @Override
    protected void initArgs(Bundle bundle) {
        mPageIdx = bundle.getInt(DISPLAY_PAGE);
        TestUtil.PrintLog("p3:"+ mPageIdx);
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        switch (mPageIdx){
            case R.layout.fragment_star:
                initPageStar();
                break;
            case R.layout.fragment_suggest:
                initPageSuggest();
                break;
        }
    }

    private void initPageSuggest() {
        TestUtil.PrintLog(this.getContext(),"Load Page Suggest Data");
    }

    private void initPageStar() {
        TestUtil.PrintLog(this.getContext(),"Load Page Star Data");

    }
}
