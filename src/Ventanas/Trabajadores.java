/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANGEL
 */
public class Trabajadores extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    Controles ct = new Controles();
    Controlador control = new Controlador();
    LoginAcceso acceso = new LoginAcceso();
    DefaultTableModel modelo = new DefaultTableModel();
    public static String user, pass1, pass2;

    public Trabajadores() {
        this.setUndecorated(true);
        initComponents();
        this.setTitle("Registro Empleados");
        this.setLocationRelativeTo(null);
        DatosUsuario();
        LlenarCombo();
        InicializarTabla();
        MostarEmpleados();
    }

    public void DatosUsuario() {
        lbnomEmp.setText("USUARIO: " + ct.empleado);
    }

    public void InicializarTabla() {
        modelo.setColumnIdentifiers(new String[]{"DNI", "NOMBRES", "APELLIDOS", "CARGO", "FACULTAD", "LOGIN"});
        tabla.setModel(modelo);
    }

    public void MostarEmpleados() {
        control.LlenarJtable(modelo, "Select * from vw_trabajadores v", 6);
    }

    public void LlenarCombo() {
        control.LlenarCombo(cbofacultad, "select * from facultades", 2);
        control.LlenarCombo(cbocargo, "Select * from cargos c", 2);
    }

    public void Crear() {
        pass1 = txtpsw1.getText();
        pass2 = txtpsw2.getText();

        if (comprueba(pass1, pass2)) {
            JOptionPane.showMessageDialog(null, control.DevolverRegistroDto("call proc_trabajadores ('" + txtdni.getText() 
                    + "','" + txtnom.getText() + "','" + txtapaterno.getText() + "','" + txtamaterno.getText() 
                    + "','" + cbocargo.getSelectedItem() + "','" + cbofacultad.getSelectedItem() 
                    + "','" + txtlogin.getText() + "',md5('" + txtpsw2.getText() + "'));", 1));
            MostarEmpleados();
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coenciden");
        }

    }

    public boolean comprueba(String psw1, String psw2) {
        boolean b = false;
        if (control.DevolverRegistroDto("select strcmp(md5('" + psw1 + "'),md5('" + psw2 + "'));", 1).equalsIgnoreCase("0")) {
            b = true;
        }
        return b;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbnomEmp = new javax.swing.JLabel();
        lbminimizar = new javax.swing.JLabel();
        lbcerrar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtapaterno = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtamaterno = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        cbofacultad = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtlogin = new javax.swing.JTextField();
        txtpsw2 = new javax.swing.JPasswordField();
        txtpsw1 = new javax.swing.JPasswordField();
        cbocargo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btregistrar = new javax.swing.JButton();
        bteditar = new javax.swing.JButton();
        bteliminar = new javax.swing.JButton();
        btcancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabelDNI16 = new javax.swing.JLabel();
        txBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO TRABAJADORES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 40));

        lbnomEmp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbnomEmp.setForeground(new java.awt.Color(255, 255, 255));
        lbnomEmp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbnomEmp.setText("NOMBRES: ANGEL PAGOLA");
        jPanel1.add(lbnomEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 350, 40));

        lbminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar1.png"))); // NOI18N
        lbminimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbminimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbminimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbminimizarMouseExited(evt);
            }
        });
        jPanel1.add(lbminimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 5, -1, -1));

        lbcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar1.png"))); // NOI18N
        lbcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbcerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbcerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbcerrarMouseExited(evt);
            }
        });
        jPanel1.add(lbcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 5, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)), "DATOS GENERALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("DNI:");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("A. PATERNO:");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 30));

        txtapaterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtapaterno.setForeground(new java.awt.Color(0, 0, 0));
        txtapaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(txtapaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 300, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("A. MATERNO:");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 30));

        txtamaterno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtamaterno.setForeground(new java.awt.Color(0, 0, 0));
        txtamaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel7.add(txtamaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 300, 30));

        txtdni.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtdni.setForeground(new java.awt.Color(0, 0, 0));
        txtdni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdniKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
        });
        jPanel7.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 300, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("NOMBRES:");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 30));

        txtnom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtnom.setForeground(new java.awt.Color(0, 0, 0));
        txtnom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnomMouseClicked(evt);
            }
        });
        jPanel7.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 300, 30));

        cbofacultad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbofacultad.setForeground(new java.awt.Color(0, 0, 0));
        cbofacultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel7.add(cbofacultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 300, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("FACULTAD:");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 30));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 500, 280));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 0)), "DATOS GENERALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("PASSWORD:");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("PASSWORD:");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("LOGIN:");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 30));

        txtlogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtlogin.setForeground(new java.awt.Color(0, 0, 0));
        txtlogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel8.add(txtlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 200, 30));

        txtpsw2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtpsw2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel8.add(txtpsw2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 200, 30));

        txtpsw1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtpsw1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel8.add(txtpsw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 200, 30));

        cbocargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbocargo.setForeground(new java.awt.Color(0, 0, 0));
        cbocargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(cbocargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 200, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("CARGO:");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 30));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 380, 250));

        btregistrar.setBackground(new java.awt.Color(255, 153, 0));
        btregistrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btregistrar.setForeground(new java.awt.Color(0, 0, 0));
        btregistrar.setText("Registrar");
        btregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btregistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 100, 50));

        bteditar.setBackground(new java.awt.Color(255, 153, 0));
        bteditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bteditar.setForeground(new java.awt.Color(0, 0, 0));
        bteditar.setText("Editar");
        jPanel2.add(bteditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 100, 50));

        bteliminar.setBackground(new java.awt.Color(255, 153, 0));
        bteliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bteliminar.setForeground(new java.awt.Color(0, 0, 0));
        bteliminar.setText("Eliminar");
        jPanel2.add(bteliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 100, 50));

        btcancelar.setBackground(new java.awt.Color(255, 153, 0));
        btcancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btcancelar.setForeground(new java.awt.Color(0, 0, 0));
        btcancelar.setText("Cancelar");
        jPanel2.add(btcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 100, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 540, 600));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "RESERVAS REGISTRADAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Leelawadee UI Semilight", 1, 12))); // NOI18N
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 13)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha Entrada", "Fecha Salida", "N° Habitacion", "Tipo Habitacion", "DNI/RUC", "Cliente", "Procedencia"
            }
        ));
        tabla.setGridColor(new java.awt.Color(0, 0, 0));
        tabla.setRowHeight(30);
        tabla.setSelectionBackground(new java.awt.Color(0, 122, 255));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 510, 400));

        jLabelDNI16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDNI16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDNI16.setText("Buscar");
        jPanel9.add(jLabelDNI16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 90, 30));

        txBuscar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        txBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txBuscar.setSelectionColor(new java.awt.Color(0, 122, 255));
        txBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txBuscarActionPerformed(evt);
            }
        });
        txBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txBuscarKeyTyped(evt);
            }
        });
        jPanel9.add(txBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 220, 30));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 540, 540));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 560, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

    }//GEN-LAST:event_tablaMouseClicked

    private void txBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscarKeyReleased

    }//GEN-LAST:event_txBuscarKeyReleased

    private void txBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txBuscarKeyTyped

    private void txBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txBuscarActionPerformed

    private void btregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btregistrarActionPerformed
        Crear();
    }//GEN-LAST:event_btregistrarActionPerformed

    private void txtnomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnomMouseClicked
        if (txtdni.getText().trim().length() != 0) {
            txtlogin.setText(txtdni.getText());
            txtpsw1.setText(txtdni.getText());
            txtpsw2.setText(txtdni.getText());
        }
    }//GEN-LAST:event_txtnomMouseClicked

    private void txtdniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyPressed

    }//GEN-LAST:event_txtdniKeyPressed

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped

    }//GEN-LAST:event_txtdniKeyTyped

    private void txtdniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyReleased
        if (txtdni.getText().trim().length() != 0) {
            txtlogin.setText(txtdni.getText());
            txtpsw1.setText(txtdni.getText());
            txtpsw2.setText(txtdni.getText());
        }
    }//GEN-LAST:event_txtdniKeyReleased

    private void lbminimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbminimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lbminimizarMouseClicked

    private void lbminimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbminimizarMouseEntered
        lbminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar2.png")));
    }//GEN-LAST:event_lbminimizarMouseEntered

    private void lbminimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbminimizarMouseExited
        lbminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/minimizar1.png")));
    }//GEN-LAST:event_lbminimizarMouseExited

    private void lbcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lbcerrarMouseClicked

    private void lbcerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcerrarMouseEntered
        lbcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar2.png")));
    }//GEN-LAST:event_lbcerrarMouseEntered

    private void lbcerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcerrarMouseExited
        lbcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recursos/cerrar1.png")));
    }//GEN-LAST:event_lbcerrarMouseExited

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Trabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trabajadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcancelar;
    private javax.swing.JButton bteditar;
    private javax.swing.JButton bteliminar;
    private javax.swing.JButton btregistrar;
    private javax.swing.JComboBox<String> cbocargo;
    private javax.swing.JComboBox<String> cbofacultad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDNI16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbcerrar;
    private javax.swing.JLabel lbminimizar;
    private javax.swing.JLabel lbnomEmp;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txBuscar;
    private javax.swing.JTextField txtamaterno;
    private javax.swing.JTextField txtapaterno;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JTextField txtnom;
    private javax.swing.JPasswordField txtpsw1;
    private javax.swing.JPasswordField txtpsw2;
    // End of variables declaration//GEN-END:variables
}
