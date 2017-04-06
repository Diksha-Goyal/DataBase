package com.example.student.databasedemo;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DBConnection db;
    private EditText edt1,edt2,edt3,edt4;
    private Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        db=new DBConnection(MainActivity.this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id= Integer.parseInt(edt1.getText().toString());
                String name= (edt2.getText().toString());
                int price= Integer.parseInt(edt3.getText().toString());
                int qty= Integer.parseInt(edt4.getText().toString());
                boolean flag= db.insertData(id,name,price,qty);
                if(flag)
                {
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    refresh();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Data is not Inserted",Toast.LENGTH_LONG).show();
                }
//                if (db.insertData(id,name,price,qty)) {
//                    Toast.makeText(MainActivity.this, "Save", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "Not Save", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.display();
            }
        });

    }
    public void init()
    {
        edt1= (EditText) findViewById(R.id.edtId);
        edt2= (EditText) findViewById(R.id.edtName);
        edt3= (EditText) findViewById(R.id.edtPrice);
        edt4= (EditText) findViewById(R.id.edtQty);
        btn1= (Button) findViewById(R.id.btnSave);
        btn2= (Button) findViewById(R.id.btnDisplay);

    }
    public void refresh()
    {
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");


    }


}
