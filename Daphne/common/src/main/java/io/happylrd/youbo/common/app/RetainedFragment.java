package io.happylrd.youbo.common.app;

import android.app.Fragment;
import android.os.Bundle;


/**
 * 用于保留大型状态(如位图), 小数据请用 `onSaveInstanceState()` 回调中的 Bundle 来完成
 */
public class RetainedFragment extends Fragment {

    // data object we want to retain
    private Object data;

    // this method is only called once for this fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
