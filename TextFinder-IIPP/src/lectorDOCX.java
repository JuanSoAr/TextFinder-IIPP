import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument; 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class lectorDOCX {
	
	public static void nose(File url) throws IOException {
		FileInputStream fis = new FileInputStream(url);
		InputStream entradaArch = fis; 
		
		System.out.println(url);
		
		XWPFDocument ardocx = new XWPFDocument(entradaArch);
		XWPFWordExtractor xwpf_we = new XWPFWordExtractor(ardocx); 
		
		String texto = xwpf_we.getText();
		//System.out.println(texto); 
	}

}
