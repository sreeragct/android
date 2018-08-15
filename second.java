package com.example.sree.mydetailspro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void btn1(View view){
        String btn="b1";
        Intent in = new Intent(this,third_.class);
        in.putExtra("btn",btn);
        startActivity(in);
    }
    public void btn2(View view){
        String btn="b2";
        Intent in = new Intent(this,third_.class);
        in.putExtra("btn",btn);
        startActivity(in);
    }
}
