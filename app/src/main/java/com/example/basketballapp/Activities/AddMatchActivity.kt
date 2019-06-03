package com.example.basketballapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basketballapp.R
import kotlinx.android.synthetic.main.activity_add_match.*

class AddMatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_match)

        bt_confirm.setOnClickListener {
            val intent = Intent(this, MatchActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
