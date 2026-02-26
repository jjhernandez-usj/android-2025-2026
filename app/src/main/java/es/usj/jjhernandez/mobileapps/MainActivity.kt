package es.usj.jjhernandez.mobileapps

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val LIFECYCLE = "LIFECYCLE"
    }

    private val view by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private fun log(methodName: String) {
        Log.v(LIFECYCLE, methodName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)
        view.btnSum.setOnClickListener {
            view.tvResult.text = sum().toString()
        }
        view.btnSubtract.setOnClickListener {
            view.tvResult.text = subtract().toString()
        }
        view.btnMultiply.setOnClickListener {
            view.tvResult.text = multiply().toString()
        }
        view.btnDivide.setOnClickListener {
            view.tvResult.text = divide().toString()
        }

        log("onCreate")
    }

    override fun onStart() {
        super.onStart()
        log("onStart")
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
    }

    override fun onPause() {
        super.onPause()
        log("onPause")
    }

    override fun onStop() {
        super.onStop()
        log("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        log("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
    }

    fun sum() : Double {
        val firstNumber = view.etFirstNumber.toDouble()
        val secondNumber = view.etSecondNumber.toDouble()
        return firstNumber + secondNumber
    }

    fun divide() : Double {
        val firstNumber = view.etFirstNumber.toDouble()
        val secondNumber = view.etSecondNumber.toDouble()
        if(secondNumber == 0.0) return 0.0
        return firstNumber / secondNumber
    }

    fun multiply() : Double {
        val firstNumber = view.etFirstNumber.toDouble()
        val secondNumber = view.etSecondNumber.toDouble()
        return firstNumber * secondNumber
    }

    fun subtract() : Double {
        val firstNumber = view.etFirstNumber.toDouble()
        val secondNumber = view.etSecondNumber.toDouble()
        return firstNumber - secondNumber
    }

}

fun EditText.toDouble(): Double {
    val textString = this.text.toString()
    if(textString.trim().isBlank()) return 0.0
    return textString.toDouble()
}