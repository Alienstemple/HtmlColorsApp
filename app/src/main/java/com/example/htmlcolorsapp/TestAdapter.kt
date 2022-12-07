package com.example.htmlcolorsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.htmlcolorsapp.databinding.RowItemBinding

class TestAdapter(private val dataSet: ArrayList<Plant>) :
    RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    val plantList = ArrayList<Plant>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rowItemBinding = RowItemBinding.bind(view)

        fun bind(plant: Plant) = with(rowItemBinding) {  // Set img and text from data class Plant to row_item
            imageView.setImageResource(plant.imageId)
            rowTextView.text = plant.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.bind(plantList[position])
    }

    override fun getItemCount() = dataSet.size

    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()  // TODO Is necessary?
    }

}