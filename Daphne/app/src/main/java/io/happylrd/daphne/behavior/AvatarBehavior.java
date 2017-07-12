package io.happylrd.daphne.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.happylrd.daphne.R;
import io.happylrd.youbo.common.util.TestUtil;


/**
 * <h1>modify class name here</h1>
 * io.happylrd.daphne.behavior
 * <p>
 * add description here
 *
 * @author Crepusculo
 * @version 1.0
 * @since 2017/7/10
 */

public class AvatarBehavior extends CoordinatorLayout.Behavior<View> {
    private final Context mContext;
    // 图片在 起始 居中
    private int cStartXPosition = 0;    // 起始的图片水平中心
    private int cStartYPosition = 0;    // 起始的图片垂直中心
    // 图片在 最终 位于顶部
    private int cFinalXPosition = 0;    // 最终的图片水平位置（与下均为非中心）
    private int cFinalYPosition = 0;    // 最终的图片垂直位置
    private int cardStartXPosition = 0; // 起始的 CardView 水平中心
    private int cardStartYPosition = 0; // 起始的 CardView 垂直中心
    private int cardStartY = 0;         // 起始的 CardView 的 Y 轴距离
    private int cStartWidth = 0;        // 图片开始宽度
    private int cFinalWidth = 0;        // 图片最终的宽度
    private int actionBarSize = 0;

    public AvatarBehavior(Context context, AttributeSet attrs) {
        mContext = context;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        // 依赖 CardView 控件
        return dependency instanceof CardView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        // 初始化属性
        shouldInitProperties(parent, child, dependency);
//        TestUtil.PrintLog(root,"cStartYPosition:\t"+cStartYPosition,false);
//        TestUtil.PrintLog(root,"cFinalYPosition:\t"+cFinalYPosition,false);
//        TestUtil.PrintLog(root,"cStartXPosition:\t"+cStartXPosition,false);
//        TestUtil.PrintLog(root,"cFinalXPosition:\t"+cFinalXPosition,false);


        // 定义最大 Y 轴滑动距离
        final int maxScrollDistance = cardStartY - actionBarSize - getStatusBarHeight();


        TestUtil.PrintLog(dependency, "maxScrollDistance\t" + maxScrollDistance, false);

        TestUtil.PrintLog(dependency, "moveDistanceY\t" + child.getWidth(), false);
        // 定义该滑动百分比
        float expendedPercentageFactor = (dependency.getY() - actionBarSize - getStatusBarHeight()) / maxScrollDistance;
        // 图片 Y 轴偏移距离
        float moveDistanceY = ((cStartYPosition - cFinalYPosition) * (1f - expendedPercentageFactor) + child.getWidth() / 2);
        // 图片 X 轴偏移距离
        float moveDistanceX = ((cStartXPosition - cFinalXPosition) * (1f - expendedPercentageFactor) + child.getWidth() / 2);
        // 图片缩小系数 (宽高一致因此只需计算一个）
        float cToSubtract = (cStartWidth - cFinalWidth) * (1f - expendedPercentageFactor);

        // 图片此时所在位置 (注意，此时是设置图片左上角的位置而非中心位置）
        child.setX(cStartXPosition - (int) moveDistanceX);
        child.setY(cStartYPosition - (int) moveDistanceY);
        // 图片此时大小
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        lp.width = (int)((cStartWidth -  cToSubtract)*0.9);
        lp.height = (int) ((cStartWidth - cToSubtract) * 0.5625);
        child.setLayoutParams(lp);
        return true;
    }

    /**
     * 初始化动画值
     *
     * @param child 被缩放控件
     * @param root  CardView
     */
    private void shouldInitProperties(CoordinatorLayout parent, View child, View root) {
        AppBarLayout appBarLayout = (AppBarLayout) parent.findViewById(R.id.appbar);

        TestUtil.PrintLog(root, "Width:\t" + appBarLayout.getWidth() / 2, false);
        TestUtil.PrintLog(root, "Height:\t" + appBarLayout.getHeight() / 2, false);
        TestUtil.PrintLog("\n\n");
        // 初始化图片开始位置中心
        if (cStartXPosition == 0) {
            int margin = 16;
            cStartXPosition = appBarLayout.getWidth() / 2 + margin;
        }
        if (cStartYPosition == 0) {
            cStartYPosition = appBarLayout.getHeight() / 2 + getStatusBarHeight();
        }

        // 初始化 CardView 中心
        if (cardStartXPosition == 0) {
//            cardStartXPosition = (int) root.getX() + root.getWidth() / 2;
            cardStartXPosition = 0;
        }

        if (cardStartYPosition == 0) {
            cardStartYPosition = (int) root.getY() + root.getHeight() / 2;
        }
        if (cardStartY == 0) {
            cardStartY = (int) root.getY();
        }

        // 获取当前 ActionBarSize
        if (actionBarSize == 0) {
            Toolbar toolbar = (Toolbar) parent.findViewById(R.id.toolbar);
            actionBarSize = toolbar.getHeight();
        }

        // 初始化图片最终位置 (中心)
        if (cFinalXPosition == 0) {
            cFinalXPosition = actionBarSize;
        }
        if (cFinalYPosition == 0) {
            cFinalYPosition = actionBarSize / 2 + getStatusBarHeight();
        }

        // 初始化组件开始与最终大小
        if (cStartWidth == 0) {
            cStartWidth = appBarLayout.getWidth();
        }
        if (cFinalWidth == 0) {
//            cFinalWidth = mContext.getResources().getDimensionPixelOffset(R.dimen.drawable);
            cFinalWidth = mContext.getResources().getDimensionPixelOffset(R.dimen.drawable);
        }


    }

    // 获取状态栏高度
    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) {
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}

