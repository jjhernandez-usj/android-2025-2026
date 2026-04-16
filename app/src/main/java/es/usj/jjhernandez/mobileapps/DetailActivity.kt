package es.usj.jjhernandez.mobileapps

import android.os.Bundle

import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityDetailBinding
import es.usj.jjhernandez.mobileapps.model.People
import es.usj.jjhernandez.mobileapps.model.Person

class DetailActivity : AppCompatActivity() {

    private val view by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    lateinit var person : Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        val id = intent.getStringExtra(ID)
        person = People.persons.first { it.id == id }
        view.et1.setText(person.name)
        view.et2.setText(person.familyName)
        view.et1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                person.name = view.et1.text.toString()
                person.familyName = view.et2.text.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }

        })
    }
}
