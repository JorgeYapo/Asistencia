package com.example.yapo.asistesia.servis;

import com.example.yapo.asistesia.to.UsuarioTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Docente on 12/02/2018.
 */

public interface UsuarioServices {
    @GET("/EventoUPeU/user/all")
    Call<List<UsuarioTO>> listarUsuario();

    @POST("/EventoUPeU/user/add")
    Call<UsuarioTO>  guardarUsuario(@Body UsuarioTO usuario);
}
