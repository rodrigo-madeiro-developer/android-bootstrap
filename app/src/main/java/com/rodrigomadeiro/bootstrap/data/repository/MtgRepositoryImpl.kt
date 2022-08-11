package com.rodrigomadeiro.bootstrap.data.repository

import com.rodrigomadeiro.bootstrap.data.retrofit.MockyIoMtgRetrofitService
import com.rodrigomadeiro.bootstrap.domain.entity.MtgColor
import com.rodrigomadeiro.bootstrap.misc.runSafely
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

class MtgRepositoryImpl @Inject constructor(): MtgRepository {

    @Inject
    lateinit var service: MockyIoMtgRetrofitService

    override suspend fun getColors(): List<out MtgColor> {
        return  withContext(Dispatchers.IO) {
            service.list()
        }
    }

    override suspend fun getColor(id: String): MtgColor? {
        return withContext(Dispatchers.IO) {
            runSafely {  service.get(id).let {
                serviceObject->

                object : MtgColor{
                    override val id: String = id
                    override val name: String = serviceObject.name
                    override val icon: String = serviceObject.icon
                    override val text: String = serviceObject.text

                }
            }
            }
        }
    }
}