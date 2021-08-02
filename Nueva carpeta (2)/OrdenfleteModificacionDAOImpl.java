// 
// Decompiled by Procyon v0.5.36
// 
package cl.egt.apirest.dao;

import cl.egt.apirest.entity.Direccionamiento;
import cl.egt.apirest.entity.DireccionamientoExcepcion;
import cl.egt.apirest.entity.DireccionamientoSorter;
import cl.egt.apirest.entity.Encargos;
import cl.egt.apirest.entity.OrdenFleteObservacionRequest;
import cl.egt.apirest.entity.OrdenFleteRequest;
import cl.egt.apirest.entity.ReclamoObservacionRequest;
import cl.egt.apirest.exception.CrmException;
import cl.egt.apirest.utils.Constantes;
import cl.egt.apirest.utils.Util;
import cl.egt.apirest.utils.UtilesFecha;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ricardo.leal
 */
@Repository
@Transactional
public class OrdenfleteModificacionDAOImpl implements OrdenfleteModificacionDAO {

    private static final Logger log = LoggerFactory.getLogger(OrdenfleteModificacionDAOImpl.class);

    @Autowired
    private EntityManager entityManager;
    @Value("${app.default.username}")
    private String username;
    @Value("${app.default.usercode}")
    private Integer usercode;

    private static final int ACTIVO = 1;
    private static final int NO_ALTERABLE = 1;
    private static final int SOLICITANTE = 1;
    private static final int MODIFICACION = 6;
    private static final int MOTIVO = 2;
    private static final String SORTERVIGENCIAALTERABLE = "SORTERVIGENCIAALTERABLE";
    private static final String SORTERRANGOVIGENCIA = "SORTERRANGOVIGENCIA";
    private static final String SORTERSALIDAINCIDENCIAS = "SORTERSALIDAINCIDENCIAS";
    private static final int CARACTERES_CODIGO_BARRA = 26;
    private static final String PEX = ".PEX";

    @Override
    public Integer getCiudadByComunaDestinatario(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo getCiudadByComunaDestinatario");
        Integer ciuCodigo = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ciudcodigo from ma_comuna ");
        sb.append("WHERE comucodigo = ?  ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, ordenFleteRequest.getCodigoComunaDestinatario());
        if (q.getResultList().size() > 0) {
            Object objCodigoCiudad = (Object) q.getSingleResult();
            ciuCodigo = Integer.parseInt(objCodigoCiudad.toString());
        } else {
            throw new CrmException(Constantes.CONST_UNO_STR, "Destinatario no tiene Comuna ingresada.");
        }
        return ciuCodigo;

    }

    @Override
    public boolean ordenFleteEsModificable(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo ordenFleteEsModificable");
        boolean oFmodificable = false;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT odflcodigo FROM mv_orden_flete ");
        sb.append("WHERE eprocodigo IN ( ?, ? , ? ,? , ? , ?) ");
        sb.append("AND odflcodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, Constantes.EST_ENTREGADO);
        q.setParameter(2, Constantes.EST_CERRADO_CON_EXCEPCION);
        q.setParameter(3, Constantes.EST_REMATADO);
        q.setParameter(4, Constantes.EST_REDESTINADO);
        q.setParameter(5, Constantes.EST_DECOMISADO);
        q.setParameter(6, Constantes.EST_ANULADO);
        q.setParameter(7, ordenFleteRequest.getOf());
        if (q.getResultList().size() == 0) {
            oFmodificable = true;
        }
        return oFmodificable;
    }

    @Override
    public boolean ordenFleteSinRezago(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo ordenFleteSinRezago");
        boolean ordenFleteSinRezago = false;
        if (ofTieneRezago(ordenFleteRequest.getOf()) == false) {
            Integer oFnueva = ordenFleteRelacionada(ordenFleteRequest);
            ordenFleteSinRezago = true;
            if (oFnueva != 0) {
                if (ofTieneRezago(oFnueva) == false) {
                    ordenFleteSinRezago = true;
                }
            }
        }
        return ordenFleteSinRezago;
    }

    @Override
    public Integer ordenFleteRelacionada(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo ordenFleteRelacionada");
        Integer oFrelacionada = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT orelofnueva FROM rl_odfl_relacionada ");
        sb.append("WHERE orelofantigua = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, ordenFleteRequest.getOf());
        if (q.getResultList().size() > 0) {
            Object objOrdenfleteNueva = (Object) q.getSingleResult();
            oFrelacionada = Integer.parseInt(objOrdenfleteNueva.toString());
        }
        return oFrelacionada;
    }

    @Override
    public boolean ofTieneRezago(Integer OrdenFlete) {
        log.info("Inicio metodo ofTieneRezago");
        boolean ofTieneRez = false;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT odflcodigo FROM mv_rezago ");
        sb.append("WHERE odflcodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, OrdenFlete);
        if (q.getResultList().size() > 0) {
            ofTieneRez = true;
        }
        return ofTieneRez;
    }

    @Override
    public boolean tipoEntregaAgenciaEsValido(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo tipoEntregaAgenciaEsValido");
        boolean tipoEntrgaAgenciaEsValido = false;
        int codigoTipoEntregaAgencia = 1;
        int codigoTipoEntregaDomicilio = 2;

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT RL.AGENCODIGO, RL.RALIEMITE, RL.RALIENTREGA,  RL.RALIENTREGADOMI ");
        sb.append("FROM rl_ag_linea_prod rl ");
        sb.append("JOIN ma_linea li on li.linecodigo = rl.linecodigo ");
        sb.append("JOIN ma_empresa emp on emp.emprcodigo = li.emprcodigo ");
        sb.append("WHERE emp.emprcodigo = ? ");
        sb.append("AND rl.agencodigo = ? ");
        sb.append("AND li.linecodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, Constantes.CODIGO_EMPRESA);
        q.setParameter(2, ordenFleteRequest.getCodigoAgenciaDestino());
        q.setParameter(3, Constantes.CONST_UNO);
        if (q.getResultList().size() > 0) {
            Object[] obj = (Object[]) q.getSingleResult();
            Integer Emision = Integer.parseInt(obj[1].toString());
            Integer EntregaAgen = Integer.parseInt(obj[2].toString());
            Integer EntregaDomicilio = Integer.parseInt(obj[3].toString());
            if ((ordenFleteRequest.getCodigoTipoEntrega() == codigoTipoEntregaAgencia && codigoTipoEntregaAgencia == EntregaAgen)
                    || ordenFleteRequest.getCodigoTipoEntrega() == codigoTipoEntregaDomicilio && codigoTipoEntregaDomicilio == EntregaDomicilio) {
                tipoEntrgaAgenciaEsValido = true;
            } else {
                tipoEntrgaAgenciaEsValido = false;
                throw new CrmException(Constantes.CONST_UNO_STR, "Agencia de destino seleccionada no trabaja con el tipo de entrega indicado. " + Constantes.JSON_NO_CONTINUAR_DESC);

            }
        }
        return tipoEntrgaAgenciaEsValido;
    }

    @Override
    public boolean comprobanteEstadoOrdenFleteEsValido(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo comprobanteEstadoOrdenFleteEsValido");
        boolean comprobanteEstadoOrdenFleteEsValido = true;

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ODFL.ODFLCODIGO FROM mv_orden_flete ODFL ");
        sb.append("INNER JOIN MV_COMPROBANTE COMPROBANTE on  COMPROBANTE.COMPCODIGO = ODFL.COMPCODIGOENTREGA ");
        sb.append("WHERE ODFL.ODFLCODIGO = ? AND ODFL.TPAGCODIGO = ? AND ODFL.COMPCODIGOENTREGA!= ? AND COMPROBANTE.COMPESTADO  IN ( ? , ? , ? ) ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, ordenFleteRequest.getOf());
        q.setParameter(2, Constantes.ORDEN_FLETE_POR_PAGAR);
        q.setParameter(3, Constantes.CONST_CERO);
        q.setParameter(4, Constantes.COMPROBANTE_EST_PAGANDO);
        q.setParameter(5, Constantes.COMPROBANTE_EST_PAGADO);
        q.setParameter(6, Constantes.COMPROBANTE_EST_RENDIDO);
        if (!q.getResultList().isEmpty()) {
            comprobanteEstadoOrdenFleteEsValido = false;
        }
        return comprobanteEstadoOrdenFleteEsValido;
    }

    @Override
    public void normalizaDireccion(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo normalizaDireccion");
        StringBuilder sbDireccion = new StringBuilder();
        sbDireccion.append("SELECT NORMCODIGO,ODFLCODIGO,NORMCOMUNOMBRE ");
        sbDireccion.append("FROM mv_dire_normalizacion ");
        sbDireccion.append("WHERE odflcodigo = ? ");
        Query qDirect = entityManager.createNativeQuery(sbDireccion.toString());
        qDirect.setParameter(1, ordenFleteRequest.getOf());
        if (qDirect.getResultList().size() > 0) {
            actualizaDireccion(ordenFleteRequest);
        } else {
            insertaDireccion(ordenFleteRequest);
        }
    }

    private void actualizaDireccion(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo actualizaDireccion");
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE mv_dire_normalizacion");
        sb.append(" SET normcomunombre = ?, ");
        sb.append(" normnombrecalle = ?, ");
        sb.append(" normdirenumeracion = ?, ");
        sb.append(" usuausuariomodi = ? ");
        sb.append("WHERE odflcodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, getcomuNombre(ordenFleteRequest.getCodigoComunaDestinatario()));
        q.setParameter(2, ordenFleteRequest.getDireccionDestino());
        q.setParameter(3, ordenFleteRequest.getNumeracionDestino());
        q.setParameter(4, username);
        q.setParameter(5, ordenFleteRequest.getOf());
        q.executeUpdate();
    }

    @Override
    public void actualizaOrdenFleteYDestino(OrdenFleteRequest ordenFleteRequest) {
        actualizaOrdenFlete(ordenFleteRequest);
        actualizaDestinaterio(ordenFleteRequest);
    }

    private void insertaDireccion(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo insertaDireccion");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO mv_dire_normalizacion ");
        sb.append("(normcodigo, odflcodigo, normcomunombre,");
        sb.append("normnombrecalle, normdirenumeracion, usuausuariocrea, normfechacrea) ");
        sb.append("VALUES(S_422_1_MV_DIRE_NORMALIZAC.NEXTVAL ,?,?,?,?,?,?)");

        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, ordenFleteRequest.getOf());
        q.setParameter(2, getcomuNombre(ordenFleteRequest.getCodigoComunaDestinatario()));
        q.setParameter(3, ordenFleteRequest.getDireccionDestino());
        q.setParameter(4, ordenFleteRequest.getNumeracionDestino());
        q.setParameter(5, username);
        q.setParameter(6, new Date());
        q.executeUpdate();
    }

    private String getcomuNombre(Integer codigoComuna) {
        log.info("Inicio metodo getcomuNombre");
        String nombreComuna = "";
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT comunombre FROM ma_comuna ");
        sb.append("WHERE comucodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, codigoComuna);
        Object objNombreComuna = (Object) q.getSingleResult();
        nombreComuna = objNombreComuna.toString();
        return nombreComuna;
    }

    private void actualizaOrdenFlete(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo actualizaOrdenFlete");
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE mv_orden_flete ");
        sb.append(" SET agencodigodestino  = ?, ");
        sb.append(" tentcodigo  = ?  ");
        sb.append("WHERE odflcodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, ordenFleteRequest.getCodigoAgenciaDestino());
        q.setParameter(2, ordenFleteRequest.getCodigoTipoEntrega());
        q.setParameter(3, ordenFleteRequest.getOf());
        q.executeUpdate();
    }

    private void actualizaDestinaterio(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo actualizaDestinaterio");
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE mv_destinatario ");
        sb.append("SET comucodigo = ?, ");
        sb.append("destdepartamento = ?, ");
        sb.append("destdireccion = ?, ");
        sb.append("ciudcodigo = ? ");
        sb.append("WHERE odflcodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, ordenFleteRequest.getCodigoComunaDestinatario());
        q.setParameter(2, ordenFleteRequest.getDepartamentoDestino());
        q.setParameter(3, ordenFleteRequest.getDireccionDestino());
        q.setParameter(4, retornaCiucodigo(ordenFleteRequest.getCodigoComunaDestinatario()));
        q.setParameter(5, ordenFleteRequest.getOf());
        q.executeUpdate();
    }

    private Integer retornaCiucodigo(Integer codComuna) {
        log.info("Inicio metodo retornaCiucodigo");
        Integer ciucodigo = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ciudcodigo FROM ma_comuna ");
        sb.append("WHERE comucodigo = ?");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, codComuna);
        Object objCodCiudad = (Object) q.getSingleResult();
        ciucodigo = Integer.parseInt(objCodCiudad.toString());
        return ciucodigo;
    }

    @Override
    public void grabaObservaciones(OrdenFleteRequest ordenFleteRequest) {
        grabaObsUno(ordenFleteRequest);
        grabaObsDos(ordenFleteRequest);
        grabaObsTres(ordenFleteRequest);
    }

    private void grabaObsUno(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo grabaObsUno");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO mv_observacion_of ");
        sb.append("(obofcodigo, odflcodigo, obofdetalle, ");
        sb.append("oboffecha, obofhora, oboftipoobserv, usuausuariocrea, obspcodigo) ");
        sb.append("VALUES(S_609_1_MV_OBSERVACION_OF.nextval,?,?,?,?,?,?,?) ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, ordenFleteRequest.getOf());
        q.setParameter(2, ordenFleteRequest.getSolicitante());
        q.setParameter(3, new Date());
        q.setParameter(4, new Date());
        q.setParameter(5, SOLICITANTE);
        q.setParameter(6, username);
        q.setParameter(7, MODIFICACION);
        q.executeUpdate();
    }

    private void grabaObsDos(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo grabaObsDos");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO mv_observacion_of ");
        sb.append("(obofcodigo, odflcodigo, obofdetalle, ");
        sb.append("oboffecha, obofhora, oboftipoobserv, usuausuariocrea, obspcodigo) ");
        sb.append("VALUES(S_609_1_MV_OBSERVACION_OF.nextval,?,?,?,?,?,?,?) ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, ordenFleteRequest.getOf());
        q.setParameter(2, ordenFleteRequest.getMotivo());
        q.setParameter(3, new Date());
        q.setParameter(4, new Date());
        q.setParameter(5, MOTIVO);
        q.setParameter(6, username);
        q.setParameter(7, MODIFICACION);
        q.executeUpdate();
    }

    private void grabaObsTres(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo grabaObsTres");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO mv_observacion_of ");
        sb.append("(obofcodigo, odflcodigo, obofdetalle, ");
        sb.append("oboffecha, obofhora, oboftipoobserv, usuausuariocrea, obspcodigo) ");
        sb.append("VALUES(S_609_1_MV_OBSERVACION_OF.nextval,?,?,?,?,?,?,?) ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, ordenFleteRequest.getOf());
        q.setParameter(2, "agencia de destino, tipo de pago");
        q.setParameter(3, new Date());
        q.setParameter(4, new Date());
        q.setParameter(5, MODIFICACION);
        q.setParameter(6, username);
        q.setParameter(7, MODIFICACION);
        q.executeUpdate();
    }

    //****************************************************************************************
    // **********************   Direccionamiento Sorter **************************************
    //****************************************************************************************
    private Integer periodoVigencia() {
        log.info("Inicio metodo periodoVigencia");
        int vigencia = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT paravalor  FROM ma_parametros ");
        sb.append("where paranombre = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, SORTERVIGENCIAALTERABLE);
        if (q.getResultList().size() > 0) {
            Object objVigencia = (Object) q.getSingleResult();
            vigencia = Integer.parseInt(objVigencia.toString());
        }
        return vigencia;
    }

    private String rangoVigencia() {
        log.info("Inicio metodo rangoVigencia");
        String rango = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT paravalor  FROM ma_parametros ");
        sb.append("where paranombre = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, SORTERRANGOVIGENCIA);
        if (q.getResultList().size() > 0) {
            Object objVigencia = (Object) q.getSingleResult();
            rango = objVigencia.toString();
        }
        return rango;
    }

    private String salidaIncidencias() {
        log.info("Inicio metodo salidaIncidencias");
        String incidencias = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT paravalor  FROM ma_parametros ");
        sb.append("where paranombre = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, SORTERSALIDAINCIDENCIAS);
        if (q.getResultList().size() > 0) {
            Object objVigencia = (Object) q.getSingleResult();
            incidencias = objVigencia.toString();
        }
        return incidencias;
    }

    private List<Encargos> listaEncargos(Integer odlfCodigo) {
        log.info("Inicio metodo listaEncargos");
        StringBuilder sb = new StringBuilder();
        sb.append("select ENCACODIGO,ENCACODIGOBARRA,tenc.TENCCODIGO,tenc.TENCNOMBRE,est.EPRODESCRIPCION,enca.ENCAKGS,enca.ENCAALTO,enca.ENCAANCHO,enca.ENCALARGO,ENCACLASIFSORTER ");
        sb.append("from MV_ENCARGO enca ");
        sb.append("inner join MA_TIPO_ENCARGO tenc on tenc.TENCCODIGO = enca.TENCCODIGO ");
        sb.append("inner join MA_ESTADO_PROCESO est on est.EPROCODIGO = enca.EPROCODIGO ");
        sb.append("where odflcodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString(), Encargos.class);
        q.setParameter(1, odlfCodigo);
        List<Encargos> encargosList = (List<Encargos>) q.getResultList();
        return encargosList;
    }

    //Direccionamiento Sorter Cajas
    private String getTipoServicio(Integer OrdenFlete) {
        log.info("Inicio metodo getTipoServicio");
        String tipoServicio = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT tsercodigo  FROM mv_orden_flete ");
        sb.append("where odflcodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, OrdenFlete);
        if (q.getResultList().size() > 0) {
            Object objServicio = (Object) q.getSingleResult();
            tipoServicio = objServicio.toString();
        }
        return tipoServicio;
    }

    private String lPad(String value, int size, String caracter) throws CrmException {
        int faltantes = size - value.length();
        if (faltantes < 0) {
            throw new CrmException(Constantes.CONST_UNO_STR, "El largo de la cadena es superrior al valor solicitado.");
        }
        String salida = "";
        for (int i = 0; i < faltantes; i++) {
            salida = salida + caracter;
        }
        return salida + value;
    }

    private String generaDireccionamiento(OrdenFleteRequest ordenFleteRequest, Encargos encargo, int codigoComuna) {
        String direccionamiento = null;
        direccionamiento = "" + encargo.getClasificacion();
        direccionamiento += getTipoServicio(ordenFleteRequest.getOf());
        direccionamiento += this.lPad(String.valueOf(ordenFleteRequest.getCodigoAgenciaDestino()), 4, "0");
        direccionamiento += ordenFleteRequest.getCodigoTipoEntrega();
        return direccionamiento;
    }

    private void grabaDireccionamientoSorter(DireccionamientoSorter direccionamientoSorter) {
        log.info("Inicio metodo grabaDireccionamientoSorter");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO mv_sorter_excepcion (soexcodigo,usuacodigo, soexfechahora, ");
        sb.append("soexexcepcion, soexextension, soexactivo, soexcodigobarra, soexobservacion, ");
        sb.append("soexisnoalterable, soexperiodovigencia,soexrangovigencia ) ");
        sb.append("VALUES(S_575_1_MV_SORTER_EXCEPCION.NEXTVAL,?,?,?,?,?,?,?,?,?,?)");
        Query q = entityManager.createNativeQuery(sb.toString());
//        q.setParameter(1, direccionamientoSorter.getSoexcodigo());
        q.setParameter(1, direccionamientoSorter.getUsuacodigo());
        q.setParameter(2, direccionamientoSorter.getSoexfechahora());
        q.setParameter(3, direccionamientoSorter.getSoexexcepcion());
        q.setParameter(4, direccionamientoSorter.getSoexextension());
        q.setParameter(5, direccionamientoSorter.getSoexactivo());
        q.setParameter(6, direccionamientoSorter.getSoexcodigobarra());
        q.setParameter(7, direccionamientoSorter.getSoexobservacion());
        q.setParameter(8, direccionamientoSorter.getSoexisnoalterable());
        q.setParameter(9, direccionamientoSorter.getSoexperiodovigencia());
        q.setParameter(10, direccionamientoSorter.getSoexrangovigencia());
        q.executeUpdate();
    }

    private Direccionamiento getDireccionamientoSorter(String strDireccionamiento) {
        log.info("Inicio metodo getDireccionamientoSorter");
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT disodesde,disohasta,disosorter,disoitl,disoactualizacion,disolinea, ");
        sb.append("disotcargadesde,disotcargahasta,disotserviciodesde,disotserviciohasta, ");
        sb.append("disoagenciadesde,disoagenciahasta,disotentregadesde,disotentregahasta ");
        sb.append("FROM mv_direccionamiento_sorter ");
        sb.append("WHERE disodesde <= ? ");
        sb.append("AND disohasta >= ? ");
        Query q = entityManager.createNativeQuery(sb.toString(), Direccionamiento.class);
        q.setParameter(1, strDireccionamiento);
        q.setParameter(2, strDireccionamiento);
        Direccionamiento direccionamiento = new Direccionamiento();
        try {
            direccionamiento = (Direccionamiento) q.getSingleResult();
        } catch (NoResultException e) {
            direccionamiento = null;
        }
        return direccionamiento;
    }

    private void grabaDireccionamientoExcepcion(DireccionamientoExcepcion direccionamientoExcepcion) {
        log.info("Inicio metodo grabaDireccionamientoExcepcion");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO mv_sorter_excepcion (codigo,codigoUsuario,fechaHoraRegistro,excepcion, isActivo, extensionArchivo  ");
        sb.append("codigoBarra, observacion ,isNoAlterable, periodoVigencia, rangoVigencia");
        sb.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, direccionamientoExcepcion.getCodigo());
        q.setParameter(2, direccionamientoExcepcion.getCodigoUsuario());
        q.setParameter(3, direccionamientoExcepcion.getFechaHoraRegistro());
        q.setParameter(4, direccionamientoExcepcion.getExcepcion());
        q.setParameter(5, direccionamientoExcepcion.getIsActivo());
        q.setParameter(6, direccionamientoExcepcion.getExtensionArchivo());
        q.setParameter(7, direccionamientoExcepcion.getCodigoBarra());
        q.setParameter(8, direccionamientoExcepcion.getObservacion());
        q.setParameter(9, direccionamientoExcepcion.getIsNoAlterable());
        q.setParameter(10, direccionamientoExcepcion.getPeriodoVigencia());
        q.setParameter(11, direccionamientoExcepcion.getRangoVigencia());
        q.executeUpdate();

    }

    private void actualizaEncargo(Encargos encargosSorterDireccionamiento) {
        log.info("Inicio metodo actualizaEncargo");
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE MV_ENCARGO SET ENCACODIGOBARRA = ? WHERE encacodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, encargosSorterDireccionamiento.getEncargoCodigoBarra());
        q.setParameter(2, encargosSorterDireccionamiento.getEncargoCodigo());
        q.executeUpdate();
    }

    private void actualizarDetalleNomina(long codigoEncargo, String codigoBarraEncargo) {
        log.info("Inicio metodo actualizarDetalleNomina");
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE DetalleNomina");
        sb.append("SET codigoBarraEncargo = ? ");
        sb.append("WHERE codigoEncargo = ?");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, codigoBarraEncargo);
        q.setParameter(2, codigoEncargo);
        q.executeUpdate();

    }

    @Override
    public void direccionamientoSorter(OrdenFleteRequest ordenFleteRequest) {
        log.info("Inicio metodo direccionamientoSorter");
        List<Encargos> encargosList = this.listaEncargos(ordenFleteRequest.getOf());
        for (Encargos enc : encargosList) {
            String direccionamiento = this.generaDireccionamiento(ordenFleteRequest, enc, ordenFleteRequest.getCodigoComunaDestinatario());
            if (enc.getEncargoCodigoBarra().trim().length() == CARACTERES_CODIGO_BARRA) {
                try {
                    //Direccionamiento Sorter Cajas
                    DireccionamientoSorter direccionamientoSorter = new DireccionamientoSorter();
                    direccionamientoSorter.setSoexcodigobarra(enc.getEncargoCodigoBarra());
                    direccionamientoSorter.setUsuacodigo(usercode);
                    direccionamientoSorter.setSoexfechahora(new Date());
                    direccionamientoSorter.setSoexactivo(ACTIVO);
                    direccionamientoSorter.setSoexisnoalterable(NO_ALTERABLE);
                    direccionamientoSorter.setSoexobservacion("Informacion de excepcion por modificacion de orden [" + ordenFleteRequest.getOf() + "]");
                    direccionamientoSorter.setSoexperiodovigencia(this.periodoVigencia());
                    direccionamientoSorter.setSoexrangovigencia(this.rangoVigencia());
                    direccionamientoSorter.setSoexexcepcion(enc.getEncargoCodigoBarra().trim() + this.salidaIncidencias());
                    direccionamientoSorter.setSoexextension(PEX);
                    this.grabaDireccionamientoSorter(direccionamientoSorter);
                } catch (Exception e) {
                    throw new CrmException(Constantes.CONST_UNO_STR, "Ocurrio un error al insertar el direccionamiento en el sorter de cajas para el encargo. [" + enc.getEncargoCodigoBarra() + "] " + e);
                }
                try {
                    //Direccionamiento Tow-Line NO EXISTE ZONA DE ERROR EN TOW-LINE
                    Direccionamiento direccionamientoTbl = this.getDireccionamientoSorter(direccionamiento);
                    if ((direccionamientoTbl != null) && !(direccionamientoTbl.getDireccionamientoDesde().isEmpty()) && (direccionamientoTbl.getSalidaITL() != null) && !(direccionamientoTbl.getSalidaITL().trim().equals(""))) {
                        DireccionamientoExcepcion direccionamientoExcepcion = new DireccionamientoExcepcion();
                        direccionamientoExcepcion.setCodigoBarra(enc.getEncargoCodigoBarra());
                        direccionamientoExcepcion.setCodigoUsuario(usercode);
                        direccionamientoExcepcion.setFechaHoraRegistro(new Date());
                        direccionamientoExcepcion.setIsActivo(ACTIVO);
                        direccionamientoExcepcion.setIsNoAlterable(NO_ALTERABLE);
                        direccionamientoExcepcion.setObservacion("Informacion de excepcion por modificacion de orden [" + ordenFleteRequest.getOf() + "]");
                        direccionamientoExcepcion.setPeriodoVigencia(this.periodoVigencia());
                        direccionamientoExcepcion.setRangoVigencia(this.rangoVigencia());
                        direccionamientoExcepcion.setExcepcion(enc.getEncargoCodigoBarra().trim() + direccionamientoTbl.getSalidaITL());
                        direccionamientoExcepcion.setExtensionArchivo(".TEX");
                        this.grabaDireccionamientoExcepcion(direccionamientoExcepcion);
                    }
                } catch (Exception e) {
                    log.error("Ocurrio un error al recuperar el la tabla de direccionamiento para el encargo  [" + enc.getEncargoCodigoBarra() + "]" + e.getMessage());
                    throw new CrmException(Constantes.CONST_UNO_STR, "Ocurrio un error al recuperar el la tabla de direccionamiento para el encargo  [" + enc.getEncargoCodigoBarra() + "]" + e);
                }
            }
            if (enc.getEncargoCodigoBarra().trim().length() == CARACTERES_CODIGO_BARRA) {
                String cB = "9" + direccionamiento + enc.getEncargoCodigoBarra().substring(10);
                enc.setEncargoCodigoBarra(cB);
                this.actualizaEncargo(enc);   //UPDATE MV_ENCARGO SET ENCACODIGOBARRA = cB WHERE encacodigo = ?     
                this.actualizarDetalleNomina(enc.getEncargoCodigo(), cB);// UPDATE mv_detalle_nomina SET encacodigobarra = cB WHERE encacodigo = ?
            }
        }

    }

    public void insertOrdenFleteObservacion(OrdenFleteObservacionRequest ordenFleteObservacionRequest) {
        StringBuilder sb = new StringBuilder();
        UtilesFecha utiltilesFecha = new UtilesFecha();
        sb.append("INSERT INTO mv_observacion_of (obofcodigo, odflcodigo, obofdetalle, oboffecha,");
        sb.append(" obofhora, oboftipoobserv,usuausuariocrea, obspcodigo) ");
        sb.append("VALUES(S_609_1_MV_OBSERVACION_OF.nextval,?,?,sysdate,sysdate,?,?,?)");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, ordenFleteObservacionRequest.getOrdenFlete());
        q.setParameter(2, ordenFleteObservacionRequest.getDetalleObservacion() + " " + ordenFleteObservacionRequest.getUsuarioCrea());
        q.setParameter(3, ordenFleteObservacionRequest.getTipoObservacion());
        q.setParameter(4, Constantes.USUARIO_GENERICO);
        q.setParameter(5, ordenFleteObservacionRequest.getObsTipoObsProceso()); 
        q.executeUpdate();      
    }

    public int verificaOrdenFlete(int odflCodigo) {
        int resultado = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT count(odflcodigo) ");
        sb.append("FROM mv_orden_flete  ");
        sb.append("WHERE odflcodigo = ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, odflCodigo);
        try {
            Object rs = (Object) q.getSingleResult();
            resultado = Integer.parseInt(rs.toString());
        } catch (NoResultException e) {
            resultado = 0;
        }
        return resultado;
    }

    public int getTipoObsOfProcesoByDescripcion(String descripcion) {
        int resultado = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT obspcodigo FROM ma_obsv_of_proceso ");
        sb.append("where (trim(obspdescripcion))= ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, descripcion.trim());
        try {
            Object rs = (Object) q.getSingleResult();
            resultado = Integer.parseInt(rs.toString());
        } catch (NoResultException e) {
            resultado = 0;
        }
        return resultado;
    }

    public int getTipoObsOfByDescripcion(String descripcion) {
        int resultado = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT toofcodigo FROM ma_tipo_obsv_of ");
        sb.append("where upper(trim(toofdescripcion))= ? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, descripcion.trim());
        try {
            Object rs = (Object) q.getSingleResult();
            resultado = Integer.parseInt(rs.toString());
        } catch (NoResultException e) {
            resultado = 0;
        }
        return resultado;
    }

    public void modificaEstadoOf(int ordenFlete, int codestado) {
        StringBuilder sb = new StringBuilder();  
        sb.append("update MV_ORDEN_FLETE ");
        sb.append("set EPROCODIGO=? ");
        sb.append("where ODFLCODIGO=? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, codestado);
        q.setParameter(2, ordenFlete);
        q.executeUpdate();        
    }
  public void insertOrdenFleteObservacionReclamo(ReclamoObservacionRequest reclamoObservacionRequest) {
        StringBuilder sb = new StringBuilder();    
        UtilesFecha utiltilesFecha = new UtilesFecha();
        sb.append("INSERT INTO mv_observacion_of (obofcodigo, odflcodigo, obofdetalle, oboffecha,");
        sb.append(" obofhora, oboftipoobserv,usuausuariocrea, obspcodigo) ");
        sb.append("VALUES(S_609_1_MV_OBSERVACION_OF.nextval,?,?,sysdate,sysdate,?,?,?)");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, reclamoObservacionRequest.getOrdenFlete());
        q.setParameter(2, reclamoObservacionRequest.getDetalleObservacion()  + ". Folio Reclamo:" + reclamoObservacionRequest.getFolio()  + " Usuario CRM:" + reclamoObservacionRequest.getUsuarioCrea());
        q.setParameter(3, reclamoObservacionRequest.getTipoObservacion());
        q.setParameter(4, Constantes.USUARIO_GENERICO);
        q.setParameter(5, reclamoObservacionRequest.getObsTipoObsProceso()); 
        q.executeUpdate();      
    }
}
