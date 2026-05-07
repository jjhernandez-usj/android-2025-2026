package es.usj.jjhernandez.mobileapps

import android.content.ContentValues
import es.usj.jjhernandez.mobileapps.model.Actor

class ActorDao(val db: MoviesSQLiteOpenHelper) : IDao<Actor> {

    override fun find(id: String): Actor? {
        val result = db.readableDatabase.query("Actors",
            arrayOf("id", "name"),
            "id = ?",
            arrayOf(id),
            null,
            null,
            null)
        result.moveToFirst()
        if (result.count == 0) return null
        val actor = Actor(result.getString(0), result.getString(1))
        result.close()
        db.close()
        return actor
    }

    override fun findAll(): List<Actor> {
        val result = db.readableDatabase.query("Actors",
            arrayOf("id", "name"),
            null,
            null,
            null,
            null,
            null)

        val actors = mutableListOf<Actor>()
        while(result.moveToNext()) {
            val actor = Actor(result.getString(0), result.getString(1))
            actors.add(actor)
        }
        result.close()
        db.close()
        return actors
    }

    override fun insert(t: Actor): Actor {
        val values = ContentValues()
        values.put("id", t.id)
        values.put("name", t.name)
        val result = db.writableDatabase.insert("Actors", null, values)
        return t
    }

    override fun update(t: Actor): Actor {
        TODO("Not yet implemented")
    }

    override fun delete(t: Actor): Int {
        TODO("Not yet implemented")
    }

}