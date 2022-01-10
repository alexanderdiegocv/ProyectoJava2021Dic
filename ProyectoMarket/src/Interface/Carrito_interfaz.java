/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Class.productos.Producto;
import Class.productos.funciones_productos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static Interface.NuevaVenta_interfaz.txtprecio;
import static Interface.NuevaVenta_interfaz.txtnombre;
import static Interface.NuevaVenta_interfaz.txtidproducto;
import static Interface.NuevaVenta_interfaz.txtstock;
import java.awt.event.ActionEvent;
/**
 *
 * @author admi
 */
public class Carrito_interfaz extends javax.swing.JDialog {

    Producto pd = null;
    DefaultTableModel modelo;
    /**
     * Creates new form Carrito_interfaz
     */
 
    public Carrito_interfaz(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        mostrar("");
    }

  
    void mostrar(String buscar){
        try {
            DefaultTableModel modelo;
           funciones_productos func = new funciones_productos ();
            modelo = func.mostrar(buscar);
            
            Tablalistado.setModel(modelo);
            
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tablalistado = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id producto", "nombre", "precio", "stock"
            }
        ));
        jScrollPane1.setViewportView(Tablalistado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 650, 200));

        jButton1.setText("PRODUCTO SELECCIONADO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 370, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/portallogin7.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int f =Tablalistado.getSelectedRow();
      
       try{
           String codigo,descripcion,stock,precio,cant,importe,nombre;
           double calcula=0.0,x=0.0,igv=0.0;
           String id;
           int canti=0;
           
           if(f== -1)
           {
               JOptionPane.showMessageDialog(null,"Selecciona en la tabla");
           }else
           {
               modelo = (DefaultTableModel) Tablalistado.getModel();
               
              
               codigo=Tablalistado.getValueAt(f,0).toString();
               nombre=Tablalistado.getValueAt(f,1).toString();
               precio=Tablalistado.getValueAt(f,2).toString();
                stock=Tablalistado.getValueAt(f,3).toString();
             txtidproducto.setText(codigo);
             txtnombre.setText(nombre); 
             txtprecio.setText(precio);
             txtstock.setText(stock);
             
               
              
             
               
             
               /*calcula= (Double.parseDouble(precio))*Integer.parseInt(cantprod.getText());*/
               
              /*total =total+ calcula;
              igv=total* 0.19;
              
              igv1=igv;
              subtotal =total-igv;
              
              txttotal.setText("" +total);
              
              txtsubtotal.setText(""+subtotal);
              
              txtigv.setText(""+igv1);*/
              
              
               this.dispose();
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Verificar seleccionar el producto");
       }
       
      
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Carrito_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrito_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrito_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrito_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Carrito_interfaz dialog = new Carrito_interfaz(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tablalistado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
