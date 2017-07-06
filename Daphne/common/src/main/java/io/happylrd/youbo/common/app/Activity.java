package io.happylrd.youbo.common.app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;

import java.util.List;

import butterknife.ButterKnife;

public abstract class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initWindows();

        if (initArgs(getIntent().getExtras())) {
            int layoutId = getContentLayout();
            setContentView(layoutId);

            initWidget();
            initData();
        } else {
            finish();
        }
    }

    protected void initWindows() {

    }

    /**
     * 初始化相关参数
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    protected abstract int getContentLayout();

    protected void initWidget() {
        ButterKnife.bind(this);
    }

    protected void initData() {

    }

    @Override
    public boolean onSupportNavigateUp() {
        // 当点击界面导航返回时, finish当前界面
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        List<android.support.v4.app.Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof io.happylrd.youbo.common.app.Fragment) {
                    if (((io.happylrd.youbo.common.app.Fragment) fragment).onBackPressed()) {
                        return;
                    }
                }
            }
        }

        super.onBackPressed();
        finish();
    }

    // -- general method for start new activity --
    public void startActivity(Class activity,@Nullable Bundle bundle){
        Intent intent = new Intent();
        intent.setClass(this,activity);
        if(bundle != null) {
            intent.putExtra("bundle", bundle);
        }
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowEnterAnimations(int transitionResId) {
        Transition transition = TransitionInflater.from(this).inflateTransition(transitionResId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(transition);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowExitAnimations(int transitionResId) {
        Transition transition = TransitionInflater.from(this).inflateTransition(transitionResId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(transition);
        }
    }
}
