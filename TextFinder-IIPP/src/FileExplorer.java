import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class FileExplorer {

    public static void fileExplorer(Stage display2){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        fileChooser.getExtensionFilters().addAll(
        		//Estos tres maes se encargan de filtrar el tipo de archivo que estamos buscando
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("DOCX", "*.docx")

        );
        //Este mae se encarga de guardar el archivo selecionado si no se seleciona nada el que en null
        File url = fileChooser.showOpenDialog(display2);
        System.out.print(url);
    }
}