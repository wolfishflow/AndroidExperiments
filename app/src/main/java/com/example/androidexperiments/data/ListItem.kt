package com.example.androidexperiments.data

sealed class ListItem : DiffUtilable {
    object Header : ListItem() {
        override fun isItemTheSame(newItem: ListItem): Boolean {
            return false
        }
    }

    object Footer : ListItem() {
        override fun isItemTheSame(newItem: ListItem): Boolean {
            return false
        }
    }

    data class Banner(val imageUrl: String) : ListItem() {
        override fun isItemTheSame(newItem: ListItem): Boolean {
            return newItem is Banner &&
                    this.imageUrl == newItem.imageUrl
        }
    }

    data class Card(val imageUrl: String, val title: String) : ListItem() {
        override fun isItemTheSame(newItem: ListItem): Boolean {
            return newItem is Card &&
                    this.imageUrl == newItem.imageUrl &&
                    this.title == newItem.title
        }
    }

    data class Loading(val isLoading: Boolean, val errorMessage: String) : ListItem() {
        override fun isItemTheSame(newItem: ListItem): Boolean {
            return newItem is Loading &&
                    this.isLoading == newItem.isLoading &&
                    this.errorMessage == newItem.errorMessage
        }
    }
}

interface DiffUtilable {
    fun isItemTheSame(newItem: ListItem): Boolean
}
