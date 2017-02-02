package edu.temple.colorpicker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);//does not know what it will look like until we add children adapters
        final View myLayout = findViewById(R.id.activity_main_layout); //because it is a view variable it can hold anything that is view, if we didn't use View we would have to cast ()

        String[] myColors = {"blue", "orange", "grey", "purple", "yellow"};

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myColors);

        listView.setAdapter(myAdapter);//tell our listview to use the adapter.

        AdapterView.OnItemClickListener oicl = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myLayout.setBackgroundColor(Color.parseColor(((TextView) view).getText().toString()));
            }
        };

        listView.setOnItemClickListener(oicl);


    }
}
