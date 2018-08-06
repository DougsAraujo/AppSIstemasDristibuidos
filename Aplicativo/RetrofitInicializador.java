package com.example.douglas.trabsd;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Douglas on 04/08/2017.
 */

public class RetrofitInicializador {

    private static final String Endereco = "http://192.168.43.40:8080/WebServices/webresources/generic/";

    public Retrofit getInitiator() {


        Retrofit retrofit = new Retrofit.Builder().baseUrl(Endereco)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
