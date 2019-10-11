import java.io.File;
import java.time.LocalDate;

import javafx.scene.control.Button;

public class Archive {
	
	Button buttin;
	int size;
	String name;
	File url;
	LocalDate date;
	BinaryTree infoTree;
	Archive next;
	Archive Prev;
	
	public Archive getNext() {
		return next;
	}
	public void setNext(Archive next) {
		this.next = next;
	}
	public Archive getPrev() {
		return Prev;
	}
	public void setPrev(Archive prev) {
		Prev = prev;
	}
	
	
	
	
	
}

