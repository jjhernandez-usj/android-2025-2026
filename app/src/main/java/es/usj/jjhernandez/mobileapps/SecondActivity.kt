package es.usj.jjhernandez.mobileapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val view by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)
        view.btnFinish.setOnClickListener { finished() }
    }

    fun finished() {
        intent.putExtra("result", "Finished")
        setResult(RESULT_OK, intent)
        finish()
    }
}