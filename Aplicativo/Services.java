package com.example.douglas.trabsd;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Douglas on 16/08/2017.
 */

public interface Services {


    @GET("login/{login}/{senha}")
    Call<User> verificalogin(@Path("login") String usuario, @Path("senha") String senha);

    @GET("compras/compras_usuarios")
    Call<List<ComprasUsuario>> comprasusuarios();

}
