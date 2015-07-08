package com.example.administrator.percent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.administrator.percent.helper.PercentLayoutHelper;

/**
 * Created by Administrator on 15-7-7.
 */
public class PercentRelativeLayout extends RelativeLayout
{
    public PercentRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs)
    {
        return new LayoutParams(getContext(),attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        PercentLayoutHelper.measureChild(this);
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);

    }


    public class LayoutParams extends RelativeLayout.LayoutParams implements
            PercentLayoutHelper.PercentLayoutParams{
        private PercentLayoutHelper percentLayoutHelper;
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            percentLayoutHelper = new PercentLayoutHelper();
            percentLayoutHelper.setAttributeSet(c,attrs);
        }

        public LayoutParams(int w, int h) {
            super(w, h);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }
        @Override
        public PercentLayoutHelper.PercentLayoutInfo getPercentLayoutInfo() {
            return   percentLayoutHelper.getPercentLayoutInfo();
        }
        public void setPercentParent(int width,int height){
            percentLayoutHelper.setParent(width,height);
        }
    }
}
