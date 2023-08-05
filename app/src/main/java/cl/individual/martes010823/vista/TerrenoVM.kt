package cl.individual.martes010823.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.individual.martes010823.data.Repositorio
import cl.individual.martes010823.data.local.TerrenoDatabase
import cl.individual.martes010823.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(app: Application) : AndroidViewModel(app) {

    val repo: Repositorio
    fun terrenosLiveData () = repo.getAllTerrenos()

    init {
        val api = TerrenoRetroFit.getRetrofitTerreno()
        val terrenoDatabase = TerrenoDatabase.getDatabase(app).getTerrenoDao()
        repo = Repositorio(api, terrenoDatabase)
    }

    fun getAllInfo() = viewModelScope.launch {
        repo.loadTerrenosToDatabase()
    }

    fun getSelectedTerreno(id:String) = repo.getSelectedItem(id)


}