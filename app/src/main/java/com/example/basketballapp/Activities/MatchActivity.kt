package com.example.basketballapp.Activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.basketballapp.R
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


        //val data: String = this.intent.extras.getString("AddData")

        //Log.d("data",data)

    }
}
