package es.usj.jjhernandez.mobileapps

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
            goingToActivityB()
        }
        view.btnToC.setOnClickListener {
            goingToActivityC()
        }
    }

    fun goingToActivityB() {

    }

    fun goingToActivityC() {

    }
}