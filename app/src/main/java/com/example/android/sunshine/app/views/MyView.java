package com.example.android.sunshine.app.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

import com.example.android.sunshine.app.Utility;

/**
 * Created by davidduque on 9/15/15.
 */
public class MyView extends View {

    private float rotation = 0.0f;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*@TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }*/

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(2.5f);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setColor(Color.BLACK);

        Paint pathNorthPaint = new Paint();
        pathNorthPaint.setAntiAlias(true);
        pathNorthPaint.setStyle(Paint.Style.FILL);
        pathNorthPaint.setColor(Color.RED);

        Paint pathSouthPaint = new Paint();
        pathSouthPaint.setAntiAlias(true);
        pathSouthPaint.setStyle(Paint.Style.FILL);
        pathSouthPaint.setColor(Color.BLACK);

        int xPoint = getWidth() / 2;
        int yPoint = getHeight() / 2;

        float radius = (float) (Math.max(xPoint, yPoint) * 0.6);
        canvas.drawCircle(xPoint, yPoint, radius, circlePaint);

        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.rotate(rotation, xPoint, yPoint);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(xPoint, yPoint);
        path.lineTo(xPoint - 10, yPoint);
        path.lineTo(xPoint, yPoint - radius);
        path.lineTo(xPoint + 10, yPoint);
        path.close();

        canvas.drawPath(path, pathNorthPaint);

        path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(xPoint, yPoint);
        path.lineTo(xPoint - 10, yPoint);
        path.lineTo(xPoint, yPoint + radius);
        path.lineTo(xPoint + 10, yPoint);
        path.close();

        canvas.drawPath(path, pathSouthPaint);

        canvas.restore();
    }

    public void setRotationDegrees(float degrees) {
        rotation = degrees;
        invalidate();
    }

    /*@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int hSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int myHeight = hSpecSize;

//        if (hSpecMode == MeasureSpec.EXACTLY) {
//            myHeight = hSpecSize;
//        } else if (hSpecMode == MeasureSpec.AT_MOST) {
//            // Wrap Content
//        }

        int wSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int myWidth = wSpecSize;

        setMeasuredDimension(myWidth, myHeight);
    }*/

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        event.getText()
                .add(Utility.getWindDirectionAccesibleContentDescription(getContext(), rotation));
        setContentDescription(event.getText().toString());

        return true;
    }
}
