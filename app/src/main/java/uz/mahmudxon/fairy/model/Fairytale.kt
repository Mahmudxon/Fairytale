package uz.mahmudxon.fairy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fairytale(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val img: String?,
    val story: String
)
{
    override fun toString(): String {
        return "$id -> $title"
    }
}