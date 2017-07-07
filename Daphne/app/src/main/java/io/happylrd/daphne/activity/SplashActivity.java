package io.happylrd.daphne.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.happylrd.youbo.common.app.Activity;

/**
 * <h1>SplashActivity</h1>
 * io.happylrd.daphne.activity
 * <p>
 * SplashActivity should not hold a view
 * SplashActivity will finished once data loading complete
 *
 * Load app initial data and global data
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/6
 */

public class SplashActivity extends AppCompatActivity {
    private static String BUNDLE = "BUNDLE";

    /**
     * Override onCreate because that SplashActivity DO NOT REQUIRE A VIEW
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadActivityData();
        Bundle bundle = new Bundle();
        /// TODO:: Validate user info cache
        startActivity(bundle,EntranceActivity.class);
        finish();
    }

    // -- general method for start new activity --
    public void startActivity(@Nullable Bundle bundle, Class activity){
        Intent intent = new Intent();
        intent.setClass(this,activity);
        if(bundle != null) {
            intent.putExtra("bundle", bundle);
        }
        startActivity(intent);
    }

    private void loadActivityData() {
        // get app initialize data here
        fakeLoad();
    }

    private void fakeLoad(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
