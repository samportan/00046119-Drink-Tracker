package com.sportan.drinktracker.ui.drink

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sportan.drinktracker.R
import com.sportan.drinktracker.data.drinks
import com.sportan.drinktracker.data.model.DrinkModel

class DrinkAdapter(private val OnClickDrink: (DrinkModel) -> Unit): RecyclerView.Adapter<DrinkAdapter.ViewHolderDrink>(){


    private var drinks: List<DrinkModel>? = null

    class ViewHolderDrink(itemView: View): RecyclerView.ViewHolder(itemView){
        fun Bind(drink: DrinkModel, OnClickDrink: (DrinkModel) -> Unit){
            val cardView: LinearLayout = itemView.findViewById(R.id.card_drink_view)
            val cardName: TextView = itemView.findViewById(R.id.card_drink_name)
            val cardDesc: TextView = itemView.findViewById(R.id.card_drink_ingredients)

            cardName.text = drink.name
            cardDesc.text = drink.ingredients

            cardView.setOnClickListener {
                OnClickDrink(drink)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDrink {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolderDrink(view)
    }

    override fun getItemCount(): Int = drinks?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolderDrink, position: Int) {
        drinks?.let {
            holder.Bind(it[position], OnClickDrink)
        }
    }

    fun submitData(drinks: List<DrinkModel>){
        this.drinks = drinks
    }

}