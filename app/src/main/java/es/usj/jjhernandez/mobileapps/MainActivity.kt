package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val view by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val contract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result: ActivityResult ->
        if(result.resultCode == RESULT_OK) {
            val data = result.data
            if(data != null) {
                view.tvResult.text = data.getStringExtra("result")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)
        view.btnStartActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            contract.launch(intent)
        }
    }
}