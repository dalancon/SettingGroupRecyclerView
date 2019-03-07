package com.dalancon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MineItemDecoration extends RecyclerView.ItemDecoration {
    /**
     * 分组的间距
     */
    private int sectionHeight;

    /**
     * 分割线的高度
     */
    private int dividerHeight = 2;

    /**
     * 分割线颜色
     */
    private String dividerColor = "#F4F4F4";

    /**
     * 组之间的区域颜色
     */
    private String groupDividerColor = "#F2F2F2";

    private Paint mPaint;

    private Paint mPaintWhite, dividerPaint;

    /**
     * 分割线左边的距离
     */
    private int divider_marginLeft = 0;

    /**
     * 显示头部的线条
     */
    private boolean showTopLine = true;

    /**
     * 显示底部的线条
     */
    private boolean showBottomLine = true;

    /**
     * 顶部和底部的分割线的左边距
     */
    private int topAndBottomMarginLeft = 0;

    private List<Integer> sections = new ArrayList<>();

    public MineItemDecoration(Context context) {
        sectionHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, context.getResources().getDisplayMetrics());
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor(groupDividerColor));

        mPaintWhite = new Paint();
        mPaintWhite.setAntiAlias(true);
        mPaintWhite.setColor(Color.WHITE);

        dividerPaint = new Paint();
        dividerPaint.setAntiAlias(true);
        dividerPaint.setColor(Color.parseColor(dividerColor));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int count = parent.getLayoutManager().getItemCount();
        int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        //显示顶部的线条
        if (showTopLine && position == 0) {
            outRect.top = dividerHeight;
        }
        //显示底部的线条
        if (showBottomLine && position == count - 1) {
            outRect.bottom = dividerHeight;
        }
        //其余的分割线
        if (position < count - 1) {
            if (sections.contains(position))//显示间距
                outRect.bottom = sectionHeight;
            else//显示分割线
                outRect.bottom = dividerHeight;
        }
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(canvas, parent, state);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int top = view.getBottom();

            //显示顶部的线条
            if (showTopLine && i == 0) {
                Rect rect = new Rect(0, view.getTop() - dividerHeight, view.getLeft() + topAndBottomMarginLeft, view.getTop());
                canvas.drawRect(rect, mPaintWhite);

                //再画分割线
                Rect rect1 = new Rect(view.getLeft() + topAndBottomMarginLeft, view.getTop() - dividerHeight, view.getWidth(), view.getTop());
                canvas.drawRect(rect1, dividerPaint);
            }
            //显示底部的线条
            if (showBottomLine && i == childCount - 1) {
                Rect rect = new Rect(0, top, view.getLeft() + topAndBottomMarginLeft, top + dividerHeight);
                canvas.drawRect(rect, mPaintWhite);

                //再画分割线
                Rect rect1 = new Rect(view.getLeft() + topAndBottomMarginLeft, top, view.getWidth(), top + dividerHeight);
                canvas.drawRect(rect1, dividerPaint);
            }

            if (sections.contains(i)) {
                Rect rect = new Rect(view.getLeft(), top, view.getWidth(), top + sectionHeight);
                canvas.drawRect(rect, mPaint);
            } else if(i != childCount - 1){
                //在item的底部画分割线
                //先画左边的留白
                Rect rect = new Rect(0, top, view.getLeft() + divider_marginLeft, top + dividerHeight);
                canvas.drawRect(rect, mPaintWhite);

                //再画分割线
                Rect rect1 = new Rect(view.getLeft() + divider_marginLeft, top, view.getWidth(), top + dividerHeight);
                canvas.drawRect(rect1, dividerPaint);
            }
        }

    }

    /**
     * 设置分割线高度
     *
     * @param dividerHeight
     */
    public MineItemDecoration setDividerHeight(int dividerHeight) {
        this.dividerHeight = dividerHeight;
        return this;
    }

    public MineItemDecoration setShowTopLine(boolean showTopLine) {
        this.showTopLine = showTopLine;
        return this;
    }

    public MineItemDecoration setShowBottomLine(boolean showBottomLine) {
        this.showBottomLine = showBottomLine;
        return this;
    }

    /**
     * 设置第一条上边和最后一条下边的线条距离左边的距离
     * @param topAndBottomMarginLeft
     * @return
     */
    public MineItemDecoration setTopAndBottomMarginLeft(int topAndBottomMarginLeft) {
        this.topAndBottomMarginLeft = topAndBottomMarginLeft;
        return this;
    }

    /**
     * 设置分割线左边的距离
     *
     * @param divider_marginLeft
     */
    public MineItemDecoration setDividerMarginLeft(int divider_marginLeft) {
        this.divider_marginLeft = divider_marginLeft;
        return this;
    }

    /**
     * 设置分组的下标
     * @param indexs
     * @return
     */
    public MineItemDecoration setSectionIndexs(Integer ...indexs){
        sections = Arrays.asList(indexs);
        return this;
    }

    /**
     * 设置分割线的颜色
     * @param dividerColor
     * @return
     */
    public MineItemDecoration setDividerColor(String dividerColor) {
        this.dividerColor = dividerColor;
        return this;
    }

    /**
     * 设置组之间的区域颜色
     * @param groupDividerColor
     * @return
     */
    public MineItemDecoration setGroupDividerColor(String groupDividerColor) {
        this.groupDividerColor = groupDividerColor;
        return this;
    }
}
