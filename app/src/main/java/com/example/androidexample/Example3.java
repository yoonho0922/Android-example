package com.example.androidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Example3 extends AppCompatActivity {

    ArrayList<User> list = new ArrayList<User>();   //User형의 list

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        lv = findViewById(R.id.listView);

        //list에 정보 집어넣기
        list.add(new User(R.drawable.daeng1,"사용자1","사용자 1입니다"));
        list.add(new User(R.drawable.daeng2,"사용자2","사용자 2입니다"));
        list.add(new User(R.drawable.daeng3,"사용자3","사용자 3입니다"));
        list.add(new User(R.drawable.daeng4,"사용자4","사용자 4입니다"));

        //어뎁터 객체 생성
        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.ex2_custom_item, list);
        lv.setAdapter(adapter); //리스트뷰에 어뎁터 적용

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Ex3Itme.class);

                // intent 객체에 데이터를 실어서 보내기
                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
                intent.putExtra("userProImg", list.get(position).userProImg);
                intent.putExtra("userName", list.get(position).userName);
                intent.putExtra("userInfo", list.get(position).userInfo);

                startActivity(intent);
            }
        }); // End of onCreate
    }// End of class
}

class MyAdapter extends BaseAdapter{

    Context context;
    int layout;
    ArrayList<User> list;
    LayoutInflater inf;
    public MyAdapter(Context context, int layout, ArrayList<User> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        inf = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inf.inflate(layout, null);
        }

        ImageView iv = (ImageView)convertView.findViewById(R.id.custom_iv_userProImg);
        TextView tvName = (TextView)convertView.findViewById(R.id.custom_tv_userName);
        TextView tvInfo = (TextView)convertView.findViewById(R.id.custom_tv_userInfo);

        User u = list.get(position);

        iv.setImageResource(u.userProImg);
        tvName.setText(u.userName);
        tvInfo.setText(u.userInfo);


        return convertView;
    }
} //End of class Myadapter

class User { // 자바빈
    int userProImg;
    String userName = "";
    String userInfo = "";
    public User(int userProImg, String userName, String userInfo) { //생성자
        super();
        this.userProImg = userProImg;
        this.userName = userName;
        this.userInfo = userInfo;
    }
    public User() {}
} //End of class User
