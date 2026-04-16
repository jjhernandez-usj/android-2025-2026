package es.usj.jjhernandez.mobileapps

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import es.usj.jjhernandez.mobileapps.adapter.CustomArrayAdapter
import es.usj.jjhernandez.mobileapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val views by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private fun generate(size: Int) : MutableList<String> {
        return Array(size) { "Item $it" }.toMutableList()
    }

    lateinit var items : MutableList<String>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        items = generate(1000)
        val adapter =
            CustomArrayAdapter(this, R.layout.row_element, items.toTypedArray())
        views.lvArrayAdapter.adapter = adapter
        views.lvArrayAdapter.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_SHORT).show()
        }
    }
}