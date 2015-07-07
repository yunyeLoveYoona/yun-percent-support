package com.example.administrator.percent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.administrator.percent.helper.PercentLayoutHelper;

/**
 * Created by Administrator on 15-7-7.
 */
public class PercentRelativeLayout extends RelativeLayout
{
    private int mode;
    private static final int NEST_MODE = 1;//嵌套模式，外层父view也采用百分比设置
    private static final int FILL_MODE = 2;//满屏模式
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
        if(getLayoutParams()!=null&&getLayoutParams() instanceof PercentLayoutHelper.PercentLayoutParams){
            mode = NEST_MODE;
        }else{
            mode = FILL_MODE;
        }
        measureChild();
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);

    }
    private void measureChild(){
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                LayoutParams layoutparms = (LayoutParams) child.getLayoutParams();
                PercentLayoutHelper.PercentLayoutInfo percentLayoutInfo=layoutparms.getPercentLayoutInfo();
                layoutparms.height = percentLayoutInfo.percent_height;
                layoutparms.width = percentLayoutInfo.percent_width;
                layoutparms.setMargins(percentLayoutInfo.percent_margin_left ==0?layoutparms.leftMargin:
                percentLayoutInfo.percent_margin_left,
                        percentLayoutInfo.percent_margin_top ==0?layoutparms.topMargin
                                :percentLayoutInfo.percent_margin_top,
                        percentLayoutInfo.percent_margin_right ==0?layoutparms.rightMargin
                                :percentLayoutInfo.percent_margin_right,
                        percentLayoutInfo.percent_margin_bottom ==0?layoutparms.bottomMargin
                                :percentLayoutInfo.percent_margin_bottom
                        );
                child.setPadding(percentLayoutInfo.percent_padding_left==0?getPaddingLeft():percentLayoutInfo.percent_padding_left,
                        percentLayoutInfo.percent_padding_top==0?getPaddingTop():percentLayoutInfo.percent_padding_top,
                        percentLayoutInfo.percent_padding_right==0?getPaddingRight():percentLayoutInfo.percent_padding_right,
                        percentLayoutInfo.percent_padding_bottom==0?getPaddingBottom():percentLayoutInfo.percent_padding_bottom);
            }
        }

    }

    public class LayoutParams extends RelativeLayout.LayoutParams implements
            PercentLayoutHelper.PercentLayoutParams{
        private PercentLayoutHelper percentLayoutHelper;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            percentLayoutHelper = new PercentLayoutHelper();
            if(mode == NEST_MODE){
                percentLayoutHelper.setParent(((LayoutParams)getLayoutParams()).getPercentLayoutInfo().percent_width
                ,((LayoutParams)getLayoutParams()).getPercentLayoutInfo().percent_width);
            }
            percentLayoutHelper.setPercentLayoutInfo(c,attrs);
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
    }
}
