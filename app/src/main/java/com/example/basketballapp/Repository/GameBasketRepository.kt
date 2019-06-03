package com.example.basketballapp.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.basketballapp.Room.Dao.GameBasketDao
import com.example.basketballapp.Room.Entity.GameBasket

class GameBasketRepository(private val gameBasketDao: GameBasketDao) {

    @WorkerThread
    suspend fun insertGame(gameBasket: GameBasket) {
        gameBasketDao.insert(gameBasket)
    }


    fun getAll(): LiveData<List<GameBasket>> = gameBasketDao.getAll()

    fun getByid(id:Long):LiveData<GameBasket> = gameBasketDao.getByid(id)

    //fun nuke() = gameBasketDao.nukeTable()



}
