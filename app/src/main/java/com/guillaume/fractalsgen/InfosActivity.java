package com.guillaume.fractalsgen;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class InfosActivity extends Activity {

    private TextView tv_link1;
    private TextView tv_link2;
    private TextView tv_link3;
    private TextView tv_link4;
    private TextView tv_link5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);

        tv_link1 = (TextView)findViewById(R.id.link1);
        tv_link1.setMovementMethod(LinkMovementMethod.getInstance());
        tv_link2 = (TextView)findViewById(R.id.link2);
        tv_link2.setMovementMethod(LinkMovementMethod.getInstance());
        tv_link3 = (TextView)findViewById(R.id.link3);
        tv_link3.setMovementMethod(LinkMovementMethod.getInstance());
        tv_link4 = (TextView)findViewById(R.id.link4);
        tv_link4.setMovementMethod(LinkMovementMethod.getInstance());
        tv_link5 = (TextView)findViewById(R.id.link5);
        tv_link5.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_infos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
