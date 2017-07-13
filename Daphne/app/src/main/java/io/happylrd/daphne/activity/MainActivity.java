package io.happylrd.daphne.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.AbstractDrawerItem;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindArray;
import butterknife.BindView;
import io.happylrd.daphne.R;
import io.happylrd.daphne.adapter.MainActivityPagerAdapter;
import io.happylrd.youbo.common.app.Activity;
import io.happylrd.youbo.common.util.TestUtil;

public class MainActivity extends Activity {
    /* bind data */
    @BindArray(R.array.drawer_titles)
    String[] mTitles;

    /* bind views */
    @BindView(R.id.tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.pager)
    ViewPager mViewPager;

//    @BindView(R.id.drawer_layout) DrawerLayout mDrawer;

    RecyclerView recyclerView;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        initToolbar().initNavBar().initTablayout();
    }

    private void _initNavBar(){
        List<AbstractDrawerItem> items = initDrawerItem(mTitles);

        int headRes = R.layout.layout_drawer_header;
        int toolbarRes = R.id.toolbar;
        AccountHeader ac = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.place_holder)
                .addProfiles(
                        new ProfileDrawerItem().withName("Namehere").withEmail("Id here").withIcon(getResources().getDrawable(R.mipmap.avatar))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        DrawerBuilder builder = new DrawerBuilder()
                .withActivity(this).withToolbar((Toolbar) findViewById(toolbarRes))
                .withAccountHeader(ac)
                // 关闭默认选取
                .withSelectedItem(-1)
                .withOnDrawerItemClickListener(new DrawerItemClickListener());

        // organize struct of menu
        for (AbstractDrawerItem item : items) {
            builder.addDrawerItems(item);
        }
        //
        builder.build();
    }
    private MainActivity initNavBar() {
        TestUtil.PrintLog(this,"Initial Nav Start...");
        _initNavBar();;
        TestUtil.PrintLog(this,"Initial Nav Success!");
        return this;
    }

    private void _initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private MainActivity initToolbar() {
        TestUtil.PrintLog(this,"Initial Toolbar Start...");
        _initToolbar();
        TestUtil.PrintLog(this,"Initial Toolbar Success!");
        return this;
    }

    private void _initTablayout(){
        mViewPager.setAdapter(
                new MainActivityPagerAdapter(
                        this.getSupportFragmentManager(),
                        new int[]{
                                R.layout.fragment_gallery,
                                R.layout.fragment_suggest,
                                R.layout.fragment_notification,
                                R.layout.fragment_about_me
                        },
                        this
                )
        );
        mTabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            if (i == 0){
                mTabLayout.getTabAt(i).setIcon(R.drawable.ic_local_florist_24dp);
            } else if (i==1){
                mTabLayout.getTabAt(i).setIcon(R.drawable.ic_whatshot_24dp);
            }else if (i==2){
                mTabLayout.getTabAt(i).setIcon(R.drawable.ic_bell_24dp);
            }else if (i==3){
                mTabLayout.getTabAt(i).setIcon(R.drawable.ic_face_24dp);
            }
        }
    }
    private MainActivity initTablayout() {
        TestUtil.PrintLog(this,"Initial Tablayout Start...");
        _initTablayout();
        TestUtil.PrintLog(this,"Initial Tablayout Success!");
        return this;
    }

    private List<AbstractDrawerItem> initDrawerItem(String[] titles) {
        List<AbstractDrawerItem> items = new ArrayList<>();
        for (int i = 0, mTitlesLength = titles.length; i < mTitlesLength; i++) {
            if (Objects.equals(titles[i], getResources().getString(R.string.NAN))) {
                DividerDrawerItem item = new DividerDrawerItem();
                items.add(item);
            } else {
                String title = titles[i];
                PrimaryDrawerItem item = new PrimaryDrawerItem().withName(title)
//                    .withIcon(getIcon(title))
                        ;
                items.add(item);
            }
        }
        return items;
    }

    /// TODO:: Need icon standard definition
//    private IIcon getIcon(String title) {
//        return ;
//    }

    private class DrawerItemClickListener implements Drawer.OnDrawerItemClickListener {
        @Override
        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
            TestUtil.PrintLog(view,position,true);
            switch (position){
                case 5:
                case 6:
                    Intent i = new Intent();
                    i.setClass(MainActivity.this,FollowActivity.class);
                    startActivity(i);
                    return false;
            }
            return false;
        }
    }
}
