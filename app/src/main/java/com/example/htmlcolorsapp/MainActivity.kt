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

    lateinit var colorAdapter: HtmlColorAdapter

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

        // Create list of colors and add it to Adapter
        var htmlColorList = arrayListOf(
            HtmlColor("red", "#FF0000", "255, 0, 0"),
            HtmlColor("green", "#00FF00", "0, 255, 0"),
            HtmlColor("blue", "#0000FF", "0, 0, 255"),
        )
        colorAdapter = HtmlColorAdapter(htmlColorList)

        mainBinding.apply {
            testRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            testRecyclerView.adapter = colorAdapter  // pass adapter to RecyclerView
        }
    }
}