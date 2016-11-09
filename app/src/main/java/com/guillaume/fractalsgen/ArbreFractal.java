package com.guillaume.fractalsgen;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Guillaume on 06/11/2016.
 */
public class ArbreFractal {

    private Paint paint;
    private Random rand;

    public ArbreFractal(){
        paint = new Paint();
        paint.setColor(Color.GREEN);
        rand = new Random();
    }

    public void drawArbre(Canvas c, int x1, int y1, double angle, int longueur, int epaisseur, int valReductionEpaisseur){
        if(longueur <= 0)
            return;

        int x2 = x1 + (int)(Math.cos(Math.toRadians(angle)) * longueur * 10.0);
        int y2 = y1 + (int)(Math.sin(Math.toRadians(angle)) * longueur * 10.0);
        //Trait principal:
        c.drawLine(x1, y1, x2, y2, paint);
        //Traits secondaires pour l'épaisseur:
        for(int i=1; i<=epaisseur/2; i++) {
            c.drawLine(x1 + i, y1, x2 + i, y2, paint);
            c.drawLine(x1 - i, y1, x2 - i, y2, paint);
        }

        if(epaisseur >= 2)
            epaisseur -= valReductionEpaisseur;

        //Calcul des nouvelles coordonnées avec un peu de hasard:
        double angle1 = angle-rand.nextInt(45);
        double angle2 = angle+rand.nextInt(45);
        int longToSoustract = 1 + rand.nextInt(3);
        drawArbre(c, x2, y2, angle1, longueur-longToSoustract, epaisseur, valReductionEpaisseur);
        drawArbre(c, x2, y2, angle2, longueur - longToSoustract, epaisseur, valReductionEpaisseur);
    }

}
