package com.example.androidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Ex3Itme extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_itme);

        ImageView iv1 = findViewById(R.id.item_iv_userProImg);
        TextView tv1 = findViewById(R.id.item_tv_userInfo);
        TextView tv2 = findViewById(R.id.item_tv_userInfo);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다

        //intent에서 얻은 값 적용
        iv1.setImageResource(intent.getIntExtra("userProImg", 0));
        tv1.setText(intent.getStringExtra("userName"));
        tv2.setText(intent.getStringExtra("userInfo"));


    }// End of onCreate
}// End of class Ex3Item
