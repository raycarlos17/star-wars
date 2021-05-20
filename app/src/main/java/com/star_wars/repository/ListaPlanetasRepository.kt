package com.star_wars.repository

import android.content.Context
import android.widget.Toast
import com.star_wars.api.ListaPlanetasMyRetrofit
import com.star_wars.model.ListaPlanetasModel
import com.star_wars.model.Planeta
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaPlanetasRepository(private val listaPlanetasApiTask: ListaPlanetasMyRetrofit) {

    companion object{
        private const val REQUEST_SUCCESS = 200
    }

    fun getListaPlanetas(context: Context, onSuccess: (List<Planeta>) -> Unit, onError: (Context, Int?) -> Unit) {
        val request = listaPlanetasApiTask.retrofitApi().getListaPlanetasApi()

        request.enqueue(object: Callback<ListaPlanetasModel>{
            override fun onResponse(
                call: Call<ListaPlanetasModel>,
                response: Response<ListaPlanetasModel>
            ) {
                val responseCode = response.code()

                if(responseCode == REQUEST_SUCCESS) {
                    val listaPlaneta = response.body()!!.results
                    onSuccess.invoke(listaPlaneta)
                } else {
                    onError.invoke(context, responseCode)
                }
            }

            override fun onFailure(call: Call<ListaPlanetasModel>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun getDetalhesPlaneta(planetaId: Int, context: Context, onSuccess: (Planeta) -> Unit, onError: (Context, Int?) -> Unit) {
        val request = listaPlanetasApiTask.retrofitApi().getDestalhesPlanetaApi(planetaId)

        request.enqueue(object: Callback<Planeta>{
            override fun onFailure(call: Call<Planeta>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Planeta>, response: Response<Planeta>) {
                val responseCode = response.code()

                if(responseCode === REQUEST_SUCCESS) {
                    val planeta = response.body()

                    if(planeta != null) {
                        onSuccess.invoke(planeta)
                    } else {
                        onError.invoke(context, null)
                    }
                } else {
                    onError.invoke(context, responseCode)
                }
            }
        })
    }

}