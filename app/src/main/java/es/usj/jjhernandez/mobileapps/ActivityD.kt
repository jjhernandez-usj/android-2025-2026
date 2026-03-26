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
        view.btnFinish.setOnClickListener { returnResult() }
    }

    fun returnResult() {
        val text = view.tvUserInput.text
        intent.putExtra(KEY, "$text")
        setResult(RESULT_OK, intent)
        finish()
    }
}