
package cl.egt.apirest.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
public class OrdenfleteDAOImpl implements OrdenfleteDAO {

    private static final Logger log = LoggerFactory.getLogger(OrdenfleteDAOImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<BigDecimal> obtenerOrdenesFletes(int codigoNomina) {
        log.info("Inicio metodo obtenerOrdenesFletes");
        List<BigDecimal> ordenesFletes = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT o.odflcodigo ");
        sb.append("FROM mv_orden_flete o ");
        sb.append("INNER JOIN mv_encargo e ON o.odflcodigo = e.odflcodigo  ");
        sb.append("INNER JOIN mv_nomina n ON n.nomicodigo = e.nomicodigoactual  ");
        sb.append("WHERE e.nomicodigoactual = ?  ");
        sb.append("AND o.emprcodigo = 1 ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, codigoNomina);
        if (q.getResultList().size() > 0) {
            ordenesFletes = (List<BigDecimal>) q.getResultList();
        }
        return ordenesFletes;
    }

    public int cuentaOrdenFlete(int ordenFlete) {
        int resultado = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT count(odflcodigo) from mv_orden_flete where odflcodigo=? ");
        Query q = entityManager.createNativeQuery(sb.toString());
        q.setParameter(1, ordenFlete);
        try {
            Object rs = (Object) q.getSingleResult();
            resultado = Integer.parseInt(rs.toString());
        } catch (NoResultException e) {
            resultado = 0;
        }
        return resultado;
    }
}
