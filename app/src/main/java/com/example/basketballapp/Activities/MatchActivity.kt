package com.example.basketballapp.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.basketballapp.R
import com.example.basketballapp.Room.Entity.GameBasket
import com.example.basketballapp.ViewModel.GameBasketViewModel
import kotlinx.android.synthetic.main.activity_match.*



class MatchActivity : AppCompatActivity() {
    var scoreTeamA = 0
    var scoreTeamB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        bt_team_a_3_p.setOnClickListener {
            scoreTeamA += 3
            tv_score_team_a.text = scoreTeamA.toString()
        }

        bt_team_a_2_p.setOnClickListener {
            scoreTeamA += 2
            tv_score_team_a.text = scoreTeamA.toString()
        }

        bt_team_a_free_throw.setOnClickListener {
            scoreTeamA += 1
            tv_score_team_a.text = scoreTeamA.toString()
        }

        bt_team_b_3_p.setOnClickListener {
            scoreTeamB += 3
            tv_score_team_b.text = scoreTeamB.toString()
        }

        bt_team_b_2_p.setOnClickListener {
            scoreTeamB += 2
            tv_score_team_b.text = scoreTeamB.toString()

        }

        bt_team_b_free_throw.setOnClickListener {
            scoreTeamB += 1
            tv_score_team_b.text = scoreTeamB.toString()
        }

        bt_reset.setOnClickListener {
            scoreTeamA = 0
            tv_score_team_a.text = scoreTeamA.toString()
            scoreTeamB = 0
            tv_score_team_b.text = scoreTeamB.toString()
        }

        bt_Finish.setOnClickListener {
            val viewModel = ViewModelProviders.of(this).get(GameBasketViewModel::class.java)

            val name_teamA = intent.getStringExtra("name_teamA")
            val name_teamB = intent.getStringExtra("name_teamB")
            val date = intent.getStringExtra("date")
            val time = intent.getStringExtra("time")

            viewModel.insertGame(GameBasket(0,name_teamA,name_teamB,scoreTeamA,scoreTeamB,date,time))
            Toast.makeText(this, "SAVED!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
