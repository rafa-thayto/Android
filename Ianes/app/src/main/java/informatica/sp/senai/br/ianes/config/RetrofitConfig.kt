package informatica.sp.senai.br.ianes.config

import informatica.sp.senai.br.ianes.service.UsuarioService
import informatica.sp.senai.br.ianes.utils.AppUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    val retrofit = Retrofit.Builder()
            .baseUrl(AppUtils.BASE_URL())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun usuarioService(): UsuarioService {
        return retrofit.create(UsuarioService::class.java)
    }

}

