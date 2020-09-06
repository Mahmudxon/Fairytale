package uz.mahmudxon.fairy.db

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.mahmudxon.fairy.model.Fairytale

@Database(entities = [Fairytale::class], version = 1, exportSchema = false)
abstract class FairytaleDB : RoomDatabase() {
    abstract fun getDao() : FairytaleDao
}