package application;

import java.io.File;


public class BinaryTree {
    NodoTree root;
    private static BinaryTree single_instance = null;

    private BinaryTree(){
        this.root = null;
    }

    public static BinaryTree getInstance()
    {
        if (single_instance == null)
            single_instance = new BinaryTree();
        return single_instance;
    }


    public void insert(List list) {
        NodoTree nuevo = new NodoTree(list);
        if (root == null) {
            root = nuevo;
        } else {
            NodoTree aux = root;
            NodoTree padre;
            while (true) {
                padre = aux;
                if (list.getFirst().getDato().toString().compareTo(aux.lista.getFirst().getDato().toString()) < 1) {
                    aux = aux.left;
                    if (aux == null) {
                        padre.left = nuevo;
                        return;
                    }
                } else {
                    aux = aux.right;
                    if (aux == null) {
                        padre.right = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public NodoTree searchTree(String valor) {
        NodoTree aux = root;
        while (!aux.lista.getFirst().getDato().toString().equals(valor)) {
            if (valor.compareTo(aux.lista.getFirst().getDato().toString()) < 1) {
                aux = aux.left;
            } else {
                aux = aux.right;
            }
            if (aux == null) {
                
                return null;
            }
        }
        System.out.println("Encontrado");  
        return aux;
    }

    public void agregarArbol(String palabra, File url) {
        if(root != null){
            if(searchTree(palabra) != null){
                NodoTree nodoTree = searchTree(palabra);
                NodoList actual = nodoTree.lista.getFirst();
                while (actual != null){
                    if(actual.getDato().toString().equals(url.toString())){
                        break;
                    }
                    if(actual.next == null){
                        nodoTree.lista.addLast(url);
                        nodoTree.lista.imprimirLista();
                    }
                    actual = actual.next;
                }
            }
            else{
                List nodoList = new List();
                nodoList.addLast(palabra);
                nodoList.addLast(url);
                insert(nodoList);
            }

        }else {
            List nodoList = new List();
            nodoList.addLast(palabra);
            nodoList.addLast(url);
            insert(nodoList);
        }

    }
   
    public void buscarFrase(String frase){
        List listUrl1;
        List listUrl2;
        String palabra = frase;
        String[] palabras = palabra.split(" ");
        listUrl1 = searchTree(palabras[0]).lista;
        List listUrl =new List();
        for (int i = 0; i < palabras.length; i++){
            listUrl2 = searchTree(palabras[i]).lista;
            NodoList nodoList1 = listUrl1.getFirst();
            while (nodoList1 != null){
                NodoList nodoList2 = listUrl2.getFirst();
                while (nodoList2 !=null){
                    if(nodoList1.getDato().equals(nodoList2.getDato())){
                        listUrl.addLast(nodoList1);
                    }
                    nodoList2 = nodoList2.next;
                }
                nodoList1 = nodoList1.next;
            }
        }
    }


}