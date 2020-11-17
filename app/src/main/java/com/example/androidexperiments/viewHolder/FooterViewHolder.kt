package com.example.androidexperiments.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexperiments.data.ListItem
import com.example.androidexperiments.databinding.AdapterFooterBinding

class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = AdapterFooterBinding.bind(itemView)

    fun onBindView(footer: ListItem.Footer) {
        binding.textView.text = "FOOTER"
    }

}
