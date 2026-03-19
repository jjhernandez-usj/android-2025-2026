package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.usj.jjhernandez.mobileapps.databinding.ActivityBBinding
import es.usj.jjhernandez.mobileapps.databinding.ActivityCBinding
import androidx.core.net.toUri

class ActivityC : AppCompatActivity() {
    private val view by lazy {
        ActivityCBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)
        view.BTNGOTOA.setOnClickListener { goingToActivityA()}
        view.BTNCALL.setOnClickListener { doACall()}
        view.BTNEMAIL.setOnClickListener { sendingEmail()}
        }

    fun goingToActivityA() {
        val intent = Intent(this, ActivityA::class.java)
        startActivity(intent)
    }

    fun doACall() {
        val intent = Intent(Intent.ACTION_DIAL, "tel:911".toUri())


        startActivity(intent)

    }
        fun sendingEmail() {
        val intent = Intent(Intent.ACTION_SENDTO, "mailto:example@gmail.com".toUri())
            startActivity(intent)
    }

}