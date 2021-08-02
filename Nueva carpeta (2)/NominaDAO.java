/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.dao;

import cl.egt.apirest.entity.NominaDetalle;

/**
 *
 * @author ricardo.leal
 */
public interface NominaDAO {

    public boolean existeNomina(int codigoNomina);
    public NominaDetalle obtenerNomina(int codigoNomina);

}
