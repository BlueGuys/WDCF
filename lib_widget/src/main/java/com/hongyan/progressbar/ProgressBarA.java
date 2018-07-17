package com.hongyan.progressbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wangning on 2018/6/11.
 */

public class ProgressBarA extends View {

    private static float WIDTH = 100.0f;
    private static float HEIGHT = 100.0f;

    private Paint paint;
    private int currentIndex = 1;

    private List<Item> list = new ArrayList<>();

    {
        list.add(new Item(0, 12, 20));
        list.add(new Item(22, 34, 20));
        list.add(new Item(44, 56, 20));
        list.add(new Item(66, 78, 20));
        list.add(new Item(88, 100, 20));
    }

    @SuppressLint("HandlerLeak")
    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            invalidate();
        }
    };

    public ProgressBarA(Context context) {
        super(context);
    }

    public ProgressBarA(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        Timer timer = new Timer();
        timer.schedule(new MyTimer(), 200, 200);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) WIDTH, (int) HEIGHT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawItems(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void drawItems(Canvas canvas) {
        for (int i = 0; i < list.size(); i++) {
            Item item = list.get(i);
            int gap = Math.abs(currentIndex - i);
            item.setHeight(20.0f + 50 / (gap + 1));
            Rect rect = new Rect(item.getLeft(), item.getTop(), item.getRight(), item.getBottom());
            paint.setColor(Color.parseColor("#66573e"));
            canvas.drawRect(rect, paint);
        }
    }

    class Item {
        private float left;
        private float right;
        private float height;

        Item(float left, float right, float height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }

        public void setHeight(float height) {
            this.height = height;
        }

        int getLeft() {
            return (int) left;
        }

        int getTop() {
            return (int) ((WIDTH - height) / 2);
        }

        int getRight() {
            return (int) right;
        }

        int getBottom() {
            return (int) (HEIGHT - getTop());
        }
    }

    class MyTimer extends TimerTask {

        @Override
        public void run() {
            currentIndex++;
            if (currentIndex > 4) {
                currentIndex = 0;
            }
            myHandler.sendEmptyMessage(1000);
        }
    }
}
