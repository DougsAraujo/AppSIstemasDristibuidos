package com.example.douglas.trabsd;

import java.io.Serializable;

/**
 * Created by Douglas on 09/07/2017.
 */

public class mercado implements Serializable{

    private String referencia;


    @Override
    public String toString() {
        return "mercado{" +
                "referencia='" + referencia + '\'' +
                '}';
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public  mercado(String ref){

        this.referencia = ref;
    }

}

