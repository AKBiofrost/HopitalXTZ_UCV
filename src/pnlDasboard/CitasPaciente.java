/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pnlDasboard;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Cita;
import model.Data;
import model.Paciente;
import model.Sucursal;

/**
 *
 * @author Administrador
 */
public class CitasPaciente extends javax.swing.JFrame {
    Data dataXYZ = Data.getInstance();
    Sucursal sucursal;    
    Paciente paciente;
    
    public CitasPaciente(String cedula, String sucursalName) {
        initComponents();
        sucursal = dataXYZ.getSucursalByNombre(sucursalName);
        labelTitle.setText("Citas - " + cedula );
        labelSesion.setText("Sesión: " + sucursal.getNombre());
        
        if(sucursal.getPacientes().isEmpty()){
            showMessage("No Hay pacientes, dirijase \n al modulo de Registro de Pacientes.");
        }else{
            paciente = sucursal.getPacienteByCedula(cedula);
            showTable(paciente.getCitas());
        }
    }

    private CitasPaciente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void showMessage(String msg){
        tablePacientesPanel.setVisible(false);
        msgPacientesPanel.setVisible(true);
        msgPacientes.setText(msg);
    }
    
    private void showTable(ArrayList<Cita> lista){
        tablePacientesPanel.setVisible(true);
        msgPacientesPanel.setVisible(false);
        int cols = 3;
        int rows = lista.size();
        labelTitle.setText("Citas - " + paciente.getCedula() + "(" + rows + ")");

        String matriz[][] = new String[rows][cols];
        for(int i = 0; i < rows; i++){
            matriz[i][0] = lista.get(i).getId();
            matriz[i][1] = lista.get(i).getMedico();
            matriz[i][2] = lista.get(i).getFecha();
        }
        
        String[] cabecera = new String[]{"Id", "Medico", "Fecha"};
        DefaultTableModel model = new DefaultTableModel(matriz,cabecera);
        tablePacientes.setModel(model);
        
        int[] anchos = new int[]{100, 200, 200};
        for(int i=0; i<cols ;i++){
            tablePacientes.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
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

        rSButtonMetro2 = new rsbuttom.RSButtonMetro();
        jPanel1 = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        rSButtonMetro5 = new rsbuttom.RSButtonMetro();
        tablePacientesPanel = new javax.swing.JScrollPane();
        tablePacientes = new javax.swing.JTable();
        inputSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnFilter = new rsbuttom.RSButtonMetro();
        msgPacientesPanel = new javax.swing.JScrollPane();
        msgPacientes = new javax.swing.JTextArea();
        labelSesion = new javax.swing.JLabel();

        rSButtonMetro2.setBackground(new java.awt.Color(255, 80, 80));
        rSButtonMetro2.setText("<");
        rSButtonMetro2.setColorHover(new java.awt.Color(255, 90, 90));
        rSButtonMetro2.setColorTextNormal(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(26, 207, 172));
        jPanel1.setPreferredSize(new java.awt.Dimension(857, 513));

        labelTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitle.setText("Citas - [Paciente]");

        rSButtonMetro5.setBackground(new java.awt.Color(255, 80, 80));
        rSButtonMetro5.setText("<");
        rSButtonMetro5.setColorHover(new java.awt.Color(255, 90, 90));
        rSButtonMetro5.setColorNormal(new java.awt.Color(255, 80, 80));
        rSButtonMetro5.setColorPressed(new java.awt.Color(255, 90, 90));
        rSButtonMetro5.setColorTextNormal(new java.awt.Color(255, 255, 255));
        rSButtonMetro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro5ActionPerformed(evt);
            }
        });

        tablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Médicos", "Pacientes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePacientes.setEnabled(false);
        tablePacientes.setRowHeight(30);
        tablePacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablePacientesMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePacientesMouseClicked(evt);
            }
        });
        tablePacientesPanel.setViewportView(tablePacientes);

        inputSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSearchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Busqueda:");

        btnFilter.setText("Filtrar");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        msgPacientesPanel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        msgPacientesPanel.setHorizontalScrollBar(null);

        msgPacientes.setEditable(false);
        msgPacientes.setBackground(new java.awt.Color(26, 207, 172));
        msgPacientes.setColumns(20);
        msgPacientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        msgPacientes.setRows(2);
        msgPacientes.setTabSize(10);
        msgPacientesPanel.setViewportView(msgPacientes);

        labelSesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelSesion.setForeground(new java.awt.Color(255, 255, 255));
        labelSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelSesion.setText("sesión: [nombre Sucursal]");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(msgPacientesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rSButtonMetro5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(tablePacientesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 87, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelSesion)
                .addGap(5, 5, 5)
                .addComponent(labelTitle)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msgPacientesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSButtonMetro5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tablePacientesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        String search = inputSearch.getText();
        if("".equals(search)){
            showTable(paciente.getCitas());
            return;
        }
        
        ArrayList<Cita> found = paciente.getCitasSearch(search);        
        if(found.isEmpty()){
            showMessage("No Se encontraron citas con lo buscando. \n" 
                    + "Su búsqueda: " + search);
        }else showTable(found);
        inputSearch.setText("");        
    }//GEN-LAST:event_btnFilterActionPerformed

    private void inputSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSearchActionPerformed

    private void rSButtonMetro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro5ActionPerformed
        CitasPacientes wSecS = new CitasPacientes(sucursal.getNombre());
        this.dispose();
        wSecS.setVisible(true);
    }//GEN-LAST:event_rSButtonMetro5ActionPerformed

    private void tablePacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePacientesMouseClicked
        
    }//GEN-LAST:event_tablePacientesMouseClicked

    private void tablePacientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePacientesMousePressed
     
    }//GEN-LAST:event_tablePacientesMousePressed

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
            java.util.logging.Logger.getLogger(CitasPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CitasPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CitasPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CitasPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CitasPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro btnFilter;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelSesion;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTextArea msgPacientes;
    private javax.swing.JScrollPane msgPacientesPanel;
    private rsbuttom.RSButtonMetro rSButtonMetro2;
    private rsbuttom.RSButtonMetro rSButtonMetro5;
    private javax.swing.JTable tablePacientes;
    private javax.swing.JScrollPane tablePacientesPanel;
    // End of variables declaration//GEN-END:variables
}
