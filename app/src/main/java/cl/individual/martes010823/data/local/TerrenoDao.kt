package cl.individual.martes010823.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TerrenoDao {

    @Insert
    suspend fun insertTerreno(terreno: TerrenoEntity)

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerrenosList(terrenosList: List<TerrenoEntity>)

    @Query("SELECT * FROM tabla_terreno ORDER BY id ASC")
    fun getTerrenoList(): LiveData<List<TerrenoEntity>>

    @Query("SELECT * FROM tabla_terreno WHERE id = :id")
    fun getTerrenoId (id:String) : LiveData<TerrenoEntity>

}