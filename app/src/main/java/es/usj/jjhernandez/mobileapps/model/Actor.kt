package es.usj.jjhernandez.mobileapps.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Actor(
    @PrimaryKey val id: String,
    val name: String
) {

    override fun toString(): String {
        return "$id,$name"
    }
}