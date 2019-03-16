package com.example.sensorapp02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {
    Paint paint;

    public CanvasView (Context con, AttributeSet as) {
        super(con, as);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas cv) {
        paint.setColor(Color.RED);
        cv.drawCircle(cv.getWidth() / 2, cv.getHeight() / 2, 50, paint);
    }


}
