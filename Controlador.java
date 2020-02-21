package Modelo;

public class Controlador{
       
    private String nombre;
    private int rafaga;
    private int tiempo;
    private String estado;
    private int tiempoespera;
    private int rafagaaux;
    private int tiemporetorno;
    private int tiemporespuesta;
    public Controlador() {
    }   

    public Controlador(String nombre, int rafaga, int tiempo, String estado) {
        this.nombre = nombre;
        this.rafaga = rafaga;
        this.tiempo = tiempo;
        this.estado = estado;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getRafagaaux() {
        return rafagaaux;
    }

    public int getTiemporespuesta() {
        return tiemporespuesta;
    }

    public void setTiemporespuesta(int tiemporespuesta) {
        this.tiemporespuesta = tiemporespuesta;
    }

    public int getTiemporetorno() {
        return tiemporetorno;
    }

    public void setTiemporetorno(int tiemporetorno) {
        this.tiemporetorno = tiemporetorno;
    }

    public void setRafagaaux(int rafagaaux) {
        this.rafagaaux = rafagaaux;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     public int getRafaga() {
        return rafaga;
    }

    public void setRafaga(int rafaga) {
        this.rafaga = rafaga;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return getNombre();
    }  

    public int getTiempoespera() {
        return tiempoespera;
    }

    public void setTiempoespera(int tiempoespera) {
        this.tiempoespera = tiempoespera;
    }
    
}
