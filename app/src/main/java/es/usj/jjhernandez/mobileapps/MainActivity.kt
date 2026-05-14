package es.usj.jjhernandez.mobileapps

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import com.google.gson.Gson
import es.usj.jjhernandez.mobileapps.adapter.CustomActorViewHolderAdapter
import es.usj.jjhernandez.mobileapps.databinding.ActivityMainBinding
import es.usj.jjhernandez.mobileapps.model.Actor
import es.usj.jjhernandez.mobileapps.model.DataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

const val ID = "ID"

const val SERVER = "10.0.2.2"

class MainActivity : AppCompatActivity() {


    private val views by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val scope = CoroutineScope(Dispatchers.IO)

    lateinit var adapter : CustomActorViewHolderAdapter

    private val actorDao: IDao<Actor> by lazy {
        //ActorDao(MoviesSQLiteOpenHelper(this))
        //ActorSPDao(this.getPreferences(MODE_PRIVATE))
        RoomDB.getDatabase(this).playerDao()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        adapter = CustomActorViewHolderAdapter(context = this, resourceId = R.layout.row_element)
        views.lvArrayAdapter.adapter = this.adapter
        val database = Firebase.database
        val myRef = database.getReference("message")
        scope.launch {

            val myRef = database.getReference("message")

            myRef.setValue("Hello, World!")

            val url = URL("http://$SERVER:8080/actors")
            val result = url.readText()
            val actors = Gson().fromJson(result, Array<Actor>::class.java)
            DataStore.addAll(actors.toList())
            actors.toList().forEach {
                actorDao.insert(it)
            }
            val found = actorDao.findAll()

            runOnUiThread {
                adapter.notifyDataSetChanged()
                Toast.makeText(this@MainActivity, found.toString(), Toast.LENGTH_LONG).show()
            }
        }

        // Read from the database
        myRef.addValueEventListener( object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<String>()
                Log.d("TAG", "Value is: " + value)
                Toast.makeText(this@MainActivity, value.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("TAG", "Failed to read value.", error.toException())
            }

        })
    }


}