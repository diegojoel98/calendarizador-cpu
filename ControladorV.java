/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.RoundRobyn;
import Controlador.SRTF;
import Modelo.Hilo;
import Modelo.ListaDoble;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Source;

public class Controlador extends javax.swing.JFrame {

    int NumProceso = 1;
    int TotalProcesos = 2;
    DefaultTableModel m;
    DefaultTableModel aux;
    Vector<Object> listaAlgoritmos;
    ListaDoble listaDoble = new ListaDoble();

    public Controlador() {
        initComponents();
        this.setLocationRelativeTo(null);
        listaAlgoritmos = new Vector<Object>();
        tabla();
        Algoritmos();
        tablaResultados();
        bloqueo_cajas_texto();
        bloqueo_botones();
        setLocationRelativeTo(this);
        txtCuantun.setVisible(false);
        lblCuantun.setVisible(false);
    }

    public void tabla() {
        String cabecera[] = {"Proceso", "Tiempo Rafa", "Tiempo de llegada", "Estado"};
        m = new DefaultTableModel(null, cabecera);
        tblProcesos.setModel(m);
    }

    public void bloqueo_cajas_texto() {
        txtRafaga.setEnabled(false);
        txtTiempo.setEnabled(false);
        jTextFieldNumProcesos.setEnabled(false);
    }

    public void bloqueo_botones() {
        btnPrepararProceso.setEnabled(false);
        btnAceptar.setEnabled(false);
        btnAceptar.setEnabled(false);
        jButtonAceptarNumProcesos.setEnabled(false);
    }

    public void limpiar_cajas_texto() {
        txtRafaga.setText(null);
        txtTiempo.setText(null);
        jTextFieldNumProcesos.setText(null);
    }

    public void tablaResultados() {
        String cabecera[] = {"Proceso", "Tiempo Espera", "Estado"};
        aux = new DefaultTableModel(null, cabecera);
        tblResultados.setModel(aux);
    }

    public void Algoritmos() {
        listaAlgoritmos.add("-----Seleccione-----");
        listaAlgoritmos.add("SRTF");
        listaAlgoritmos.add("Round Robyn");
        for (int i = 0; i < listaAlgoritmos.size(); i++) {
            cbnListaAlgoritmos.addItem(listaAlgoritmos.get(i));
        }
    }
    int CPU;
    int tiempo;
    int prioridad;
    int numeroProcesos = 0;

    public void eleccion() {
        Hilo h = new Hilo(jspGraficos, listaDoble);
        h.vuelta();
    }



    public void tiempoProcesos_RR(){
        double t = 0;
        double r=0;
        double tiempoespera = 0;
        String Datos[] = new String[3];
        for(int i=0;i<listaDoble.size();i++){
                Datos[0] = listaDoble.get(i).dato.getNombre();
                  if(i==0){
                  tiempoespera+=listaDoble.get(i).dato.getRafaga()+listaDoble.get(i).dato.getTiempo();
                  t=listaDoble.get(i).dato.getTiempo();
                  r+=t;
                  listaDoble.get(i).dato.setTiempoespera((int) t);
                  Datos[1] = String.valueOf(t);
                }else{
                    t=tiempoespera-listaDoble.get(i).dato.getTiempo();
                    r+=t; 
                    listaDoble.get(i).dato.setTiempoespera((int) tiempoespera);
                    tiempoespera+=listaDoble.get(i).dato.getRafaga();
                    Datos[1] = String.valueOf(t);    
                  }   
                  Datos[2] = String.valueOf("Procesado");
            aux.addRow(Datos);
        }
    }
    public void tiempoProcesos_SRTF() {
        String Datos[] = new String[3];
        for (int i = 0; i < listaDoble.size(); i++) {
            Datos[0] = listaDoble.get(i).dato.getNombre();
            Datos[1] = "" + listaDoble.get(i).dato.getTiempoespera();
            Datos[2] = String.valueOf("Procesado");
            aux.addRow(Datos);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProcesos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cbnListaAlgoritmos = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        jspGraficos = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblTPE = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblCuantun = new javax.swing.JLabel();
        txtCuantun = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JTextField();
        btnPrepararProceso = new javax.swing.JButton();
        txtRafaga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonAceptarNumProcesos = new javax.swing.JButton();
        jTextFieldNumProcesos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 27)); // NOI18N
        jLabel1.setText("Numero de procesos: ");

        tblProcesos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblProcesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProcesos);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        jLabel6.setText("Algoritmo de calendarizacion:");

        cbnListaAlgoritmos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cbnListaAlgoritmos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnListaAlgoritmosActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAceptar.setText("Aplicar Algoritmo");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jspGraficos.setWheelScrollingEnabled(false);

        tblResultados.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblResultados);

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("Reiniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel7.setText("Tiempo promedio de espera: ");

        lblTPE.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTPE.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText(" Proceso:");

        lblCuantun.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCuantun.setText("Quantum:");

        txtCuantun.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Tiempo Rafaga:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Tiempo Llegada:");

        txtTiempo.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoActionPerformed(evt);
            }
        });

        btnPrepararProceso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnPrepararProceso.setText("Listo");
        btnPrepararProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrepararProcesoActionPerformed(evt);
            }
        });

        txtRafaga.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setText("P1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCuantun)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRafaga, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCuantun, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrepararProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRafaga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuantun, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCuantun, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrepararProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jButtonAceptarNumProcesos.setText("Aceptar");
        jButtonAceptarNumProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarNumProcesosActionPerformed(evt);
            }
        });

        jTextFieldNumProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumProcesosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbnListaAlgoritmos, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jTextFieldNumProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonAceptarNumProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(135, 135, 135)))
                                        .addGap(24, 24, 24))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jspGraficos, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTPE, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbnListaAlgoritmos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldNumProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAceptarNumProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jspGraficos))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblTPE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code
         
       if (cbnListaAlgoritmos.getSelectedItem().equals("Round Robyn")) {
            RoundRobyn r = new RoundRobyn(listaDoble);
            r.FCSC();
            r.RR(Integer.parseInt(txtCuantun.getText()));
            jspGraficos.setViewportView(new Hilos(listaDoble.size(), listaDoble));

        } else if (cbnListaAlgoritmos.getSelectedItem().equals("SRTF")) {
            SRTF n = new SRTF(listaDoble);
            n.FCSC();
            ListaDoble p = new ListaDoble();
            p = n.TimepoTotal();
            jspGraficos.setViewportView(new Hilos(p.size(), p));
        }
         if (cbnListaAlgoritmos.getSelectedItem().equals("Round Robyn")) {
            tiempoProcesos_RR();
            bloqueo_botones();
            bloqueo_cajas_texto();
            RoundRobyn a = new RoundRobyn(listaDoble);
            a.unionE(lblTPE, numeroProcesos);
        } else if (cbnListaAlgoritmos.getSelectedItem().equals("SRTF")) {
            tiempoProcesos_SRTF();
            bloqueo_botones();
            bloqueo_cajas_texto();
            SRTF n = new SRTF(listaDoble);
            lblTPE.setText(String.valueOf(n.tiempoEspera()));
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cbnListaAlgoritmosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnListaAlgoritmosActionPerformed
        // TODO add your handling code here:
        jTextFieldNumProcesos.setEnabled(true);
        jButtonAceptarNumProcesos.setEnabled(true);
        

    }//GEN-LAST:event_cbnListaAlgoritmosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Controlador p = new Controlador();
        p.setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPrepararProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrepararProcesoActionPerformed
        // TODO add your handling code here:

        try {
            CPU = Integer.parseInt(txtRafaga.getText());
            tiempo = Integer.parseInt(txtTiempo.getText());
            if (CPU < 0) {
                throw new Exception(" El tiempo rafaga introducido no puede ser negativo");
            }
            if (tiempo < 0) {
                throw new Exception(" El tiempo de espera introducido no puede ser negativo");
            }
            if ((txtRafaga.getText().equals("")) || (txtTiempo.getText().equals(""))) {
                throw new Exception("Todos los campos son obligatorios");
            }
            if (cbnListaAlgoritmos.getSelectedItem().equals("Round Robyn")) {
                int cuantum = Integer.parseInt(txtCuantun.getText());
                if (txtCuantun.getText().equals("")) {
                    throw new Exception("Todos los campos son obligatorios");
                } else if (cuantum <= 0) {
                    throw new Exception(" EL cuantum introducido no puede ser menor o igual a cero");
                } else {
                    RoundR();
                    limpiar_cajas_texto();
                    numeroProcesos++;
                }
            }
            if (cbnListaAlgoritmos.getSelectedItem().equals("SRTF")) {
                SRTF();
                limpiar_cajas_texto();
            }
            jLabel5.setText("P" + (NumProceso + 1));
            NumProceso++;
        if (NumProceso > TotalProcesos) {
            bloqueo_cajas_texto();
            btnPrepararProceso.setEnabled(false);
            jLabel5.setText("P"+(NumProceso-1)); 
            btnAceptar.setEnabled(true);
        }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El programa solo admite valores numericos enteros");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_btnPrepararProcesoActionPerformed

    private void txtTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempoActionPerformed

    private void jTextFieldNumProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumProcesosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumProcesosActionPerformed

    private void jButtonAceptarNumProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarNumProcesosActionPerformed
        // TODO add your handling code here:
        
        try{
        
        TotalProcesos = Integer.parseInt(jTextFieldNumProcesos.getText());
        
         if (TotalProcesos < 1) {
                throw new Exception(" El numero de procesos introducido no puede ser menor que 1");
            }
        
        jTextFieldNumProcesos.setVisible(false);
       jButtonAceptarNumProcesos.setVisible(false);
         if(cbnListaAlgoritmos.getSelectedItem().equals("SRTF")){
         
            txtRafaga.setEnabled(true);
            txtTiempo.setEnabled(true);
            btnPrepararProceso.setEnabled(true);
            txtCuantun.setVisible(false);
            lblCuantun.setVisible(false);
            
        cbnListaAlgoritmos.setEnabled(false); 
        }else if(cbnListaAlgoritmos.getSelectedItem().equals("Round Robyn")){
        
            txtRafaga.setEnabled(true);
            txtTiempo.setEnabled(true);
            btnPrepararProceso.setEnabled(true);
            txtCuantun.setVisible(true);
            lblCuantun.setVisible(true);
            
            cbnListaAlgoritmos.setEnabled(false); 
        }
        
            
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El programa solo admite valores numericos enteros");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButtonAceptarNumProcesosActionPerformed


    void RoundR() {
        CPU = Integer.parseInt(txtRafaga.getText());
        tiempo = Integer.parseInt(txtTiempo.getText());
        String estado = "Preparado";
        String Datos[] = new String[4];
        Datos[0] = jLabel5.getText();
        Datos[1] = String.valueOf(CPU);
        Datos[2] = String.valueOf(tiempo);
        Datos[3] = String.valueOf(estado);
        m.addRow(Datos);
        Modelo.Controlador p = new Modelo.Controlador(jLabel5.getText(), CPU, tiempo, estado);
        listaDoble.insertarFinal(p);
        jspGraficos.setViewportView(new Dibujos(listaDoble.size(), listaDoble));

    }

    void SRTF() {

        CPU = Integer.parseInt(txtRafaga.getText());
        tiempo = Integer.parseInt(txtTiempo.getText());
        String estado = "Preparado";
        String Datos[] = new String[4];
        Datos[0] = jLabel5.getText();
        Datos[1] = String.valueOf(CPU);
        Datos[2] = String.valueOf(tiempo);
        Datos[3] = String.valueOf(estado);
        m.addRow(Datos);
        Modelo.Controlador p = new Modelo.Controlador(jLabel5.getText(), CPU, tiempo, estado);
        listaDoble.insertarFinal(p);
        jspGraficos.setViewportView(new Dibujos(listaDoble.size(), listaDoble));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Controlador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Controlador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Controlador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Controlador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controlador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnPrepararProceso;
    private javax.swing.JComboBox cbnListaAlgoritmos;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAceptarNumProcesos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldNumProcesos;
    public javax.swing.JScrollPane jspGraficos;
    private javax.swing.JLabel lblCuantun;
    private javax.swing.JLabel lblTPE;
    private javax.swing.JTable tblProcesos;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtCuantun;
    private javax.swing.JTextField txtRafaga;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables
}
