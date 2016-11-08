package com.guillaume.fractalsgen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

/**
 * Created by Guillaume on 06/11/2016.
 */
public class DrawView extends View {

    private int height;
    private int width;

    ArbreFractal arbre;

    public DrawView(Context context){
        super(context);
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void onDraw(Canvas canvas){
        height = canvas.getHeight();
        width = canvas.getWidth();

        arbre = new ArbreFractal();
        arbre.drawArbre(canvas, width/2, height, -90, 20);
    }

}
