package com.rodrigomadeiro.bootstrap.ui.listcolors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rodrigomadeiro.bootstrap.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class ListColorsFragment: Fragment() {

    //region Properties
    @Inject
    lateinit var adapter: ListColorsAdapter

    private val viewModel: ListColorsViewModel by viewModels()

    lateinit var recyclerView: RecyclerView
    //endregion

    //region Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_colors_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setupViewModel()
        setupEvents()

        load()
    }
    //endregion

    //region Setup
    private fun setupView(){
        recyclerView = requireView().findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
    }

    private fun setupViewModel(){
        viewModel.colors.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
    }

    private fun setupEvents(){

    }
    //endregion

    //region Misc
    private fun load(){
        viewModel.getColors()
    }
    //endregion
}