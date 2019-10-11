import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExplorer {

    public static void fileExplorer(Stage display2) throws FileNotFoundException, IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("DOCX", "*.docx")

        );
        File url = fileChooser.showOpenDialog(display2);
        callMethood(url);
    }
    
    public static void callMethood(File url) throws FileNotFoundException, IOException {
		lectorArchivo.contentTXT(url);
    }
    
    
}