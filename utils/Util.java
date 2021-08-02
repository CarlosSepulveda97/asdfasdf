/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.utils;

import cl.egt.apirest.entity.Reclamo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author ricardo.leal
 */
public class Util {

    public String formatJson(Object reclamo) {
        ObjectMapper mapper = new ObjectMapper();
        Reclamo reclamoBean = new Reclamo();
        String json = "";
        try {
            json = mapper.writeValueAsString(reclamo);

        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error trasnformando Objeto a JSON :" + e);
        }
        return json;
    }

    public Util() {
    }

    public boolean validaDatoNumerico(String parametro) {
        boolean datoValido = false;
        Double numero = 0.0;
        try {
            numero = Double.parseDouble(parametro);
            datoValido = true;
        } catch (Exception ex) {
            datoValido = false;
        }
        return datoValido;

    }

    public boolean validaFormatoFecha(String fecha) {
        boolean formatoValido = false;
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

            Date nfecha = formatoFecha.parse(fecha);

            System.out.println(nfecha.getYear());
            formatoValido = true;
        } catch (ParseException e) {
            formatoValido = false;
        }

        return formatoValido;
    }


}
