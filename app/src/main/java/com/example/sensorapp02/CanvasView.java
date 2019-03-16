package com.example.sensorapp02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import static java.lang.Math.abs;

public class CanvasView extends View {
    private Paint paint;
    private float cvW, cvH;
    private float posX, posY;
    private float velX, velY;

    public CanvasView (Context con, AttributeSet as) {
        super(con, as);

        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas cv) {
        cvW = cv.getWidth();
        cvH = cv.getHeight();
        cv.drawColor(Color.YELLOW);
        paint.setColor(Color.RED);
        cv.drawCircle(cv.getWidth() / 2 + posX, cv.getHeight() / 2 + posY, 50, paint);
    }

    public void setPos(float ax, float ay) {
        ax *= -1;
        float dt = 0.1f;

        float preX = posX;
        posX += velX * dt + ax * dt * dt;
        velX += ax * dt;

        float preY = posY;
        posY += velY * dt + ay * dt * dt;
        velY += ay * dt;

        // 端の処理
        if (abs(posX) > cvW / 2 - 50) {
            velX *= 0;
            posX = preX;
        }
        if (abs(posY) > cvH / 2 - 50) {
            velY *= 0;
            posY = preY;
        }

        invalidate();
    }

}
