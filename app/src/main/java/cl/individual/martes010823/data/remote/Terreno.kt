package cl.individual.martes010823.data.remote

import com.google.gson.annotations.SerializedName

// POJO (como el entity)
class Terreno(
    val id: String,
    val price: Int,
    val type: String,
    @SerializedName("img_src") val imgSrc: String
)