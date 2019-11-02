package application;
import java.io.File;
import javafx.scene.control.Button;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;



public class Archivo {
	
	private SimpleIntegerProperty size;
	private SimpleStringProperty name;
	private SimpleStringProperty date;
	Archivo next;
	Archivo Prev;
	File url;
	
	public Archivo getNext() {
		return next;
	}
	
	public void setNext(Archivo next) {
		this.next = next;
	}
	
	public Archivo(int size, String name, String date, File url) {
		this.size = new SimpleIntegerProperty(size);
		this.name = new SimpleStringProperty(name);
		this.date = new SimpleStringProperty(date);
		this.url = url;
	}

	public Archivo(File url) {
		super();
		this.url = url;
	}

	public int getSize() {
		return size.get();
	}

	public String getName() {
		return name.get();
	}

	public File getUrl() {
		return url;
	}

	public void setUrl(File url) {
		this.url = url;
	}

	public void setDate(String date) {
		this.date = new SimpleStringProperty(date);
	}
	
	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}
	
	public String getDate() {
		return date.get();
	}

	public Archivo getPrev() {
		return Prev;
	}
	
	public void setPrev(Archivo prev) {
		Prev = prev;
	}

}
