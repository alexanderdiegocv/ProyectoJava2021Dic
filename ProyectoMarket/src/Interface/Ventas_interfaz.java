/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Class.Conexion;
import Class.venta.funciones_venta;
import Class.venta.ventas;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Date;
import javax.swing.JOptionPane;
import static sun.management.Agent.error;

/**
 *
 * @author admi
 */
public class Ventas_interfaz extends javax.swing.JFrame {

    DefaultTableModel modelo;
    funciones_venta fv =new funciones_venta();
   
    Conexion con= new Conexion();
    
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    private Date fecha;
    public Ventas_interfaz() {
        initComponents();
         this.setLocationRelativeTo(null);
         ListarProveedores();
       

         
       
    }

    public void ListarProveedores(){
      
    List <ventas> Listarpv = fv.ListarVentas();
    
    modelo=(DefaultTableModel) tablaventa.getModel();
    
     Object[] ob= new Object[6];
     
    for(int i=0;i<Listarpv.size();i++)
    {
        ob[0]=Listarpv.get(i).getId_venta();
        ob[1]=Listarpv.get(i).getDni_cliente();
        ob[2]=Listarpv.get(i).getNombre_cliente();
        ob[3]=Listarpv.get(i).getMonto_total();
        ob[4]=Listarpv.get(i).getId_facturadetalle();  
        ob[5]=Listarpv.get(i).getFecha();
        modelo.addRow(ob);
    }
    tablaventa.setModel(modelo);  
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir_hover.png"))); // NOI18N
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 80, 50));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("VENTAS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 120, 30));

        txtfecha.setText("aaaa/mm/dd");
        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });
        getContentPane().add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 160, 30));

        tablaventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id venta", "dni cliente", "Nombre Cliente", "Monto total", "id factura", "Fecha"
            }
        ));
        tablaventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaventaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaventa);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 730, 220));

        jButton1.setText("Reporte de ventas general");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 730, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/portallogin7.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Sistema sis =new Sistema();
        sis.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed
SimpleDateFormat conver = new SimpleDateFormat("yyyy/MM/dd");
Date fecha1;
private String nuevoFormato;




    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
    Connection conn =con.getConnection();
        JasperReport reportes;
        reportes = null;
        String path = "src\\Reportes\\ventas.jasper ";
   
      
        try {
             Map parametro =new HashMap();
             
        String fecha = txtfecha.getText();
        String[] fechaDesestructurada = fecha.split("/");
        if(fechaDesestructurada[0].length() != 4){
            JOptionPane.showMessageDialog(null,"El año tiene que tener 4 dijitos");
            return;
        }else if(fechaDesestructurada[1].length() != 2){
            JOptionPane.showMessageDialog(null,"El mes tiene que tener 2 dijitos");
            return;
        }else if(fechaDesestructurada[2].length() != 2){
            JOptionPane.showMessageDialog(null,"El día tiene que tener 2 dijitos");
            return;
        }
        
        fecha1 = conver.parse(txtfecha.getText());
          parametro.put("fecha",fecha1);

            reportes = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path,parametro,conn);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException e) {
            System.out.println(e.toString());
        } catch (ParseException ex) {
            Logger.getLogger(Ventas_interfaz.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaventaMouseClicked
        int fila = tablaventa.rowAtPoint(evt.getPoint());
    
        if(fila==-1){
            JOptionPane.showMessageDialog(null,"Producto no seleccionado");
        }
        else{
            String fechaDesestructurada = tablaventa.getValueAt(fila, 5).toString();
            String[] fechaPartes = fechaDesestructurada.split("-");
            String fechaEstructurada = "";
            for (int i = 0; i < fechaPartes.length; i++) {
                if(i+1 == fechaPartes.length){
                    fechaEstructurada += fechaPartes[i];
                }else {
                    fechaEstructurada += fechaPartes[i] + "/";   
                }
            }
            txtfecha.setText(fechaEstructurada);
        }
    }//GEN-LAST:event_tablaventaMouseClicked

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

    
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
            java.util.logging.Logger.getLogger(Ventas_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas_interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaventa;
    private javax.swing.JTextField txtfecha;
    // End of variables declaration//GEN-END:variables
}
