package com.example.searchapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.app.Activity;

public class MainActivity extends Activity {
    private SearchView srv1;
    private ListView lv1;
    private ArrayAdapter<String> aadapter;
    private String[] names;
    private ArrayList<String> alist;
    private int[] number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        srv1 = (SearchView) findViewById(R.id.srv1);
        number = new int[100];
        names = new String[100];
        for(int i=0; i<100;i++){
            number[i]=i+1;
            names[i]="这是第"+(i+1)+"行";
        }

        lv1 = (ListView) findViewById(R.id.lv1);
        aadapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, names);

        lv1.setAdapter(aadapter);

        srv1.setOnQueryTextListener(new OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO Auto-generated method stub
                if (newText.length() != 0) {
                    setFilterText(newText);
                } else {
                    clearTextFilter();
                }
                return false;
            }
        });
    }

    public void setFilterText(String filterText) {
        ArrayList<String> list = new ArrayList<String>();
        String[] tempStr;
        for (int i = 0; i < names.length; i++) {
            if (names[i].contains(filterText)) {
                list.add(names[i]);
            }
        }
        if (list.size() >= 0) {
            tempStr = new String[list.size()];
            int j = 0;
            for (String str : list) {
                tempStr[j++] = str;
            }
            aadapter = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_expandable_list_item_1, tempStr);
            lv1.setAdapter(aadapter);
        }
    }

    public void clearTextFilter() {
        aadapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, names);
        lv1.setAdapter(aadapter);
    }
}
