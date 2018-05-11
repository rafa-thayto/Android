package br.com.senai.agenda

import br.com.senai.agenda.service.ContatoService
import br.com.senai.agenda.utils.AppUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

        val retrofit = Retrofit.Builder()
                .baseUrl(AppUtils.BASE_URL())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    fun contatoService(): ContatoService {
        return retrofit.create(ContatoService::class.java)
    }

}