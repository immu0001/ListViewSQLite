package com.example.listviewsqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ScannedList extends AppCompatActivity {

    DatabaseHelper db = new DatabaseHelper(this);

    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contents_layout);

        ListView listView=findViewById(R.id.LL);
        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = db.getListContents();
        if (data.getCount() == 0) {
            Toast.makeText(ScannedList.this, "NO DATA FOUND!!!", Toast.LENGTH_SHORT).show();
        } else {
            while (data.moveToNext()) {
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thelist);
                listView.setAdapter(listAdapter);
            }

        }

    }
}
