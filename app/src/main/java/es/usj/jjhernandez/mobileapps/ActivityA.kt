package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityABinding

class ActivityA : AppCompatActivity() {

    private val view by lazy {
        ActivityABinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)
        view.btnToB.setOnClickListener {
            goToB()
        }
        view.btnToC.setOnClickListener {
            goToC()
        }
    }

    fun goToB() {
        val intent = Intent(this, ActivityB::class.java)
        startActivity(intent)
    }

    fun goToC() {
        val intent = Intent(this, ActivityC::class.java)
        startActivity(intent)
    }
}