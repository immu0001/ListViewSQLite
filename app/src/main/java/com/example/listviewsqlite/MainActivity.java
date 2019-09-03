package com.example.listviewsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button add,view;
    EditText editText;
    DatabaseHelper db=new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     editText=findViewById(R.id.editText);
     add=findViewById(R.id.addbtn);
     view=findViewById(R.id.viewbtn);


     view.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent= new Intent(MainActivity.this,ScannedList.class);
             startActivity(intent);
         }
     });

     add.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String newEntry = editText.getText().toString();
             if(editText.length()!=0){
                 AddData(newEntry);
                 editText.setText("");
             }else{
                 Toast.makeText(MainActivity.this,"You Must put Something in here",Toast.LENGTH_LONG).show();
             }
         }
     });
    }

public void AddData(String newEntry){
        boolean insertData = db.adddata(newEntry);
        if(insertData){
            Toast.makeText(MainActivity.this,"Hurrey!!! Successfully inserted into the database",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"somethimg went wrong!!!",Toast.LENGTH_LONG).show();
        }

}

}
