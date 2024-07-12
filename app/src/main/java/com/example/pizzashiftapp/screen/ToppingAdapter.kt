package com.example.pizzashiftapp.screen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizzashiftapp.R
import com.example.pizzashiftapp.databinding.CardToppingItemBinding
import com.example.pizzashiftapp.domain.model.PizzaIngredient
import com.example.pizzashiftapp.domain.model.PizzaIngredientType
import com.example.pizzashiftapp.domain.model.ingredientTranslationMap

class ToppingAdapter : RecyclerView.Adapter<ToppingAdapter.ToppingViewHolder>() {

    private var catalog: List<PizzaIngredient> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setCatalog(toppings: List<PizzaIngredient>) {
        catalog = toppings
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_topping_item, parent, false)
        return ToppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToppingViewHolder, position: Int) {
        val topping = catalog[position]
        holder.bind(topping)
    }

    override fun getItemCount(): Int {
        return catalog.size
    }

    class ToppingViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = CardToppingItemBinding.bind(view)

        fun bind(ingredient: PizzaIngredient) = with(binding) {

            val ingredientRu = translateIngredient(ingredient.name)
            title.text = ingredientRu

            price.text = itemView.context.getString(R.string.topping_cost, ingredient.cost.toInt())

            Glide.with(itemView.context)
                .load(ingredient.img)
                .into(imageView)

        }

        private fun translateIngredient(name: String): String {
            val type = PizzaIngredientType.entries.find { it.name.equals(name, ignoreCase = true) }
            return type?.let { ingredientTranslationMap[it] } ?: name
        }
    }
}