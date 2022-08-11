package com.rodrigomadeiro.bootstrap.data.retrofit

import com.rodrigomadeiro.bootstrap.domain.entity.MtgColor

data class MockyIoMtgColorListItem(
    override val id: String,
    override val name: String,
    override val icon: String
): MtgColor {
    override val text: String
        get() = ""
}

data class MockyIoMtgColorDetailItem(
    val name: String,
    val icon: String,
    val text: String
){
}