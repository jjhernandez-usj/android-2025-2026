package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityBBinding

const val COMPANY_ID = "companyID"
const val COUNTRY = "country"
const val NAME = "name"

class ActivityB : AppCompatActivity() {

    private val views by lazy {
        ActivityBBinding.inflate(layoutInflater)
    }

    private val countries = arrayOf("Spain", "France", "Germany")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        views.spCountry.adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item,
            countries)
        showCitizen()
        views.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if(checkedId == views.rbCitizen.id) {
               showCitizen()
            } else {
               showCompany()
            }
        }
        views.btnInit.setOnClickListener { initOperation() }
    }

    fun showCitizen() {
        views.companyLayout.visibility = View.GONE
        views.citizenLayout.visibility = View.VISIBLE
    }

    fun showCompany() {
        views.companyLayout.visibility = View.VISIBLE
        views.citizenLayout.visibility = View.GONE
    }

    fun initOperation() {
        val destination = if(views.rbCitizen.isChecked) {
            CitizenActivity::class.java
        } else {
            CompanyActivity::class.java
        }
        val intent = Intent(this, destination)
        if(views.rbCompany.isChecked) {
            intent.putExtra(COMPANY_ID, views.etCompanyID.text.toString())
            intent.putExtra(COUNTRY, views.spCountry.selectedItem.toString())
        } else {
            intent.putExtra(NAME, "${views.etName.text} ${views.etSurname.text}")
        }
        startActivity(intent)
    }
}