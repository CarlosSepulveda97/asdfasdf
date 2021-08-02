// 
// Decompiled by Procyon v0.5.36
// 
package cl.egt.apirest.service;

import cl.egt.apirest.entity.OrdenFleteDetalleTracking;
import cl.egt.apirest.entity.DetalleTrackingRequest;
import cl.egt.apirest.exception.CrmException;
import cl.egt.apirest.entity.OrdenFleteRequest;
import cl.egt.apirest.dao.TrackingDAO;
import cl.egt.apirest.dao.EncargosDAO;
import cl.egt.apirest.dao.NominaDAO;
import cl.egt.apirest.dao.OrdenfleteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import cl.egt.apirest.dao.OrdenfleteModificacionDAO;
import cl.egt.apirest.dao.ReclamoDetalleSeguimientoDAO;
import cl.egt.apirest.entity.OrdenFleteObservacionRequest;
import cl.egt.apirest.entity.ReclamoObservacionRequest;
import cl.egt.apirest.utils.Constantes;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrdenFleteServiceImpl implements OrdenFleteService {

    @Autowired
    private OrdenfleteModificacionDAO ordenfleteModificacionDAO;
    @Autowired
    private OrdenfleteDAO ordenfleteDAO;
    @Autowired
    private EncargosDAO encargosDAO;
    @Autowired
    private NominaDAO nominaDAO;
    @Autowired
    TrackingDAO trackingDAO;
    @Autowired
    ReclamoDetalleSeguimientoDAO reclamoDetalleSeguimientoDAO;

    @Override
    public void updateOrdenFlete(OrdenFleteRequest ordenFleteRequest) {

        if (getCodigoCiudadDestinoOrdenFlete(ordenFleteRequest.getOf()) != ordenfleteModificacionDAO.getCiudadByComunaDestinatario(ordenFleteRequest)) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Ciudad destino de OF debe ser igual a la ciudad que pertenece la comuna del destinatario.");
        }

        if (!ordenfleteModificacionDAO.ordenFleteEsModificable(ordenFleteRequest)) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Orden de flete no modificable");
        }

        if (!ordenfleteModificacionDAO.ordenFleteSinRezago(ordenFleteRequest)) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Orden de flete esta en rezago");
        }
        if (!this.ordenfleteModificacionDAO.tipoEntregaAgenciaEsValido(ordenFleteRequest)) {
            throw new CrmException("1", "Tipo de Entrega Agencia no es valido");
        }

        if (!encargosDAO.encargoLibreDeNomina(ordenFleteRequest)) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Existen encargos que esta en nomina de Reparto");
        }

        if (!ordenfleteModificacionDAO.comprobanteEstadoOrdenFleteEsValido(ordenFleteRequest)) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Comprobante de orden de flete no es valido");
        }

        ordenfleteModificacionDAO.normalizaDireccion(ordenFleteRequest);

        ordenfleteModificacionDAO.actualizaOrdenFleteYDestino(ordenFleteRequest);

        ordenfleteModificacionDAO.grabaObservaciones(ordenFleteRequest);

        ordenfleteModificacionDAO.direccionamientoSorter(ordenFleteRequest);

    }

    private Integer getCodigoCiudadDestinoOrdenFlete(Integer codOrdenFlete) {
        DetalleTrackingRequest detalleTrackingRequest = new DetalleTrackingRequest();
        detalleTrackingRequest.setOf(codOrdenFlete);
        OrdenFleteDetalleTracking response = trackingDAO.getDetalleTrackingList(detalleTrackingRequest);

        return response.getCodigoCiudadDestino();
    }

    @Override
    public List<Integer> obtenerOrdenesFletes(int codigoNomina) {

        List<BigDecimal> ordenesBig = ordenfleteDAO.obtenerOrdenesFletes(codigoNomina);
        List<Integer> ordenesFlete = new ArrayList<>();

        if (nominaDAO.existeNomina(codigoNomina)) {
            int cont = 0;
            for (BigDecimal bigDecimal : ordenesBig) {
                ordenesFlete.add(ordenesBig.get(cont).intValue());
                cont++;
            }
        }

        return ordenesFlete;
    }

    public void insertOrdenFleteObservacion(List<OrdenFleteObservacionRequest> ordenFleteObservacionRequestList) {
        for (OrdenFleteObservacionRequest ordenFleteObservacionRequest : ordenFleteObservacionRequestList) {
            if (ordenFleteObservacionRequest.getOrdenFlete() == 0) {
                throw new CrmException(Constantes.CONST_UNO_STR, "Debe indicar la ordende flete que a la que desea imputar la observacion. No se ha cargado ningun dato");
            }
            if (ordenfleteModificacionDAO.verificaOrdenFlete(ordenFleteObservacionRequest.getOrdenFlete()) == 0) {
                throw new CrmException(Constantes.CONST_UNO_STR, "La OF " + ordenFleteObservacionRequest.getOrdenFlete() + " no existe. No se ha cargado ningun dato");
            }
            int codigoObsTipoObsProceso = ordenFleteObservacionRequest.getObsTipoObsProceso();
            if (codigoObsTipoObsProceso == 0) {
                throw new CrmException(Constantes.CONST_UNO_STR, "Tipo observacion de proceso incorrecto en la OF " + ordenFleteObservacionRequest.getOrdenFlete() + ". No se ha cargado ningun dato");
            }
            int codigoTipoObs = ordenFleteObservacionRequest.getTipoObservacion();
            if (codigoTipoObs == 0) {
                throw new CrmException(Constantes.CONST_UNO_STR, "Tipo observacion incorrecto en la OF " + ordenFleteObservacionRequest.getOrdenFlete() + ". No se ha cargado ningun dato");
            }

            if (ordenFleteObservacionRequest.getDetalleObservacion() == null) {
                throw new CrmException(Constantes.CONST_UNO_STR, "La OF " + ordenFleteObservacionRequest.getOrdenFlete() + " no tiene observacion. No se ha cargado ningun dato");
            }
            if (ordenFleteObservacionRequest.getDetalleObservacion().length() == 0) {
                throw new CrmException(Constantes.CONST_UNO_STR, "La OF " + ordenFleteObservacionRequest.getOrdenFlete() + " no tiene observacion. No se ha cargado ningun dato");
            }

        }
        for (OrdenFleteObservacionRequest ordenFleteObservacionRequest : ordenFleteObservacionRequestList) {
            ordenfleteModificacionDAO.insertOrdenFleteObservacion(ordenFleteObservacionRequest);
        }
    }

    public int verificaOrdenFlete(int odflCodigo) {
        return ordenfleteModificacionDAO.verificaOrdenFlete(odflCodigo);
    }

    public void modificaEstadoOf(int ordenFlete, int codestado) {
        ordenfleteModificacionDAO.modificaEstadoOf(ordenFlete, codestado);
    }

    public void modificaEncargo(int ordenFlete, int codestado) {
        encargosDAO.modificaEstadoEncargo(ordenFlete, codestado);
    }

    public void insertObservacionReclamo(ReclamoObservacionRequest reclamoObservacionRequest) {

        if (reclamoObservacionRequest.getFolio() ==0  || reclamoDetalleSeguimientoDAO.validaFolio(reclamoObservacionRequest.getFolio()) == 0) {
                  throw new CrmException(Constantes.CONST_UNO_STR, "Folio del reclamo no es válido. No se ha cargado ");
      
        }
        if (reclamoObservacionRequest.getOrdenFlete() == 0) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Debe indicar la ordende flete que a la que desea imputar la observacion. No se ha cargado ");
        }
        if (ordenfleteModificacionDAO.verificaOrdenFlete(reclamoObservacionRequest.getOrdenFlete()) == 0) {
            throw new CrmException(Constantes.CONST_UNO_STR, "La OF " + reclamoObservacionRequest.getOrdenFlete() + " no existe. No se ha cargado");
        }

        if (reclamoObservacionRequest.getObsTipoObsProceso() == 0) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Tipo observacion de proceso incorrecto en la OF " + reclamoObservacionRequest.getOrdenFlete() + ". No se ha cargado ");
        }

        if (reclamoObservacionRequest.getObsTipoObsProceso() == 0) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Tipo observacion incorrecto en la OF " + reclamoObservacionRequest.getOrdenFlete() + ". No se ha cargado");
        }

        if (reclamoObservacionRequest.getDetalleObservacion() == null) {
            throw new CrmException(Constantes.CONST_UNO_STR, "La OF " + reclamoObservacionRequest.getOrdenFlete() + " no tiene observacion. No se ha cargado");
        }
        if (reclamoObservacionRequest.getDetalleObservacion().trim().length() == 0) {
            throw new CrmException(Constantes.CONST_UNO_STR, "La OF " + reclamoObservacionRequest.getOrdenFlete() + " no tiene observacion. No se ha cargado");
        }
        ordenfleteModificacionDAO.insertOrdenFleteObservacionReclamo(reclamoObservacionRequest);
    }

    public int validaOrdenFlete(int ordenFlete) {
        int validaOf = ordenfleteDAO.cuentaOrdenFlete(ordenFlete);
        return validaOf;
    }
}
