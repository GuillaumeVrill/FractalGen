package com.guillaume.fractalsgen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    private ListView fractalList;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fractalList = (ListView)findViewById(R.id.list_fractal);

        ArrayList<String> fractal_list = new ArrayList<String>();
        fractal_list.addAll(Arrays.asList(getResources().getStringArray(R.array.fractals)));

        listAdapter = new ArrayAdapter<String>(this, R.layout.item_list_fractal, fractal_list);
        fractalList.setAdapter(new ListViewCustomAdapter(getApplicationContext(), getResources().getStringArray(R.array.fractals)));
        fractalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), DrawActivity.class);
                switch(position){
                    case 0:
                        i = new Intent(getApplicationContext(), InfosActivity.class);
                        break;

                    case 1:
                        i.putExtra("fractal_name", "f_tree");
                        break;

                    case 2:
                        i.putExtra("fractal_name", "f_mandelbrot");
                        break;

                    default: break;
                }
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}

class ListViewCustomAdapter extends BaseAdapter {

    Context context;
    String[] data;
    private static LayoutInflater inflater = null;

    public ListViewCustomAdapter(Context context, String[] data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.item_list_fractal, null);
        TextView text = (TextView) vi.findViewById(R.id.btn_list_fractal);
        text.setText(data[position]);
        return vi;
    }
}
