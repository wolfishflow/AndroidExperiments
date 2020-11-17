package com.example.androidexperiments.data

import GetLoggedInUserQuery
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(val apolloClient: ApolloClient) : ViewModel() {

    private val _data: MutableLiveData<GetLoggedInUserQuery.Data?> = MutableLiveData()
    val data: LiveData<GetLoggedInUserQuery.Data?> get() = _data

    fun fetchData() {
        viewModelScope.launch {
            _data.value = apolloClient.query(GetLoggedInUserQuery()).toDeferred().await().data
        }
    }

}