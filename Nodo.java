package Modelo;

public class Nodo {
    public Controlador dato; 
    public Nodo siguiente;
    public Nodo anterior;
    
    public Nodo(Controlador dato) {
        this.dato = dato;
        this.siguiente=null;
        this.anterior=null;
    } 

    public Controlador getDato() {
        return dato;
    }

    public void setDato(Controlador dato) {
        this.dato = dato;
    }
    
    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior; 
    }  
}
