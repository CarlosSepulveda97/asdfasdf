// 
// Decompiled by Procyon v0.5.36
// 
package cl.egt.apirest.dao;

import cl.egt.apirest.entity.OrdenFlete;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.Query;
import cl.egt.apirest.entity.MotivoReclamo;
import cl.egt.apirest.exception.CrmException;
import cl.egt.apirest.entity.IngresoReclamoBean;
import cl.egt.apirest.entity.ReclamoReclamanteResponse;
import cl.egt.apirest.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import cl.egt.apirest.utils.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Primary;

@Primary
@Repository
public class ReclamoDAOImpl implements ReclamoDAO {

    private static final Logger log = LoggerFactory.getLogger(ReclamoDAOImpl.class);

    //RESPUESTAS JSON
    private static int SI_REQUIERE_OF = 1;
    public static final int COD_ORDEN_NO_EXISTE = 0;
    public static final String DESC_ORDEN_NO_EXISTE = "Orden Flete no existe ";
    public static final String ORDEN_FLETE_VALIDA = "Orden Flete valida ";
    public static final String JSON_COD_FOLIO_RECLAMO_EXISTE_DESC = "No se puede continuar con el flujo. El folio ingresado ya existe";
    public static final String JSON_COD_FOLIO_RECLAMO_NO_EXISTE_DESC = "Folio sin reclamo asociado. Se puede continuar con el flujo";
    public static final String JSON_ORDEN_FLETE_RECLAMO_EXISTE_DESC = "Orden Flete Tienes un reclamo asociacio. NO Continuar con el flujo";
    public static final String ORDEN_FLETE_NO_VALIDA = "Orden Flete no existe ";
    Constantes constantes = new Constantes() {
    };
    @Autowired
    private EntityManager entityManager;

    public String formatJson(Object reclamo) {
        Util utl = new Util();
        String json = utl.formatJson(reclamo);
        return json;
    }

    public String ReclamoValidaIngresoByFolioReclamo(Integer NumFolio) {
        log.info("Inicio metodo ReclamoValidaIngresoByFolioReclamo");
        String json = "";
        ReclamoReclamanteResponse respuestaJson = new ReclamoReclamanteResponse();

        if (ReclamoConsultaExistenciaByFolio(NumFolio) == true) {
            respuestaJson.setCodRespuesta(constantes.CONST_UNO);
            respuestaJson.setDescRespuesta(JSON_COD_FOLIO_RECLAMO_EXISTE_DESC);
        } else {
            respuestaJson.setCodRespuesta(constantes.CONST_CERO);
            respuestaJson.setDescRespuesta(JSON_COD_FOLIO_RECLAMO_NO_EXISTE_DESC);

        }
        json = formatJson(respuestaJson);
        return json;
    }

    @Override
    public String ReclamoValidaIngresoByOdenFlete(Integer OrdenFlete) {
        log.info("Inicio metodo ReclamoValidaIngresoByOdenFlete");
        String json = "";
        ReclamoReclamanteResponse respuestaJson = new ReclamoReclamanteResponse();
        if (OrdenFleteConsultaExistencia(OrdenFlete)) {
            respuestaJson.setCodRespuesta(constantes.CONST_CERO);
            respuestaJson.setDescRespuesta(ORDEN_FLETE_VALIDA);
            if (OrdenFleteConsultaSiTieneReclamoAsociado(OrdenFlete)) {
                respuestaJson.setCodRespuesta(constantes.CONST_CERO);
                respuestaJson.setDescRespuesta(JSON_ORDEN_FLETE_RECLAMO_EXISTE_DESC);
            }
        } else {
            respuestaJson.setCodRespuesta(constantes.CONST_UNO);
            respuestaJson.setDescRespuesta(ORDEN_FLETE_NO_VALIDA);
        }
        json = formatJson(respuestaJson);
        return json;
    }

    @Override
    public ReclamoReclamanteResponse ReclamoValidaIngresoByReclamoAndOdenFlete(IngresoReclamoBean ingresoReclamoBean) {
        log.info("Inicio metodo ReclamoValidaIngresoByReclamoAndOdenFlete");
        ReclamoReclamanteResponse respuestaJson = new ReclamoReclamanteResponse();
        Util util = new Util();

        if (ingresoReclamoBean.getFecha() == null) {
            throw new CrmException(Constantes.CONST_UNO_STR, "El campo fecha es obligatorio. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (ingresoReclamoBean.getFecha().trim().length() == 0) {
            throw new CrmException(Constantes.CONST_UNO_STR, "El campo fecha es obligatorio. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }

        if (!util.validaFormatoFecha(ingresoReclamoBean.getFecha())) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Fecha ingresada no es v�lida. Formato esperado es dd/mm/yy " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (!util.validaDatoNumerico(String.valueOf(ingresoReclamoBean.getCodMotivo()))) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Dato ingresado no es valido en el campo c�digo motivo. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (ingresoReclamoBean.getFolio() == 0) {
            ingresoReclamoBean.setFolio(folioNuevo());
        }
        if (ingresoReclamoBean.getFolio() != 0 && folioExiste(ingresoReclamoBean.getFolio())) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Folio ingresado ya existe en otro reclamo. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (reclamo_requiere_of(ingresoReclamoBean.getCodMotivo()) && ingresoReclamoBean.getOrdenFlete() == null) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Motivo de reclamo require una orden de flete. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (reclamo_requiere_of(ingresoReclamoBean.getCodMotivo()) && ingresoReclamoBean.getOrdenFlete() == 0) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Motivo de reclamo require una orden de flete. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (!util.validaDatoNumerico(String.valueOf(ingresoReclamoBean.getMonto()))) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Dato ingresado no es valido en el campo Monto. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (ingresoReclamoBean.getCodMotivo() == null || ingresoReclamoBean.getCodMotivo() == 0) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Debe ingresar codigo motivo " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (!util.validaDatoNumerico(String.valueOf(ingresoReclamoBean.getMonto()))) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Dato ingresado no es valido en el campo Monto. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (ingresoReclamoBean.getOrdenFlete() != null && !util.validaDatoNumerico(String.valueOf(ingresoReclamoBean.getOrdenFlete()))) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Dato ingresado no es valido en el campo Orden de Flete " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (ingresoReclamoBean.getOrdenFlete() != null && ingresoReclamoBean.getOrdenFlete() != 0 && !OrdenFleteConsultaExistencia(ingresoReclamoBean.getOrdenFlete())) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Orden de flete no existe... " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (ingresoReclamoBean.getOrdenFlete() > 999999999) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Orden de flete no v�lida" + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (!util.validaDatoNumerico(String.valueOf(ingresoReclamoBean.getFolio()))) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Dato ingresado no es valido en el campo Folio. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (ingresoReclamoBean.getOrdenFlete() != null && ingresoReclamoBean.getOrdenFlete() != 0) {
            if (OrdenFleteConsultaSiTieneReclamoAsociado(ingresoReclamoBean.getOrdenFlete())) {
                throw new CrmException(Constantes.CONST_UNO_STR, "Orden de flete ya est� asociada a un reclamo... " + Constantes.JSON_NO_CONTINUAR_DESC);
            }
        }
        if (ingresoReclamoBean.getFolio() != null) {
            if (ReclamoConsultaExistenciaByFolio(ingresoReclamoBean.getFolio())) {
                throw new CrmException(Constantes.CONST_UNO_STR, "Folio de reclamo ya est� asociado a un reclamo... " + Constantes.JSON_NO_CONTINUAR_DESC);
            }
        }
        return respuestaJson;
    }

    private boolean reclamo_requiere_of(Integer cod_reclamo) {
        log.info("Inicio metodo reclamo_requiere_of");
        boolean validacionMotivo = false;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT mreccodigo, mrecnombre, mrecreqof, mrecusuariocrea,  ");
        sb.append("mrecusuariomodi, mrecfechacrea, mrecfechamodi, mrecversion ");
        sb.append("FROM ma_motivo_reclamo ");
        sb.append("where mreccodigo=? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, cod_reclamo);
        MotivoReclamo motivoReclamo = new MotivoReclamo();
        if (q.getResultList().size() > 0) {
            Object[] require = (Object[]) q.getSingleResult();
            Object strCodMotivo = (Object) require[2];
            if (Integer.parseInt(strCodMotivo.toString()) == SI_REQUIERE_OF) {
                validacionMotivo = true;
            }
        }
        return validacionMotivo;
    }

    @Override
    public boolean folioExiste(long folioIngresado) {
        log.info("Inicio metodo folioExiste");
        boolean folioExiste = false;
        StringBuilder sb = new StringBuilder();
        sb.append("select  reclfolio from mv_reclamo where reclfolio= ?");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, folioIngresado);
        if (q.getResultList().size() > 0) {
            folioExiste = true;
        }
        return folioExiste;
    }

    public long getFolioMaximo(long folioIngresado) {
        log.info("Inicio metodo getFolioMaximo");
        long folioMaximo = 0;
        StringBuilder sb = new StringBuilder();

        if (folioIngresado > 0) {
            sb.append("select max(reclfolio) from mv_reclamo ");
            Query q = entityManager.createNativeQuery(sb.toString());
            Object require = (Object) q.getSingleResult();
            Object folio = (Object) require;
            folioMaximo = Long.parseLong(folio.toString());
        }

        return folioMaximo;
    }

    public int folioNuevo() {
        log.info("Inicio metodo folioNuevo");
        int folioMaximo = 0;
        StringBuilder sb = new StringBuilder();

        sb.append("select max(reclfolio) from mv_reclamo ");
        Query q = entityManager.createNativeQuery(sb.toString());
        Object require = (Object) q.getSingleResult();
        Object folio = (Object) require;
        folioMaximo = (int) ((Long.parseLong(folio.toString())) + 666);

        return folioMaximo;
    }

    public long verificaCodigo(long reclcodigo) {
        log.info("Inicio metodo verificaCodigo");
        long folioDisponible = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("select  reclcodigo  from mv_reclamo where reclcodigo= ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, reclcodigo);
        if (q.getResultList().size() > 0) {
            folioDisponible = getFolioMaximo(reclcodigo);
        } else {
            folioDisponible = reclcodigo;
        }
        return folioDisponible;
    }

    @Override
    public boolean ReclamoConsultaExistenciaByFolio(Integer NumFolio) {
        log.info("Inicio metodo ReclamoConsultaExistenciaByFolio");
        boolean validacionAprobada = false;
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT r.reclcodigo,r.ereccodigo,r.mreccodigo,r.reclfolio,r.reclfechacrea,r.reclfechamodi,r.reclmonto,  ");
        sb.append("r.reclsernac,r.odflcodigo,r.emprcodigo,r.reclacuso,r.reclrechazado,r.reclcontactopend,r.recltomado,");
        sb.append("r.usuausuariocrea,r.usuausuariomodi,r.recltiporesolucion,r.reclversion  ");
        sb.append("FROM mv_reclamo r ");
        sb.append("INNER JOIN ma_motivo_reclamo m ON r.mreccodigo=m.mreccodigo ");
        sb.append("INNER JOIN mv_reclamante re ON re.reclcodigo=r.reclcodigo ");
        sb.append("INNER JOIN ma_estado_reclamo e ON e.ereccodigo=r.ereccodigo ");
        sb.append("WHERE r.reclcodigo = ?");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, NumFolio);
        if (q.getResultList().size() > 0) {
            validacionAprobada = true;
        } else {
            validacionAprobada = false;
        }
        return validacionAprobada;
    }

    @Override
    public boolean OrdenFleteConsultaSiTieneReclamoAsociado(Integer OrdenFlete) {
        log.info("Inicio metodo OrdenFleteConsultaSiTieneReclamoAsociado");
        boolean validacionAprobada = false;
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT odflcodigo FROM mv_reclamo ");
        sb.append("WHERE odflcodigo = ?");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, OrdenFlete);
        if (q.getResultList().size() > 0) {
            validacionAprobada = true;
        } else {
            validacionAprobada = false;
        }
        return validacionAprobada;
    }

    @Override
    public boolean OrdenFleteConsultaExistencia(Integer numeroOf) {
        log.info("Inicio metodo OrdenFleteConsultaExistencia");
        boolean validacionAprobada = false;
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT enc.odflcodigo AS ordenflete ");
        sb.append("FROM mv_orden_flete odf ");
        sb.append("INNER JOIN mv_encargo enc ON enc.odflcodigo = odf.odflcodigo ");
        sb.append("INNER JOIN mv_remitente rem ON rem.odflcodigo = odf.odflcodigo ");
        sb.append("INNER JOIN ma_estado_proceso epr ON epr.eprocodigo = enc.eprocodigo ");
        sb.append("INNER JOIN ma_ubicacion_fisic ubi ON ubi.ubifcodigo = enc.ubiccodigoactual ");
        sb.append("INNER JOIN ma_agencia age ON age.agencodigo = ubi.agencodigo ");
        sb.append("INNER JOIN ma_ciudad ciu ON ciu.ciudcodigo = age.ciudcodigo ");
        sb.append("LEFT JOIN mv_entrega_of ent ON ent.odflcodigo = odf.odflcodigo ");
        sb.append("WHERE enc.odflcodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, numeroOf);
        OrdenFlete ordenflete = new OrdenFlete();
        ordenflete.setOfcodigo(numeroOf);
        if (q.getResultList().size() > 0) {
            validacionAprobada = true;
        } else {
            validacionAprobada = false;
        }
        return validacionAprobada;
    }
}
