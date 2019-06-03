package com.example.basketballapp.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            tv_date_game.text= item.date

            this.setOnClickListener { clickListener(item) }
        }
    }
}




