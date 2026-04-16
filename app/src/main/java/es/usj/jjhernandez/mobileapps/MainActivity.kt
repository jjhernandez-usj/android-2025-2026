package es.usj.jjhernandez.mobileapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.adapter.CustomPeopleViewHolderAdapter
import es.usj.jjhernandez.mobileapps.databinding.ActivityMainBinding
import es.usj.jjhernandez.mobileapps.model.People

const val ID = "ID"

class MainActivity : AppCompatActivity() {

    private val views by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var adapter : CustomPeopleViewHolderAdapter

    private val contract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        adapter = CustomPeopleViewHolderAdapter(context = this, resourceId = R.layout.row_element, items = People.persons)
        views.lvArrayAdapter.adapter = this.adapter
        views.lvArrayAdapter.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailActivity::class.java)
            val person = People.persons[position]
            intent.putExtra(ID, person.id)
            contract.launch(intent)
        }
    }
}