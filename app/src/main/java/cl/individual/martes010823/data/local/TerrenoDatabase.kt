package cl.individual.martes010823.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [TerrenoEntity::class], version = 1)
abstract class TerrenoDatabase : RoomDatabase() {

    abstract fun getTerrenoDao(): TerrenoDao

    companion object {
        @Volatile
        private var INSTANCE: TerrenoDatabase? = null

        fun getDatabase(context: Context): TerrenoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TerrenoDatabase::class.java,
                    "bar_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }

}