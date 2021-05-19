package com.star_wars

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.star_wars.api.ListaPlanetasMyRetrofit
import com.star_wars.model.ListaPlanetasModel
import kotlinx.android.synthetic.main.activity_lista_planetas.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaPlanetas : AppCompatActivity() {

    lateinit var recycleListaPlanetas: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_planetas)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recycleListaPlanetas = rv_lista_planetas
        recycleListaPlanetas.layoutManager = LinearLayoutManager(this)
        getData()
    }

    private fun getData() {
        val call: Call<List<ListaPlanetasModel>> =
            ListaPlanetasMyRetrofit.instance?.listaPlanetasApi()?.getListaPlanetasApi() as Call<List<ListaPlanetasModel>>
        call.enqueue(object : Callback<List<ListaPlanetasModel>> {
            override fun onResponse(
                call: Call<List<ListaPlanetasModel>>,
                response: Response<List<ListaPlanetasModel>>
            ) {
                val adapter = ListaPlanetasAdapter(this@ListaPlanetas, response.body()?.toList() as List<ListaPlanetasModel>)
                recycleListaPlanetas.adapter = adapter
            }

            override fun onFailure(call: Call<List<ListaPlanetasModel>>, t: Throwable) {
                Toast.makeText(this@ListaPlanetas, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}