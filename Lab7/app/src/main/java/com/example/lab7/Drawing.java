package com.example.lab7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.os.Handler;
import android.view.View;


public class Drawing extends View {
    private Bitmap bitmap;
    private int lightIndex = -1;
    private RadialGradient radialGradient;
    private LinearGradient linearGradient;
    private Paint redBrush, yellowBrush, greenBrush;
    @SuppressWarnings("deprecation")
    private Handler handler = new Handler();

    public Drawing(Context context) {
        super(context);
        init();
    }

    public void init() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);

//        radialGradient=new RadialGradient(0,0,20, Color.GREEN,Color.BLUE, Shader.TileMode.REPEAT);
//        linearGradient=new LinearGradient(0,0,200,200,Color.RED,Color.BLACK,Shader.TileMode.MIRROR);

        redBrush = new Paint(Paint.ANTI_ALIAS_FLAG);
        redBrush.setColor(Color.RED);
        redBrush.setStrokeWidth(75f);

        yellowBrush = new Paint(Paint.ANTI_ALIAS_FLAG);
        yellowBrush.setColor(Color.YELLOW);
        yellowBrush.setStrokeWidth(75f);

        greenBrush = new Paint(Paint.ANTI_ALIAS_FLAG);
        greenBrush.setColor(Color.GREEN);
        greenBrush.setStrokeWidth(75f);


        handler.post(runnable);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (lightIndex == 0) {
            redBrush.setColor(Color.RED);
            yellowBrush.setColor(Color.GRAY);
            greenBrush.setColor(Color.GRAY);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2 - 678, 308f, redBrush);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, 308f, yellowBrush);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2 + 678, 308f, greenBrush);

        } else if (lightIndex == 1) {
            redBrush.setColor(Color.GRAY);
            yellowBrush.setColor(Color.YELLOW);
            greenBrush.setColor(Color.GRAY);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2 - 678, 308f, redBrush);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, 308f, yellowBrush);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2 + 678, 308f, greenBrush);
        } else if (lightIndex == 2) {

            redBrush.setColor(Color.GRAY);
            yellowBrush.setColor(Color.GRAY);
            greenBrush.setColor(Color.GREEN);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2 - 678, 308f, redBrush);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, 308f, yellowBrush);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2 + 678, 308f, greenBrush);
        }

//        canvas.drawBitmap(bitmap, (getMeasuredWidth()/2) - (bitmap.getWidth()/2),(getMeasuredHeight()/2) - (bitmap.getHeight()/2),null );
        canvas.save();
        super.onDraw(canvas);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            lightIndex = (lightIndex + 1) % 3;
            invalidate();
            handler.postDelayed(this, 500);
        }
    };

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacks(runnable);
    }
}
