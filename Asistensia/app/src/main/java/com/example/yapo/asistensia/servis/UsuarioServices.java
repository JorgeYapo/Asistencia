package com.example.yapo.asistensia.servis;



import java.util.List;
import com.example.yapo.asistensia.to.UsuarioTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Update by Yapo on 05/06/2018;
 */

public interface UsuarioServices {
    @GET("/EventoUPeU/user/all")
    Call<List<UsuarioTO>> listarUsuario();

    @POST("/EventoUPeU/user/add")
    Call<UsuarioTO>  guardarUsuario(@Body UsuarioTO usuario);

    @POST("/EventoUPeU/user/login")
    Call<UsuarioTO>  login(@Body UsuarioTO usuario);
}
