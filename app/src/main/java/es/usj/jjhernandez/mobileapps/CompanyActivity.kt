package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.widget.doOnTextChanged
import es.usj.jjhernandez.mobileapps.databinding.ActivityCompanyBinding

class CompanyActivity : AppCompatActivity() {

    private val views by lazy {
        ActivityCompanyBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        val companyID = intent.getStringExtra(COMPANY_ID)
        views.etID.setText(companyID)
        views.btnCall.isEnabled = false
        views.btnSend.isEnabled = false
        views.btnOpen.isEnabled = false
        views.etPhoneNumber.doOnTextChanged { text, _, _, _ ->
            views.btnCall.isEnabled = text?.trim().toString().isNotEmpty()
        }
        views.etCompanyEmail.doOnTextChanged { text, _, _, _ ->
            views.btnSend.isEnabled = text?.trim().toString().isNotEmpty()
        }
        views.etWeb.doOnTextChanged { text, _, _, _ ->
            views.btnOpen.isEnabled = text?.trim().toString().isNotEmpty()
        }
        views.btnCall.setOnClickListener {
            call()
        }
        views.btnSend.setOnClickListener {
            send()
        }
        views.btnOpen.setOnClickListener {
            open()
        }
    }

    fun call() {
        val intent = Intent(Intent.ACTION_DIAL, "tel:${views.etPhoneNumber.text}".toUri())
        startActivity(intent)
    }

    fun send() {
        val intent = Intent(Intent.ACTION_SEND, "mailto:${views.etCompanyEmail.text}".toUri())
        startActivity(intent)
    }

    fun open() {
        val intent = Intent(Intent.ACTION_VIEW, "https://${views.etWeb.text}".toUri())
        startActivity(intent)
    }
}