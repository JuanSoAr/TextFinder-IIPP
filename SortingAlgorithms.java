package application;

public class SortingAlgorithms {
    /**
     * Listas o sublitas que van a ser utilizadas para el ordenamiento de las listas
     */
    private List cero = new List();
    private List one = new List();
    private List two = new List();
    private List three = new List();
    private List four = new List();
    private List five = new List();
    private List six = new List();
    private List seven = new List();
    private List eight = new List();
    private List nine = new List();
    private List arrayList = new List();
    private List left = new List();
    private List right = new List();

    /**
     * Ordenamiento rapido para los nombres de los archivos, tener cuidado prioritisa las mayusaculas antes que las minusculas
     * @param list la lista a ordenar
     * @param current primera poscion de la lista
     * @return la lista enlazada ordenada por nombres
     */
    public List quickSorted(List list,NodoList current) {
        NodoList Compare = list.getFirst();
        while (!Ordenado(list)) { //Funcion que revisa si la lista ya esta ordenada
            while (Compare != null) {
                if (Compare.getDato() == current.getDato()) {//Si el dato es el mismo
                    Compare = Compare.next;
                }
                if (((current.getDato()).toString()).compareTo((Compare.getDato()).toString()) < 1) {//Compara si la pañabraactual esta antes que la siguiente palabra
                    right.addLast(Compare.getDato());
                    Compare = Compare.next;
                } else {
                    left.addLast(Compare.getDato());
                    Compare = Compare.next;
                }
            }
            nuevaLista(list, right, left, current);//Crea la lista nueva despues de separa la lista enlazada
            current = current.next;
            left.delteList();
            right.delteList();
            quickSorted(list,current);
        }
        list.imprimirLista();
        return list;
    }

    /**
     * Crea una nueva lisat despues de partir la anteriorpara seguir ordenando
     * @param list lista anterios
     * @param right datos mayores que el nodo analizado
     * @param left datos menores que el nodo analizado
     * @param current pimer dato de la lista
     * @return
     */
    private List nuevaLista(List list, List right, List left, NodoList current) {
        list.delteList();
        NodoList currentLeft = left.getFirst();
        NodoList currentRight = right.getFirst();
        while (currentLeft != null) {
            list.addLast(currentLeft.getDato());
            currentLeft = currentLeft.next;
        }
        list.addLast(current.getDato());
        while (currentRight != null) {
            list.addLast(currentRight.getDato());
            currentRight = currentRight.next;
        }
        return list;
    }

    /**
     * Revisa si la lista ya esta ordenada
     * @param list una lista
     * @return un bolleano
     */
    private boolean Ordenado(List list) {
        NodoList current = list.getFirst();
        while (current.next != null) {
            if (((current.getDato()).toString()).compareTo((current.next.getDato()).toString()) < 1) {
                current = current.next;
            } else return false;
        }
        return true;
    }

    /**
     * Ordenamiento de burbujar
     * @param list una lista con las fechas
     * @return lista con ordenamiento de fechas
     */
    public List bubleSort(List list) {//Se le envia una lista
        if (list.getFirst() == null) {//Rebisa que el primero no sea null
            return null;
        } else {
            NodoList current = list.getFirst();//Guarda el primer nodo de la lisya
            int cont = 0;//Inicializa un contador
            while (cont != list.len + 1) {//Condicion de parada
                while (current.next != null) {//Se mueve sobre la lista
                    if (((current.getDato()).toString()).compareTo((current.next.getDato()).toString()) >= 0) {//Compara las palabras
                        String tem = current.getDato().toString();//Guarda la palabra actual
                        current.setDato(current.next.getDato().toString());//Cambia el valor del dato actual
                        current.next.setDato(tem);//Cambia el valor del siguiete dato
                    }
                    current = current.next;
                }
                current = list.getFirst();
                cont += 1;
            }
            list.imprimirLista();
            return list;
        }
    }

    /**
     * Limpia las lista que se utilizan en el radixSort
     */
    private void clearList() {
        cero.delteList();
        one.delteList();
        two.delteList();
        three.delteList();
        four.delteList();
        five.delteList();
        six.delteList();
        seven.delteList();
        eight.delteList();
        nine.delteList();
    }

    /**
     * Crea un array con todas las litas presentes
     */
    private void createArrayList() {
        arrayList.addLast(cero);
        arrayList.addLast(one);
        arrayList.addLast(two);
        arrayList.addLast(three);
        arrayList.addLast(four);
        arrayList.addLast(five);
        arrayList.addLast(six);
        arrayList.addLast(seven);
        arrayList.addLast(eight);
        arrayList.addLast(nine);
    }

    /**
     * Obtiene el numero de digitos mayor de los numeros
     * @param list una lista
     * @return El numero de digitos de numero mayor
     */
    private int moreDigits(List list) {
        int lenNum = 0;
        NodoList current = list.getFirst();
        while (current != null) {
            if (lenNum < ((current.getDato()).toString().length())) {
                lenNum = (current.getDato()).toString().length();
            }
            current = current.next;
        }
        return lenNum;
    }

    /**
     * Algoritmo raidixSorted
     * @param list una lista con espacio en memoria
     * @return la lista ordenada
     */
    public List radixSorted(List list) {
        createArrayList();
        NodoList current = list.getFirst();
        int ciclos = moreDigits(list);
        int pos = 0;
        while (ciclos + 1 != pos) {
            while (current != null) {
                //(int) current.getDato() / ((int) Math.pow(10, pos))) % (10) obtiene el digito segun corresponda
                //su ciclo, ejemplo cilco 0 obtiene unidades,1 decenas ....
                if (new Integer((int) current.getDato() / ((int) Math.pow(10, pos))) % (10) == 0) {
                    cero.addLast(current.getDato());
                }
                if (new Integer((int) current.getDato() / ((int) Math.pow(10, pos))) % (10) == 1) {
                    one.addLast(current.getDato());
                }
                if (new Integer((int) current.getDato() / ((int) Math.pow(10, pos))) % (10) == 2) {
                    two.addLast(current.getDato());
                }
                if (new Integer((int) current.getDato() / ((int) Math.pow(10, pos))) % (10) == 3) {
                    three.addLast(current.getDato());
                }
                if (new Integer((int) current.getDato() / ((int) Math.pow(10, pos))) % (10) == 4) {
                    four.addLast(current.getDato());
                }
                if (new Integer((int) current.getDato() / ((int) Math.pow(10, pos))) % (10) == 5) {
                    five.addLast(current.getDato());
                }
                if (new Integer((int) current.getDato() / ((int) Math.pow(10, pos))) % (10) == 6) {
                    six.addLast(current.getDato());
                }
                if (new Integer((int) current.getDato() / ((int) Math.pow(10, pos))) % (10) == 7) {
                    seven.addLast(current.getDato());
                }
                if (new Integer((int) current.getDato() / ((int) Math.pow(10, pos))) % (10) == 8) {
                    eight.addLast(current.getDato());
                }
                if (new Integer((int) current.getDato() / ((int) Math.pow(10, pos))) % (10) == 9) {
                    nine.addLast(current.getDato());
                }
                current = current.next;
            }
            newList(list, arrayList);//Se crea una nueva lista con la separacion de los datos segun su valor en el ciclo
            current = list.getFirst();
            pos += 1;
        }
        return list;
    }

    /**
     * crea una nueva lista ordenada segun su ciclo
     * @param list una lista
     * @param arrayList el arreglo con las lista de 0 a 9 las cuales crean la nueva lista
     * @return
     */
    private List newList(List list, List arrayList) {
        list.delteList();
        NodoList currentlList = arrayList.getFirst();
        List listAux = (List) currentlList.getDato();
        NodoList nodoInList = listAux.getFirst();
        while (currentlList != null) {
            while (nodoInList != null) {
                list.addLast(nodoInList.getDato());
                nodoInList = nodoInList.next;
            }
            currentlList = currentlList.next;
            if (currentlList != null) {
                listAux = (List) currentlList.getDato();
                nodoInList = listAux.getFirst();
            }
        }
        clearList();
        return list;
    }
}


