// 
// Decompiled by Procyon v0.5.36
// 
package cl.egt.apirest.dao;

import cl.egt.apirest.entity.NominaDetalle;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yeremy.toro
 */
@Repository
@Transactional
public class NominaDAOImpl implements NominaDAO {

    private static final Logger log = LoggerFactory.getLogger(NominaDAOImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public boolean existeNomina(int codigoNomina) {
        log.info("Inicio metodo existeNomina");
        boolean existe = false;

        StringBuilder sb = new StringBuilder();
        sb.append("select no.nomicodigo from mv_nomina no where no.nomicodigo=?");

        Query q = entityManager.createNativeQuery(sb.toString());

        q.setParameter(1, codigoNomina);

        if (q.getResultList().size() > 0) {
            existe = true;
        }

        return existe;
    }

    @Override
    public NominaDetalle obtenerNomina(int codigoNomina) {
        log.info("Inicio metodo obtenerNomina");
        NominaDetalle nomina = new NominaDetalle();

        boolean existe = existeNomina(codigoNomina);
        if (existe) {
            StringBuilder sb = new StringBuilder();
            sb.append("select no.nomicodigo , no.enomcodigo , e.enomdescripcion ");
            sb.append("from mv_nomina no ");
            sb.append("INNER JOIN ma_estado_nomina e ON e.ENOMCODIGO = no.ENOMCODIGO ");
            sb.append("WHERE no.nomicodigo= ? ");

            Query q = entityManager.createNativeQuery(sb.toString());

            q.setParameter(1, codigoNomina);

            Object[] objeto = (Object[]) q.getSingleResult();

            nomina.setNomina(Integer.parseInt(String.valueOf(objeto[0])));
            nomina.setCodigoEstado(Integer.parseInt(String.valueOf(objeto[1])));
            nomina.setEstado((String) objeto[2]);

        } else {
            nomina.setNomina(codigoNomina);
            nomina.setCodigoEstado(204);
            nomina.setEstado("Nomina no existe");
        }

        return nomina;
    }

}
