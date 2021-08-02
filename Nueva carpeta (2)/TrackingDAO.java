/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.dao;

import cl.egt.apirest.entity.Destinatario;
import cl.egt.apirest.entity.DestinatarioRedestinaAgencia;
import cl.egt.apirest.entity.DetalleTrackingRequest;
import cl.egt.apirest.entity.OrdenFleteDetalleTracking;
import cl.egt.apirest.entity.Encargos;
import cl.egt.apirest.entity.InformacionPago;
import cl.egt.apirest.entity.ReclamoDetalleTracking;
import cl.egt.apirest.entity.Remitente;
import cl.egt.apirest.entity.ResumeTrackingRequest;
import cl.egt.apirest.entity.ResumeTrackingResponse;
import java.util.List;


/**
 *
 * @author egt
 */
public interface TrackingDAO {

   List<ResumeTrackingResponse> getResumeTrackingList(ResumeTrackingRequest resumeTrackingRequest);
    
    OrdenFleteDetalleTracking getDetalleTrackingList(DetalleTrackingRequest detalleTrackingRequest);
    
    List<Encargos> getEncargosResumeList(DetalleTrackingRequest detalleTrackingRequest);
    
    List<InformacionPago> getInformacionPagoList(DetalleTrackingRequest detalleTrackingRequest);
    
    Remitente getRemitenteDetalleTracking(DetalleTrackingRequest detalleTrackingRequest);
    
    Destinatario getDestinatarioDetalleTracking(DetalleTrackingRequest detalleTrackingRequest);
    
    ReclamoDetalleTracking getReclamoDetalleTracking(DetalleTrackingRequest detalleTrackingRequest);

    DestinatarioRedestinaAgencia getDestinatarioRedestinacionDetalleTracking(DetalleTrackingRequest detalleTrackingRequest);
    

}
