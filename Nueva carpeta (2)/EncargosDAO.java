/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.dao;

import cl.egt.apirest.entity.OrdenFleteRequest;

/**
 *
 * @author ricardo.leal
 */
public interface EncargosDAO {
    public boolean encargoLibreDeNomina(OrdenFleteRequest ordenFleteRequest);
    public void modificaEstadoEncargo(int ordenFlete, int codestado);
}
