package com.rodrigomadeiro.bootstrap.ui.listcolors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigomadeiro.bootstrap.domain.entity.MtgColor
import com.rodrigomadeiro.bootstrap.domain.usecase.GetColorListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListColorsViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var getColorListUseCase: GetColorListUseCase

    val colors = MutableLiveData<List<MtgColor>>()

    fun getColors(){
        viewModelScope.launch {
            val resultColors = getColorListUseCase.getColors()
            colors.postValue(resultColors)
        }
    }
}