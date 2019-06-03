package com.example.basketballapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.basketballapp.R
import com.example.basketballapp.Room.Entity.GameBasket
import kotlinx.android.synthetic.main.activity_game_viewer.*

class GameViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_viewer)

        val id: String = this.intent.extras.getString("CLAV") ?: "null"

        Log.d("val",id)


    }
    fun receivedata(games:GameBasket){

    }
}
