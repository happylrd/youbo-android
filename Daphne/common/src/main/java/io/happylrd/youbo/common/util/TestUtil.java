package io.happylrd.youbo.common.util;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.happylrd.youbo.common.widget.component.FakeModel;

/**
 * <h1>modify class name here</h1>
 * io.happylrd.youbo.common.util
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/5
 */

public class TestUtil {
    private static String sign = "Crepusculo.Daphne";

    public static String[] getTestStringArr(){
        return new String[]{"饺子","混沌","汤圆","出口","电脑","洗脚盆"};
    }
    public static void PrintLog(String s){
        Log.d(sign+"\t"+"NO CONTEXT EXIST",s);
    }
    public static void PrintLog(View v, String s,Boolean showToast){
        if(showToast){
            Toast.makeText(v.getContext(),s,Toast.LENGTH_LONG).show();
        }
        Log.d(sign+"\t"+v.toString(),s);
    }
    public static void PrintLog(View v, int i,Boolean showToast){
        PrintLog(v,"Num: "+i,showToast);
    }
    public static void PrintLog(View v, int i){
        PrintLog(v,"Num: "+i,false);
    }
    public static void PrintLog(Context ctx, String s) {
        Log.d(sign+"\t"+ctx.toString(),s);
    }

    public static FakeModel getFakeModel(){return new FakeModel();}

    public static List<FakeModel> getFakeModelList(int i) {
        ArrayList<FakeModel> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            list.add(new FakeModel());
        }
        return list;
    }

    public static void PrintError(View v,String s) {
        Log.e(sign+'\t'+v.toString(),s);
    }
}
