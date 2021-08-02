/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.dao;

import cl.egt.apirest.entity.OrdenFleteObservacionRequest;
import cl.egt.apirest.entity.OrdenFleteRequest;
import cl.egt.apirest.entity.ReclamoObservacionRequest;
import java.util.List;

/**
 *
 * @author ricardo.leal
 */
public interface OrdenfleteModificacionDAO {
     public boolean ordenFleteEsModificable(OrdenFleteRequest ordenFleteRequest);
     public boolean ordenFleteSinRezago(OrdenFleteRequest ordenFleteRequest);
     public Integer ordenFleteRelacionada(OrdenFleteRequest ordenFleteRequest);
     public boolean ofTieneRezago(Integer OrdenFlete);
     public boolean tipoEntregaAgenciaEsValido(OrdenFleteRequest ordenFleteRequest);
     public boolean comprobanteEstadoOrdenFleteEsValido(OrdenFleteRequest ordenFleteRequest);
     public void normalizaDireccion(OrdenFleteRequest ordenFleteRequest);
     public void actualizaOrdenFleteYDestino(OrdenFleteRequest ordenFleteRequest);
     public void grabaObservaciones(OrdenFleteRequest ordenFleteRequest);
     public void direccionamientoSorter(OrdenFleteRequest ordenFleteRequest);
     public Integer getCiudadByComunaDestinatario(OrdenFleteRequest ordenFleteRequest);
     public void insertOrdenFleteObservacion(OrdenFleteObservacionRequest ordenFleteObservacionRequestList);
     public void insertOrdenFleteObservacionReclamo(ReclamoObservacionRequest reclamoObservacionRequest); 
     public int verificaOrdenFlete(int odflCodigo);
     public int getTipoObsOfProcesoByDescripcion(String descripcion);
     public int getTipoObsOfByDescripcion(String descripcion);
     public void modificaEstadoOf(int ordenFlete, int codestado);
}
