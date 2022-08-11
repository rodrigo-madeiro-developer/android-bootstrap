package com.rodrigomadeiro.bootstrap.ui.listcolors

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.rodrigomadeiro.bootstrap.R
import com.rodrigomadeiro.bootstrap.domain.entity.MtgColor
import javax.inject.Inject

class ListColorsAdapter @Inject constructor(): RecyclerView.Adapter<ListColorsAdapter.ViewHolder>() {

    //region Internal
    class ViewHolder(val view: ListColorFragmentItemCellView) : RecyclerView.ViewHolder(view)
    //endregion

    //region Properties
    @Inject
    lateinit var activity: Activity

    private val data = mutableListOf<MtgColor>()
    //endregion

    //region Public
    fun setData(newData: List<MtgColor>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    //endregion

    //region Overrides
    override fun getItemCount() = data.size
    //endregion

    //region Lifecycle
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.list_colors_fragment_item_cell, parent, false) as ListColorFragmentItemCellView

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data.get(position)
        holder.view.bind(item)
    }
    //endregion

    //region Misc
    //endregion
}