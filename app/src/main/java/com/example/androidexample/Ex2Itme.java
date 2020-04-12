package com.example.androidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Ex2Itme extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2_itme);

        tv1 = findViewById(R.id.item_tv_userInfo);


    }
}
