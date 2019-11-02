package application;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Url {
 
	
	static List urlLisu = new List();
   
	public static String obtenerNombres(File url){
        System.out.println(url.getName());
        return url.getName();
    }
	
	public static Integer peso(File url){
        url.length();
        System.out.println(url.length());
        return new Integer((int) url.length());
	}
    
    public static String FechaModificacion(File url) {
        long ms = url.lastModified();
        Date d = new Date(ms);
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString((c.get(Calendar.MONTH) + 1));
        String año = Integer.toString(c.get(Calendar.YEAR));
        System.out.println(año +"/"+ mes +"/"+ dia);
        return  (año +"/"+ mes +"/"+ dia);
    }
    
    public static void agregarUrl(File url){
        urlLisu.addLast(url);
        urlLisu.imprimirLista();
    }
    
}