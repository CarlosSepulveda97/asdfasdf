package cl.egt.apirest.utils;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cl.egt.apirest.entity.DetalleDominioClienteRequest;
import cl.egt.apirest.entity.DominioCliente;
import cl.egt.apirest.exception.CrmException;
import org.springframework.stereotype.Component;

/**
 *
 * @author luis.flores
 */
@Component
public class DominioUtil {
    
    public void validaDatos(DetalleDominioClienteRequest dominio){
        boolean result = true;
        
        if(dominio ==null || dominio.getDominio()==null || dominio.getDominio().trim().equals("")){
            throw new CrmException(Constantes.ERROR_CODIGO_SIN_DOMINIO,Constantes.ERROR_DESCRIPCION_SIN_DOMINIO);
        }
        if(dominio.getDominio().contains("/")){
            throw new CrmException(Constantes.ERROR_CODIGO_CARACTER_ERRONEO_1,Constantes.ERROR_DESCRIPCION_CARACTER_ERRONEO_1);
        }
        if(dominio.getDominio().contains("\"") || dominio.getDominio().contains("\'")){
            throw new CrmException(Constantes.ERROR_CODIGO_CARACTER_ERRONEO_2,Constantes.ERROR_DESCRIPCION_CARACTER_ERRONEO_2);
        }
    }
    
    public void validaDatos(String dominio){
        boolean result = true;
        
        if(dominio ==null || dominio.trim().equals("")){
            throw new CrmException(Constantes.ERROR_CODIGO_SIN_DOMINIO,Constantes.ERROR_DESCRIPCION_SIN_DOMINIO);
        }
        if(dominio.contains("/")){
            throw new CrmException(Constantes.ERROR_CODIGO_CARACTER_ERRONEO_1,Constantes.ERROR_DESCRIPCION_CARACTER_ERRONEO_1);
        }
        if(dominio.contains("\"") || dominio.contains("\'")){
            throw new CrmException(Constantes.ERROR_CODIGO_CARACTER_ERRONEO_2,Constantes.ERROR_DESCRIPCION_CARACTER_ERRONEO_2);
        }
    }
    
     public void validaDominio(DominioCliente d){   
        if( d.getDomDominio()==null || d.getDomDominio().trim().equals("")){
            throw new CrmException(Constantes.ERROR_CODIGO_SIN_DOMINIO,Constantes.ERROR_DESCRIPCION_SIN_DOMINIO);
        }
        
        if( d.getDomPrioridad()<0){
            throw new CrmException(Constantes.ERROR_CODIGO_DATOS_INCOMPLETOS,Constantes.ERROR_DESCRIPCION_DATOS_INCOMPLETOS);
        }
        
        if( d.getDomCodAsistenteBack()<0 ||d.getDomCodAsistenteCabecera()<0 ){
            throw new CrmException(Constantes.ERROR_CODIGO_DATOS_INCOMPLETOS,Constantes.ERROR_DESCRIPCION_DATOS_INCOMPLETOS);
        }
        
        if( d.getDomAsistenteCabecera()==null || d.getDomAsistenteBack()==null 
                || d.getDomAsistenteCabecera().trim().equals("") || d.getDomAsistenteBack().trim().equals("")){
            throw new CrmException(Constantes.ERROR_CODIGO_DATOS_INCOMPLETOS,Constantes.ERROR_DESCRIPCION_DATOS_INCOMPLETOS);
        }
        
        if( d.getDomAptitud()==null || d.getDomAptitud().trim().equals("")){
            throw new CrmException(Constantes.ERROR_CODIGO_DATOS_INCOMPLETOS,Constantes.ERROR_DESCRIPCION_DATOS_INCOMPLETOS);
        }
    }
    
}
