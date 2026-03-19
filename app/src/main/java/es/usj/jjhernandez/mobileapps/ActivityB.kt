package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.component1
import androidx.activity.result.component2
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {
    private val view by lazy {
        ActivityBBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)
        view.button5.setOnClickListener { goingToActivityA() }
    }

    fun goingToActivityA() {
        val intent = Intent(this, ActivityA::class.java)
        startActivity(intent)
    }

 val contract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
     (resultCode, data) ->

     if(resultCode == RESULT_OK){
         val content = data?.getStringExtra("julio")?:""
         view.tvRestult.text = content

     }
 }


    fun goingToActivityD() {
        val intent = Intent(this, ActivityD::class.java)
        contract.launch(intent)


    }
}
