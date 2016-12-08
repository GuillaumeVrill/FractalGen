package com.guillaume.fractalsgen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

import java.util.Random;

/**
 * Created by Guillaume on 07/12/2016.
 */
public class FractalMandelbrotView extends View {

    private int height;
    private int width;
    private Random rand;

    MandelbrotFractale mandelbrot;

    public FractalMandelbrotView(Context context){
        super(context);
        setBackgroundColor(Color.BLACK);
        rand = new Random();
    }

    @Override
    public void onDraw(Canvas canvas){
        height = canvas.getHeight();
        width = canvas.getWidth();

        //Dessin de la fractal:
        mandelbrot = new MandelbrotFractale();
        mandelbrot.drawMandelbrot(canvas);
    }

}
