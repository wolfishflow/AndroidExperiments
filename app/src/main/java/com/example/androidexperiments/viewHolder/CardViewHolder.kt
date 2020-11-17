package com.example.androidexperiments.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexperiments.data.ListItem
import com.example.androidexperiments.databinding.AdapterCardBinding

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = AdapterCardBinding.bind(itemView)

    fun onBindView(card: ListItem.Card) {
        binding.textView.text = card.title
    }

}
