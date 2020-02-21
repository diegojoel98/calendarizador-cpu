package Modelo;

import Vista.Dibujos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;

public class Hilo extends Thread{
    JScrollPane graficos;
    ListaDoble listaDoble=new ListaDoble();
    
    public Hilo(JScrollPane graficos,ListaDoble listaDoble){
        this.graficos=graficos;
        this.listaDoble=listaDoble;
    }
    public void vuelta(){
        try {
            graficos.setViewportView(new Dibujos(listaDoble.size(), listaDoble));
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
 
