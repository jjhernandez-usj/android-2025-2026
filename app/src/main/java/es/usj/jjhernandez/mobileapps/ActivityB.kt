package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.component1
import androidx.activity.result.component2
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityBBinding

const val KEY = "message"
class ActivityB : AppCompatActivity() {

    private val view by lazy {
        ActivityBBinding.inflate(layoutInflater)
    }

    val contract =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { (resultCode, data) ->
            if (resultCode == RESULT_OK) {
                val content = data?.getStringExtra(KEY) ?: ""
                view.tvResult.text = content
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)
        view.btnBToA.setOnClickListener { goToA() }
        view.btnBToD.setOnClickListener { goToD() }
    }

    fun goToA() {
        val intent = Intent(this, ActivityA::class.java)
        startActivity(intent)
    }

    fun goToD() {
        val intent = Intent(this, ActivityD::class.java)
        contract.launch(intent)
    }
}
