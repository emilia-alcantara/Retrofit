package cl.individual.martes010823.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.individual.martes010823.data.Repositorio
import cl.individual.martes010823.data.remote.Terreno
import cl.individual.martes010823.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(app: Application) : AndroidViewModel(app) {

    val repo: Repositorio
    val terrenosLiveData = MutableLiveData<List<Terreno>>()

    init {
        val api = TerrenoRetroFit.getRetrofitTerreno()
        repo = Repositorio(api)
    }

    fun getAllInfo() = viewModelScope.launch {
        terrenosLiveData.value = repo.getInfo()

    }


}