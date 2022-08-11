package com.rodrigomadeiro.bootstrap.domain.usecase

import com.rodrigomadeiro.bootstrap.data.repository.MtgRepository
import com.rodrigomadeiro.bootstrap.domain.entity.MtgColor
import javax.inject.Inject

class GetColorListUseCase @Inject constructor(){

    @Inject
    lateinit var repository: MtgRepository

    suspend fun getColors(): List<out MtgColor>{
        return repository.getColors()
    }
}