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
    private Paint leafPaint;
    private Random rand;
    private int tonality;

    public ArbreFractal(){
        paint = new Paint();
        leafPaint = new Paint();
        paint.setColor(Color.WHITE);
        rand = new Random();
        tonality = rand.nextInt(8);
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
        double angle3 = angle+rand.nextInt(45)-rand.nextInt(45);
        int longToSoustract = 1 + rand.nextInt(3);
        drawArbre(c, x2, y2, angle1, longueur-longToSoustract, epaisseur, valReductionEpaisseur);
        drawArbre(c, x2, y2, angle2, longueur - longToSoustract, epaisseur, valReductionEpaisseur);
        if(rand.nextInt(3) == 1)
            drawArbre(c, x2, y2, angle3, longueur - longToSoustract, epaisseur, valReductionEpaisseur);

        //dessin des feuilles (probabilité dépendante de l'épaisseur):
        drawCircles(leafPaint, c, epaisseur, x2, y2, tonality);
    }

    private void drawCircles(Paint paint, Canvas c, int epaisseur, int posX, int posY, int colorTonality){
        getColorTonality(paint, colorTonality);
        if(epaisseur <= 38 && epaisseur > 20 && rand.nextInt(2)==1)
            c.drawCircle(posX + rand.nextInt(10) - rand.nextInt(10), posY + rand.nextInt(10) - rand.nextInt(10), 100 + rand.nextInt(30), paint);
        else if(epaisseur <= 20 && epaisseur > 14 && rand.nextInt(2)==1)
            c.drawCircle(posX + rand.nextInt(10) - rand.nextInt(10), posY + rand.nextInt(10) - rand.nextInt(10), 70 + rand.nextInt(30), paint);
        else if(epaisseur <= 14 && epaisseur > 8)
            c.drawCircle(posX + rand.nextInt(10) - rand.nextInt(10), posY + rand.nextInt(10) - rand.nextInt(10), 50 + rand.nextInt(30), paint);
        else if(epaisseur <= 8 && epaisseur > 4) {
            c.drawCircle(posX + rand.nextInt(5) - rand.nextInt(5), posY + rand.nextInt(5) - rand.nextInt(5), 30 + rand.nextInt(15), paint);
            if(rand.nextInt(2) == 1) {
                getColorTonality(paint, colorTonality);
                c.drawCircle(posX + rand.nextInt(5) - rand.nextInt(5), posY + rand.nextInt(5) - rand.nextInt(5), 30 + rand.nextInt(15), paint);
            }
        }
        else if(epaisseur <= 4) {
            c.drawCircle(posX + rand.nextInt(10) - rand.nextInt(10), posY + rand.nextInt(10) - rand.nextInt(10), 15 + rand.nextInt(10), paint);
            for(int i=0; i<2; i++) {
                if (rand.nextInt(2) == 1) {
                    getColorTonality(paint, colorTonality);
                    c.drawCircle(posX + rand.nextInt(10) - rand.nextInt(10), posY + rand.nextInt(10) - rand.nextInt(10), 15 + rand.nextInt(10), paint);
                }
            }
        }
    }

    private void getColorTonality(Paint paint, int tonality){
        if(tonality == 0) //VERT
            paint.setColor(Color.argb(120, 50, rand.nextInt(155) + 100, rand.nextInt(155)));
        else if(tonality == 1) //ORANGE
            paint.setColor(Color.argb(120, rand.nextInt(155) + 100, rand.nextInt(155), 50));
        else if(tonality == 2) //VIOLET
            paint.setColor(Color.argb(120, rand.nextInt(155) + 100, 50, rand.nextInt(155)+100));
        else if(tonality == 3) //JAUNE
            paint.setColor(Color.argb(120, rand.nextInt(100) + 155, rand.nextInt(100) + 155, 50));
        else if(tonality == 4) //BLANC
            paint.setColor(Color.argb(120, rand.nextInt(55) + 200, rand.nextInt(55) + 200, rand.nextInt(55) + 200));
        else if(tonality == 5) { //GRIS
            int greyTon = rand.nextInt(150)+50;
            paint.setColor(Color.argb(120, greyTon, greyTon, greyTon));
        }
        else if(tonality == 6) //ROUGE
            paint.setColor(Color.argb(120, rand.nextInt(155) + 100, 50, 50));
        else if(tonality == 7) //BLEU
            paint.setColor(Color.argb(120, 50, rand.nextInt(100) + 50, rand.nextInt(155) + 100));
    }

}
