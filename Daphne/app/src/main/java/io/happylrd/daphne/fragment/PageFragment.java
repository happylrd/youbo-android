package io.happylrd.daphne.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.crepusculo.model.CardModel;
import cn.crepusculo.model.ExpandableCardModel;
import cn.crepusculo.model.GeneralCardModel;
import io.happylrd.daphne.R;
import io.happylrd.daphne.adapter.PageRecyclerAdapter;
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

public class PageFragment extends Fragment{

    private static final String DISPLAY_PAGE = "DISPLAY_PAGE";
    private int mPageIdx;

    public static PageFragment newInstance(int page) {
        Bundle bundle = new Bundle();
        bundle.putInt(DISPLAY_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getContentLayout() {
        return mPageIdx;
    }

    @Override
    protected void initArgs(Bundle bundle) {
        mPageIdx = bundle.getInt(DISPLAY_PAGE);
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
    }

    @Override
    protected void initData() {
        super.initData();
        switch (mPageIdx) {
            case R.layout.fragment_gallery:
                initPageGallery();
                break;
            case R.layout.fragment_suggest:
                initPageSuggest();
                break;
            case R.layout.fragment_notification:
                initPageNotification();
                break;
            case R.layout.fragment_about_me:
                initAboutMe();
                break;
            default:
        }
    }

    private void initAboutMe() {
        TestUtil.PrintLog(this.getContext(), "Load Page AboutMe Data");
    }

    private void initPageNotification() {
        TestUtil.PrintLog(this.getContext(), "Load Page Notification Data");
    }


    private void initPageSuggest() {
        TestUtil.PrintLog(this.getContext(), "Load Page Suggest Data");
    }

    private void initPageGallery() {
        TestUtil.PrintLog(this.getContext(), "Load Page Gallery Data");
        try {
            RecyclerView recycler = (RecyclerView) this.getView().findViewById(R.id.recycler);

            List<CardModel> list = new ArrayList<>();
            list.add(new GeneralCardModel().random());
            list.add(new GeneralCardModel().random());
            list.add(new GeneralCardModel().random());
            list.add(new ExpandableCardModel());
            list.add(new GeneralCardModel().random());
            list.add(new GeneralCardModel().random());
            list.add(new GeneralCardModel().random());

            PageRecyclerAdapter<CardModel> adapter = new PageRecyclerAdapter<>(list);


            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

            recycler.setAdapter(adapter);
            recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
            recycler.setHasFixedSize(true);

//            DividerItemDecoration dividerDrawerItem = new DividerItemDecoration (recycler.getContext(),
//                    linearLayoutManager.getOrientation());
//            recycler.addItemDecoration(dividerDrawerItem);

        } catch (NullPointerException e) {
            TestUtil.PrintError(this.getView(),e.toString());
        }
    }

    private enum TYPE {
        STAR(R.layout.fragment_gallery),
        SUGGEST(R.layout.fragment_suggest),
        NOTIFICATION(R.layout.fragment_notification),
        ABOUTME(R.layout.fragment_about_me);

        private int value;

        TYPE(int i) {
            value = i;
        }
    }
}
