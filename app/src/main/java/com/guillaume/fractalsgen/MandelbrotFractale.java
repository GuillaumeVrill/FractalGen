package com.guillaume.fractalsgen;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Guillaume on 07/12/2016.
 */
public class MandelbrotFractale {

    private Paint paint;
    private Random rand;

    public MandelbrotFractale(){
        paint = new Paint();
        paint.setColor(Color.WHITE);
        rand = new Random();
    }

    public void drawMandelbrot(Canvas c){
        c.drawLine(0,0, 100, 100, paint);
    }

}
