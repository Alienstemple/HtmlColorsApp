package com.example.htmlcolorsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.htmlcolorsapp.databinding.ActivityMainBinding
import com.example.htmlcolorsapp.databinding.RowItemBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding

    lateinit var plantAdapter: TestAdapter

    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        var plantList = arrayListOf<Plant>(
            Plant(imageIdList[0], "Plant 1"),
            Plant(imageIdList[1], "Plant 2")
        )
        plantAdapter = TestAdapter(plantList)

//        rowItemBinding = RowItemBinding.inflate(layoutInflater)  // initialize row item with layout
        mainBinding.apply {
            testRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            testRecyclerView.adapter = plantAdapter
        }
    }
}