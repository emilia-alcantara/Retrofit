package cl.individual.martes010823.data

import cl.individual.martes010823.data.remote.Terreno
import cl.individual.martes010823.data.remote.TerrenoAPI

class Repositorio (private val terrenoApi:TerrenoAPI) {

    suspend fun getInfo() : List<Terreno>{
        val response = terrenoApi.getData()
        if (response.isSuccessful) {
            val respBody = response.body()
            respBody?.let {
                return it
            }
        }
        return emptyList()
    }


}