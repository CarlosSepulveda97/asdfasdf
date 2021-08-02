/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.dao;

import cl.egt.apirest.entity.ReclamoReclamanteResponse;
import cl.egt.apirest.entity.IngresoReclamoBean;

/**
 *
 * @author luis.flores
 */
public interface ReclamoDAO {

    public boolean ReclamoConsultaExistenciaByFolio(Integer NumFolio);

    public String ReclamoValidaIngresoByFolioReclamo(Integer NumFolio);

    public String ReclamoValidaIngresoByOdenFlete(Integer OrdenFlete);

    public ReclamoReclamanteResponse ReclamoValidaIngresoByReclamoAndOdenFlete(IngresoReclamoBean ingresoReclamoBean);

    public boolean OrdenFleteConsultaSiTieneReclamoAsociado(Integer OrdenFlete);

    public boolean OrdenFleteConsultaExistencia(Integer OrdenFlete);

    public boolean folioExiste(long folioIngresado);

    public String formatJson(Object reclamo);

    public long verificaCodigo(long reclcodigo);

    public long getFolioMaximo(long filioIngresado);
  
}
