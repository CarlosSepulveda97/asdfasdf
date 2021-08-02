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
public class DetalleTrackingRequest {

    @NotNull
    @ApiModelProperty(example = "914233897")
    private int of;

    public int getOf() {
        return of;
    }

    public void setOf(int of) {
        this.of = of;
    }

    @Override
    public String toString() {
        return "DetalleTrackingRequest{" + "of=" + of + '}';
    }
}
