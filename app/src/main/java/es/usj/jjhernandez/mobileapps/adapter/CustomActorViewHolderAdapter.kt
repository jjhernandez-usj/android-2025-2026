package es.usj.jjhernandez.mobileapps.adapter


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import es.usj.jjhernandez.mobileapps.R
import es.usj.jjhernandez.mobileapps.model.Actor
import es.usj.jjhernandez.mobileapps.model.DataStore

class CustomActorViewHolderAdapter(
    context: Context,
    val resourceId: Int,
) : ArrayAdapter<Actor>(context, resourceId, DataStore.actors) {


    class ViewHolder {
        lateinit var text1 : TextView
        lateinit var text2 : TextView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val timestamp = System.currentTimeMillis()
        if(view == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(resourceId, null)
            Log.d("ADAPTER NEW VIEW", "New view ${System.currentTimeMillis() - timestamp}")
            val viewHolder =
                ViewHolder()
            viewHolder.text1 = view.findViewById(R.id.text1)
            viewHolder.text2 = view.findViewById(R.id.text2)
            view.tag = viewHolder
        } else {
            Log.d("ADAPTER REUSED VIEW", "Reused view ${System.currentTimeMillis() - timestamp}")
        }
        val value = getItem(position)
        val holder = view!!.tag as ViewHolder
        holder.text1.text = "${value?.id}"
        holder.text2.text = value?.name ?: "Unknown"
        return view
    }
}