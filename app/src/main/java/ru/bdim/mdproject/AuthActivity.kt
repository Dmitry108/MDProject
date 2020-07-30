package ru.bdim.mdproject

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        btn_enter_name.setOnClickListener {
            fun showError(message: String){
                Snackbar.make(it, message, Snackbar.LENGTH_LONG)
                    .setAction("Ok"){txt_name.requestFocus()}
                    .show()
            }
            when (txt_name.text.toString().length){
                0 -> showError("Enter name!")
                in 0..10 -> start()
                else -> showError("Too match characters")
            }
        }
        btn_close.setOnClickListener {
            finish()
        }
    }

    private fun start(){
        startActivity(Intent(this, MainActivity::class.java))
    }
}