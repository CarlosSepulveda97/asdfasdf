/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.service;

import cl.egt.apirest.entity.IngresoReclamoBean;
import cl.egt.apirest.entity.DatosReclamanteBean;
import cl.egt.apirest.entity.ReclamoReclamanteResponse;

/**
 *
 * @author ricardo.leal
 */
public interface ReclamoPasoDosService {
    public ReclamoReclamanteResponse validaIngresoReclamante(DatosReclamanteBean datosReclamante);
}
