/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.dao;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ricardo.leal
 */
public interface OrdenfleteDAO {

    public List<BigDecimal> obtenerOrdenesFletes(int codigoNomina);
    public int cuentaOrdenFlete(int ordenFlete);

}
