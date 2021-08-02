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
import cl.egt.apirest.exception.CrmNotFoundException;
import cl.egt.apirest.utils.Constantes;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author egt
 */
@Repository
public class TrackingDAOImpl implements TrackingDAO {

    private static final Logger log = LoggerFactory.getLogger(TrackingDAOImpl.class);

    @Autowired
    private EntityManager entityManager;

    public List<ResumeTrackingResponse> getResumeTrackingList(ResumeTrackingRequest resumeTrackingRequest) {
        log.info("Inicio metodo getResumeTrackingList");
        StringBuilder sb = new StringBuilder();
        sb.append("select odfl.ODFLCODIGO,odfl.ODFLFECHEMICORTA,odfl.ODFLFECHENTREST,remi.REMIRUT,TRIM(remi.REMINOMBRES) as REMINOMBRES,TRIM(remi.REMIAPELLIDOP) as REMIAPELLIDOP,TRIM(remi.REMIAPELLIDOM) as REMIAPELLIDOM,TRIM(remi.REMIRAZONSOCIAL) as REMIRAZONSOCIAL, remi.REMIRUTEMPRESA as REMIRUTEMPRESA,");
        sb.append("dest.DESTRUT,TRIM(dest.DESTNOMBRES) as DESTNOMBRES,TRIM(dest.DESTAPELLIDOP) as DESTAPELLIDOP,TRIM(dest.DESTAPELLIDOM) as DESTAPELLIDOM,(dest.DESTRAZONSOCIAL) as DESTRAZONSOCIAL,ciudadorigen.CIUDCODIGO as codigoCiudadOrigen,TRIM(ciudadorigen.CIUDNOMBRE) as ciudorigen,ciudaddestino.CIUDCODIGO as codigoCiudadDestino,TRIM(ciudaddestino.CIUDNOMBRE) as ciuddestino,");
        sb.append("tipoent.TENTCODIGO,TRIM(tipoent.TENTNOMBRE) as TENTNOMBRE ,estado.EPROCODIGO,TRIM(estado.EPRODESCRIPCION) as EPRODESCRIPCION ,recl.RECLFOLIO,redes.SOLICODIGO,dcto.DADJFOLIO as DCTOADJUNTO,dcto2.DADJFOLIO as DCTOADJUNTOSINENC,rlcc.TCTANUMERO as NUMEROCTACTE,rlcc.TCTADV DVCTACTE from MV_ORDEN_FLETE odfl ");
        sb.append("left join MV_DCTO_ADJUNTO dcto on dcto.ODFLCODIGO = odfl.ODFLCODIGO ");
        sb.append("left join MV_DCTO_ADJUNTO_SIN_ENCARGO dcto2 on dcto2.ODFLCODIGO = odfl.ODFLCODIGO ");
        sb.append("left join RL_ODFL_CTA_CTE rlcc on rlcc.ODFLCODIGO = odfl.ODFLCODIGO ");
        sb.append("inner join MV_REMITENTE remi on odfl.ODFLCODIGO = remi.ODFLCODIGO ");
        sb.append("inner join ma_ciudad ciudadorigen on ciudadorigen.CIUDCODIGO = odfl.CIUDCODIGOORIGEN ");
        sb.append("inner join ma_ciudad ciudaddestino on ciudaddestino.CIUDCODIGO = odfl.CIUDCODIGODESTINO ");
        sb.append("inner join MA_TIPO_ENTREGA tipoent on tipoent.TENTCODIGO = odfl.TENTCODIGO ");
        sb.append("inner join MA_ESTADO_PROCESO estado on estado.EPROCODIGO = odfl.EPROCODIGO ");
        sb.append("inner join MV_DESTINATARIO dest on odfl.ODFLCODIGO = dest.ODFLCODIGO ");
        sb.append("left join MV_RECLAMO recl on recl.ODFLCODIGO = odfl.ODFLCODIGO ");
        sb.append("left join MV_SOLIC_REDESTINA redes on redes.SOLIODFLCODIGO = odfl.ODFLCODIGO ");
        sb.append("where odfl.ODFLFECHEMICORTA BETWEEN (SYSDATE- ? ) AND SYSDATE AND (remi.REMIRUT = ? OR dest.DESTRUT = ? OR remi.REMIRUTEMPRESA = ?)");
        Query q = entityManager.createNativeQuery(sb.toString(), ResumeTrackingResponse.class);
        List<ResumeTrackingResponse> resultResumeTracking = new ArrayList<ResumeTrackingResponse>();
        q.setParameter(1, resumeTrackingRequest.getDias());
        q.setParameter(2, resumeTrackingRequest.getRut());
        q.setParameter(3, resumeTrackingRequest.getRut());
        q.setParameter(4, resumeTrackingRequest.getRut());
        resultResumeTracking = q.getResultList();
        return resultResumeTracking;
    }

    public OrdenFleteDetalleTracking getDetalleTrackingList(DetalleTrackingRequest detalleTrackingRequest) throws CrmNotFoundException {
        log.info("Inicio metodo getDetalleTrackingList");
        OrdenFleteDetalleTracking detalleTrackingResponse = new OrdenFleteDetalleTracking();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ODFL.ODFLCODIGO,ODFL.ODFLFECHEMICORTA,ODFL.ODFLFECHENTREST,CIUDORIGEN.CIUDCODIGO AS CODIGOCIUDADORIGEN,CIUDORIGEN.CIUDNOMBRE AS CIUDADORIGEN,");
            sb.append("AGENORIGEN.AGENCODIGO AS CODIGOAGENCIAORIGEN,AGENORIGEN.AGENDESCRIPCION AS AGENORIGENDESCRIPCION,CIUDDESTINO.CIUDCODIGO AS CODIGOCIUDADDESTINO,CIUDDESTINO.CIUDNOMBRE AS CIUDADDESTINO,AGENDESTINO.AGENCODIGO AS CODIGOAGENCIADESTINO,AGENDESTINO.AGENDESCRIPCION AS AGENDESTINODESCRIPCION,");
            sb.append("TPAG.TPAGCODIGO,TPAG.TPAGNOMBRE,ODFL.ODFLTOTALENCARGOS AS CANTIDADBULTOS,ODFL.ODFLTOTALOF,TSERV.TSERCODIGO,TSERV.TSERNOMBRE,TENT.TENTCODIGO,TENT.TENTNOMBRE,");
            sb.append("TEMI.TEMICODIGO,TEMI.TEMINOMBRE,ENTRE.ENOFFECHA AS FECHAENTREGA,ENTRE.ENOFHORA AS HORAENTREGA,ENTRE.ENOFRUT AS RUTRECIBE,ENTRE.ENOFDV AS DVRECIBE,ENTRE.ENOFNOMBRES AS NOMBRERECIBE,ENTRE.ENOFAPELLIDOP AS APEPRECIBE,");
            sb.append("ENTRE.ENOFAPELLIDOM AS APEMRECIBE,CTA.CCORCODIGO,CTA.CCORNUMERO,CTA.CCORDV,CTA.CLIERUT AS CTARUTEMPRESA,RLCTA.TCTACENTROCOSTO AS CENTROCOSTO,REDES.SOLICODIGO AS CODIGOREDESTINACION,");
            sb.append("RLRELA.ORELOFANTIGUA AS OFANTIGUA, RLRELA.ORELOFNUEVA AS OFNUEVA,EPRO.EPROCODIGO,EPRO.EPRODESCRIPCION,RECL.RECLCODIGO AS CODIGORECLAMO,RECL.RECLFOLIO AS FOLIORECLAMO,ESTRECL.ERECCODIGO AS NOMBREESTADORECLAMO,ESTRECL.ERECCODIGO AS CODIGOESTADORECLAMO,RECL.RECLMONTO,");
            sb.append("REMI.REMIRUT,REMI.REMIDV,REMI.REMINOMBRES,REMI.REMIAPELLIDOP,REMI.REMIAPELLIDOM,REMI.REMITELEFONO,REMI.REMIDIRECCION,REMI.REMINUMERACION,REMI.REMIEMAIL,REMI.REMIDEPARTAMENTO,");
            sb.append("REMI.REMIRAZONSOCIAL,REMI.REMIRUTEMPRESA,COMUREMI.COMUCODIGO AS CODIGOCOMUNAREMITENTE,COMUREMI.COMUNOMBRE AS COMUNAREMITENTE,");
            sb.append("DEST.DESTRUT,DEST.DESTDV,DEST.DESTNOMBRES,DEST.DESTAPELLIDOP,DEST.DESTAPELLIDOM,DEST.DESTTELEFONO,DEST.DESTDIRECCION,DEST.DESTNUMERACION,DEST.DESTEMAIL,DEST.DESTDEPARTAMENTO,");
            sb.append("DEST.DESTRAZONSOCIAL,DEST.DESTNOMBRECONTACTO,COMUDEST.COMUCODIGO AS CODIGOCOMUNADESTINATARIO,COMUDEST.COMUNOMBRE AS COMUNADESTINATARIO ");
            sb.append("FROM MV_ORDEN_FLETE ODFL ");
            sb.append("INNER JOIN MA_CIUDAD CIUDORIGEN ON CIUDORIGEN.CIUDCODIGO = ODFL.CIUDCODIGOORIGEN ");
            sb.append("INNER JOIN MA_AGENCIA AGENORIGEN ON AGENORIGEN.AGENCODIGO = ODFL.AGENCODIGOORIGEN ");
            sb.append("INNER JOIN MA_CIUDAD CIUDDESTINO ON CIUDDESTINO.CIUDCODIGO = ODFL.CIUDCODIGODESTINO ");
            sb.append("INNER JOIN MA_AGENCIA AGENDESTINO ON AGENDESTINO.AGENCODIGO = ODFL.AGENCODIGODESTINO ");
            sb.append("INNER JOIN MV_REMITENTE REMI ON REMI.ODFLCODIGO = ODFL.ODFLCODIGO ");
            sb.append("INNER JOIN MA_COMUNA COMUREMI ON COMUREMI.COMUCODIGO = REMI.COMUCODIGO ");
            sb.append("INNER JOIN MA_CIUDAD CIUDREMI ON CIUDREMI.CIUDCODIGO = REMI.CIUDCODIGO ");
            sb.append("INNER JOIN MV_DESTINATARIO DEST ON DEST.ODFLCODIGO = ODFL.ODFLCODIGO ");
            sb.append("INNER JOIN MA_COMUNA COMUDEST ON COMUDEST.COMUCODIGO = DEST.COMUCODIGO ");
            sb.append("INNER JOIN MA_CIUDAD CIUDDEST ON CIUDDEST.CIUDCODIGO = DEST.CIUDCODIGO ");
            sb.append("INNER JOIN MA_TIPO_PAGO TPAG ON TPAG.TPAGCODIGO = ODFL.TPAGCODIGO ");
            sb.append("INNER JOIN MA_TIPO_SERVICIO TSERV ON TSERV.TSERCODIGO = ODFL.TSERCODIGO ");
            sb.append("INNER JOIN MA_TIPO_EMISION TEMI ON TEMI.TEMICODIGO = ODFL.TEMICODIGO ");
            sb.append("INNER JOIN MA_TIPO_ENTREGA TENT ON TENT.TENTCODIGO = ODFL.TENTCODIGO ");
            sb.append("INNER JOIN MA_ESTADO_PROCESO EPRO ON EPRO.EPROCODIGO = ODFL.EPROCODIGO ");
            sb.append("LEFT JOIN MV_ENTREGA_OF ENTRE ON ENTRE.ODFLCODIGO = ODFL.ODFLCODIGO ");
            sb.append("LEFT JOIN MV_RECLAMO RECL ON RECL.ODFLCODIGO = ODFL.ODFLCODIGO ");
            sb.append("LEFT JOIN MA_ESTADO_RECLAMO ESTRECL ON ESTRECL.ERECCODIGO = RECL.ERECCODIGO ");
            sb.append("LEFT JOIN RL_ODFL_CTA_CTE RLCTA ON RLCTA.ODFLCODIGO = ODFL.ODFLCODIGO ");
            sb.append("LEFT JOIN MA_CTA_CORRIENTE CTA ON CTA.CCORCODIGO = RLCTA.CCORCODIGO ");
            sb.append("LEFT JOIN RL_ODFL_RELACIONADA RLRELA ON RLRELA.ORELOFANTIGUA = ODFL.ODFLCODIGO ");
            sb.append("LEFT JOIN MV_SOLIC_REDESTINA REDES ON REDES.SOLIODFLCODIGO = ODFL.ODFLCODIGO ");
            sb.append("WHERE ODFL.ODFLCODIGO = ? ");
            Query q = entityManager.createNativeQuery(sb.toString(), OrdenFleteDetalleTracking.class);
            q.setParameter(1, detalleTrackingRequest.getOf());
            detalleTrackingResponse = (OrdenFleteDetalleTracking) q.getSingleResult();
        } catch (NoResultException ex) {
            throw new CrmNotFoundException(Constantes.MSG_NOT_FOUND_TRACKING + " número : " + detalleTrackingRequest.getOf());
        }
        return detalleTrackingResponse;
    }

    public Remitente getRemitenteDetalleTracking(DetalleTrackingRequest detalleTrackingRequest) {
        log.info("Inicio metodo getRemitenteDetalleTracking");
        Remitente remitente = new Remitente();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT REMI.REMIRUT,REMI.REMIDV,REMI.REMINOMBRES,REMI.REMIAPELLIDOP,REMI.REMIAPELLIDOM,REMI.REMITELEFONO,");
            sb.append("REMI.REMIDIRECCION,REMI.REMINUMERACION,REMI.REMIEMAIL,REMI.REMIDEPARTAMENTO,");
            sb.append("REMI.REMIRAZONSOCIAL,REMI.REMIRUTEMPRESA,COMUREMI.COMUCODIGO AS CODIGOCOMUNAREMITENTE, ");
            sb.append("COMUREMI.COMUNOMBRE AS COMUNAREMITENTE,CIUDREMI.CIUDCODIGO,CIUDREMI.CIUDNOMBRE ");
            sb.append("FROM MV_REMITENTE REMI  ");
            sb.append("INNER JOIN MA_COMUNA COMUREMI ON COMUREMI.COMUCODIGO = REMI.COMUCODIGO ");
            sb.append("INNER JOIN MA_CIUDAD CIUDREMI ON CIUDREMI.CIUDCODIGO = REMI.CIUDCODIGO ");
            sb.append("WHERE REMI.ODFLCODIGO = ? ");
            Query q = entityManager.createNativeQuery(sb.toString(), Remitente.class);
            q.setParameter(1, detalleTrackingRequest.getOf());
            remitente = (Remitente) q.getSingleResult();
        } catch (NoResultException ex) {
            log.error("Error en BD al hacer tracking al remitente " + ex.getMessage());
            remitente = null;
        }
        return remitente;
    }

    public Destinatario getDestinatarioDetalleTracking(DetalleTrackingRequest detalleTrackingRequest) {
        log.info("Inicio metodo getDestinatarioDetalleTracking");
        Destinatario destinatario = new Destinatario();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT DEST.DESTRUT,DEST.DESTDV,DEST.DESTNOMBRES,DEST.DESTAPELLIDOP,DEST.DESTAPELLIDOM,DEST.DESTTELEFONO,DEST.DESTDIRECCION,DEST.DESTNUMERACION,DEST.DESTEMAIL,DEST.DESTDEPARTAMENTO,DEST.DESTRAZONSOCIAL,DEST.DESTNOMBRECONTACTO,");
            sb.append("COMUDEST.COMUCODIGO AS CODIGOCOMUNADESTINATARIO,COMUDEST.COMUNOMBRE AS COMUNADESTINATARIO ");
            sb.append("FROM MV_DESTINATARIO DEST ");
            sb.append("LEFT JOIN MA_COMUNA COMUDEST ON COMUDEST.COMUCODIGO = DEST.COMUCODIGO ");
            sb.append("LEFT JOIN MA_CIUDAD CIUDDEST ON CIUDDEST.CIUDCODIGO = DEST.CIUDCODIGO ");
            sb.append("WHERE DEST.ODFLCODIGO = ? ");
            Query q = entityManager.createNativeQuery(sb.toString(), Destinatario.class);
            q.setParameter(1, detalleTrackingRequest.getOf());
            destinatario = (Destinatario) q.getSingleResult();
        } catch (NoResultException ex) {
            log.error("Error en BD al hacer tracking al destinatario " + ex.getMessage());
            destinatario = null;
        }
        return destinatario;
    }

    public ReclamoDetalleTracking getReclamoDetalleTracking(DetalleTrackingRequest detalleTrackingRequest) {
        log.info("Inicio metodo getReclamoDetalleTracking");
        ReclamoDetalleTracking reclamoDetalleTracking = new ReclamoDetalleTracking();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT RECL.RECLCODIGO AS CODIGORECLAMO,RECL.RECLFOLIO AS FOLIORECLAMO,");
            sb.append("ESTRECL.ERECNOMBRE AS NOMBREESTADORECLAMO,ESTRECL.ERECCODIGO AS CODIGOESTADORECLAMO,RECL.RECLMONTO ");
            sb.append("FROM MV_RECLAMO RECL ");
            sb.append("INNER JOIN MA_ESTADO_RECLAMO ESTRECL ON ESTRECL.ERECCODIGO = RECL.ERECCODIGO ");
            sb.append("WHERE RECL.ODFLCODIGO = ? ");
            Query q = entityManager.createNativeQuery(sb.toString(), ReclamoDetalleTracking.class);
            q.setParameter(1, detalleTrackingRequest.getOf());
            reclamoDetalleTracking = (ReclamoDetalleTracking) q.getSingleResult();
        } catch (NoResultException ex) {
            log.error("Error en BD al hacer tracking al reclamo " + ex.getMessage());
            reclamoDetalleTracking = null;
        }
        return reclamoDetalleTracking;
    }

    public List<Encargos> getEncargosResumeList(DetalleTrackingRequest detalleTrackingRequest) {
        log.info("Inicio metodo getEncargosResumeList");
        StringBuilder sb = new StringBuilder();
        sb.append("select ENCACODIGO,ENCACODIGOBARRA,tenc.TENCCODIGO,tenc.TENCNOMBRE,est.EPRODESCRIPCION,enca.ENCAKGS,enca.ENCAALTO,enca.ENCAANCHO,enca.ENCALARGO,ENCACLASIFSORTER ");
        sb.append("from MV_ENCARGO enca ");
        sb.append("inner join MA_TIPO_ENCARGO tenc on tenc.TENCCODIGO = enca.TENCCODIGO ");
        sb.append("inner join MA_ESTADO_PROCESO est on est.EPROCODIGO = enca.EPROCODIGO ");
        sb.append("where odflcodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString(), Encargos.class);
        List<Encargos> resultEncargosTracking = new ArrayList<Encargos>();
        q.setParameter(1, detalleTrackingRequest.getOf());
        resultEncargosTracking = q.getResultList();
        return resultEncargosTracking;
    }

    public List<InformacionPago> getInformacionPagoList(DetalleTrackingRequest detalleTrackingRequest) {
        log.info("Inicio metodo getInformacionPagoList");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT TDOC.TDOCCODIGO,TDOC.TDOCDESCRIPCION,TRIB.DTRIMONTOTOTAL,TRIB.DTRIFOLIO ");
        sb.append("FROM MV_DCTO_TRIBUTARIO TRIB ");
        sb.append("INNER JOIN MV_ORDEN_FLETE ODFL ON ODFL.COMPCODIGO = TRIB.COMPCODIGO OR ODFL.COMPCODIGOENTREGA = TRIB.COMPCODIGO ");
        sb.append("INNER JOIN MA_TIPO_DOCUMENTO TDOC ON TDOC.TDOCCODIGO = TRIB.TDAGCODIGO ");
        sb.append("WHERE TRIB.COMPCODIGO != 0 AND ODFL.ODFLCODIGO = ? ");
        Query q = entityManager.createNativeQuery(sb.toString(), InformacionPago.class);
        List<InformacionPago> resultEncargosTracking = new ArrayList<InformacionPago>();
        q.setParameter(1, detalleTrackingRequest.getOf());
        resultEncargosTracking = (List<InformacionPago>) q.getResultList();
        return resultEncargosTracking;
    }

    @Override
    public DestinatarioRedestinaAgencia getDestinatarioRedestinacionDetalleTracking(DetalleTrackingRequest detalleTrackingRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
