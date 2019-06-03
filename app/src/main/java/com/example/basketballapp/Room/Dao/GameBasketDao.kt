package com.example.basketballapp.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.basketballapp.Room.Entity.GameBasket

@Dao
interface GameBasketDao {

    @Query("SELECT * from GameBasket ORDER BY id ASC")
    fun getAll(): LiveData<List<GameBasket>>

    @Insert
    suspend fun insert(game: GameBasket)

    @Query("DELETE FROM GameBasket")
    fun deleteAll()
}
