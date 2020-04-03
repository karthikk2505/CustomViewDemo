package com.kb.customviewapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class LovelyView extends View {
    private int circleCol, labelCol;
    //label text
    private String circleText;
    //paint for drawing custom view
    private Paint circlePaint;
    public LovelyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);
    }
    private void initViews(Context context,AttributeSet attrs)
    {
        circlePaint = new Paint();
        //get the attributes specified in attrs.xml using the name
        TypedArray a =context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.LovelyView, 0, 0);
        try {
            //get the text and colors specified using the names in
                    circleText =
                    a.getString(R.styleable.LovelyView_circleLabel);
            circleCol =
                    a.getInteger(R.styleable.LovelyView_circleColor,
                            0);//0 is default
            labelCol = a.getInteger(R.styleable.LovelyView_labelColor,
                    0);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;
        //get the radius as half of the width or height, whichever
        //subtract ten so that it has some space around it
        int radius = 0;
        if(viewWidthHalf>viewHeightHalf)
            radius=viewHeightHalf-10;
        else
            radius=viewWidthHalf-10;
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
        //set the paint color using the circle color specified
        circlePaint.setColor(circleCol);
        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius,
                circlePaint);
        //set the text color using the color specified
        circlePaint.setColor(labelCol);
        //set text properties
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(50);
        //draw the text using the string attribute and chosen
        canvas.drawText(circleText, viewWidthHalf, viewHeightHalf,
                circlePaint);
    }
    public void setCircleColor(int newColor){
        //update the instance variable
    circleCol=newColor;
    //redraw the view
    invalidate();
    requestLayout();
    }
    public void setLabelColor(int newColor){
        //update the instance variable
        labelCol=newColor;
        //redraw the view
        invalidate();
        requestLayout();
    }
    public void setLabelText(String newLabel){
        //update the instance variable
        circleText=newLabel;
        //redraw the view
        invalidate();
        requestLayout();
    }
}
