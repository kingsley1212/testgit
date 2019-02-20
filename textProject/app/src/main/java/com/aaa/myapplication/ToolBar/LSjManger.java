package com.aaa.myapplication.ToolBar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2018/11/6 0006.
 */

public class LSjManger extends RecyclerView.LayoutManager {
    private Context mContext;
    private int mItemViewWidth;
    private int mItemViewHeight;
    private int mItemCount;
    private int mScrollOffset = Integer.MAX_VALUE;
    private float mScale = 0.9f;

    public void LSjManger(Context context) {
        this.mContext = context;
        mItemViewWidth = (int) (getHorizontalSpace() * 0.87f);
        mItemViewHeight = (int) (mItemViewWidth * 1.46f);
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
    }
    /**
     * 测量itemview的确切大小
     */
    private void measureChildWithExactlySize(View child ) {
        final int widthSpec = View.MeasureSpec.makeMeasureSpec(mItemViewWidth, View.MeasureSpec.EXACTLY);
        final int heightSpec = View.MeasureSpec.makeMeasureSpec(mItemViewHeight, View.MeasureSpec.EXACTLY);
        child.measure(widthSpec, heightSpec);
    }

    @Override
    public boolean canScrollVertically() {
        return super.canScrollVertically();
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollVerticallyBy(dy, recycler, state);
    }

    /**
     * 获取RecyclerView的显示高度
     */
    public int getVerticalSpace() {
        return getHeight() - getPaddingTop() - getPaddingBottom();
    }

    public int getHorizontalSpace() {
        return getWidth() - getPaddingLeft() - getPaddingRight();
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() == 0 || state.isPreLayout()) return;
        removeAndRecycleAllViews(recycler);
        mItemViewWidth = (int) (getHorizontalSpace() * 0.87f);//item的宽度
        mItemViewHeight = (int) (mItemViewWidth * 1.46f);//item的高度
        mItemCount = getItemCount();
        mScrollOffset = Math.min(Math.max(mItemViewHeight, mScrollOffset), mItemCount * mItemViewHeight);
        layoutChild(recycler);
    }

    private void layoutChild(RecyclerView.Recycler recycler) {

    }
}
