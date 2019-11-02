package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javafx.scene.text.TextFlow;

public class LectorArchivos {

	static String pdf = "application/pdf";
	static String txt = "text/plain";
	static String docx = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
	static List palabraList = new List();
    static List urlList = new List();
    static List List = new List();
    static int lineasTotales;

	@SuppressWarnings("unlikely-arg-type")
	public static void typeArchive(File url, String type, BinaryTree bt) throws IOException {
		if (type.equals(pdf)) {
			forPDF(url, bt);
		}else if (type.equals(docx)) {
			forDOCX(url, bt);
		}else {
			forTXT(url, bt);
		}
	}
	
	public static void forPDF(File url, BinaryTree bt) {
        PDDocument document = null;
        try {
            document = PDDocument.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!document.isEncrypted()) {
            PDFTextStripper stripper = null;
            try {
                stripper = new PDFTextStripper();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String text = null;
            try {
                text = stripper.getText(document);
                String[] palabras = text.split(" ");
                for (int i = 0; i < palabras.length; i++) {
                    System.out.println(palabras[i]);
                	bt.agregarArbol(palabras[i], url);
                    
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void forTXT(File url, BinaryTree bt) throws IOException {
		BufferedReader leerArchivo = new BufferedReader(new FileReader(url));
        String lineaLeida;
        while ((lineaLeida = leerArchivo.readLine()) != null) {
            lineasTotales = lineasTotales + 1;
            String[] palabras = lineaLeida.split(" ");
            for (int i = 0; i < palabras.length; i++) {
            	bt.agregarArbol(palabras[i], url);
            }
        }
    }
	
	public static void forDOCX(File url, BinaryTree bt) throws IOException {
		FileInputStream fis = new FileInputStream(url);
		InputStream entradaArch = fis; 
		XWPFDocument ardocx = new XWPFDocument(entradaArch);
		@SuppressWarnings("resource")
		XWPFWordExtractor xwpf_we = new XWPFWordExtractor(ardocx); 
		String texto = xwpf_we.getText();
		String[] palabra = texto.split(" ");
        for (int i = 0; i < palabra.length; i++) {
    		System.out.println(palabra[i]); 

        }
		
	}
	



	
	
	
}
