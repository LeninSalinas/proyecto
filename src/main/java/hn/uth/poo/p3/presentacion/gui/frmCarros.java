/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.presentacion.gui;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class frmCarros extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCarros
     */
    
    public frmCarros() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSeccionCarros = new javax.swing.JLabel();
        lblColorVehiculo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        lblNumeroMotor = new javax.swing.JLabel();
        lblVIN = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtNumeroMotor = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtVIN = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaDatos = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSeccionCarros.setText("Seccion de Carros");
        getContentPane().add(lblSeccionCarros, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        lblColorVehiculo.setText("Color de su vehiculo:");
        getContentPane().add(lblColorVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, -1, -1));

        jLabel1.setText("Marca:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 84, -1, -1));

        lblModelo.setText("Modelo");
        getContentPane().add(lblModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 112, -1, -1));

        lblAnio.setText("Año");
        getContentPane().add(lblAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        lblNumeroMotor.setText("Numero del Motor");
        getContentPane().add(lblNumeroMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 166, -1, -1));

        lblVIN.setText("VIN:");
        getContentPane().add(lblVIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 192, -1, -1));

        lblPlaca.setText("Placa");
        getContentPane().add(lblPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 223, -1, -1));

        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 137, 136, -1));

        txtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioActionPerformed(evt);
            }
        });
        getContentPane().add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 163, 136, -1));

        txtNumeroMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroMotorActionPerformed(evt);
            }
        });
        getContentPane().add(txtNumeroMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 189, 136, -1));

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 78, 136, -1));

        txtVIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVINActionPerformed(evt);
            }
        });
        getContentPane().add(txtVIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 220, 136, -1));

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });
        getContentPane().add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 109, 136, -1));

        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });
        getContentPane().add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 52, 136, -1));

        txtaDatos.setColumns(20);
        txtaDatos.setRows(5);
        jScrollPane1.setViewportView(txtaDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 100, 233, 141));

        jLabel2.setText("Describa el problema del auto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 78, -1, -1));

        jButton1.setBackground(new java.awt.Color(102, 204, 255));
        jButton1.setText("Enviar Datos");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 100, -1));

        jLabel3.setText("Fecha de Inicio:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 272, -1, -1));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 266, 123, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed

    private void txtNumeroMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroMotorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroMotorActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtVINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVINActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblColorVehiculo;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNumeroMotor;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblSeccionCarros;
    private javax.swing.JLabel lblVIN;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumeroMotor;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtVIN;
    private javax.swing.JTextArea txtaDatos;
    // End of variables declaration//GEN-END:variables
}
