package com.antilog.flagmentprac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button 매칭하기
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        //btn1이란 버튼을 눌렀을 때 실행
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FragmentTransaction 호출
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //Fragment를 상속하여 커스텀한
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.frame, fragment1);
                transaction.commit();
            }
        });

        //btn2이란 버튼을 눌렀을 때 실행
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FragmentTransaction 호출
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //Fragment를 상속하여 커스텀한
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.frame, fragment2);
                transaction.commit();
            }
        });

        //btn3이란 버튼을 눌렀을 때 실행
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FragmentTransaction 호출
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //Fragment를 상속하여 커스텀한
                Fragment3 fragment3 = new Fragment3();
                transaction.replace(R.id.frame, fragment3);
                transaction.commit();
            }
        });

        //btn1이란 버튼을 눌렀을 때 실행
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FragmentTransaction 호출
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //Fragment를 상속하여 커스텀한
                Fragment4 fragment4 = new Fragment4();
                transaction.replace(R.id.frame, fragment4);
                transaction.commit();
            }
        });


    }
}
