package com.antilog.androidprac4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_text;
    Button btn_test;
    String str;

    ImageView img_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_text = findViewById(R.id.et_text);

        btn_test = findViewById(R.id.btn_test);
        btn_test.setOnClickListener((v)->{
            str = et_text.getText().toString();
            Intent intent = new Intent(getApplicationContext(), SubActivity.class);
            intent.putExtra("str", str);
            startActivity(intent);
        });

        img_test = findViewById(R.id.img_test);
        img_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
