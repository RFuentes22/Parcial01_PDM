package com.example.basketballapp.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basketballapp.R
import com.example.basketballapp.Room.Entity.GameBasket
import kotlinx.android.synthetic.main.recyclerview_item.view.*


class GameBasketAdapter(val items: List<GameBasket>, val clickListener: (GameBasket) -> Unit):RecyclerView.Adapter<GameBasketAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], clickListener)


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: GameBasket, clickListener: (GameBasket) -> Unit) = with(itemView) {
            tv_game_name.text = " ${item.teamA}  VS  ${item.teamB}"
            //Log.d("pokwinfoViewHolder",item.toString())
            this.setOnClickListener { clickListener(item) }
        }
    }
}




/*
class GameBasketAdapter internal constructor(context: Context) :  RecyclerView.Adapter<GameBasketAdapter.GameViewHolder>
    () {


    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var games = emptyList<GameBasket>() // Cached copy of words

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameItemView: TextView = itemView.findViewById(R.id.tv_game_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val current = games[position]
        holder.gameItemView.text = current.teamA

    }

    internal fun setGames(games: List<GameBasket>) {
        this.games = games
        notifyDataSetChanged()
    }



    override fun getItemCount() = games.size

}
*/

