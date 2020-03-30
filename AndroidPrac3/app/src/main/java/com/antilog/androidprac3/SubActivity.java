package com.antilog.androidprac3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tv_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub = findViewById(R.id.tv_sub);

        Intent intent = getIntent(); //Intent 로 날아오는 값을 받는다.
        String str = intent.getStringExtra("str"); //str 이라는 별명의 값을 String 방식으로 받는다.

        tv_sub.setText(str);
    }
}
