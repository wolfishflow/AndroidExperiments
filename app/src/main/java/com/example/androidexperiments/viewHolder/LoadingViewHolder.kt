package com.example.androidexperiments.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexperiments.data.ListItem
import com.example.androidexperiments.databinding.AdapterLoadingBinding

class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = AdapterLoadingBinding.bind(itemView)

    fun onBindView(loading: ListItem.Loading) {

    }

}
