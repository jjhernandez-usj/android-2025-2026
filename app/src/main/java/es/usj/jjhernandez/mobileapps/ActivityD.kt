package es.usj.jjhernandez.mobileapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.usj.jjhernandez.mobileapps.databinding.ActivityCBinding
import es.usj.jjhernandez.mobileapps.databinding.ActivityDBinding

class ActivityD : AppCompatActivity() {

    private val view by lazy {
        ActivityDBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)

    }

    fun sendInfoToB(){

        val text = view.TVUserInput.text

        intent.putExtra("julio", text)
        setResult(RESULT_OK, intent)
        finish()

    }


}