package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val view by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(view.root)
        view.btnSum.setOnClickListener {
            //view.tvResult.text = sum().toString()
            navigate()
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

    fun navigate() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}

fun EditText.toDouble(): Double {
    val textString = this.text.toString()
    if(textString.trim().isBlank()) return 0.0
    return textString.toDouble()
}