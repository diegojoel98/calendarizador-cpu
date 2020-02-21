
package Modelo;

import javax.swing.JOptionPane;

public class ListaDoble {

    private Nodo cabecera;
    public ListaDoble() {
        cabecera = null;
    }

    public boolean esVacio() {
        return (this.cabecera == null);
    }

    public int size() {
        int tamano = 0;
        Nodo aux = cabecera;
        if (!esVacio()) {
            tamano++;

            while (aux.siguiente != null) {
                tamano++;
                aux = aux.siguiente;
            }
        }
        return tamano;
    }

    public void insertarCabecera(Controlador dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacio()) {
            cabecera = nuevo;
        }
    }
    public void inserta_inicio(Controlador dato){
      if(!esVacio()){
            Nodo nuevo=new Nodo(dato);
            if(cabecera.dato.getTiempo()>nuevo.dato.getTiempo()){
                nuevo.siguiente=cabecera;
                cabecera.anterior=nuevo;
                cabecera=nuevo;
            }else{
                cabecera.siguiente=nuevo;
                nuevo.anterior=cabecera;
            }
        }
        
    }
   
    public void insertarPrincipio(Controlador dato){
        Nodo nuevo = new Nodo(dato);
        if(esVacio()){
            insertarCabecera(dato);
        }else{
            insertarInicio(dato);
        }
    }
    public void insertar(int pos,Controlador dato){
        if(!esVacio()){
            Nodo aux=cabecera;
            Nodo nuevo=new Nodo(dato);
            if(aux.siguiente==null){
                inserta_inicio(dato);
            }else if(aux.siguiente.siguiente==null){
                aux.siguiente=nuevo;
                nuevo.siguiente=aux.siguiente;
                nuevo.anterior=aux;
                aux.siguiente.anterior=nuevo;
            }else{
                
            }
        }
    }
    public void insertarInicio(Controlador dato) {
        Nodo nuevo = new Nodo(dato);
        if (!esVacio()) {
            nuevo.siguiente = cabecera;
            cabecera.anterior = nuevo;
            cabecera = nuevo;
        }
    }

    public void insertarFinal(Controlador dato) {
        Nodo aux = cabecera;
        Nodo nuevo = new Nodo(dato);
        if (!esVacio()) {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
            nuevo.anterior = aux;
        } else {
            insertarCabecera(dato);
        }
    }

    public void insertarPorPosicion(Controlador dato, int posicion) {
        if (!esVacio()) {
            if (posicion == 1) {
                insertarInicio(dato);
            } else {
                if (posicion == size()) {
                    insertarFinal(dato);
                } else {
                    if (posicion > 0 && posicion < size()) {
                        Nodo nuevo = new Nodo(dato);
                        Nodo aux = cabecera;
                        int con = 0;
                        while (con != (posicion - 1)) {
                            aux = aux.siguiente;
                            con++;
                        }
                        Nodo a = aux.siguiente;
                        nuevo.siguiente = aux.siguiente;
                        aux.siguiente = nuevo;
                        nuevo.anterior = aux;
                        a.anterior = nuevo;
                    }
                }

            }

        } else {
            insertarCabecera(dato);
        }
    }

    public void modificar(int pos, Controlador datos) {
        Nodo auxiliar = cabecera;
        int recorrido = 0;
        if (!esVacio()) {
            if (pos == 0) {
                cabecera.dato = (Controlador) datos;
            } else {
                if (pos == size()) {
                    get(pos).dato = (Controlador) datos;
                } else {
                    if (pos > 0 & pos < size()) {
                        Nodo nuevo = new Nodo(datos);
                        while (recorrido != (pos - 1)) {
                            auxiliar = auxiliar.siguiente;
                            recorrido++;
                        }
                        nuevo.siguiente = auxiliar.siguiente;
                        auxiliar.siguiente.dato = nuevo.dato;
                    } else {
                        JOptionPane.showMessageDialog(null, "EL ELEMENTO ES MAYOR AL TAMAÑO DE LA LISTA");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "LA LISTA ESTA VACIA");
        }

    }

    public Nodo get(int posicion) {
        Nodo aux = cabecera;
        int contador = 0;
        while (contador != posicion) {
            aux = aux.siguiente;
            contador++;
        }
        return aux;
    }

    public void eliminarLista() {
        if (!esVacio()) {
            cabecera.siguiente = null;
            cabecera = null;            
        } else {            
        }
    }

    public void eliminarInicio() {
        Nodo aux = cabecera;
        if (cabecera.siguiente != null) {
            cabecera = aux.siguiente;
            cabecera.anterior = null;
            aux.siguiente = null;
        } else {
            cabecera = null;
        }
    }

    public void eliminarFinal() {
        Nodo auxiliar = cabecera;
        Nodo eliminar = auxiliar.siguiente;
        if (!esVacio()) {
            if (cabecera.siguiente != null) {
                while (auxiliar.siguiente.siguiente != null) {
                    auxiliar = auxiliar.siguiente;
                    eliminar = eliminar.siguiente;
                }
            }
            auxiliar.siguiente = null;
            eliminar.anterior = null;
        }
    }

    public void eliminarEntreNodos(int pos) {
        Nodo auxiliar = cabecera;
        int recorrido = 0;
        if (!esVacio()) {
            if (pos == 0) {
                eliminarInicio();
            } else {
                if (pos == size() - 1) {
                    eliminarFinal();
                } else {
                    if (pos > 0 & pos < size()) {
                        Nodo eliminar = auxiliar.siguiente;
                        while (recorrido != (pos - 1)) {
                            auxiliar = auxiliar.siguiente;
                            eliminar = eliminar.siguiente;
                            recorrido++;
                        }
                        auxiliar.siguiente = eliminar.siguiente;
                        eliminar.siguiente.anterior = auxiliar;
                        eliminar.siguiente = null;
                        eliminar.anterior = null;

                    } else {
                        JOptionPane.showMessageDialog(null, "NO EXISTE LA POSICION");

                    }
                }
            }
        }

    }

    public String imprimir() {
        String informacion = "";
        Nodo actual = cabecera;
        System.out.println("DATOS INGRESADOS: ");
        while (actual != null) {
            informacion += actual.dato.toString() + "\n";
            actual = actual.siguiente;
        }
        return informacion;
    }
    
}
