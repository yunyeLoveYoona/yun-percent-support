package com.example.administrator.percent.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.percent.R;


/**
 * Created by Administrator on 15-7-7.
 */
public class PercentLayoutHelper {
    private int parentWidth ;
    private int parentHeight;
    private PercentLayoutInfo percentLayoutInfo;
    private  TypedArray typedArray;
    public void setAttributeSet(Context context,AttributeSet attrs){
        if(percentLayoutInfo == null) {
            if (parentWidth == 0) {
                getScreen(context);
            }
            percentLayoutInfo = new PercentLayoutInfo();
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.percent_layout_params);
        }
    }
    public PercentLayoutInfo getPercentLayoutInfo(){
        int i =  typedArray.getInteger
                (R.styleable.percent_layout_params_layout_heightPercentH,0);
        int j = typedArray.getInteger
                (R.styleable.percent_layout_params_layout_heightPercentW,0);
        int m = (int)(
                typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_heightPercentW,0)/100.f*parentWidth);
        percentLayoutInfo.percent_height = typedArray.getInteger
                (R.styleable.percent_layout_params_layout_heightPercentH,0) == 0?(int)(
                typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_heightPercentW,0)/100.f*parentWidth):
                (int)(  typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_heightPercentH,0)/100.f*parentHeight);
        percentLayoutInfo.percent_width = (int)(typedArray.getInteger
                (R.styleable.percent_layout_params_layout_widthPercentH,0) == 0?
                typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_widthPercentW,0)/100.f*parentWidth:
                typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_widthPercentH,0)/100.f*parentHeight);
        percentLayoutInfo.percent_margin_left = typedArray.getInteger
                (R.styleable.percent_layout_params_layout_marginLeftPercentH,0) == 0?
                (int)(typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_marginLeftPercentW,0)/100.f*parentWidth):
                (int)( typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_marginLeftPercentH,0)/100.f*parentHeight);
        percentLayoutInfo.percent_margin_top = typedArray.getInteger
                (R.styleable.percent_layout_params_layout_marginTopPercentH,0) == 0?
                (int)(typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_marginTopPercentW,0)/100.f*parentWidth):
                (int)( typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_marginTopPercentH,0)/100.f*parentHeight);
        percentLayoutInfo.percent_margin_right = typedArray.getInteger
                (R.styleable.percent_layout_params_layout_marginRightPercentH,0) == 0?
                (int)(typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_marginRightPercentW,0)/100.f*parentWidth):
                (int)( typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_marginRightPercentH,0)/100.f*parentHeight);
        percentLayoutInfo.percent_margin_bottom = typedArray.getInteger
                (R.styleable.percent_layout_params_layout_marginBottomPercentH,0) == 0?
                (int)(typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_marginBottomPercentW,0)/100.f*parentWidth):
                (int)( typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_marginBottomPercentH,0)/100.f*parentHeight);
        percentLayoutInfo.percent_padding_left = typedArray.getInteger
                (R.styleable.percent_layout_params_layout_paddingLeftPercentH,0) == 0?
                (int)(typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_paddingLeftPercentW,0)/100.f*parentWidth):
                (int)( typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_paddingLeftPercentH,0)/100.f*parentHeight);
        percentLayoutInfo.percent_padding_top = typedArray.getInteger
                (R.styleable.percent_layout_params_layout_paddingTopPercentH,0) == 0?
                (int)(typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_paddingTopPercentW,0)/100.f*parentWidth):
                (int)( typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_paddingTopPercentH,0)/100.f*parentHeight);
        percentLayoutInfo.percent_padding_right = typedArray.getInteger
                (R.styleable.percent_layout_params_layout_paddingRightPercentH,0) == 0?
                (int)(typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_paddingRightPercentW,0)/100.f*parentWidth):
                (int)( typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_paddingRightPercentH,0)/100.f*parentHeight);
        percentLayoutInfo.percent_padding_bottom = typedArray.getInteger
                (R.styleable.percent_layout_params_layout_paddingBottomPercentH,0) == 0?
                (int)(typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_paddingBottomPercentW,0)/100.f*parentWidth):
                (int)( typedArray.getInteger
                        (R.styleable.percent_layout_params_layout_paddingBottomPercentH,0)/100.f*parentHeight);
        return percentLayoutInfo;
    }

    public interface PercentLayoutParams{
        public PercentLayoutInfo getPercentLayoutInfo();
        public void setPercentParent(int width ,int height);
    }
    private void getScreen(Context context){
        WindowManager windowManager = ((Activity)context).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        parentWidth = parentWidth = display.getWidth();
        parentHeight = parentHeight = display.getHeight();
    }
    public class PercentLayoutInfo{
        public int percent_width;
        public int percent_height;
        public int percent_margin_left;
        public int percent_margin_top;
        public int percent_margin_right;
        public int percent_margin_bottom;
        public int percent_padding_left;
        public int percent_padding_top;
        public int percent_padding_right;
        public int percent_padding_bottom;
    }
    public void setParent(int parentWidth,int parentHeight){
        this.parentWidth = parentWidth;
        this.parentHeight =parentHeight;
    }
    public static void measureChild(ViewGroup viewGroup){
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                if(viewGroup.getLayoutParams() instanceof PercentLayoutHelper.PercentLayoutParams){
                    ((PercentLayoutParams) child.getLayoutParams()).setPercentParent(((PercentLayoutParams) viewGroup.getLayoutParams()).getPercentLayoutInfo().percent_width,
                            ((PercentLayoutParams) viewGroup.getLayoutParams()).getPercentLayoutInfo().percent_height);
                }
                PercentLayoutHelper.PercentLayoutInfo percentLayoutInfo=
                        ((PercentLayoutParams) child.getLayoutParams()).getPercentLayoutInfo();


                if(child.getLayoutParams() instanceof RelativeLayout.LayoutParams){
                    RelativeLayout.LayoutParams layoutparms = (RelativeLayout.LayoutParams) child.getLayoutParams();
                    if(percentLayoutInfo.percent_height!=0&&percentLayoutInfo.percent_width!=0){
                       layoutparms.height = percentLayoutInfo.percent_height;
                        layoutparms.width = percentLayoutInfo.percent_width;
                    }
                    layoutparms.setMargins(percentLayoutInfo.percent_margin_left ==0?layoutparms.leftMargin:
                                    percentLayoutInfo.percent_margin_left,
                            percentLayoutInfo.percent_margin_top ==0?layoutparms.topMargin
                                    :percentLayoutInfo.percent_margin_top,
                            percentLayoutInfo.percent_margin_right ==0?layoutparms.rightMargin
                                    :percentLayoutInfo.percent_margin_right,
                            percentLayoutInfo.percent_margin_bottom ==0?layoutparms.bottomMargin
                                    :percentLayoutInfo.percent_margin_bottom
                    );
                }else   if(child.getLayoutParams() instanceof LinearLayout.LayoutParams){
                    LinearLayout.LayoutParams layoutparms = (LinearLayout.LayoutParams) child.getLayoutParams();
                    if(percentLayoutInfo.percent_height!=0&&percentLayoutInfo.percent_width!=0){
                        layoutparms.height = percentLayoutInfo.percent_height;
                        layoutparms.width = percentLayoutInfo.percent_width;
                    }
                    layoutparms.setMargins(percentLayoutInfo.percent_margin_left ==0?layoutparms.leftMargin:
                                    percentLayoutInfo.percent_margin_left,
                            percentLayoutInfo.percent_margin_top ==0?layoutparms.topMargin
                                    :percentLayoutInfo.percent_margin_top,
                            percentLayoutInfo.percent_margin_right ==0?layoutparms.rightMargin
                                    :percentLayoutInfo.percent_margin_right,
                            percentLayoutInfo.percent_margin_bottom ==0?layoutparms.bottomMargin
                                    :percentLayoutInfo.percent_margin_bottom
                    );
                }else  if(child.getLayoutParams() instanceof FrameLayout.LayoutParams){
                    FrameLayout.LayoutParams layoutparms = (FrameLayout.LayoutParams) child.getLayoutParams();
                    if(percentLayoutInfo.percent_height!=0&&percentLayoutInfo.percent_width!=0){
                        layoutparms.height = percentLayoutInfo.percent_height;
                        layoutparms.width = percentLayoutInfo.percent_width;
                    }
                    layoutparms.setMargins(percentLayoutInfo.percent_margin_left ==0?layoutparms.leftMargin:
                                    percentLayoutInfo.percent_margin_left,
                            percentLayoutInfo.percent_margin_top ==0?layoutparms.topMargin
                                    :percentLayoutInfo.percent_margin_top,
                            percentLayoutInfo.percent_margin_right ==0?layoutparms.rightMargin
                                    :percentLayoutInfo.percent_margin_right,
                            percentLayoutInfo.percent_margin_bottom ==0?layoutparms.bottomMargin
                                    :percentLayoutInfo.percent_margin_bottom
                    );
                }
                child.setPadding(percentLayoutInfo.percent_padding_left == 0 ? child.getPaddingLeft() : percentLayoutInfo.percent_padding_left,
                        percentLayoutInfo.percent_padding_top == 0 ? child.getPaddingTop() : percentLayoutInfo.percent_padding_top,
                        percentLayoutInfo.percent_padding_right == 0 ? child.getPaddingRight() : percentLayoutInfo.percent_padding_right,
                        percentLayoutInfo.percent_padding_bottom == 0 ? child.getPaddingBottom() : percentLayoutInfo.percent_padding_bottom);

            }
        }
    }
}
