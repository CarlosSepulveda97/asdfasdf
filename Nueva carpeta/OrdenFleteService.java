/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.service;

import cl.egt.apirest.entity.OrdenFlete;
import cl.egt.apirest.entity.OrdenFleteObservacionRequest;
import cl.egt.apirest.entity.OrdenFleteRequest;
import cl.egt.apirest.entity.ReclamoObservacionRequest;
import java.util.List;

/**
 *
 * @author egt
 */
public interface OrdenFleteService {

    public void updateOrdenFlete(OrdenFleteRequest ordenFleteRequest);

    public List<Integer> obtenerOrdenesFletes(int codigoNomina);

    public void insertOrdenFleteObservacion(List<OrdenFleteObservacionRequest> ordenFleteObservacionRequest);

    public void modificaEstadoOf(int ordenFlete, int codestado);

    public void modificaEncargo(int ordenFlete, int codestado);
    
    public void insertObservacionReclamo(ReclamoObservacionRequest reclamoObservacionRequest);
    
     public int validaOrdenFlete(int ordenFlete);

}
