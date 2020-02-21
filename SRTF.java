package Controlador;

import Modelo.ListaDoble;
import Modelo.Controlador;
import java.util.ArrayList;
import java.util.List;

public class SRTF {
     ListaDoble listaDoble=new ListaDoble();
     
     ListaDoble AuxlistaDoble=new ListaDoble();
     
    public double tiempoespera;
    public double tiemporetorno;
    public double tiemporespuesta;
      
     double WT = 0,TT = 0;
    public SRTF(ListaDoble listaDoble){
        this.listaDoble = listaDoble;
    }
    
        
    public void FCSC(){
        for(int i=1;i<listaDoble.size();i++){
            for(int j=0;j<listaDoble.size()-1;j++){
                if(listaDoble.get(i).dato.getTiempo()<listaDoble.get(j).dato.getTiempo()){
                   Controlador aux=listaDoble.get(j).getDato();
                   listaDoble.modificar(j, listaDoble.get(i).dato);
                   listaDoble.modificar(i, aux);
                }
            }
        }
    }
    
public ListaDoble TimepoTotal(){
    
    int n = listaDoble.size();
  //  System.out.println("\n tamaño: " + n);
    
    int proc[][] = new int[n + 1][4];
    int datos[][] = new int[100][3];
    int conDatos = 0;
    for(int i = 1; i <= n; i++)
       {
     proc[i][0] = listaDoble.get(i-1).dato.getTiempo();
     
      proc[i][1] = listaDoble.get(i-1).dato.getRafaga();
       }
   
      
     int total_time = 0;
     for(int i = 1; i <= n; i++)
     {
      total_time += proc[i][1];
     }
     int time_chart[] = new int[total_time];
     for(int i = 0; i < total_time; i++)
     {
      int sel_proc = 0;
      int min = 99999;
      for(int j = 1; j <= n; j++)
      {
       if(proc[j][0] <= i)
       {
        if(proc[j][1] < min && proc[j][1] != 0)
        {
         min = proc[j][1];
         sel_proc = j;
        }
       }
      }
      
        time_chart[i] = sel_proc;
        proc[sel_proc][1]--;
      for(int j = 1; j <= n; j++)
      {
       if(proc[j][0] <= i)
       {
        if(proc[j][1] != 0)
        {
         proc[j][3]++;
            if(j != sel_proc)
             proc[j][2]++;
        }
        else if(j == sel_proc)
         proc[j][3]++;
       }
      }
      
      
      if(i != 0)
      {
       if(sel_proc != time_chart[i - 1])
       {
        
         datos[conDatos][0] = sel_proc;
         datos[conDatos][1] = i;
         datos[conDatos][2] = 0;
         
         datos[conDatos-1][2] = i-datos[conDatos-1][1];
         conDatos++;
       }
      }
      else
      { 
         datos[conDatos][0] = sel_proc;
         datos[conDatos][1] = 0;
         datos[conDatos][2] = 1;
         conDatos++;
      }
      if(i == total_time - 1)
      { 
      int au = i+1;
      datos[conDatos-1][2] = i+1-datos[conDatos-1][1];
      }
     }
  
     for (int i = 0; i< conDatos; i++){      
        // System.out.println("Nombre: P"+datos[i][0]);
        // System.out.println("Tiempo espera: "+datos[i][1]);
        // System.out.println("Tiempo rafaga: "+datos[i][2]);
        // System.out.println("---------------------- ");        
        AuxlistaDoble.insertarFinal(new Controlador("P"+datos[i][0], datos[i][2], datos[i][1], "procesado"));
     }
     
     for(int i = 1; i <= n; i++)
     {
           listaDoble.get(i-1).dato.setTiempoespera(proc[i][2]); 
           listaDoble.get(i-1).dato.setTiemporespuesta(proc[i][3]); 
     }
     
     
     
     return AuxlistaDoble;
    }
    
    public double tiempoEspera(){ 
    int n = listaDoble.size();
    int proc[][] = new int[n + 1][4];
    int datos[][] = new int[100][3];
    int conDatos = 0;
    for(int i = 1; i <= n; i++)
       {
      proc[i][0] = listaDoble.get(i-1).dato.getTiempo();
    
      proc[i][1] = listaDoble.get(i-1).dato.getRafaga();
       }
   
        System.out.println();
     
     int total_time = 0;
     for(int i = 1; i <= n; i++)
     {
      total_time += proc[i][1];
     }
     int time_chart[] = new int[total_time];
  
     for(int i = 0; i < total_time; i++)
     {
      int sel_proc = 0;
      int min = 99999;
      for(int j = 1; j <= n; j++)
      {
       if(proc[j][0] <= i)
       {
        if(proc[j][1] < min && proc[j][1] != 0)
        {
         min = proc[j][1];
         sel_proc = j;
        }
       }
      }
      
     time_chart[i] = sel_proc;
      proc[sel_proc][1]--;
      for(int j = 1; j <= n; j++)
      {
       if(proc[j][0] <= i)
       {
        if(proc[j][1] != 0)
        {
         proc[j][3]++;
            if(j != sel_proc)
             proc[j][2]++;
        }
        else if(j == sel_proc)
         proc[j][3]++;
       }
      }
      
      if(i != 0)
      {
       if(sel_proc != time_chart[i - 1])
       {     
         datos[conDatos][0] = sel_proc;
         datos[conDatos][1] = i;
         datos[conDatos][2] = 0;
         
         datos[conDatos-1][2] = i-datos[conDatos-1][1];
         conDatos++;
       }
      }
      else{ 
         datos[conDatos][0] = sel_proc;
         datos[conDatos][1] = 0;
         datos[conDatos][2] = 1;
         conDatos++;
      }
      if(i == total_time - 1)//All the process names have been printed now we have to print the time at which execution ends
      { 
      int au = i+1;
      datos[conDatos-1][2] = i+1-datos[conDatos-1][1];
      }
     }
  
     for (int i = 0; i< conDatos; i++){
        // System.out.println("Nombre: P"+datos[i][0]);
        // System.out.println("Tiempo espera: "+datos[i][1]);
        // System.out.println("Tiempo rafaga: "+datos[i][2]);
        // System.out.println("---------------------- ");      
        AuxlistaDoble.insertarFinal(new Controlador("P"+datos[i][0], datos[i][2], datos[i][1], "procesado"));
     }
     System.out.println("P\t WT \t TT ");
     for(int i = 1; i <= n; i++)
     {
           listaDoble.get(i-1).dato.setTiempoespera(proc[i][2]); 
           listaDoble.get(i-1).dato.setTiemporespuesta(proc[i][3]); 
     }
     
     System.out.println();
     
        for(int i = 1; i <= n; i++)
     {
      WT += proc[i][2];
      TT += proc[i][3];
     }
     WT /= n;
     TT /= n;
     //WT = (int)((WT * 100)/100);
     return WT;
    }

    
    
 
    
    public static void main(String[] args) {
     ListaDoble l=new ListaDoble();
     Controlador p1=new Controlador("p1", 3,  4, null);
     Controlador p2=new Controlador("p2", 1,  4, null);
     Controlador p3=new Controlador("p3", 3,  4, null);
     Controlador p4=new Controlador("p4", 4,  4, null);
     Controlador p5=new Controlador("p5", 2,  4, null);
     l.insertarPrincipio(p1);
     l.insertarPrincipio(p2);
     l.insertarPrincipio(p3);
     l.insertarPrincipio(p4);
     l.insertarPrincipio(p5);
     SRTF f=new SRTF(l);
     f.FCSC();
    }
    
}
