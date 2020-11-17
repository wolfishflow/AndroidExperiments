package com.example.androidexperiments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexperiments.data.ListItem
import com.example.androidexperiments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val abc = listOf(
            ListItem.Header,
            ListItem.Card("", "YOLO"),
            ListItem.Loading(true, ""),
            ListItem.Loading(true, ""),
            ListItem.Banner(""),
            ListItem.Loading(true, ""),
            ListItem.Footer
        )
        val adapter = MyAdapter()
        //setup RV
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter

        adapter.submitList(abc)


        val def = listOf(
            ListItem.Header,
            ListItem.Card("", "YOLO"),
            ListItem.Loading(true, ""),
            ListItem.Footer
        )

        binding.button.setOnClickListener {


            adapter.submitList(def)
        }
    }
}