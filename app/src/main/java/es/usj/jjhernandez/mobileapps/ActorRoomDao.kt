package es.usj.jjhernandez.mobileapps

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import es.usj.jjhernandez.mobileapps.model.Actor

@Dao
interface ActorRoomDao : IDao<Actor> {

    @Query("SELECT * FROM Actor WHERE id = :id")
    override fun find(id: String): Actor?

    @Query("SELECT * FROM Actor")
    override fun findAll(): List<Actor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInternal(actor: Actor)

    override fun insert(t: Actor): Actor {
        insertInternal(t)
        return t
    }

    @Update
    fun updateInternal(actor: Actor)

    override fun update(t: Actor): Actor {
        updateInternal(t)
        return t
    }

    @Delete
    override fun delete(t: Actor): Int

}