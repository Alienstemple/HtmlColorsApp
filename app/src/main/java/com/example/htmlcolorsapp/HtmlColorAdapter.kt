package com.example.htmlcolorsapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.htmlcolorsapp.data.HtmlColor
import com.example.htmlcolorsapp.databinding.MainColorItemBinding

class HtmlColorAdapter(private val colorArrayList: ArrayList<HtmlColor>):
    RecyclerView.Adapter<HtmlColorAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val colorItemBinding = MainColorItemBinding.bind(view)  // step 1 -- bind

        fun bind(htmlColor: HtmlColor) = with(colorItemBinding){  // with -- instead of parameter
            // or Color.rgb(1,1,1), or Color.valueOf(0xffff0000)
            colorItemFrameLayout.setBackgroundColor(Color.parseColor(htmlColor.hex))
            colorHtmlTextView.text = htmlColor.htmlName
            colorHexTextView.text = htmlColor.hex
            colorRgbTextView.text = htmlColor.rgb
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_color_item, parent, false)  // step 2 -- inflate

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(colorArrayList[position])
    }

    override fun getItemCount() = colorArrayList.size
}