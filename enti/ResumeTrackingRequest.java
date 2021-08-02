/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author egt
 */
public class ResumeTrackingRequest {

    @NotNull
    @ApiModelProperty(example = "13695719")
    private int rut;
    @ApiModelProperty(example = "70")
    private int dias;

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "ResumeTrackingRequest{" + "rut=" + rut + ", dias=" + dias + '}';
    }

}
