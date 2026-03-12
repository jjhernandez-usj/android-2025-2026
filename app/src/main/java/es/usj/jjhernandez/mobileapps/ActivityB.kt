package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {
    private val view by lazy {ActivityBBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)

        view.btnToA.setOnClickListener {
            goingToActivityA()
        }

        view.btnToD.setOnClickListener {
            goingToActivityD()
        }
    }

    fun goingToActivityA() {
        val intent = Intent(this, ActivityA::class.java)
        startActivity(intent)
    }

    fun goingToActivityD() {

    }
}