package com.example.htmlcolorsapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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


///////////////////////////////
//package com.example.htmlcolorsapp
//
//import android.graphics.Color
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.htmlcolorsapp.databinding.MainColorItemBinding
//import com.example.htmlcolorsapp.misc.Constants
//
//class HtmlColorAdapter:
//    RecyclerView.Adapter<HtmlColorAdapter.ViewHolder>() {
//
//    private val colorGeneralList = mutableListOf<HtmlColorGeneral>()   // Not in constructor
//
//    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
//        private val colorItemBinding = MainColorItemBinding.bind(view)  // step 1 -- bind
//
//        fun bind(htmlColor: HtmlColor) = with(colorItemBinding){  // with -- instead of parameter
//            // or Color.rgb(1,1,1), or Color.valueOf(0xffff0000)
//            colorItemFrameLayout.setBackgroundColor(Color.parseColor(htmlColor.hex))
//            colorHtmlTextView.text = htmlColor.htmlName
//            colorHexTextView.text = htmlColor.hex
//            colorRgbTextView.text = htmlColor.rgb
//        }
//
//        private fun bindMainColor(htmlColor: HtmlColorGeneral) {
//
//        }
//
//        private fun bindSecondaryColor(htmlColor: HtmlColorGeneral) {
//
//        }
//
//        fun bind(htmlColorGeneral: HtmlColorGeneral) {
//            when(htmlColorGeneral) {
//                is HtmlColorGeneral.HtmlColorMain -> bindMainColor(htmlColorGeneral)
//                is HtmlColorGeneral.HtmlColorSecondary -> bindSecondaryColor(htmlColorGeneral)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val layout = when(viewType) {
//            Constants.TYPE_COLOR_MAIN -> R.layout.main_color_item
//            Constants.TYPE_COLOR_SECONDARY -> R.layout.secondary_color_item
//            else -> throw IllegalArgumentException("Invalid view type")
//        }
//
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.main_color_item, parent, false)  // step 2 -- inflate
//
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(colorGeneralList[position])
//    }
//
//    override fun getItemCount() = colorGeneralList.size
//    override fun getItemViewType(position: Int): Int {
//        return when (colorGeneralList[position]) {
//            is HtmlColorGeneral.HtmlColorMain -> Constants.TYPE_COLOR_MAIN
//            is HtmlColorGeneral.HtmlColorSecondary -> Constants.TYPE_COLOR_SECONDARY
//        }
//    }
//}