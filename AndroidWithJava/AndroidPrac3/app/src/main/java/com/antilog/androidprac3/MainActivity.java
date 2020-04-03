package com.antilog.androidprac3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_test;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_test = findViewById(R.id.et_test);
        /*str = et_test.getText().toString();
        * 해당 코드가 이 위치에 있을 경우 생명주기로 앱이 실행되었을때 저장된다.
        * 따라서 Intent 를 진행해도 빈화면이 나오는데 이는 생명주기를 onClick으로 옮겨서 버튼을 눌렀을때
        * 저장되도록 하면 해결 할 수 있다.*/


        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et_test.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                //현재 엑티비티와 이동할 액티비티를 써준다.
                intent.putExtra("str", str);
                //다음 액티비티에서 str(전)이라는 별명으로 str(후)값을 쓴다.
                startActivity(intent); //액티비티 이동
            }
        });
    }
}
