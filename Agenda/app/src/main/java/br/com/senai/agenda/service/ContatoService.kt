package br.com.senai.agenda.service

import br.com.senai.agenda.modelo.Contato
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ContatoService {

    @POST("api/contatos")
    fun salvarContato(@Body contato: Contato): Call<Contato>

}