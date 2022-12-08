package com.example.htmlcolorsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.htmlcolorsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding

    lateinit var colorAdapter: HtmlColorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // Create list of colors and add it to Adapter
        var htmlColorList = arrayListOf(
            HtmlColor("red", "#FF0000", "255, 0, 0"),
            HtmlColor("green", "#00FF00", "0, 255, 0"),
            HtmlColor("blue", "#0000FF", "0, 0, 255"),
        )
        colorAdapter = HtmlColorAdapter()

        mainBinding.apply {
            // Access our RecyclerView from layout binding
            testRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            testRecyclerView.adapter = colorAdapter  // pass adapter to RecyclerView

            val dividerItemDecoration = DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL)
            ResourcesCompat.getDrawable(resources, R.drawable.color_item_divider, null)
                ?.let { drawable -> dividerItemDecoration.setDrawable(drawable) }
            // Variant 2:
//            getDrawable(R.drawable.color_item_divider)?.let { dr -> dividerItemDecoration.setDrawable(dr) }

            testRecyclerView.addItemDecoration(dividerItemDecoration)
        }
    }
}