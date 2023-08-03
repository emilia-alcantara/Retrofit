package cl.individual.martes010823.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.individual.martes010823.data.Repositorio
import cl.individual.martes010823.data.remote.TerrenoAPI
import cl.individual.martes010823.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(app: Application) : AndroidViewModel(app) {

    val repo: Repositorio

    init {
        val api = TerrenoRetroFit.getRetrofitTerreno()
        repo = Repositorio(api)
    }

    fun getAllInfo() = viewModelScope.launch {
        repo.getInfo()
    }


}