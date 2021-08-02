// 
// Decompiled by Procyon v0.5.36
// 

package cl.egt.apirest.dao;

import cl.egt.apirest.utils.Constantes;
import cl.egt.apirest.utils.Util;
import cl.egt.apirest.entity.DatosReclamanteBean;
import cl.egt.apirest.entity.ReclamoReclamanteResponse;
import cl.egt.apirest.exception.CrmException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cl.egt.apirest.service.ReclamoPasoUnoService;
import static cl.egt.apirest.utils.UtilesFecha.validarFecha;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ricardo.leal
 */
@Repository
@Transactional
public class ReclamanteDAOImpl extends ReclamoDAOImpl implements ReclamanteDAO {

    private static final Logger log = LoggerFactory.getLogger(ReclamanteDAOImpl.class);
    
    @Autowired
    private ReclamoPasoUnoService reclamoServicePasoUno;
    @Autowired
    private EntityManager entityManager;

    @Override
    public ReclamoReclamanteResponse validaIngresoReclamante(DatosReclamanteBean datosReclamante) {
        log.info("Inicio metodo validaIngresoReclamante");
        Util utl = new Util();
        ReclamoReclamanteResponse reclamoReclamanteRespuesta = new ReclamoReclamanteResponse();
        //Valido el Json ya revisado en el primer step del proceso        
        reclamoReclamanteRespuesta = reclamoServicePasoUno.ReclamoValidaIngresoByReclamoAndOdenFlete(datosReclamante);
        peraparaRespuesta(reclamoReclamanteRespuesta, datosReclamante);

        if (reclamoReclamanteRespuesta.getCodRespuesta() == Constantes.CODIGO_ERROR) {
            throw new CrmException(Constantes.CONST_UNO_STR, "No se encontraron registros... " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        //Si la validacion Anterior es aprobada, continuo con la revision de los datos del reclamante.        
        if (datosReclamante.getReclamante() == null) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Reclamante emisor(0) o destinatario(1) es obligatorio. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (datosReclamante.getPersonaEmmpresa() == null) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Reclamante Persona(0) o Empresa(1) debe ser especificado. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (datosReclamante.getRutReclamante() == null) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Rut de reclamante Persona o Empresa debe ser especificado. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (datosReclamante.getDvReclamante() == null || datosReclamante.getDvReclamante().trim().length() == Constantes.CONST_CERO) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Digito verificador de reclamante Persona o Empresa debe ser especificado. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (datosReclamante.getNombres() == null || datosReclamante.getNombres().trim().length() == Constantes.CONST_CERO) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Nombre de reclamante Persona o Empresa debe ser especificado. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (datosReclamante.getApellidoPaterno() == null || datosReclamante.getApellidoPaterno().trim().length() == Constantes.CONST_CERO
                && datosReclamante.getReclamante() == Constantes.CONST_CERO) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Apellidos de reclamante son obligatorios cuando es persona natural. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (datosReclamante.getCodComuna() == null || datosReclamante.getCodCiudad() == null) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Comuna y ciudad es campo requerido. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (datosReclamante.getTelefono() == null) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Teléfono es campo requerido. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (!utl.validaDatoNumerico(String.valueOf(datosReclamante.getRutReclamante()))) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Campo rut debe ser un dato numérico. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (!isRutValidoAlTipoPersona(datosReclamante.getPersonaEmmpresa(), datosReclamante.getRutReclamante())) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Rut ingresado no corresponde al tipo de persona seleccionado. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (reclamoReclamanteRespuesta.getCodCiudad() == null || reclamoReclamanteRespuesta.getCodComuna() == null) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Codigo de ciudad y comuna es obligatorio. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (!ciudadCodigoExiste(reclamoReclamanteRespuesta.getCodCiudad())) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Codigo de ciudad no es v�lido. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (!comunaCodigoExiste(reclamoReclamanteRespuesta.getCodCiudad(), reclamoReclamanteRespuesta.getCodComuna())) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Codigo de comuna no es v�lido. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (reclamoReclamanteRespuesta.getInformeComplementario() == null || reclamoReclamanteRespuesta.getInformeComplementario().trim().length() == Constantes.CONST_CERO) {
            throw new CrmException(Constantes.CONST_UNO_STR, "El ingreso del informe complementario es obligatorio. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (!validarFecha(reclamoReclamanteRespuesta.getFecha().toString())) {
            throw new CrmException(Constantes.CONST_UNO_STR, "Formato fecha no es v�lido. " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
        if (grabaReclamoYComplemento(reclamoReclamanteRespuesta, datosReclamante)) {
            return reclamoReclamanteRespuesta;
        } else {
               throw new CrmException(Constantes.CONST_UNO_STR, "Error al grabar el registro " + Constantes.JSON_NO_CONTINUAR_DESC);
        }
    }

    private void peraparaRespuesta(ReclamoReclamanteResponse reclamoReclamanteRespuesta, DatosReclamanteBean datosReclamanteBean) {
        reclamoReclamanteRespuesta.setFolio(datosReclamanteBean.getFolio());
        reclamoReclamanteRespuesta.setFecha(datosReclamanteBean.getFecha());
        reclamoReclamanteRespuesta.setCodMotivo(datosReclamanteBean.getCodMotivo());
        reclamoReclamanteRespuesta.setOrdenFlete(datosReclamanteBean.getOrdenFlete());
        reclamoReclamanteRespuesta.setMonto(datosReclamanteBean.getMonto());
        reclamoReclamanteRespuesta.setReclamante(datosReclamanteBean.getReclamante());
        reclamoReclamanteRespuesta.setPersonaEmmpresa(datosReclamanteBean.getPersonaEmmpresa());
        reclamoReclamanteRespuesta.setRutReclamante(datosReclamanteBean.getReclamante());
        reclamoReclamanteRespuesta.setDvReclamante(datosReclamanteBean.getDvReclamante());
        reclamoReclamanteRespuesta.setNombres(datosReclamanteBean.getNombres());
        reclamoReclamanteRespuesta.setApellidoPaterno(datosReclamanteBean.getApellidoPaterno());
        reclamoReclamanteRespuesta.setApellidoMaterno(datosReclamanteBean.getApellidoMaterno());
        reclamoReclamanteRespuesta.setDireccion(datosReclamanteBean.getDireccion());
        reclamoReclamanteRespuesta.setCodCiudad(datosReclamanteBean.getCodCiudad());
        reclamoReclamanteRespuesta.setCodComuna(datosReclamanteBean.getCodComuna());
        reclamoReclamanteRespuesta.setTelefono(datosReclamanteBean.getTelefono());
        reclamoReclamanteRespuesta.setEmail(datosReclamanteBean.getEmail());
        reclamoReclamanteRespuesta.setReclamoSernac(datosReclamanteBean.getReclamoSernac());
        reclamoReclamanteRespuesta.setInformeComplementario(datosReclamanteBean.getInformeComplementario());
        reclamoReclamanteRespuesta.setImagenUrl(datosReclamanteBean.getImagenUrl());
    }
    
    private boolean isRutValidoAlTipoPersona(Integer tipoPersona, Integer rut) {
        log.info("Inicio metodo isRutValidoAlTipoPersona");
        boolean respuesta = false;
        if (tipoPersona == Constantes.TIPO_PERSONA_NATURAL && rut < Constantes.RUT_EMPRESA) {
            respuesta = true;
        } else if(tipoPersona == Constantes.TIPO_PERSONA_EMPRESA && rut > Constantes.RUT_EMPRESA) {
             respuesta = true;
        }else{
         respuesta = false;
        }
        return respuesta;
    }
    public boolean folioExiste(long folio) {
        log.info("Inicio metodo folioExiste");
        boolean folioValida = false;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT reclfolio  FROM mv_reclamo where reclfolio = ?");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, folio);
        if (q.getResultList().size() > 0) {
            folioValida = true;
        }
        return folioValida;
    }   
  

    private long obtieneCorrelativoComplemento() {
        log.info("Inicio metodo obtieneCorrelativoComplemento");
        long correlativo = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT S_455_1_MV_INF_COMP_RECLAMO.NEXTVAL FROM DUAL");
        Query q = entityManager.createNativeQuery(sb.toString());
        Object[] require = (Object[]) q.getSingleResult();
        Object objCorrelativo = (Object) require[1];
        correlativo = Long.parseLong(objCorrelativo.toString());
        return correlativo;
    }

    private boolean ciudadCodigoExiste(long codigoCiudad) {
        log.info("Inicio metodo ciudadCodigoExiste");
        boolean ciudadValida = false;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ciudcodigo  FROM ma_ciudad where ciudcodigo = ?");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, codigoCiudad);
        if (q.getResultList().size() > 0) {
            ciudadValida = true;
        }
        return ciudadValida;
    }

    private boolean comunaCodigoExiste(long codigoCiudad, long codigoComuna) {
        log.info("Inicio metodo comunaCodigoExiste");
        boolean comunaValida = false;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT comucodigo  FROM ma_comuna where comucodigo = ? and ciudcodigo= ?");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, codigoComuna);
        q.setParameter(2, codigoCiudad);
        if (q.getResultList().size() > 0) {
            comunaValida = true;
        }
        return comunaValida;
    }

    private long obtieneCorrelativoReclamo() {
        log.info("Inicio metodo obtieneCorrelativoReclamo");
        long correlativo = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT S_428_1_MV_RECLAMO.NEXTVAL FROM DUAL");
        Query q = entityManager.createNativeQuery(sb.toString());
        Object require = (Object) q.getSingleResult();
        correlativo = Long.parseLong(require.toString());
        return correlativo;
    }
    private long obtieneCorrelativoReclamamante() {
        log.info("Inicio metodo obtieneCorrelativoReclamamante");
        long correlativo = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT S_437_19_MV_RECLAMANTE.NEXTVAL FROM DUAL");
        Query q = entityManager.createNativeQuery(sb.toString());
        Object require = (Object) q.getSingleResult();
        correlativo = Long.parseLong(require.toString());
        return correlativo;
    }

    public boolean grabaReclamoYComplemento(ReclamoReclamanteResponse reclamoReclamanteRespuesta, DatosReclamanteBean datosReclamanteBean) {
        log.info("Inicio metodo grabaReclamoYComplemento");
        boolean reclamoGrabado = false;
        if (grabaReclamo(reclamoReclamanteRespuesta,datosReclamanteBean)) {
            reclamoGrabado = true;
        }
        return reclamoGrabado;
    }

    private boolean grabaReclamo(ReclamoReclamanteResponse reclamoReclamanteRespuesta, DatosReclamanteBean datosReclamante) {
        log.info("Inicio metodo grabaReclamo");
        boolean reclamoGrabado = false;
        try {
            long nuevoFolio = getFolioMaximo(reclamoReclamanteRespuesta.getFolio());
            //long nuevoFolio = datosReclamante.getFolio();
            long codigoReclamo = obtieneCorrelativoReclamo();
            String fechaReclamo = reclamoReclamanteRespuesta.getFecha().toString();
            Date fecha = new SimpleDateFormat("dd/MM/yy").parse(fechaReclamo);
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO mv_reclamo");
            sb.append("(RECLCODIGO,ERECCODIGO,MRECCODIGO,RECLFOLIO,RECLFECHACREA,RECLFECHAMODI,RECLMONTO,RECLSERNAC, ODFLCODIGO, ");// ");
            sb.append(" EMPRCODIGO,RECLACUSO,RECLRECHAZADO,RECLCONTACTOPEND,RECLTOMADO,USUAUSUARIOCREA,USUAUSUARIOMODI,");//");
            sb.append(" RECLTIPORESOLUCION,RECLVERSION,CAJACODIGO )");
            sb.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
            Query q = entityManager.createNativeQuery(sb.toString());
            q.setParameter(1, codigoReclamo);
            q.setParameter(2, Constantes.INGRESADO);
            q.setParameter(3, reclamoReclamanteRespuesta.getCodMotivo());
            q.setParameter(4, reclamoReclamanteRespuesta.getFolio());
            q.setParameter(5, fecha);
            q.setParameter(6, fecha);
            q.setParameter(7, reclamoReclamanteRespuesta.getMonto());
            q.setParameter(8, reclamoReclamanteRespuesta.getReclamoSernac());
            q.setParameter(9, reclamoReclamanteRespuesta.getOrdenFlete());
            q.setParameter(10, Constantes.CODIGO_EMPRESA);
            q.setParameter(11, Constantes.CONST_CERO);
            q.setParameter(12, Constantes.CONST_CERO);
            q.setParameter(13, Constantes.CONST_CERO);
            q.setParameter(14, Constantes.CONST_CERO);
            q.setParameter(15, Constantes.USUARIO_GENERICO);
            q.setParameter(16, Constantes.USUARIO_GENERICO);
            q.setParameter(17, Constantes.CONST_CERO);
            q.setParameter(18, Constantes.CONST_UNO);
            q.setParameter(19, Constantes.CONST_CERO);
            q.executeUpdate();
            
            StringBuilder sb2 = new StringBuilder();
            sb2.append("INSERT INTO MV_RECLAMANTE");
            sb2.append("(RECLCODIGO,RCLMTIPORECLAMANTE,RCLMRUT,RCLMDV,RCLMNOMBRES,RCLMAPELLIDOP,RCLMAPELLIDOM,RCLMRAZONSOCIAL,");
            sb2.append("RCLMDIRECCION,COMUCODIGO,CIUDCODIGO,RCLMTELEFONO,RCLMEMAIL,RCLMFECHACREA,RCLMFECHAMODI,RCLMUSUARIOCREA,RCLMUSUARIOMODI,RCLMRECLAMANTE,RCLMCODIGO) ");
            sb2.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            Query q2 = entityManager.createNativeQuery(sb2.toString());
            q2.setParameter(1, codigoReclamo);
            q2.setParameter(2, datosReclamante.getPersonaEmmpresa());
            q2.setParameter(3, datosReclamante.getRutReclamante());
            q2.setParameter(4, datosReclamante.getDvReclamante());
            q2.setParameter(5, datosReclamante.getNombres());
            q2.setParameter(6, datosReclamante.getApellidoPaterno());
            q2.setParameter(7, datosReclamante.getApellidoMaterno());
            q2.setParameter(8, datosReclamante.getNombres());
            q2.setParameter(9, datosReclamante.getDireccion());
            q2.setParameter(10, datosReclamante.getCodComuna());
            q2.setParameter(11, datosReclamante.getCodCiudad());
            q2.setParameter(12, datosReclamante.getTelefono());
            q2.setParameter(13, datosReclamante.getEmail());
            q2.setParameter(14, fecha);
            q2.setParameter(15, fecha);
            q2.setParameter(16, Constantes.USUARIO_GENERICO);
            q2.setParameter(17, Constantes.USUARIO_GENERICO);
            q2.setParameter(18, datosReclamante.getReclamante());
            q2.setParameter(19, obtieneCorrelativoReclamo());
            q2.executeUpdate();
            
            reclamoGrabado = true;
            
            if (!grabaComplemento(codigoReclamo, reclamoReclamanteRespuesta)) {
                reclamoGrabado = true;
            } else {
                reclamoGrabado = false;
                eliminaReclamo(codigoReclamo);
                eliminaReclamante(codigoReclamo);
            }
            
            
            
        } catch (Exception ex) {
            reclamoGrabado = false;
            System.out.println(ex);
            log.error("Error en BD al grabar reclamo: " + ex.getMessage());
        }
        return reclamoGrabado;
    }

    private void eliminaReclamo(long codigoReclamo) {
        log.info("Inicio metodo eliminaReclamo");
        StringBuilder sb = new StringBuilder();
        sb.append("Delete From mv_reclamo where reclcodigo = ?");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, codigoReclamo);
        q.executeUpdate();
    }
    private void eliminaReclamante(long codigoReclamo) {
        log.info("Inicio metodo eliminaReclamante");
        StringBuilder sb = new StringBuilder();
        sb.append("Delete From mv_reclamante where reclcodigo = ?");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, codigoReclamo);
        q.executeUpdate();
    }

    private boolean grabaComplemento(Long codigoReclamo, ReclamoReclamanteResponse reclamoReclamanteRespuesta) {
        log.info("Inicio metodo grabaComplemento");
        boolean reclamoGrabado = false;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("insert into mv_inf_comp_reclamo");
            sb.append("(icorcodigo,reclcodigo,icortexto ) ");
            sb.append("VALUES(?,?,?);");
            Query q = entityManager.createNativeQuery(sb.toString());
            q.setParameter(1, obtieneCorrelativoComplemento());
            q.setParameter(2, codigoReclamo);
            q.setParameter(3, reclamoReclamanteRespuesta.getInformeComplementario());
            q.executeUpdate();
            reclamoGrabado = true;
        } catch (Exception ex) {
            reclamoGrabado = false;
        }
        return reclamoGrabado;
    }

    @Override
    public boolean grabaReclamoYComplemento(ReclamoReclamanteResponse reclamoReclamanteRespuesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
