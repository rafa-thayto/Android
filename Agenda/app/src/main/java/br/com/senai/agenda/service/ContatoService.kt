package br.com.senai.agenda.service

import br.com.senai.agenda.modelo.Contato
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ContatoService {

    @GET("api/contatos")
    fun listarContatos(): Call<List<Contato>>

    @GET("api/contatos/{id}")
    fun buscarContato(@Path("id") id: Long): Call<Contato>

    @POST("api/contatos")
    fun salvarContato(@Body contato: Contato): Call<Contato>

    @POST("api/contatos/{id}")
    fun alterarContato(@Path("id") id: Long, @Body contato: Contato): Call<Contato>

}