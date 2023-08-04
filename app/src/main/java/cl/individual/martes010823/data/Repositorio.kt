package cl.individual.martes010823.data

import androidx.lifecycle.LiveData
import cl.individual.martes010823.data.local.TerrenoDao
import cl.individual.martes010823.data.local.TerrenoEntity
import cl.individual.martes010823.data.remote.Terreno
import cl.individual.martes010823.data.remote.TerrenoAPI

class Repositorio(private val terrenoApi: TerrenoAPI, private val terrenoDao: TerrenoDao) {

    fun getAllTerrenos(): LiveData<List<TerrenoEntity>> {
        return terrenoDao.getTerrenoList()
    }

    suspend fun loadTerrenosToDatabase() {
        //consumir desde la api y cargar a la base de datos
        val response = terrenoApi.getData()
        if (response.isSuccessful) {
            val respBody = response.body()
            respBody?.let { terrenos ->
                val terrenosEntity = terrenos.map { it.toEntity() }
                terrenoDao.insertTerrenosList(terrenosEntity)
            }
        }

    }
}

// función de extensión para obtener una entidad (local) desde el terreno(remoto)
fun Terreno.toEntity(): TerrenoEntity =
    TerrenoEntity(this.id, this.price, this.type, this.imgSrc)
