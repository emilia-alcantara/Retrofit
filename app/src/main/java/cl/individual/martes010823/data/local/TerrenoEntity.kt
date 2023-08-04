package cl.individual.martes010823.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_terreno")
data class TerrenoEntity(
    // acá pasamos el id en el constructor primario porque no es autogenerado
    // sin embargo, por ser String es más complejo de comparar, es preferible usar int autogenerado
    // @ColumnInfo(name = "first_name") val firstName: String (para cambiar nombre)
    @PrimaryKey val id: String,
    val price: Int,
    val type: String,
    val imgSrc: String
)