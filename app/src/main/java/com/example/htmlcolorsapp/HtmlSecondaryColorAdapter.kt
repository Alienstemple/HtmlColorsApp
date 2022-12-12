package com.example.htmlcolorsapp

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.htmlcolorsapp.data.HtmlColor
import com.example.htmlcolorsapp.data.HtmlColorMain
import com.example.htmlcolorsapp.databinding.MainColorItemBinding
import com.example.htmlcolorsapp.databinding.SecondaryColorItemBinding

class HtmlSecondaryColorAdapter(private val secondaryColorArrayList: ArrayList<HtmlColorMain.HtmlColorSecondary>) :
RecyclerView.Adapter<HtmlColorAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        init {
//            view.setOnClickListener {
//            }
//        }

        private val colorItemBinding = SecondaryColorItemBinding.bind(view)  // step 1 -- bind

        fun bind(htmlSecondaryColor: HtmlColorMain.HtmlColorSecondary) = with(colorItemBinding){  // with -- instead of parameter
            // or Color.rgb(1,1,1), or Color.valueOf(0xffff0000)
            secondaryColorFrameLayout.setBackgroundColor(Color.parseColor(htmlSecondaryColor.hex))
            textView.text = htmlSecondaryColor.hex
        }

        fun setOnClickListener() {
            itemView.setOnClickListener {
                Toast.makeText(it.context, "text", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HtmlColorAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HtmlColorAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = secondaryColorArrayList.size
}