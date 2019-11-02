package application;

import java.io.File;

public class List<T> {
    
	private NodoList<T> first;
    int len = 0;

    public NodoList<T> getFirst() {
        return first;
    }
    public void delteList() {

        this.first = null;
    }
    
    public  void addLast(T t) {
        if (this.first == null) {
            this.first = new NodoList<>(t);
            len += 1;
        } else {
            NodoList Actual = this.first;
            while (Actual.next != null) {
                Actual = Actual.next;
            }
            Actual.next = new NodoList(t);
            len += 1;
        }
    }

    public void imprimirLista() {
        NodoList Actual = this.first;
        System.out.print("[");
        while (Actual != null) {
            System.out.print(Actual.getDato() + ",");
            Actual = Actual.next;
        }
        System.out.print("]");
    }
}