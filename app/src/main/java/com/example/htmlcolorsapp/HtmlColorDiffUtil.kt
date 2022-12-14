package com.example.htmlcolorsapp

import androidx.recyclerview.widget.DiffUtil
import com.example.htmlcolorsapp.data.HtmlColorGeneral
import kotlin.reflect.typeOf

class HtmlColorDiffUtil(
    private val oldList: MutableList<HtmlColorGeneral>,
    private val newList: MutableList<HtmlColorGeneral>
    ) : DiffUtil.Callback(){
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // TODO
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}