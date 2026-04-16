package es.usj.jjhernandez.mobileapps

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val views by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private fun generate(size: Int) : Array<String> {
        return Array(size) { "Item $it" }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        views.lvArrayAdapter.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            generate(1000)
        )

        views.lvArrayAdapter.onItemClickListener = AdapterView.OnItemClickListener { _, view, _, _ ->
            Toast.makeText(this, (view as TextView).text, Toast.LENGTH_SHORT).show()
        }
    }
}