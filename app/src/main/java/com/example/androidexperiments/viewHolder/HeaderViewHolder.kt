package com.example.androidexperiments.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexperiments.databinding.AdapterHeaderBinding

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = AdapterHeaderBinding.bind(itemView)

    fun onBindView() {
        binding.textView.text = "HEADER"
    }

}
