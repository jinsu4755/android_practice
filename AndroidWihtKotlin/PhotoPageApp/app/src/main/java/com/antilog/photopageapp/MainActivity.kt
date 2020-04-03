package com.antilog.photopageapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1st.setOnClickListener {

            Toast.makeText(this, "1st Photo", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Photo1stActivity::class.java)
            startActivity(intent)
        }

        btn_2nd.setOnClickListener {
            Toast.makeText(this, "2nd Photo", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Photo2ndActivity::class.java)
            startActivity(intent)
        }

        btn_3rd.setOnClickListener {
            Toast.makeText(this, "3nd Photo", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Photo3rdActivity::class.java)
            startActivity(intent)
        }
    }
}
