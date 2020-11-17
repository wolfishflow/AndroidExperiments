package com.example.androidexperiments.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexperiments.data.ListItem
import com.example.androidexperiments.databinding.AdapterBannerBinding

class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = AdapterBannerBinding.bind(itemView)

    fun onBindView(banner: ListItem.Banner) {

    }

}
