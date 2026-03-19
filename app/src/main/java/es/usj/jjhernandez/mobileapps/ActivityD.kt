package es.usj.jjhernandez.mobileapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityDBinding

class ActivityD : AppCompatActivity() {

    private val view by lazy {
        ActivityDBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)
        view.btnReturnToB.setOnClickListener { sendInfoToB() }
    }

    fun sendInfoToB() {

        val text = view.tvUserInput.text

        intent.putExtra("julio", "$text")
        setResult(RESULT_OK, intent)
        finish()

    }


}