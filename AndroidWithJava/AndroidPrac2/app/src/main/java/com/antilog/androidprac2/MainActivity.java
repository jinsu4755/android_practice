package com.antilog.androidprac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_id;
    Button btn_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //onCreate 는 어플을 처음 실행하였을때 처음으로 실행하는 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //해당 xml 파일을 연결해서 실행

        et_id = findViewById(R.id.et_id);
        btn_button = findViewById(R.id.btn_button);

        btn_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                et_id.setText("im jinsu");
                //setText 는 엑션으로 값을 바꾸어줄때 사용한다.

            }
        });
    }
}
