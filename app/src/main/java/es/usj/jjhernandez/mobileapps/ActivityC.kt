package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import es.usj.jjhernandez.mobileapps.databinding.ActivityCBinding

class ActivityC : AppCompatActivity() {

    private val view by lazy {
        ActivityCBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)
        view.btnCToA.setOnClickListener { goToA() }
        view.btnCall.setOnClickListener { call() }
        view.btnEmail.setOnClickListener { sendEmail() }
    }

    fun goToA() {
        val intent = Intent(this, ActivityA::class.java)
        startActivity(intent)
    }

    fun call() {
        val intent = Intent(Intent.ACTION_DIAL, "tel:911".toUri())
        startActivity(intent)
    }

    fun sendEmail() {
        val intent = Intent(Intent.ACTION_SENDTO, "mailto:example@gmail.com".toUri())
        startActivity(intent)
    }

}