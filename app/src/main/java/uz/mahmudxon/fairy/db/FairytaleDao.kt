package uz.mahmudxon.fairy.db

import androidx.room.Dao
import androidx.room.Query
import uz.mahmudxon.fairy.model.Fairytale

@Dao
interface FairytaleDao {
    @Query("select * from Fairytale")
    suspend fun getAll() : List<Fairytale>

    @Query("select * from Fairytale where id = (:id - 1) or id = :id or id = (:id + 1)")
    suspend fun getById(id : Int) : List<Fairytale>

    @Query("select * from Fairytale where title like :search")
    suspend fun getBySearch(search : String) : List<Fairytale>
}