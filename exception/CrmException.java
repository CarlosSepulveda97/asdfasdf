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
public class CrmException extends RuntimeException {

    private static final long serialVersionUID = -820025001722622353L;

    private final String codigo;
    private final String mensaje;

    public CrmException(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

}
