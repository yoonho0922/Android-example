package com.example.androidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Example2 extends AppCompatActivity {

    int[] userProfileImg = {R.drawable.daeng1, R.drawable.daeng2, R.drawable.daeng3, R.drawable.daeng4};
    String[] userName = {"사용자1", "사용자2", "사용자3", "사용자4"};
    String[] userInfo = {"사용자1입니다.", "사용자2입니다.", "사용자3입니다.", "사용자3입니다."};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        lv = findViewById(R.id.listView);

        ArrayList list = new ArrayList();
        //List에 Map형태로 저장
        for (int i = 0; i < userName.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userProImg", userProfileImg[i]);
            map.put("userName", userName[i]);
            map.put("userInfo", userInfo[i]);

            list.add(map);
        }

        //key랑 id 선언
        String[] keys = {"userProImg", "userName", "userInfo"};
        int[] ids = {R.id.custom_iv_userProImg, R.id.custom_tv_userName, R.id.custom_tv_userInfo};

        //adapter 선언
        //ArrayAdapter 기본 어댑터
        // android.R.layout.simple_list_item_1은 안드로이드에서 제공하는 기본 리스트 아이템
        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);

        //커스텀 어뎁터 이용
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.ex2_custom_item, keys, ids);

        //listView에 adapter 적용
        lv.setAdapter(adapter);
    }
}
