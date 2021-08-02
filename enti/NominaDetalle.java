/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 *
 * @author yeremy.toro
 */

@ApiModel(description = "All details about the Employee. ")
public class NominaDetalle{

    @ApiModelProperty(notes = "Codigo de la nomina")
    private int nomina;
    
    @ApiModelProperty(notes = "Codigos de estado posibles { 1,2,3,4,5,7,8,204 }")
    private int codigoEstado;
    @ApiModelProperty(notes = "Estados posibles { EMITIDA,DESPACHADA,ANULADA,EN TRANSITO,CERRADA PARCIAL,CERRADA,RENDIDA,LIQUIDADA,NOMINA NO EXISTE }")
    private String estado;
    @ApiModelProperty(notes = "Lista de Ordenes de Fletes asociadas a la nomina")
    private List<Integer> ofs;

    public int getNomina() {
        return nomina;
    }

    public void setNomina(int nomina) {
        this.nomina = nomina;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getEstado() {
        return estado.trim();
    }

    public void setEstado(String estado) {
        this.estado = estado.trim();
    }

    public List<Integer> getOfs() {
        return ofs;
    }

    public void setOfs(List<Integer> ofs) {
        this.ofs = ofs;
    }

    @Override
    public String toString() {
        return "NominaDetalle{" + "nomina=" + nomina + ", codigoEstado=" + codigoEstado + ", estado=" + estado + ", ofs=" + ofs + '}';
    }
}
