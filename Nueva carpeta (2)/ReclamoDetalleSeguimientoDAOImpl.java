// 
// Decompiled by Procyon v0.5.36
// 
package cl.egt.apirest.dao;

import cl.egt.apirest.entity.ReclamoDetalleSeguimientoResponse;
import javax.persistence.Query;
import java.util.List;
import cl.egt.apirest.exception.CrmException;
import cl.egt.apirest.entity.ReclamoDetalleSeguimientoCabeceraResponse;
import cl.egt.apirest.entity.ReclamoDetalleSeguimientoRequest;
import cl.egt.apirest.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ReclamoDetalleSeguimientoDAOImpl implements ReclamoDetalleSeguimientoDAO {

    private static final Logger log = LoggerFactory.getLogger(ReclamoDetalleSeguimientoDAOImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public ReclamoDetalleSeguimientoCabeceraResponse reclamoDetalleResponse(ReclamoDetalleSeguimientoRequest reclamoDetalleRequest) {
        log.info("Inicio metodo reclamoDetalleResponse");
        ReclamoDetalleSeguimientoCabeceraResponse reclamoDetalleResponse = new ReclamoDetalleSeguimientoCabeceraResponse();

        String campoDeBusqueda = campoConsulta(reclamoDetalleRequest);
        Integer parametroEntrada = paramEntrada(reclamoDetalleRequest);

        if (campoDeBusqueda != null && (parametroEntrada != null)) {
            try {
                reclamoDetalleResponse = consultaReclamoCabecera(campoDeBusqueda, parametroEntrada);

            } catch (Exception ex) {
                throw new CrmException(Constantes.CONST_UNO_STR, "Ocurrio un error al consultar el detalle de reclamos: " + ex.getMessage() + " " + Constantes.JSON_NO_CONTINUAR_DESC);
            }
        } else {
            throw new CrmException(Constantes.CONST_UNO_STR, "Critarios de consulta no cumplen con lo  esperado " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        return reclamoDetalleResponse;
    }

    private ReclamoDetalleSeguimientoCabeceraResponse consultaReclamoCabecera(String campoDeBusqueda, Integer parametroEntrada) {
        log.info("Inicio metodo consultaReclamoCabecera");
        StringBuilder sb = new StringBuilder();
        sb.append("select rec.reclcodigo,rec.reclfolio,rec.odflcodigo,rec.reclfechacrea,mot.mreccodigo,trim(mot.mrecnombre)  AS mrecnombre,  ");
        sb.append("rec.reclmonto,est.ereccodigo,trim(est.erecnombre)  AS erecnombre,ciudorigen.ciudcodigo AS ciudcodigoorigen,TRIM(ciudorigen.ciudnombre) AS ciudnombreorigen,tent.tentcodigo,  ");
        sb.append("TRIM(tent.tentdescripcion) AS tentdescripcion,tpag.tpagcodigo,TRIM(tpag.tpagnombre) AS tpagnombre ,odfl.odfltotalkgs,odfl.odfltotalflete,TRIM(remi.reminombres) AS reminombres,  ");
        sb.append("TRIM(remi.remiapellidop ) AS remiapellidop,TRIM(remi.remiapellidom) AS remiapellidom ,TRIM(dest.destnombres) AS destnombres,TRIM(dest.destapellidop) AS destapellidop,TRIM(dest.destapellidom) AS destapellidom,ciuddestino.ciudcodigo AS ciudcodigodestino,  ");
        sb.append("TRIM(ciuddestino.ciudnombre) AS ciudnombredestino,cta.ccornumero,cta.ccordv,tserv.tsercodigo,TRIM(tserv.tsernombre) AS tsernombre,odfl.odfltotalencargos,  ");
        sb.append("odfl.odflmontovalordec,recla.rclmreclamante,recla.rclmtiporeclamante,recla.rclmrut,recla.rclmdv,TRIM(recla.rclmrazonsocial) AS rclmrazonsocial,TRIM(recla.rclmdireccion) AS rclmdireccion,  ");
        sb.append("comu.comucodigo,TRIM(comu.comunombre) AS comunombre,TRIM(recla.rclmtelefono) AS rclmtelefono,TRIM(ciudrecla.ciudcodigo) AS ciudcodigoreclamo,TRIM(ciudrecla.ciudnombre) AS ciudnombrereclamo,recla.rclmemail  ");
        sb.append("from mv_reclamo rec  ");
        sb.append("left join mv_orden_flete odfl on odfl.odflcodigo = rec.odflcodigo  ");
        sb.append("inner join mv_reclamante recla on recla.reclcodigo = rec.reclcodigo  ");
        sb.append("inner join ma_motivo_reclamo mot on mot.mreccodigo = rec.mreccodigo  ");
        sb.append("inner join ma_estado_reclamo est on est.ereccodigo = rec.ereccodigo  ");
        sb.append("inner join ma_comuna comu on comu.comucodigo = recla.comucodigo  ");
        sb.append("inner join ma_ciudad ciudrecla on ciudrecla.ciudcodigo = recla.ciudcodigo  ");
        sb.append("left join ma_ciudad ciudorigen on ciudorigen.ciudcodigo = odfl.ciudcodigoorigen  ");
        sb.append("left join ma_ciudad ciuddestino on ciuddestino.ciudcodigo = odfl.ciudcodigodestino  ");
        sb.append("left join mv_remitente remi on remi.odflcodigo = odfl.odflcodigo  ");
        sb.append("left join mv_destinatario dest on dest.odflcodigo = odfl.odflcodigo  ");
        sb.append("left join ma_tipo_pago tpag on tpag.tpagcodigo = odfl.tpagcodigo  ");
        sb.append("left join ma_tipo_entrega tent on tent.tentcodigo = odfl.tentcodigo  ");
        sb.append("left join ma_tipo_servicio tserv on tserv.tsercodigo = odfl.tsercodigo  ");
        sb.append("left join rl_odfl_cta_cte rlodfl on rlodfl.odflcodigo = odfl.odflcodigo  ");
        sb.append("left join ma_cta_corriente cta on cta.ccorcodigo = rlodfl.ccorcodigo  ");
        sb.append(" WHERE " + campoDeBusqueda + "= ?");
        Query q = entityManager.createNativeQuery(sb.toString(), (Class) ReclamoDetalleSeguimientoCabeceraResponse.class);
        q.setParameter(1, (Object) parametroEntrada);
        ReclamoDetalleSeguimientoCabeceraResponse reclamoDetalleSeguimientoCabeceraResponse = (ReclamoDetalleSeguimientoCabeceraResponse) q.getSingleResult();
        reclamoDetalleSeguimientoCabeceraResponse.setReclamoSeguimientoDetalleResponseList((List) this.detalleSeguimientoByReclcodigo(reclamoDetalleSeguimientoCabeceraResponse));
        return reclamoDetalleSeguimientoCabeceraResponse;
    }

    private List<ReclamoDetalleSeguimientoResponse> detalleSeguimientoByReclcodigo(ReclamoDetalleSeguimientoCabeceraResponse reclamoDetalleSeguimientoCabeceraResponse) {
        log.info("Inicio metodo detalleSeguimientoByReclcodigo");
        StringBuilder sb = new StringBuilder();
        sb.append("select seg.sreccodigo,seg.reclcodigo,seg.ereccodigo,seg.srecfecha,seg.srechora, ");
        sb.append("ubic.ubifcodigo,trim(ubic.ubifdescripcion) ubifdescripcion,trim(seg.srecobservacion) srecobservacion,usu.usuacodigo,usu.usuausuario  ");
        sb.append("from mv_seg_reclamo seg ");
        sb.append("inner join ma_ubicacion_fisic ubic on ubic.ubifcodigo = seg.ubifcodigo ");
        sb.append("inner join ma_usuario usu on usu.usuacodigo = seg.usuacodigo ");
        sb.append("inner join mv_reclamo recl on recl.reclcodigo = seg.reclcodigo ");
        sb.append("where recl.reclcodigo = ?  order by seg.ereccodigo desc ");
        Query q = this.entityManager.createNativeQuery(sb.toString(), (Class) ReclamoDetalleSeguimientoResponse.class);
        q.setParameter(1, (Object) reclamoDetalleSeguimientoCabeceraResponse.getReclcodigo());
        List<ReclamoDetalleSeguimientoResponse> reclamoDetalleSeguimientoResponse = (List<ReclamoDetalleSeguimientoResponse>) q.getResultList();
        return reclamoDetalleSeguimientoResponse;
    }

    private String campoConsulta(ReclamoDetalleSeguimientoRequest reclamoDetalleRequest) {
        log.info("Inicio metodo campoConsulta");
        String campoDeBusqueda = "";
        if ((reclamoDetalleRequest.getOdflcodigo() != null && reclamoDetalleRequest.getOdflcodigo() != 0)
                && (reclamoDetalleRequest.getReclfolio() != null && reclamoDetalleRequest.getReclfolio() != 0)) {
            campoDeBusqueda = "odfl.odflcodigo ";
        }
        if (reclamoDetalleRequest.getOdflcodigo() != null && reclamoDetalleRequest.getOdflcodigo() != 0) {
            campoDeBusqueda = "odfl.odflcodigo  ";
        }
        if (reclamoDetalleRequest.getReclfolio() != null && reclamoDetalleRequest.getReclfolio() != 0) {
            campoDeBusqueda = "rec.reclfolio  ";
        }
        return campoDeBusqueda;
    }

    private Integer paramEntrada(ReclamoDetalleSeguimientoRequest reclamoDetalleRequest) {
        log.info("Inicio metodo paramEntrada");
        Integer parametroEntrada = null;
        if ((reclamoDetalleRequest.getOdflcodigo() != null && reclamoDetalleRequest.getOdflcodigo() != 0)
                && (reclamoDetalleRequest.getReclfolio() != null && reclamoDetalleRequest.getReclfolio() != 0)) {
            parametroEntrada = reclamoDetalleRequest.getReclfolio();
        }
        if (reclamoDetalleRequest.getOdflcodigo() != null && reclamoDetalleRequest.getOdflcodigo() != 0) {
            parametroEntrada = reclamoDetalleRequest.getOdflcodigo();
        }
        if (reclamoDetalleRequest.getReclfolio() != null && reclamoDetalleRequest.getReclfolio() != 0) {
            parametroEntrada = reclamoDetalleRequest.getReclfolio();
        }
        return parametroEntrada;
    }

    public void updateOfByFolio(ReclamoDetalleSeguimientoRequest reclamoDetalleRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE MV_RECLAMO SET ODFLCODIGO=? WHERE RECLFOLIO=?");
        Query q = this.entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, (Object) reclamoDetalleRequest.getOdflcodigo());
        q.setParameter(2, (Object) reclamoDetalleRequest.getReclfolio());
        q.executeUpdate();
    }

    public int validaFolio(Integer folio) {
        Integer resultado = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("select count(reclfolio)  from mv_reclamo where reclfolio = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, folio);
        if (q.getResultList().size() > 0) {
            Object objCountFolio = (Object) q.getSingleResult();
            resultado = Integer.parseInt(objCountFolio.toString());
        }
        return resultado;
    }

}
