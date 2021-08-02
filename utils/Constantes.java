/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.utils;

public abstract class Constantes
{
    public static final String USUARIO_GENERICO = "DLS1";
    public static final int USUARIO_GENERICO_COD = 1672;
    public static final int INGRESADO = 1;
    public static final int CODIGO_EMPRESA = 1;
    public static final String FORMATO_VISTA_FECHA = "dd/MM/yy";
    public static final String FORMATO_BD_HORA = "HH:mm";

    public static final String PARAM_RUT_EMPRESA = "50000000";

    public static final int CONST_CERO = 0;
    public static final int CONST_UNO = 1;
    public static final String CONST_UNO_STR = "1";
    public static final int CODIGO_ERROR = 1;
    public static Integer TIPO_PERSONA_NATURAL = 1;    
    public static Integer TIPO_PERSONA_EMPRESA = 2;    
    public static Integer RUT_EMPRESA = 50000000;
    public static final String JSON_NO_CONTINUAR_DESC = "No se puede continuar con el flujo";
    public static final String JSON_CONTINUAR_DESC = "Datos ingresados correctamente.";
    public static final String MSG_NOT_FOUND_DETALLE_TRACKING = "No se encontro registro para detalle de la orden de Flete";
    public static final String MSG_NOT_FOUND_TRACKING = "No se encontró información para la orden de Flete";

    public static final int EST_ENTREGADO = 1;
    public static final int EST_CERRADO_CON_EXCEPCION = 11;
    public static final int EST_REMATADO = 12;
    public static final int EST_REDESTINADO = 13;
    public static final int EST_DECOMISADO = 14;
    public static final int EST_ANULADO = 15;
    
    public static final int ORDEN_FLETE_POR_PAGAR = 3;
    public static final int COMPROBANTE_EST_PAGANDO = 1;
    public static final int COMPROBANTE_EST_PAGADO = 2;
    public static final int COMPROBANTE_EST_RENDIDO = 3;
    public static final int PERSONA =1 ;
    public static final int EMPRESA =2;

    
    //TIPOS DE PAGO
    public static final int TPAG_CONTADO = 1;
    public static final int TPAG_CTACTE = 2;
    public static final int TPAG_PORPAGAR= 3;
    
    //AGENCIA REDESTINACION
    public static final int AGEN_REDES= 1467;
    
    //AREA
    public static final String AREA_SOLICITANTE = "BA360";
    
    //QA
    //public static final String URI = "/apiqa/apistarkencrm";
    
    //PROD
    //public static final String URI = "/apiprd/apistarkencrm";
    
    //Final
    public static final String URI = "/";
    
    //MANEJO DE ERRORES
    public static final String ERROR_CODIGO_SIN_REGISTROS = "01";
    public static final String ERROR_CODIGO_CARACTER_ERRONEO_1 = "02";
    public static final String ERROR_CODIGO_CONSULTA_SQL = "03";
    public static final String ERROR_CODIGO_CARACTER_ERRONEO_2 = "04";
    public static final String ERROR_CODIGO_SIN_DOMINIO = "05";
    public static final String ERROR_CODIGO_DOMINIO_NO_VALIDO = "06";
    public static final String ERROR_CODIGO_ACTUALIZAR_DOMINIO = "07";
    public static final String ERROR_CODIGO_ELIMINAR_DOMINIO = "08";
    public static final String ERROR_CODIGO_DATOS_INCOMPLETOS = "09";
    public static final String ERROR_CODIGO_INSERTAR_DOMINIO = "10";
    public static final String ERROR_CODIGO_INSERTAR_DESTINATARIO= "11";

    
    public static final String ERROR_DESCRIPCION_SIN_REGISTROS = "No se encontró información asociada a la consulta. ";
    public static final String ERROR_DESCRIPCION_CARACTER_ERRONEO_1 = "El caracter / no está permitido. Debe ingresar un dominio válido. ";
    public static final String ERROR_DESCRIPCION_CONSULTA_SQL = "Ocurrió un error con la consulta a la tabla  : ";
    public static final String ERROR_DESCRIPCION_CARACTER_ERRONEO_2 = "Las comillas simples o dobles no están permitidas. Debe ingresar un dominio válido. ";
    public static final String ERROR_DESCRIPCION_SIN_DOMINIO = "Debe ingresar un dominio para continuar por favor. ";
    public static final String ERROR_DESCRIPCION_DOMINIO_NO_VALIDO = "Uno de los dominios ingresados no es válido.";
    public static final String ERROR_DESCRIPCION_ACTUALIZAR_DOMINIO = "Ocurrió un error y no fue posible modificar la información, favor intente más tarde.";
    public static final String ERROR_DESCRIPCION_ELIMINAR_DOMINIO = "Ocurrió un error y no fue posible eliminar la información, favor intente más tarde.";
    public static final String ERROR_DESCRIPCION_DATOS_INCOMPLETOS = "Los datos ingresados están incompletos.";
    public static final String ERROR_DESCRIPCION_INSERTAR_DOMINIO = "Ocurrió un error y no fue posible insertar la información, favor intente más tarde.";
    public static final String ERROR_DESCRIPCION_INSERTAR_DESTINATARIO= "Ocurrió un error y no fue posible insertar el nuevo destinatario, favor intente más tarde.";
    


}
