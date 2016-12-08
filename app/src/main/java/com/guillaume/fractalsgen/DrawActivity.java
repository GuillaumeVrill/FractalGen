package com.guillaume.fractalsgen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class DrawActivity extends Activity {

    private FractalTreeView fTreeView;
    private FractalMandelbrotView fMandelbrotView;
    String fractalName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        fractalName = i.getStringExtra("fractal_name");
        switch(fractalName){
            case "f_tree":
                fTreeView = new FractalTreeView(this);
                setContentView(fTreeView);
                break;

            case "f_mandelbrot":
                fMandelbrotView = new FractalMandelbrotView(this);
                setContentView(fMandelbrotView);
                break;

            default: break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_draw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                switch(fractalName){
                    case "f_tree":
                        fTreeView = new FractalTreeView(getApplicationContext());
                        setContentView(fTreeView);
                        break;

                    case "f_mandelbrot":
                        fMandelbrotView = new FractalMandelbrotView(this);
                        setContentView(fMandelbrotView);
                        break;

                    default: break;
                }
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
