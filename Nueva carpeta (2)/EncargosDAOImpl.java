// 
// Decompiled by Procyon v0.5.36
// 

package cl.egt.apirest.dao;

import cl.egt.apirest.entity.EncargoModificacionOf;
import cl.egt.apirest.entity.Nomina;
import cl.egt.apirest.entity.OrdenFleteRequest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EncargosDAOImpl  implements EncargosDAO{

    private static final Logger log = LoggerFactory.getLogger(EncargosDAOImpl.class);
    
    @Autowired
    private EntityManager entityManager;
    private static final Integer nominaReparto = 2;
    private static final Integer nominaLiquidada = 8;

    @Override
    public boolean encargoLibreDeNomina(OrdenFleteRequest ordenFleteRequest){
        log.info("Inicio metodo encargoLibreDeNomina");
        boolean encargoLibreDeNomina = true;
        StringBuilder sbEncargo = new StringBuilder();
        sbEncargo.append("SELECT encacodigo,encacodigobarra,odflcodigo,tenccodigo,eprocodigo,");
        sbEncargo.append("tconcodigo,encacontenido,encakgs,encam3,encalargo,encaalto,encaancho,");
        sbEncargo.append("encaunidades,eenccodigo,encagrupo,ubiccodigoactual,nomicodigoactual,");
        sbEncargo.append("usuacodigocontrol,encafechacontrol,encahoracontrol,ubiccodigo,");
        sbEncargo.append("encacodigobarraturex,encaclasifsorter,isinformadosorter ");
        sbEncargo.append("FROM mv_encargo ");
        sbEncargo.append("WHERE odflcodigo = ? ");
        Query qEncargo = entityManager.createNativeQuery(sbEncargo.toString(), EncargoModificacionOf.class);
        qEncargo.setParameter(1, ordenFleteRequest.getOf());
        List<EncargoModificacionOf> encargoModificacionOfList = (List<EncargoModificacionOf>) qEncargo.getResultList();
        for (EncargoModificacionOf encargoModificacionOf : encargoModificacionOfList) {
            if (encargoModificacionOf.getNomicodigoactual() != 0) {
                StringBuilder sbNomina = new StringBuilder();
                sbNomina.append("SELECT nomicodigo,usuacodigoresp,servcodigo,nomifechacreacion,");
                sbNomina.append("nomihoracreacion,enomcodigo,usuacodigocrea,nomifecharecep,nomihorarecep,");
                sbNomina.append("usuacodigorecep,usuacodigodesp,nomitotalofs,nomitotalencargos,nomitotalkgs,");
                sbNomina.append("nomitotalm3,nomibcomisionablen,nomibcomisionabler,emprcodigo,agencodigoorigen,");
                sbNomina.append("agencodigodestino,ubifcodigo,tnomcodigo,rendcodigo,maqucodigo,triprutpiloto,");
                sbNomina.append("triprutcopiloto,triprutauxiliar,nomifechadesp,nomifechahoramodi,nomihoradespacho,");
                sbNomina.append("triprutpiloto2,triprutcopiloto2,triprutauxiliar2,triprutpiloto3,triprutcopiloto3,triprutauxiliar3 ");
                sbNomina.append("FROM mv_nomina");
                sbNomina.append("WHERE NOMICODIGO = ? ");
                Query qNomina = entityManager.createNativeQuery(sbNomina.toString(), Nomina.class);
                qNomina.setParameter(1, encargoModificacionOf.getNomicodigoactual());

                List<Nomina> nominaList = (List<Nomina>) qNomina.getResultList();
                for (Nomina nomina : nominaList) {
                    if (nomina.getTnomcodigo() == nominaReparto) {
                        if (nomina.getEnomcodigo() != nominaLiquidada) {
                            encargoLibreDeNomina = false;
                        }
                    }
                }
            }
        }
        return encargoLibreDeNomina;
    }
    
    
    
        public void modificaEstadoEncargo(int ordenFlete, int codestado) {
        StringBuilder sb = new StringBuilder();  
        sb.append("update MV_ENCARGO  ");
        sb.append("set EPROCODIGO=? ");
        sb.append("where ODFLCODIGO=? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, codestado);
        q.setParameter(2, ordenFlete);
        q.executeUpdate();        
    }
    
    
    
    
}
