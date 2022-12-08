package com.example.htmlcolorsapp

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.htmlcolorsapp.databinding.MainColorItemBinding
import com.example.htmlcolorsapp.misc.Constants

class HtmlMultipleViewTypeAdapter:
    RecyclerView.Adapter<HtmlMultipleViewTypeAdapter.ViewHolder>() {
    private val TAG = "HtmlMultiViewAdaptLog"

    private val colorGeneralList = mutableListOf<HtmlColorGeneral>()   // Not in constructor

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val TAG = "HtmlMultiViewHolderLog"
        private val colorItemBinding = MainColorItemBinding.bind(view)  // step 1 -- bind

        private fun bindMainColor(htmlColor: HtmlColorGeneral.HtmlColorMain) = with(colorItemBinding) {
            // or Color.rgb(1,1,1), or Color.valueOf(0xffff0000)
            colorItemFrameLayout.setBackgroundColor(Color.parseColor(htmlColor.hex))
            colorHtmlTextView.text = htmlColor.htmlName
            colorHexTextView.text = htmlColor.hex
            colorRgbTextView.text = htmlColor.rgb
        }

        private fun bindSecondaryColor(htmlColor: HtmlColorGeneral.HtmlColorSecondary) {
            Log.d(TAG, "bindSecondaryColor")
        }

        fun bind(htmlColorGeneral: HtmlColorGeneral) {
            Log.d(TAG, "bind general function")
            when(htmlColorGeneral) {
                is HtmlColorGeneral.HtmlColorMain -> bindMainColor(htmlColorGeneral)
                is HtmlColorGeneral.HtmlColorSecondary -> bindSecondaryColor(htmlColorGeneral)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = when(viewType) {
            Constants.TYPE_COLOR_MAIN -> R.layout.main_color_item
            Constants.TYPE_COLOR_SECONDARY -> R.layout.secondary_color_item
            else -> throw IllegalArgumentException("Invalid view type")
        }

        Log.d(TAG, "Layout ${layout.toString()} was chosen")

        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)  // step 2 -- inflate

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(colorGeneralList[position])  // General fun
    }

    fun setColorList(colorlist: ArrayList<HtmlColorGeneral>) {   // Setter instead of constructor
        colorGeneralList.apply {
            clear()
            addAll(colorlist)
        }
    }

    override fun getItemCount() = colorGeneralList.size
    override fun getItemViewType(position: Int): Int {
        return when (colorGeneralList[position]) {
            is HtmlColorGeneral.HtmlColorMain -> Constants.TYPE_COLOR_MAIN
            is HtmlColorGeneral.HtmlColorSecondary -> Constants.TYPE_COLOR_SECONDARY
        }
    }
}