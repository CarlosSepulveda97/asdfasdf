/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.service;

import cl.egt.apirest.entity.IngresoReclamoBean;
import cl.egt.apirest.entity.ReclamoReclamanteResponse;

/**
 *
 * @author luis.flores
 */
public interface ReclamoPasoUnoService {

    public boolean ReclamoConsultaExistenciaByFolio(Integer numReclamo);

    public String ReclamoValidaIngresoByFolioReclamo(Integer numReclamo);

    public String ReclamoValidaIngresoByOdenFlete(Integer ordenFlete);

    public ReclamoReclamanteResponse ReclamoValidaIngresoByReclamoAndOdenFlete(IngresoReclamoBean ingresoReclamoBean);

}
