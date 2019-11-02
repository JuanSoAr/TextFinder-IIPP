package application;

import java.io.File;

/**
 * La clase nodo arbol se utiliza para la cracion de los arboles,siendo los nodos listas enlazadas antes creadas que
 * contaran en su primera poscion la palabra y la siguentes una lista con todos los URL donde la palabra aparece
 */
public class NodoTree {
 
	public List lista;
    public NodoTree left;
    public NodoTree right;

    public NodoTree(List list) {
        this.lista = list;
    }

    public List getList() {
        return lista;
    }

    public void setLista(List list) {
        this.lista = list;
    }
    public void agregarUrl(List list, File url){
        list.addLast(url);
    }
}