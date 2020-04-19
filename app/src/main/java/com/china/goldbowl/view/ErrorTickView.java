package com.china.goldbowl.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.china.goldbowl.R;


public class ErrorTickView extends View {
    private final Paint paint;
    private final Path path,drawPath;
    private float leftPathLength, rightPathLength;
    private final PathMeasure pathMeasure1,pathMeasure2;
    private float leftFraction;
    private float rightFraction;

    public ErrorTickView(Context context) {
        this(context, null);
    }

    public ErrorTickView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint =new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        path =new Path();
        drawPath=new Path();
        pathMeasure1=new PathMeasure();
        pathMeasure2 = new PathMeasure();


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ErrorTickView);
        setColor(a.getColor(R.styleable.ErrorTickView_ev_color, Color.WHITE));
        setStrokeWidth(a.getDimension(R.styleable.ErrorTickView_ev_strokeWidth,4f));
        a.recycle();
    }


    public void setColor(int color) {
        paint.setColor(color);
    }

    public void setStrokeWidth(float strokeWidth) {
        paint.setStrokeWidth(strokeWidth);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        final Rect bounds = new Rect(0,0,w,h);
        int radius= Math.min(w, h)/2;
        final int centerX = bounds.centerX();
        final int centerY = bounds.centerY();
        path.reset();
        path.moveTo((float) (centerX - Math.cos(Math.toRadians(45)) * radius), (float) (centerY - Math.sin(Math.toRadians(45)) * radius));
        path.lineTo((float) (centerX + Math.cos(Math.toRadians(45)) * radius), (float) (centerY + Math.sin(Math.toRadians(45)) * radius));
        pathMeasure1.setPath(path, false);
        leftPathLength = pathMeasure1.getLength();
        path.reset();
        path.moveTo((float) (centerX + Math.cos(Math.toRadians(45)) * radius), (float) (centerY - Math.sin(Math.toRadians(45)) * radius));
        path.lineTo((float) (centerX - Math.cos(Math.toRadians(45)) * radius), (float) (centerY + Math.sin(Math.toRadians(45)) * radius));
        pathMeasure2.setPath(path, false);
        rightPathLength = pathMeasure2.getLength();
    }


    public void startErrorTick() {
        AnimatorSet errorSet = new AnimatorSet();
        ValueAnimator animator1 = ValueAnimator.ofFloat(0.2f, 0.8f);
        animator1.setStartDelay(300);
        animator1.setInterpolator(new OvershootInterpolator());
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                leftFraction = (float) animation.getAnimatedValue();
                invalidate();
            }
        });

        ValueAnimator animator2 = ValueAnimator.ofFloat(0.2f, 0.8f);
        animator2.setInterpolator(new OvershootInterpolator());
        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                rightFraction = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        errorSet.play(animator1).before(animator2);
        errorSet.start();
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        paint.setPathEffect(null);
        drawPath.reset();
        drawPath.lineTo(0, 0);
        pathMeasure1.getSegment(0.2f * leftPathLength, rightFraction * leftPathLength, drawPath, true);
        canvas.drawPath(drawPath, paint);
        drawPath.reset();
        drawPath.lineTo(0, 0);
        pathMeasure2.getSegment(0.2f * rightPathLength, leftFraction * rightPathLength, drawPath, true);
        canvas.drawPath(drawPath, paint);
    }

}