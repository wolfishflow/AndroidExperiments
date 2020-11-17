package com.example.androidexperiments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.androidexperiments.data.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //private val mainViewModel: MainViewModel by viewModels()
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.fetchData()
        viewModel.data.observe(this) { data ->
            data?.let {
                Toast.makeText(this, data.viewer.login, Toast.LENGTH_SHORT).show()
            }
        }
    }
}