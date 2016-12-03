package com.guillaume.fractalsgen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

import java.util.Random;

/**
 * Created by Guillaume on 06/11/2016.
 */
public class FractalTreeView extends View {

    private int height;
    private int width;
    private Random rand;

    ArbreFractal arbre;

    public FractalTreeView(Context context){
        super(context);
        setBackgroundColor(Color.BLACK);
        rand = new Random();
    }

    @Override
    public void onDraw(Canvas canvas){
        height = canvas.getHeight();
        width = canvas.getWidth();

        arbre = new ArbreFractal();
        arbre.drawArbre(canvas, width/2, height, -90, 20, 50, 4+rand.nextInt(3));
    }

}
