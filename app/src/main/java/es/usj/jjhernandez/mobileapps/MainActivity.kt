package es.usj.jjhernandez.mobileapps

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.adapter.CustomPeopleViewHolderAdapter
import es.usj.jjhernandez.mobileapps.databinding.ActivityMainBinding

const val ID = "ID"

class MainActivity : AppCompatActivity() {

    private val views by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var adapter : CustomPeopleViewHolderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        adapter = CustomPeopleViewHolderAdapter(context = this, resourceId = R.layout.row_element)
        views.lvArrayAdapter.adapter = this.adapter
        views.lvArrayAdapter.setOnItemClickListener { _, _, _, _ ->
           while(true) {
               Log.d("LOOPING", "Until freeze")
           }
        }
    }
}