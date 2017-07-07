package io.happylrd.youbo.common.widget.component;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindArray;
import io.happylrd.youbo.common.R;

/**
 * <h1>modify class name here</h1>
 * io.happylrd.youbo.common.widget.component
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/6
 */

public class FakeModel {
    public String getTitle() {
        return mTitle;
    }

    public FakeModel setmTitles(String s) {
        this.mTitle = s;
        return this;
    }

    String mTitle;
    public FakeModel(){
        mTitle = "Randrom:"+(int)(Math.random()*100);
    }
}
