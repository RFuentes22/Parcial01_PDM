package com.example.basketballapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basketballapp.Adapter.GameBasketAdapter
import com.example.basketballapp.R
import com.example.basketballapp.Room.Entity.GameBasket
import com.example.basketballapp.ViewModel.GameBasketViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewAdapter: GameBasketAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val newGameActivityRequestCode = 1
    //private lateinit var gameViewModel: GameBasketAdapter.GameViewHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Data()

        fab.setOnClickListener {

            val intent = Intent(this, AddMatchActivity::class.java)
            // start your next activity
            startActivity(intent)
        }



    }

    fun initRecycler(games: MutableList<GameBasket>){
        viewManager = LinearLayoutManager(this )

        viewAdapter = GameBasketAdapter(games, {gameItem: GameBasket -> gameItemClicked(gameItem)})

        recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
    private fun gameItemClicked(item: GameBasket){
        startActivity(Intent(this, GameViewer::class.java).putExtra("CLAVIER", item.id ))
    }

    fun Data(){
        val viewModel = ViewModelProviders.of(this).get(GameBasketViewModel::class.java)
        viewModel.getAllGames().observe(this, Observer { games ->

            // games?.let { adapter.setGames(it) }
            for (games in games) {
                Log.d("Lista de games", games.toString())



            }
            initRecycler(games as MutableList<GameBasket>)

        })

    }
}
