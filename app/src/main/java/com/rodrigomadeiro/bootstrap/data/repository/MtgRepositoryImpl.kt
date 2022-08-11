package com.rodrigomadeiro.bootstrap.data.repository

import com.rodrigomadeiro.bootstrap.data.retrofit.MockyIoMtgRetrofitService
import com.rodrigomadeiro.bootstrap.domain.entity.MtgColor
import com.rodrigomadeiro.bootstrap.misc.runSafely
import javax.inject.Inject
import javax.inject.Singleton

class MtgRepositoryImpl @Inject constructor(): MtgRepository {

    @Inject
    lateinit var service: MockyIoMtgRetrofitService

    override fun getColors(): List<out MtgColor> {
        return service.list()
    }

    override fun getColor(id: String): MtgColor? {
        return runSafely {  service.get(id).let {
            serviceObject->

            return object : MtgColor{
                override val id: String = id
                override val name: String = serviceObject.name
                override val icon: String = serviceObject.icon
                override val text: String = serviceObject.text

            }
        } }
    }
}