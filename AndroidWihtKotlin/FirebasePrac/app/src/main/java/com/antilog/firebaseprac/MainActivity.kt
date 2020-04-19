package com.antilog.firebaseprac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private var string_uid: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        // 이미 로그인한 경우는 currentUser 에 정보를 담아준다.
        val currentUser = auth.currentUser

        button_login.setOnClickListener {
            if (currentUser != null) {
                //이미 로그인 한 적이 있음
                Log.d("MainActivity", "이미 로그인함.")
                string_uid = currentUser.uid
            } else {
                //로그인 한 적이 없음
                //로그인 구현하기
                Log.d("MainActivity", "로그인 한적 없음 로직 실행")
                auth.signInAnonymously()
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = auth.currentUser
                            string_uid = user!!.uid
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

            }
        }
    }
}
