package cl.individual.martes010823.data.remote

import retrofit2.Response
import retrofit2.http.GET

// Interfaz de operaciones (En la base de datos sería DAO)
interface TerrenoAPI {
    @GET("realestate")
    suspend fun getData(): Response<List<Terreno>>
}