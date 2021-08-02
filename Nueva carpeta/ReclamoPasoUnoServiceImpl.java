/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.service;

import cl.egt.apirest.entity.IngresoReclamoBean;
import cl.egt.apirest.dao.ReclamoDAO;
import cl.egt.apirest.entity.ReclamoReclamanteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis.flores
 */
@Service
public class ReclamoPasoUnoServiceImpl implements ReclamoPasoUnoService {

    @Autowired
    private ReclamoDAO reclamoDAO;

    @Override
    public boolean ReclamoConsultaExistenciaByFolio(Integer numReclamo) {
        boolean existeFolio = reclamoDAO.ReclamoConsultaExistenciaByFolio(numReclamo);
        return existeFolio;
    }

    @Override
    public String ReclamoValidaIngresoByFolioReclamo(Integer numReclamo) {
        String json = reclamoDAO.ReclamoValidaIngresoByFolioReclamo(numReclamo);
        return json;
    }

    @Override
    public String ReclamoValidaIngresoByOdenFlete(Integer ordenFlete) {
        String json = reclamoDAO.ReclamoValidaIngresoByOdenFlete(ordenFlete);
        return json; 
    }

    @Override
    public ReclamoReclamanteResponse ReclamoValidaIngresoByReclamoAndOdenFlete(IngresoReclamoBean ingresoReclamoBean) {
        ReclamoReclamanteResponse json = reclamoDAO.ReclamoValidaIngresoByReclamoAndOdenFlete(ingresoReclamoBean);
        return json;
    }

}
