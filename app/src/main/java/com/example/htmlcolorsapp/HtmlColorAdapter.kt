package com.example.htmlcolorsapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.htmlcolorsapp.databinding.ColorItemBinding

class HtmlColorAdapter(private val colorArrayList: ArrayList<HtmlColor>):
    RecyclerView.Adapter<HtmlColorAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val colorItemBinding = ColorItemBinding.bind(view)  // step 1 -- bind

        fun bind(htmlColor: HtmlColor) = with(colorItemBinding){  // with -- instead of parameter
            // or .rgb(1,1,1), or .valueOf(0xffff0000)
            colorItemFrameLayout.setBackgroundColor(Color.parseColor("#FFF0000"))   // TODO from color array list
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.color_item, parent, false)  // step 2 -- inflate

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = colorArrayList.size
}