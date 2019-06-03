package com.example.basketballapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basketballapp.Repository.GameBasketRepository
import com.example.basketballapp.Room.BasketRoomDatabase
import com.example.basketballapp.Room.Entity.GameBasket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameBasketViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GameBasketRepository
    // val allBooksEng: LiveData<List<Book>>

    init {
        val GameBasketDao = BasketRoomDatabase.getDatabase(application,viewModelScope).GameBasketDao()
        repository = GameBasketRepository(GameBasketDao)

    }

    fun insertGame(gameBasket: GameBasket) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertGame(gameBasket)
    }

    fun getByid(id:Long): LiveData<GameBasket> = repository.getByid(id)

    fun getAllGames(): LiveData<List<GameBasket>> = repository.getAll()


}