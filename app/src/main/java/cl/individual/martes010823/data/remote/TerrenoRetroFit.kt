package cl.individual.martes010823.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Cliente (sería la base de datos)
class TerrenoRetroFit {
        companion object {
            private const val URL_BASE =
                "https://android-kotlin-fun-mars-server.appspot.com/"

            fun getRetrofitTerreno() : TerrenoAPI {
                val mRetrofit = Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return mRetrofit.create(TerrenoAPI::class.java)
            }
        }
    }
