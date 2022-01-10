/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class.productos;

import Class.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admi
 */
public class funciones_productos {
    private Conexion mysql = new Conexion();
    private Connection con = mysql.getConnection();
    private String sSql = "";
    PreparedStatement ps;
    ResultSet rs;
    public Integer totalregistros;
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"id_producto","Nombre","Precio","Stock"};
        String [] registro = new String [7];
        
        totalregistros = 0;
        modelo = new DefaultTableModel (null, titulos);
        if (buscar.equals("")) {
            sSql = "SELECT * FROM productos";
            
        } else {
            sSql = "SELECT * FROM productos WHERE precio LIKE '%"+buscar+"%'";
            
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSql);
            
            while(rs.next()){
                registro [0] = rs.getString(1);
                registro [1] = rs.getString(2);
                registro [2] = rs.getString(4);
                registro [3] = rs.getString(6);
               
                
                
                totalregistros = totalregistros +1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
      
         public Producto BuscarPro(int cod){
              
        int id_producto =cod;
        Producto producto = new Producto(id_producto);
        String sql = "SELECT * FROM productos WHERE id_producto = ?";
        try {
            con =mysql.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id_producto);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setStock(rs.getString("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }   
        
        
        public boolean ActualizarStock(int cant, int cod ){
        String sql = "UPDATE productos SET stock = ? WHERE id_producto = ?";
        try {
            con = mysql.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,cant);
            ps.setInt(2,cod);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }


}
