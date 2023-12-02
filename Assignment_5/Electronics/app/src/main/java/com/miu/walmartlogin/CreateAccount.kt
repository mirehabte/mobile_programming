package com.miu.walmartlogin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        btnCreateAccount.setOnClickListener{
            val result = User(etFirstName.text.toString(),etLastName.text.toString(),etEmail.text.toString(),etPassword.text.toString())
            val rintent = intent
            rintent.putExtra("user", result)
            setResult(Activity.RESULT_OK, rintent)
            Toast.makeText(this, "Account created successfully.", Toast.LENGTH_LONG).show()
            finish()

        }
    }
    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

}