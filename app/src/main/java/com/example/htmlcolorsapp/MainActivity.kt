package com.example.htmlcolorsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.htmlcolorsapp.data.HtmlColor
import com.example.htmlcolorsapp.data.HtmlColorGeneral
import com.example.htmlcolorsapp.databinding.ActivityMainBinding
import com.example.htmlcolorsapp.misc.Constants
import com.example.htmlcolorsapp.misc.MarginItemDecoration

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding

    lateinit var colorAdapter: HtmlColorAdapter
    lateinit var multViewColorAdapter: HtmlMultipleViewTypeAdapter

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
        colorAdapter = HtmlColorAdapter(htmlColorList)

        // Create List and Adapter for main and secondary colors
        var htmlMultiViewColorList = arrayListOf<HtmlColorGeneral>(
            HtmlColorGeneral.HtmlColorMain("RED", "#FF0000", "255, 0, 0"),  // TODO add secondary colors
            HtmlColorGeneral.HtmlColorSecondary("#F4A460"),
            HtmlColorGeneral.HtmlColorSecondary("#DAA520"),
            HtmlColorGeneral.HtmlColorSecondary("#800000"),
            HtmlColorGeneral.HtmlColorSecondary("#CD853F"),
            HtmlColorGeneral.HtmlColorSecondary("#D2691E"),
            HtmlColorGeneral.HtmlColorSecondary("#A52A2A"),
            HtmlColorGeneral.HtmlColorMain("GREEN", "#00FF00", "0, 255, 0"),
            HtmlColorGeneral.HtmlColorMain("BLUE", "#0000FF", "0, 0, 255"),
        )
        multViewColorAdapter = HtmlMultipleViewTypeAdapter()
        multViewColorAdapter.setColorList(htmlMultiViewColorList)


//        mainBinding.apply {
//            // Access our RecyclerView from layout binding
//            testRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
////            testRecyclerView.adapter = colorAdapter  // pass adapter to RecyclerView
//            testRecyclerView.adapter = multViewColorAdapter
//
//            val dividerItemDecoration = DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL) // Divider orientation
//            ResourcesCompat.getDrawable(resources, R.drawable.color_item_divider, null)
//                ?.let { drawable -> dividerItemDecoration.setDrawable(drawable) }
//            // Variant 2:
////            getDrawable(R.drawable.color_item_divider)?.let { dr -> dividerItemDecoration.setDrawable(dr) }
//
//            testRecyclerView.addItemDecoration(dividerItemDecoration)
//            testRecyclerView.addItemDecoration(
//                MarginItemDecoration(
//                resources.getDimension(R.dimen.recycler_item_margin).toInt())
//            )
//        }

        mainBinding.apply {
            testRecyclerView.layoutManager = GridLayoutManager(this@MainActivity, Constants.SPAN_SIZE)
            testRecyclerView.adapter = multViewColorAdapter
            testRecyclerView.addItemDecoration(
                MarginItemDecoration(
                    resources.getDimension(R.dimen.recycler_item_margin).toInt())
            )
        }

        mainBinding.addColorButton.setOnClickListener {
            htmlMultiViewColorList.add(0, HtmlColorGeneral.HtmlColorMain("Blue", "#0000FF", "0, 0, 255"))
            multViewColorAdapter.setColorList(htmlMultiViewColorList)
        }

    }
}