/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.service;

import cl.egt.apirest.dao.ReclamanteDAO;
import cl.egt.apirest.dao.ReclamoDAO;
import cl.egt.apirest.entity.DatosReclamanteBean;
import cl.egt.apirest.entity.IngresoReclamoBean;
import cl.egt.apirest.entity.ReclamoReclamanteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricardo.leal
 */
@Service
public class ReclamoPasoDosServiceImpl implements ReclamoPasoDosService {

    @Autowired
    private ReclamanteDAO reclamanteDAO;

    @Override
    public ReclamoReclamanteResponse validaIngresoReclamante( DatosReclamanteBean datosReclamante) {
        ReclamoReclamanteResponse reclamoReclamanteRespuesta = reclamanteDAO.validaIngresoReclamante(datosReclamante);
        return reclamoReclamanteRespuesta;
    }

}
