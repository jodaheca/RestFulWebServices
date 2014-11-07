/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Joaquin David
 */
public class Respuesta {
    public static final String ERROR="ERROR";
    public static final String FALTA_CAMPOS = "CAMPOSFALTANTES";
    public static final String CREADO="CREADO";
    
    private String tipo ;
    private String mensaje;

    public Respuesta() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
