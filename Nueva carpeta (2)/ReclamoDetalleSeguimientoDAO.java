/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.dao;

import cl.egt.apirest.entity.ReclamoDetalleSeguimientoCabeceraResponse;
import cl.egt.apirest.entity.ReclamoDetalleSeguimientoRequest;

/**
 *
 * @author ricardo.leal
 */
public interface ReclamoDetalleSeguimientoDAO {
       public ReclamoDetalleSeguimientoCabeceraResponse reclamoDetalleResponse(ReclamoDetalleSeguimientoRequest reclamoDetalleRequest); 
       public void updateOfByFolio(ReclamoDetalleSeguimientoRequest reclamoDetalleRequest);
       public int validaFolio(Integer folio);
}
