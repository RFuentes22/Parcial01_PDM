package com.example.basketballapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.basketballapp.R
import com.example.basketballapp.Room.Entity.GameBasket
import com.example.basketballapp.ViewModel.GameBasketViewModel
import kotlinx.android.synthetic.main.activity_game_viewer.*
import org.json.JSONObject

class GameViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_viewer)

        val id: Long = this.intent.extras.getLong("CLAVIER")

        Log.d("val", id.toString())


        val viewModel = ViewModelProviders.of(this).get(GameBasketViewModel::class.java)

        viewModel.getByid(id).observe(this, Observer { games ->

           // Log.d("Lista de gamesViewer", games.toString())


            tv2_nameTeamA.text = games.teamA
            tv2_nameTeamB.text = games.teamB
            tv2_scoreA.text = games.ScoreTeamA.toString()
            tv2_scoreB.text = games.ScoreTeamB.toString()
            tv2_date.text = games.date
            tv2_time.text = games.time
            tv2_winner.text = if (games.ScoreTeamA > games.ScoreTeamB)
            {
                games.teamA
            }
            else {
                games.teamB
            }

        })

    }
}



