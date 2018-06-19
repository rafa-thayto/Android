package informatica.sp.senai.br.ianes.service

import informatica.sp.senai.br.ianes.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsuarioService {

    @POST("/auth/jwt")
    fun authenticate(@Body usuario: Usuario): Call<Usuario>

}
