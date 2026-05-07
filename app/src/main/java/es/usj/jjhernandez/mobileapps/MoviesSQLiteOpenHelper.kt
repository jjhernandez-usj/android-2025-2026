package es.usj.jjhernandez.mobileapps

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val DATABASE_NAME = "movies"
const val DATABASE_VERSION = 1

class MoviesSQLiteOpenHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val CREATE_TABLE = "CREATE TABLE Actors (id TEXT, name TEXT)"
        private const val DROP_TABLE = "DROP TABLE IF EXISTS Actors"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(DROP_TABLE)
        db.execSQL(CREATE_TABLE)
    }
}