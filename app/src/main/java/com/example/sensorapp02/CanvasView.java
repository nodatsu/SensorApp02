package com.example.sensorapp02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {
    Paint paint;
    private float posX, posY;
    private float velX, velY;

    public CanvasView (Context con, AttributeSet as) {
        super(con, as);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas cv) {
        paint.setColor(Color.RED);
        cv.drawCircle(cv.getWidth() / 2 + posX, cv.getHeight() / 2 + posY, 50, paint);
    }

    public void setPos(float ax, float ay) {
        ax *= -1;
        float dt = 1.0f;

        posX += velX * dt + ax * dt * dt;
        velX += ax * dt;

        posY += velY * dt + ay * dt * dt;
        velY += ay * dt;

        invalidate();
    }

}
