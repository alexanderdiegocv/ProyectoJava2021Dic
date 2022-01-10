package Interface;

import Class.Conexion;
import Class.productos.Producto;    
import Class.proveedores.Proveedor;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Producto_interfaz extends javax.swing.JFrame {

    Producto pd = null;
    DefaultTableModel modelo;
    
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
    public Producto_interfaz() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        Inhabilitar();
        
        String sql = "SELECT*FROM proveedores";
         
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();

            //DefaultComboBoxModel lista = new DefaultComboBoxModel();
            //jComboBoxProveedores.setModel(lista);
            
            while(rs.next()){
                    jComboBoxProveedores.addItem(
                        new Proveedor(
                                rs.getInt("id_proveedor"),
                                rs.getString("nombre_proveedor")
                        ).getNombre()
                    );
                    /*lista.addElement(
                        new Proveedor(
                            rs.getInt("id_proveedor"),
                            rs.getString("nombre_proveedor")
                        )
                    );*/
            }
        } catch (SQLException e) {
           System.out.println(e.toString()); 
        }
        
        //Proveedor res = (Proveedor) jComboBoxProveedores.getSelectedItem();
        //int id = res.getId_proveedor();
        //System.out.println("ID de Proveedor: "+id);
        
        mostrarProductos();
    }
    
    private void Inhabilitar() {
        
        txtnombre.setEnabled(false);
        txtdescripcion.setEnabled(false);
        txtprecio.setEnabled(false);
        txtunidades.setEnabled(false);
        txtstock.setEnabled(false);
       
        txtID.setText("");
        txtnombre.setText("");
        txtdescripcion.setText("");
        txtprecio.setText("");
        txtunidades.setText("");
        txtstock.setText("");
    }
    
    private void Habilitar(){
        
        txtnombre.setEnabled(true);
        txtdescripcion.setEnabled(true);
        txtprecio.setEnabled(true);
        txtunidades.setEnabled(true);
        txtstock.setEnabled(true);
    
    }
    
    private void LimpiarTabla(){
        
        for(int i=0;i<tablaproductos.getRowCount();i++)
        {
            modelo.removeRow(i);
            i=i-1;
        }
    }
    
    private void LimpiarJFields(){
    
        txtID.setText("");
        txtnombre.setText("");
        txtdescripcion.setText("");
        txtprecio.setText("");
        txtunidades.setText("");
        txtstock.setText("");
    }
    
    public void mostrarProductos(){
      
        List <Producto> ListaProductos = pd.ListarProductos();

        modelo=(DefaultTableModel) tablaproductos.getModel();

        Object[] ob= new Object[7];

        for(int i=0;i<ListaProductos.size();i++)
        {
            ob[0]=ListaProductos.get(i).getId_producto();
            ob[1]=ListaProductos.get(i).getNombre();
            ob[2]=ListaProductos.get(i).getDescripcion();
            ob[3]=ListaProductos.get(i).getPrecio();
            ob[4]=ListaProductos.get(i).getUnidades();  
            ob[5]=ListaProductos.get(i).getStock();
            ob[6]=ListaProductos.get(i).getNombre_proveedor(ListaProductos.get(i).getId_proveedor());
            modelo.addRow(ob);
        }
        tablaproductos.setModel(modelo);  
    }
    
    private void Modificar(){
  
    String sql="UPDATE productos SET nombre='"+txtnombre.getText()+ "',descripcion='"+txtdescripcion.getText()+"',precio='"+txtprecio.getText()+"',unidades='"+txtunidades.getText()+"',stock='"+txtstock.getText()+"',id_proveedor='"+Proveedor.BuscarProveedorNombre((String) jComboBoxProveedores.getSelectedItem())+"'  WHERE id_producto ='"+txtID.getText()+"'";

     try
        {
            if(!"".equals(txtID.getText())||!"".equals(txtnombre.getText())||!"".equals(txtdescripcion.getText())||!"".equals(txtprecio.getText())|| !"".equals(txtunidades.getText())||!"".equals(txtstock.getText())|| !"Proveedor".equals((String) jComboBoxProveedores.getSelectedItem()))
            {
                con=cn.getConnection();
                st=con.createStatement();
                st.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null,"Producto actualizado");
                LimpiarTabla();
                mostrarProductos();
            }
            else{
                JOptionPane.showMessageDialog(null,"Completa los espacios");
            }
        }catch(HeadlessException | SQLException e)
        {
            System.out.println(e.toString());
            
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

        jLabel2 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        jComboBoxProveedores = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtunidades = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtstock = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaproductos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        txtID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRODUCTOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 140, -1));
        getContentPane().add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 230, -1));
        getContentPane().add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 110, -1));

        jComboBoxProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProveedoresActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 130, 20));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMBRE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, -1));

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 230, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DESCRIPCIÓN");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PRECIO");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 90, -1));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("UNIDADES");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 90, -1));

        txtunidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunidadesActionPerformed(evt);
            }
        });
        getContentPane().add(txtunidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("STOCK");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 90, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PROVEEDOR");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, -1));
        getContentPane().add(txtstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 130, -1));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("BUSCAR");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 70, -1));

        tablaproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripcion", "Precio", "Unidades", "Stock", "Proveedor"
            }
        ));
        tablaproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaproductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaproductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 730, 190));

        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jButton1.setText("NUEVO");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 130, 40));

        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Actualizar (2).png"))); // NOI18N
        jButton2.setText("ACTUALIZAR");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 130, 40));

        jButton3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        jButton3.setText("ELIMINAR");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 130, 40));

        jButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GuardarTodo.png"))); // NOI18N
        jButton4.setText("REGISTRAR");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 130, 40));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir_hover.png"))); // NOI18N
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, 80, 50));

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
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 660, -1));
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 14, 70, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/portallogin5.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtunidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtunidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunidadesActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void jComboBoxProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProveedoresActionPerformed

    private void tablaproductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaproductosMouseClicked
        int fila = tablaproductos.rowAtPoint(evt.getPoint());
        Habilitar();
    
        if(fila==-1){
            JOptionPane.showMessageDialog(null,"Producto no seleccionado");
        }
        else{
           
            txtID.setText(tablaproductos.getValueAt(fila, 0).toString());
            txtnombre.setText(tablaproductos.getValueAt(fila, 1).toString());
            txtdescripcion.setText(tablaproductos.getValueAt(fila, 2).toString());
            txtprecio.setText(tablaproductos.getValueAt(fila, 3).toString());
            txtunidades.setText(tablaproductos.getValueAt(fila, 4).toString());
            txtstock.setText(tablaproductos.getValueAt(fila, 5).toString());
            jComboBoxProveedores.setSelectedItem(tablaproductos.getValueAt(fila, 6).toString());
        }
    }//GEN-LAST:event_tablaproductosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Habilitar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!txtID.getText().equals("")){
            Modificar();
            LimpiarTabla();
            mostrarProductos();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Inserta una fila");
        }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //if(!"".equals(txtnombre.getText())||!"".equals(txtdescripcion.getText())||!"".equals(txtprecio.getText())|| !"".equals(txtunidades.getText())||!"".equals(txtstock.getText())){
            //JOptionPane.showMessageDialog(null,"Seleccione en la tabla");
        //}else{
            if(!"".equals(txtID.getText())){
                int pregunta=JOptionPane.showConfirmDialog(null,"Estas seguro que quieres eliminar");
                if(pregunta==0){
                          int id = Integer.parseInt(txtID.getText());
                          Producto.EliminarProducto(id);
                          LimpiarTabla();
                          mostrarProductos();
                          LimpiarJFields();
                }
            }
        //}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!"".equals(txtnombre.getText())||!"".equals(txtdescripcion.getText())||!"".equals(txtprecio.getText())|| !"".equals(txtunidades.getText())||!"".equals(txtstock.getText())|| !"Proveedor".equals(jComboBoxProveedores.getSelectedItem()))
      {
           Producto pd = new Producto(txtnombre.getText(),txtdescripcion.getText(),txtprecio.getText(), txtunidades.getText(), txtstock.getText(), Proveedor.BuscarProveedorNombre((String) jComboBoxProveedores.getSelectedItem()));
           //pd.setId_producto(Integer.parseInt(txtID.getText()));
           pd.RegistrarProducto(pd);
           
           
           JOptionPane.showMessageDialog(null,"Producto Registrado");
      }
      else
      {
          JOptionPane.showMessageDialog(null,"Rellena todos los campos");
      }
          LimpiarTabla();
          mostrarProductos();
          LimpiarJFields();
 

    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        String[]titulos ={"Id", "Nombre", "Descripción", "Precio", "Unidades", "Stock", "Proveedor"};   
        String[]registros=new String[10];

        String sql="SELECT*FROM productos WHERE nombre LIKE '%"+txtbuscar.getText()+"%'";

        modelo=new DefaultTableModel(null,titulos);
        try
        {
           con=cn.getConnection();
           st=con.createStatement();
           rs=st.executeQuery(sql);

            while(rs.next())
            {

                registros[0]=rs.getString("id_producto");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("descripcion");
                registros[3]=rs.getString("precio");
                registros[4]=rs.getString("unidades");
                registros[5]=rs.getString("stock");
                registros[6]=rs.getString("id_proveedor");
               modelo.addRow(registros);

            }
            tablaproductos.setModel(modelo);
        }catch(SQLException e)
        {
            System.out.println(e.toString());
        }
       
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Sistema sis =new Sistema();
        sis.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        
    }//GEN-LAST:event_txtbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Producto_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producto_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producto_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producto_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Producto_interfaz().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Producto_interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBoxProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaproductos;
    private javax.swing.JLabel txtID;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txtunidades;
    // End of variables declaration//GEN-END:variables
}
