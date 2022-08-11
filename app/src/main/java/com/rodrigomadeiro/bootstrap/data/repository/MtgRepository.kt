package com.rodrigomadeiro.bootstrap.data.repository

import com.rodrigomadeiro.bootstrap.domain.entity.MtgColor

interface MtgRepository {
    suspend fun getColors(): List<out MtgColor>
    suspend fun getColor(id: String): MtgColor?
}