/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class.venta;

import Class.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class funciones_venta {
    
      Connection con;
    Conexion cn =new Conexion();
    PreparedStatement ps;
    int r;
    
       public int RegistrarVenta(ventas v)
    {
        String sql="INSERT into ventas (dni_cliente,nombre_cliente,monto_total,id_facturadetalle) VALUES (?,?,?,?)";
    
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,v.getDni_cliente());
            ps.setString(2,v.getNombre_cliente());
            ps.setDouble(3,v.getMonto_total());
            ps.setInt(4,v.getId_facturadetalle());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally
        {
            try {
               con.close(); 
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        
            
        
        return r;
    }
         public int RegistrarDetalle(Detalleventa dv)
            
    {
        String sql="INSERT into factura_detalle (id_facturadetalle,nombre,cantidad,precio) VALUES (?,?,?,?)";
        try {
          con=cn.getConnection();
          ps=con.prepareStatement(sql); 
          ps.setInt(1,dv.getId_facturadetalle());
          ps.setString(2,dv.getProducto());
          ps.setInt(3,dv.getCantidad());
          ps.setDouble(4,dv.getPrecio());
          ps.execute();
        } catch (Exception e) {
            System.out.println(e.toString());
        }finally
        {
            try {
               con.close(); 
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return r;
        
    }
}
