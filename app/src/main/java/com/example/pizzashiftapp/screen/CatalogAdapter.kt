package com.example.pizzashiftapp.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizzashiftapp.R
import com.example.pizzashiftapp.databinding.CardPizzaItemBinding
import com.example.pizzashiftapp.domain.model.Pizza


class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {

    private var catalog: List<Pizza> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setCatalog(pizzas: List<Pizza>) {
        catalog = pizzas
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_pizza_item, parent, false)
        return CatalogViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        val pizza = catalog[position]
        holder.bind(pizza)

        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("id", pizza.id)
                putString("name", pizza.name)
                putStringArray("ingredients", pizza.ingredients.map { it.name }.toTypedArray())
                putStringArray("price", pizza.sizes.map { it.price.toString() }.toTypedArray())
                putString("img", pizza.img)
            }

            Navigation.findNavController(holder.itemView).navigate(R.id.action_mainPageFragment_to_pizzaFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return catalog.size
    }

    class CatalogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = CardPizzaItemBinding.bind(view)

        fun bind(pizza: Pizza) = with(binding) {
            title.text = pizza.name
            info.text = pizza.description
            price.text = itemView.context.getString(R.string.pizza_price, pizza.sizes.firstOrNull()?.price?.toInt() ?: 0)

            Glide.with(itemView.context)
                .load(pizza.img)
                .into(imageView)

        }
    }
}