package es.usj.jjhernandez.mobileapps

import android.content.SharedPreferences
import es.usj.jjhernandez.mobileapps.model.Actor

const val ACTORS_SHARED_PREFERENCES_KEY = "actors"

class ActorSPDao(val actorSharedPreferences: SharedPreferences) : IDao<Actor> {

    override fun find(id: String): Actor? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Actor> {
        val set = actorSharedPreferences.getStringSet(ACTORS_SHARED_PREFERENCES_KEY, mutableSetOf())
        val actors = mutableListOf<Actor>()
        set?.forEach {
            actors.add(Actor(it.split(",")[0], it.split(",")[1]))
        }
        return actors
    }

    override fun insert(t: Actor): Actor {
        val sharedPreferences = actorSharedPreferences.getStringSet(ACTORS_SHARED_PREFERENCES_KEY, mutableSetOf<String>())
        with(actorSharedPreferences.edit()) {
            val mutableSet = mutableSetOf<String>()
            mutableSet.addAll(sharedPreferences.orEmpty())
            mutableSet.add(t.toString())
            putStringSet(ACTORS_SHARED_PREFERENCES_KEY, mutableSet)
            apply()
        }
        return t
    }

    override fun update(t: Actor): Actor {
        TODO("Not yet implemented")
    }

    override fun delete(t: Actor): Int {
        TODO("Not yet implemented")
    }
}