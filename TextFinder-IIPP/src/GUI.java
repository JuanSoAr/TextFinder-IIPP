import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
	
public class GUI extends Application {

	private FileExplorer fe;
	
	public static void main (String [] args ) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		/**
		 * Objects for menu
		 */
		Button button1 = new Button("Text Finder");
		Button button2 = new Button("Instrucciones");

		VBox panel1 = new VBox(20);
		panel1.setAlignment(Pos.CENTER );
		panel1.getChildren().addAll(button1, button2);	

		StackPane canvas1 = new StackPane();
		canvas1.getChildren().add(panel1);

		Scene display1 = new Scene(canvas1, 1600, 900);

		primaryStage.setScene(display1);
		
		primaryStage.setTitle("Circuit Designer By Carmen Araya");
		primaryStage.setResizable(false);
	
		/**
		 * Objects for Text finder
		 */
		
		Button bAdd = new Button("Agregar");
		Button bName = new Button("Ordenar Nombre");
		Button bDate = new Button("Ordenar Fecha");
		Button bSize = new Button("Ordenar Tamaño");
		
		VBox cButton = new VBox(15);
		//cButton.setAlignment(Pos.CENTER_LEFT);
		cButton.getChildren().addAll(bAdd, bName, bDate, bSize);
		
		Pane files = new Pane();
		files.setPrefSize(2000, 1200);
		
		ScrollPane sb = new ScrollPane(files);
		sb.setMinSize(1000, 800);
		sb.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		sb.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

		VBox VBoxFiles = new VBox(10);
		//VBoxFiles.setAlignment(Pos.CENTER_RIGHT);
		VBoxFiles.getChildren().addAll(sb);
		
		HBox panelMain = new HBox(200);
		panelMain.getChildren().addAll(cButton, sb);
		
		BorderPane canvas2 = new BorderPane();
		canvas2.getChildren().addAll(panelMain);
		
		Scene display2 = new Scene(canvas2, 1600, 900);		
		
		
		/**
		 * Events for bottoms
		 */
		button1.setOnAction(e -> primaryStage.setScene(display2));
		bAdd.setOnAction(e -> FileExplorer.fileExplorer(primaryStage));
		
		primaryStage.show();	
	}

}
