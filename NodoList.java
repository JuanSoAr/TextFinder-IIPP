package application;

import java.io.File;

public class NodoList<T> {
	
    private T value;
    public NodoList<T> next;
    public File url;
    
    public NodoList(){
        next = null;
    }

    public NodoList(T p){
        next = null;
        value = p;
    }
   
    public T getDato() {
        return value;
    }
    
    public void setDato(T dato) {
        this.value = dato;
    }
    
    public void setUrl(File url) {
        this.url = url;
    }
    
    public File getUrl() {
        return url;
    }
}