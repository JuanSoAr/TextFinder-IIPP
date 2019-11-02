package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.TextFlow;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;



public class MainController implements Initializable{
	
	@FXML private TableView<Archivo> table;
	@FXML private TableColumn<Archivo, Integer> size;
	@FXML private TableColumn<Archivo, String> name;
	@FXML private TableColumn<Archivo, String > date;
	@FXML private TextField search;
	@FXML private ListView<File> searchResult;
	@FXML private ComboBox<String> comboBox;
	@FXML private TextFlow textFlow;
	static BinaryTree bt = BinaryTree.getInstance();
	
	private ObservableList<Archivo> listaArchivos =
		FXCollections.observableArrayList();
	 
	private ObservableList<File> listaBusqueda = 
		FXCollections.observableArrayList();

	private ObservableList<String> listaOrdenar = 
			FXCollections.observableArrayList("Nombre", "Tamaño", "Fecha");
	
	public void prueba (ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("DOCX", "*.docx")

        );
        File url = fileChooser.showOpenDialog(null);
        String tipodeArchivo = Files.probeContentType(url.toPath());
        LectorArchivos.typeArchive(url, tipodeArchivo, bt);
        Archivo archivo = new Archivo(Url.peso(url), Url.obtenerNombres(url),  Url.FechaModificacion(url), url);
        listaArchivos.add(archivo);
	}

	public void searchDocument(ActionEvent event) throws IOException {
		listaBusqueda.clear();
		String searchWord = search.getText();
		String[] datos = searchWord.split(" ");
		int n = datos.length;
		if (n == 1) {
			List list = bt.searchTree(searchWord).lista;
			NodoList nl = list.getFirst().next;
			while(nl != null) {
				listaBusqueda.add((File) nl.getDato());
				nl = nl.next;
			}
		}else {
			List list = bt.searchTree(datos[1]).lista;
			NodoList nl = list.getFirst().next;
			while(nl != null) {
				listaBusqueda.add((File) nl.getDato());
				nl = nl.next;
		}
		}
	}

	public void validateOrder(ActionEvent event) {
		System.out.println(comboBox.getValue());
	}
	
	public void openDocument(ActionEvent event) {
		int i = table.getSelectionModel().getSelectedIndex();
		File o = listaArchivos.get(i).getUrl();
		try {
			Desktop.getDesktop().open(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(ActionEvent event) {
		int i = table.getSelectionModel().getSelectedIndex();
		Archivo o = listaArchivos.get(i);
		listaArchivos.remove(o);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		  size.setCellValueFactory(new PropertyValueFactory<Archivo, Integer>("size"));
		  name.setCellValueFactory(new PropertyValueFactory<Archivo, String>("name"));
		  date.setCellValueFactory(new PropertyValueFactory<Archivo, String>("date"));
		  table.setItems(listaArchivos);
		  searchResult.setItems(listaBusqueda);
		  comboBox.setItems(listaOrdenar);
	}
	
	public void addFolder(ActionEvent event) throws IOException {
		DirectoryChooser dc = new DirectoryChooser();
		File folder = dc.showDialog(null);
		if(folder == null) {		
			System.out.println("No selecciono un folder para cargar");
		} else {
			String[] files = folder.list();	
			for(int i = 1; i < files.length; i++) {	
				String file = folder + "/"  + files[i];	
				File validation = new File(file);
				System.out.println(file);
				if(validation.isFile()) {
					String tipodeArchivo = Files.probeContentType(validation.toPath());
			        LectorArchivos.typeArchive(validation, tipodeArchivo, bt);
			        Archivo archivo = new Archivo(Url.peso(validation), Url.obtenerNombres(validation),
			        							  Url.FechaModificacion(validation), validation);
			        listaArchivos.add(archivo);
				}else {
					System.out.println("No es documento");
				}
			}
		}
	}
	
	public void writeText(ActionEvent event) {
		TableViewSelectionModel<Archivo> i = table.getSelectionModel();
		String searchWord = search.getText();
		NodoTree list = bt.searchTree(i.toString()); 
	}
}

