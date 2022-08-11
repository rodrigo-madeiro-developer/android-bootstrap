package com.rodrigomadeiro.bootstrap.data.repository

import com.rodrigomadeiro.bootstrap.domain.entity.MtgColor

interface MtgRepository {
    fun getColors(): List<out MtgColor>
    fun getColor(id: String): MtgColor?
}