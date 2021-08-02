/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.service;

import cl.egt.apirest.dao.ReclamoDetalleSeguimientoDAO;
import cl.egt.apirest.entity.ReclamoDetalleSeguimientoCabeceraResponse;
import cl.egt.apirest.entity.ReclamoDetalleSeguimientoRequest;
import cl.egt.apirest.exception.CrmException;
import cl.egt.apirest.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricardo.leal
 */
@Service
public class ReclamoDetalleSeguimientoServiceImpl implements ReclamoDetalleSeguimientoService {

    @Autowired
    private ReclamoDetalleSeguimientoDAO reclamoDetalleSeguimientoDAO;

    @Override
    public ReclamoDetalleSeguimientoCabeceraResponse reclamoDetalleResponse(ReclamoDetalleSeguimientoRequest reclamoDetalleRequest) {
        ReclamoDetalleSeguimientoCabeceraResponse reclamoDetalleCabeceraResponse = new ReclamoDetalleSeguimientoCabeceraResponse();
        reclamoDetalleCabeceraResponse = reclamoDetalleSeguimientoDAO.reclamoDetalleResponse(reclamoDetalleRequest);
        return reclamoDetalleCabeceraResponse;
    }

    public void updateOfByFolio(ReclamoDetalleSeguimientoRequest reclamoDetalleRequest) {
        try {
            if (reclamoDetalleSeguimientoDAO.validaFolio(reclamoDetalleRequest.getReclfolio()) > 0) {
                reclamoDetalleSeguimientoDAO.updateOfByFolio(reclamoDetalleRequest);
            } else {
                throw new CrmException(Constantes.CONST_UNO_STR, "Folio noencontrado.No es posible actualizar ");
            }
        } catch (Exception ex) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Ocurrio un error al consultar el detalle de reclamos: " + ex.getMessage() + " " + Constantes.JSON_NO_CONTINUAR_DESC);
        }

    }
}
