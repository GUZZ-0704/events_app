package com.example.events_app.repositories

import com.example.events_app.api.APICliente
import com.example.events_app.models.Cliente
import com.example.events_app.models.Clientes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ClienteRepository {
    val instanceRetrofit = RetrofitRepository.getRetrofitInstance()
    val service = instanceRetrofit.create(APICliente::class.java)

    fun getClientesList(token: String, success: (Clientes?) -> Unit, failure: (Throwable) -> Unit) {
        service.getAllClientes(token).enqueue(object : Callback<Clientes> {
            override fun onResponse(res: Call<Clientes>, response: Response<Clientes>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load clientes"))
                }
            }

            override fun onFailure(res: Call<Clientes>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun getCliente(token: String, id: Int, success: (Cliente?) -> Unit, failure: (Throwable) -> Unit) {
        service.getClienteById(token, id).enqueue(object : Callback<Cliente> {
            override fun onResponse(res: Call<Cliente>, response: Response<Cliente>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to load cliente"))
                }
            }

            override fun onFailure(res: Call<Cliente>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun addCliente(token: String, cliente: Cliente, success: (Cliente?) -> Unit, failure: (Throwable) -> Unit) {
        service.createCliente(token, cliente).enqueue(object : Callback<Cliente> {
            override fun onResponse(res: Call<Cliente>, response: Response<Cliente>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to add cliente"))
                }
            }

            override fun onFailure(res: Call<Cliente>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun updateCliente(token: String, cliente: Cliente, id: Int, success: (Cliente?) -> Unit, failure: (Throwable) -> Unit) {
        service.updateCliente(token, id,cliente).enqueue(object : Callback<Cliente> {
            override fun onResponse(res: Call<Cliente>, response: Response<Cliente>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(Exception("Failed to update cliente"))
                }
            }

            override fun onFailure(res: Call<Cliente>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteCliente(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteCliente(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to delete cliente"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }

    fun deleteClienteCompletamente(token: String, id: Int, success: () -> Unit, failure: (Throwable) -> Unit) {
        service.deleteClienteCompletamente(token, id).enqueue(object : Callback<Void> {
            override fun onResponse(res: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    failure(Exception("Failed to completely delete cliente"))
                }
            }

            override fun onFailure(res: Call<Void>, t: Throwable) {
                failure(t)
            }
        })
    }
}
