package com.example.events_app.repositories

import com.example.events_app.api.APIEncargadoOrganizaEvento
import com.example.events_app.models.EncargadoOrganizaEvento
import com.example.events_app.models.EncargadosOrganizanEventos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object EncargadoOrganizaEventoRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APIEncargadoOrganizaEvento::class.java)

    fun getAllEncargadosOrganizanEventos(token: String, success: (EncargadosOrganizanEventos?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAllEncargadosOrganizanEventos(token).enqueue(object : Callback<EncargadosOrganizanEventos> {
            override fun onResponse(res: Call<EncargadosOrganizanEventos>, response: Response<EncargadosOrganizanEventos>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load encargados organizan eventos"))
                }
            }

            override fun onFailure(res: Call<EncargadosOrganizanEventos>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getEncargadoOrganizaEventoById(token: String, idEncargado: Int, idEvento: Int, success: (EncargadoOrganizaEvento?) -> Unit, failure: (Throwable) -> Unit) {
        service.getEncargadoOrganizaEventoById(token, idEncargado, idEvento).enqueue(object : Callback<EncargadoOrganizaEvento> {
            override fun onResponse(res: Call<EncargadoOrganizaEvento>, response: Response<EncargadoOrganizaEvento>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load encargado organiza evento"))
                }
            }

            override fun onFailure(res: Call<EncargadoOrganizaEvento>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun createEncargadoOrganizaEvento(token: String, encargadoOrganizaEvento: EncargadoOrganizaEvento, success: (EncargadoOrganizaEvento?) -> Unit, failure: (Throwable) -> Unit) {
        service.createEncargadoOrganizaEvento(token, encargadoOrganizaEvento).enqueue(object : Callback<EncargadoOrganizaEvento> {
            override fun onResponse(res: Call<EncargadoOrganizaEvento>, response: Response<EncargadoOrganizaEvento>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to create encargado organiza evento"))
                }
            }

            override fun onFailure(res: Call<EncargadoOrganizaEvento>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteEncargadoOrganizaEvento(token: String, idEncargado: Int, idEvento: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteEncargadoOrganizaEvento(token, idEncargado, idEvento).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete encargado organiza evento"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }
}
