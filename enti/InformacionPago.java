/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author egt
 */
@Entity(name = "InformacionPago")
@Table(name = "InformacionPago")
public class InformacionPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "TDOCCODIGO")
    private int codigoTipoDocumento;
    @Column(name = "TDOCDESCRIPCION")
    private String tipoDocumento;
    @Column(name = "DTRIMONTOTOTAL")
    private int montoDocumento;
    @Column(name = "DTRIFOLIO")
    private int numDocumento;

    public int getCodigoTipoDocumento() {
        return codigoTipoDocumento;
    }

    public void setCodigoTipoDocumento(int codigoTipoDocumento) {
        this.codigoTipoDocumento = codigoTipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getMontoDocuemnto() {
        return montoDocumento;
    }

    public void setMontoDocuemnto(int montoDocuemnto) {
        this.montoDocumento = montoDocuemnto;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    @Override
    public String toString() {
        return "InformacionPago{" + "codigoTipoDocumento=" + codigoTipoDocumento + ", tipoDocumento=" + tipoDocumento + ", montoDocumento=" + montoDocumento + ", numDocumento=" + numDocumento + '}';
    }
}
