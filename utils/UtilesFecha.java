// 
// Decompiled by Procyon v0.5.36
// 
package cl.egt.apirest.utils;

import java.text.DateFormat;
import java.util.Locale;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class UtilesFecha {

    public static boolean validarFecha(String fecha) {
        if (fecha == null) {
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        System.out.println(fecha.trim().length());
        System.out.println(dateFormat.toPattern().length());
        if (fecha.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }
        dateFormat.setLenient(true);
        return true;
    }

    public static String parseDateToString(Date fecha, String formato) throws Exception {
        try {
            DateFormat formatoVistaFecha = new SimpleDateFormat(formato, new Locale("es", "cl"));
            return formatoVistaFecha.format(fecha);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public static Date parseStringDateToDate(String fecha, String formato) throws Exception {
        try {
            DateFormat formatoVistaFecha = new SimpleDateFormat(formato);
            if (fecha != null && !fecha.isEmpty()) {
                return formatoVistaFecha.parse(fecha);
            }
            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public Date FechaYHoraActual() {
        Date today = Calendar.getInstance().getTime();
        return today;
    }
}
