package es.usj.jjhernandez.mobileapps.adapter

import es.usj.jjhernandez.mobileapps.R

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomArrayAdapter(context: Context, private val resourceId: Int, items: Array<String>) :
    ArrayAdapter<String>(context, resourceId, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(resourceId,null)
        val text1 = view.findViewById<TextView>(R.id.text1)
        val text2 = view.findViewById<TextView>(R.id.text2)
        val value = getItem(position)
        text1.text = context.resources.getString(R.string.t1_text, value)
        text2.text = context.resources.getString(R.string.t2_text, value)
        Log.d("ADAPTER GET VIEW", value!!)
        return view
    }
}