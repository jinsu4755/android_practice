package com.antilog.thirdsemina.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.antilog.thirdsemina.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var toastMessage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_register -> {
                if (editTextNullOrBlank()) {
                    Toast.makeText(this@RegisterActivity, toastMessage, Toast.LENGTH_SHORT)
                        .show()
                } else {
                    //회원가입 요청시
                    requestRegister()
                }

            }
        }
    }

    private fun requestRegister(){
        

    }

    private fun editTextNullOrBlank(): Boolean {
        when {
            et_register_id.text.isNullOrBlank() -> {
                toastMessage = "아이디를 입력해주세요"
                return true
            }
            et_register_pw.text.isNullOrBlank() -> {
                toastMessage = "비밀번호를 입력해주세요"
                return true
            }
            et_register_pw_check.text.isNullOrBlank() -> {
                toastMessage = "비밀번호 확인 칸을 작성해주세요"
                return true
            }
            et_register_name.text.isNullOrBlank() -> {
                toastMessage = "이름을 입력해주세요"
                return true
            }
            et_register_email.text.isNullOrBlank() -> {
                toastMessage = "이메일을 입력해주세요"
                return true
            }
            et_register_phone.text.isNullOrBlank() -> {
                toastMessage = "전화번호를를 입력해주세요"
                return true
            }
        }
        return false
    }
}
