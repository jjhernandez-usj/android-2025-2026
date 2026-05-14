package es.usj.jjhernandez.mobileapps

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import es.usj.jjhernandez.mobileapps.model.Actor

@Database(
    entities = [Actor::class],
    version = 1
)
abstract class RoomDB : RoomDatabase() {

    abstract fun playerDao(): ActorRoomDao

    companion object {
        private var INSTANCE: RoomDB? = null
        fun getDatabase(context: Context): RoomDB {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, RoomDB::class.java, "actor-database.db")
                            .fallbackToDestructiveMigration(true)
                            .build()
                }
            }
            return INSTANCE!!
        }
    }

}

class RoomDBApp : Application() {
    val db = Room
        .databaseBuilder(applicationContext, RoomDB::class.java, "actors-database")
        .build()
}