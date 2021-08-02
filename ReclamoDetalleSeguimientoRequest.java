/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

/**
 *
 * @author ricardo.leal
 */
public class ReclamoDetalleSeguimientoRequest {
    
    private Integer odflcodigo;
    private Integer reclfolio;

    public Integer getOdflcodigo() {
        return odflcodigo;
    }

    public void setOdflcodigo(Integer odflcodigo) {
        this.odflcodigo = odflcodigo;
    }

    public Integer getReclfolio() {
        return reclfolio;
    }

    public void setReclfolio(Integer reclfolio) {
        this.reclfolio = reclfolio;
    }

    @Override
    public String toString() {
        return "ReclamoDetalleSeguimientoRequest{" + "odflcodigo=" + odflcodigo + ", reclfolio=" + reclfolio + '}';
    }
    
    
}
