package Interface;

import Class.Conexion;
import javax.swing.JOptionPane;
import Class.proveedores.funciones_proveedor;
import Class.proveedores.Proveedor;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Proveedor_interfaz extends javax.swing.JFrame {

    funciones_proveedor fp = new funciones_proveedor();
    DefaultTableModel modelo;
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    public Proveedor_interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        inhabilitar();
        ListarProveedores();
    }

    void inhabilitar(){
        txtid_proveedor.setEnabled(false);
        txtdni.setEnabled(false);
        txtnombre.setEnabled(false);
        txttelefono.setEnabled(false);
        txtcorreo.setEnabled(false);
        txtdireccion.setEnabled(false);
        txtrazon.setEnabled(false);
       
        txtid_proveedor.setText("");
        txtdni.setText("");
        txtnombre.setText("");
        txttelefono.setText("");
        txtcorreo.setText("");
        txtdireccion.setText("");
        txtrazon.setText("");
        
    }
    
void habilitar()
{
    txtdni.setEnabled(true);
    txtnombre.setEnabled(true);
    txttelefono.setEnabled(true);
    txtdireccion.setEnabled(true);
    txtcorreo.setEnabled(true);
    txtrazon.setEnabled(true);
}

void limpiar()
{
 for(int i=0;i<tablaproveedor.getRowCount();i++)
 {
     modelo.removeRow(i);
     i=i-1;
 }

}

  public void ListarProveedores(){
      
    List <Proveedor> Listarpv = fp.ListarProveedores();
    
    modelo=(DefaultTableModel) tablaproveedor.getModel();
    
     Object[] ob= new Object[6];
     
    for(int i=0;i<Listarpv.size();i++)
    {
        ob[0]=Listarpv.get(i).getDni();
        ob[1]=Listarpv.get(i).getNombre();
        ob[2]=Listarpv.get(i).getTelefono();
        ob[3]=Listarpv.get(i).getCorreo();
        ob[4]=Listarpv.get(i).getDireccion();  
        ob[5]=Listarpv.get(i).getRazon();
        modelo.addRow(ob);
    }
    tablaproveedor.setModel(modelo);  
    
}
  
  void modificar()
{
  
    String sql="UPDATE proveedores SET dni_proveedor='"+txtdni.getText()+ "',nombre_proveedor='"+txtnombre.getText()+"',telefono='"+txttelefono.getText()+"',direccion='"+txtdireccion.getText()+"',correo='"+txtcorreo.getText()+"',razon='"+txtrazon.getText()+"'  where dni_proveedor ='"+txtdni.getText()+"'";

   
     try
        {
            if(!"".equals(txtdni.getText())||!"".equals(txtnombre.getText())||!"".equals(txttelefono.getText())||!"".equals(txtdireccion.getText())|| !"".equals(txtcorreo.getText())||!"".equals(txtrazon.getText()))
            {
                con=cn.getConnection();
                st=con.createStatement();
                st.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null,"Usuario actualizado");
                limpiar();
                ListarProveedores();
            }
            else{
                JOptionPane.showMessageDialog(null,"Completa los espacios");
            }
        }catch(HeadlessException | SQLException e)
        {
            System.out.println(e.toString());
            
        }
}
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaproveedor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        txtid_proveedor = new javax.swing.JTextField();
        txtrazon = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(840, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PROVEEDORES");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DNI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 40, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DIRECCION");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 100, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NOMBRE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TELEFONO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 80, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("RAZON SOCIAL");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 120, -1));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("BUSCAR");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 90, -1));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CORREO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 90, -1));

        tablaproveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dni", "Nombre", "Telefono", "Correo", "Direccion", "Razon"
            }
        ));
        tablaproveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaproveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaproveedor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 730, 140));

        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jButton1.setText("NUEVO");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 130, 40));

        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Actualizar (2).png"))); // NOI18N
        jButton2.setText("ACTUALIZAR");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 130, 40));

        jButton3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        jButton3.setText("ELIMINAR");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 130, 40));

        jButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GuardarTodo.png"))); // NOI18N
        jButton4.setText("REGISTRAR");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 130, 40));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir_hover.png"))); // NOI18N
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, 80, 50));

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 670, -1));

        txtid_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid_proveedorActionPerformed(evt);
            }
        });
        jPanel1.add(txtid_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 30, -1));
        jPanel1.add(txtrazon, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 120, -1));
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 120, -1));

        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 110, -1));

        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });
        jPanel1.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 100, -1));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 100, -1));
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 110, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/portallogin7.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(900, 500));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtid_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_proveedorActionPerformed

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       habilitar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
          if(!"".equals(txtdni.getText()) && !"".equals(txtnombre)&& !"".equals(txttelefono.getText()) && !"".equals(txtdireccion.getText()) && !"".equals(txtcorreo.getText()) && !"".equals(txtrazon.getText()))
      {
           Proveedor pb =new Proveedor(txtdni.getText(),txtnombre.getText(),txttelefono.getText(),txtdireccion.getText(), txtcorreo.getText(), txtrazon.getText());
           fp.RegistrarProveedor(pb);
           
           JOptionPane.showMessageDialog(null,"Empleado Registrado");
      }
      else
      {
          JOptionPane.showMessageDialog(null,"Rellena todos los campos ");
      }
          limpiar();
          ListarProveedores();
          LimpiarProveedor();
          
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if("".equals(txtdni.getText()) &&"".equals(txtnombre.getText()) &&"".equals(txttelefono.getText())||"".equals(txtdireccion.getText())|| "".equals(txtcorreo.getText())||"".equals(txtrazon.getText()))
{
    JOptionPane.showMessageDialog(null,"Seleccione en la tabla");
}
else
{
 if(!"".equals(txtdni.getText()))
{
int pregunta=JOptionPane.showConfirmDialog(null,"Estas seguro que quieres eliminar");
if(pregunta==0)
        {
           int id1=Integer.parseInt(txtdni.getText());
           fp.EliminarCliente(id1);
           limpiar();
           ListarProveedores();
           LimpiarProveedor();
        }
}
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablaproveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaproveedorMouseClicked
       int fila = tablaproveedor.rowAtPoint(evt.getPoint());
    habilitar();
    
    if(fila==-1)
        {
            JOptionPane.showMessageDialog(null,"Usuario no seleccionado");
        }
        else{
           
            txtdni.setText(tablaproveedor.getValueAt(fila, 0).toString());
            txtnombre.setText(tablaproveedor.getValueAt(fila, 1).toString());
            txttelefono.setText(tablaproveedor.getValueAt(fila, 2).toString());
            txtcorreo.setText(tablaproveedor.getValueAt(fila, 3).toString());
            txtdireccion.setText(tablaproveedor.getValueAt(fila, 4).toString());
            txtrazon.setText(tablaproveedor.getValueAt(fila, 5).toString());
 
        }
    }//GEN-LAST:event_tablaproveedorMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

          if(!txtdni.getText().equals(""))
        {
            modificar();
            limpiar();
            ListarProveedores();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Inserta una fila");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
      
String[]titulos ={"Dni","Nombre","Telefono","Correo","Direccion","Razon"};   
String[]registros=new String[50];

String sql="SELECT*FROM proveedores WHERE dni_proveedor LIKE '%"+txtbuscar.getText()+"%'";

modelo=new DefaultTableModel(null,titulos);
try
{
   con=cn.getConnection();
   st=con.createStatement();
   rs=st.executeQuery(sql);
   
    while(rs.next())
    {
        
        registros[0]=rs.getString("dni_proveedor");
        registros[1]=rs.getString("nombre_proveedor");
        registros[2]=rs.getString("telefono");
        registros[3]=rs.getString("correo");
        registros[4]=rs.getString("direccion");
        registros[5]=rs.getString("razon");
       modelo.addRow(registros);
   
    }
    tablaproveedor.setModel(modelo);
}catch(SQLException e)
{
    System.out.println(e.toString());
}
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      Sistema sis =new Sistema();
      sis.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Proveedor_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedor_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedor_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedor_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedor_interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaproveedor;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtid_proveedor;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtrazon;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
private void LimpiarProveedor()
{
    
    txtdni.setText("");
    txtnombre.setText("");
    txttelefono.setText("");
    txtdireccion.setText("");
    txtcorreo.setText("");
    txtrazon.setText("");
}
}
