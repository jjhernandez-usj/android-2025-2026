package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import es.usj.jjhernandez.mobileapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val views by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        var hasPassword = false
        var hasUsername = false
        views.btnLogin.isEnabled = false
        views.etUsername.doOnTextChanged { text, _, _, _ ->
            hasUsername = text?.trim().toString().isNotEmpty()
            views.btnLogin.isEnabled = hasUsername && hasPassword
        }
        views.etPassword.doOnTextChanged { text, _, _, _ ->
            hasPassword = text?.trim().toString().isNotEmpty()
            views.btnLogin.isEnabled = hasUsername && hasPassword
        }
        views.btnLogin.setOnClickListener {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ActivityB::class.java))
        }
    }
}