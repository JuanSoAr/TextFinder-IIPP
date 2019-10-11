import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class lectorArchivo{

	    public static void contentTXT(File url) throws FileNotFoundException, IOException {
	        String cadena;
	        FileReader f = new FileReader(url);
	        BufferedReader b = new BufferedReader(f);
	        while((cadena = b.readLine())!=null) {
	            System.out.println(cadena);
	        }
	        b.close();
	    }

}
