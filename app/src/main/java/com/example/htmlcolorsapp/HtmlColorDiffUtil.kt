package com.example.htmlcolorsapp

import androidx.recyclerview.widget.DiffUtil
import com.example.htmlcolorsapp.data.HtmlColorGeneral

class HtmlColorDiffUtil(
    private val oldList: ArrayList<HtmlColorGeneral>,
    private val newList: ArrayList<HtmlColorGeneral>
    ) : DiffUtil.Callback(){
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // TODO
        return (oldList[oldItemPosition] as HtmlColorGeneral.HtmlColorMain).hex == (newList[newItemPosition] as HtmlColorGeneral.HtmlColorMain).hex
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}