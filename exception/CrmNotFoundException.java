/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.exception;

/**
 *
 * @author humberto.escares
 */
public class CrmNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -820025001722622353L;

    private final String mensaje;

    public CrmNotFoundException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

}
