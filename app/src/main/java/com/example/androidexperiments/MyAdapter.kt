package com.example.androidexperiments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexperiments.data.ListItem
import com.example.androidexperiments.viewHolder.*

class MyAdapter : ListAdapter<ListItem, RecyclerView.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)

        // TODO determine if there is room to move these the sealed class
        return when (viewType) {
            R.layout.adapter_header -> HeaderViewHolder(view)
            R.layout.adapter_footer -> FooterViewHolder(view)
            R.layout.adapter_banner -> BannerViewHolder(view)
            R.layout.adapter_card -> CardViewHolder(view)
            else -> LoadingViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is HeaderViewHolder -> holder.onBindView()
            is FooterViewHolder -> holder.onBindView(item as ListItem.Footer)
            is BannerViewHolder -> holder.onBindView(item as ListItem.Banner)
            is CardViewHolder -> holder.onBindView(item as ListItem.Card)
            is LoadingViewHolder -> holder.onBindView(item as ListItem.Loading)
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (getItem(position)) {
            ListItem.Header -> R.layout.adapter_header
            ListItem.Footer -> R.layout.adapter_footer
            is ListItem.Banner -> R.layout.adapter_banner
            is ListItem.Card -> R.layout.adapter_card
            is ListItem.Loading -> R.layout.adapter_loading
        }

    companion object {
        object DiffCallback : DiffUtil.ItemCallback<ListItem>() {
            override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                // TODO is there a way to enforce listitems to have these methods? (ie interface?)
                return when(oldItem) {
                    ListItem.Header -> oldItem.hashCode() == newItem.hashCode()
                    ListItem.Footer -> oldItem.hashCode() == newItem.hashCode()
                    is ListItem.Banner -> oldItem.isItemTheSame(newItem)
                    is ListItem.Card -> oldItem.isItemTheSame(newItem)
                    is ListItem.Loading -> oldItem.isItemTheSame(newItem)
                }
            }

            override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}