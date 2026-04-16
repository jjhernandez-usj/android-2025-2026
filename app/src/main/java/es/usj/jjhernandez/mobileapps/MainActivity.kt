package es.usj.jjhernandez.mobileapps

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val views by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private fun generate(size: Int) : MutableList<String> {
        return Array(size) { "Item $it" }.toMutableList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            generate(1000)
        )

        views.lvArrayAdapter.adapter = adapter

        views.lvArrayAdapter.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selected = adapter.getItem(position)
            adapter.remove(selected)
            adapter.notifyDataSetChanged()
        }
    }
}