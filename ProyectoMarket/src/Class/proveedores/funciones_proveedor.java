
package Class.proveedores;

import Class.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admi
 */
public class funciones_proveedor {
    
   Conexion cn= new Conexion();
   Connection con;
   PreparedStatement ps;
   ResultSet rs;
  
   public boolean RegistrarProveedor(proveedores pb)
   {
       String sql ="INSERT INTO proveedores(dni_proveedor,nombre_proveedor,telefono,direccion,correo,razon) VALUES (?,?,?,?,?,?)";
       try
       {
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.setString(1,pb.getDni());
        ps.setString(2,pb.getNombre());
        ps.setString(3,pb.getTelefono());
        ps.setString(4,pb.getDireccion());
        ps.setString(5,pb.getCorreo());
        ps.setString(6,pb.getRazon());
        ps.execute();
        
        return true;
       }catch(SQLException e)
       {
           System.out.println(e.toString()); 
           return false;
       }finally{
           try
           {
               con.close();
           }catch(SQLException e)
           {
               System.out.println(e.toString());
           }
       }
       
   }
   
   public List ListarProveedores()
   {
      List< proveedores > Listapv = new ArrayList();
      
      String sql="SELECT*FROM proveedores";
      
       try {
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next())
           {
                    proveedores cl= new proveedores();
                    cl.setId_proveedor(rs.getInt("id_proveedor"));
                    cl.setDni(rs.getString("dni_proveedor"));
                    cl.setNombre(rs.getString("nombre_proveedor"));
                    cl.setTelefono(rs.getString("telefono"));
                    cl.setDireccion(rs.getString("direccion"));
                    cl.setCorreo(rs.getString("correo"));
                    cl.setRazon(rs.getString("razon"));

                    Listapv.add(cl);
           }
       } catch (SQLException e) {
           System.out.println(e.toString()); 
       }
      return Listapv;
   }
   public boolean EliminarCliente(int id1)
    {
        String sql="DELETE FROM proveedores WHERE dni_proveedor=?";
        try
        {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id1);
            ps.execute();
            return true;
        }catch(SQLException e)
        {
            System.out.println(e.toString());
            return false;
        }finally{
            try
            {
            con.close();
            }catch(Exception ex)
            {
                System.out.println(ex.toString());
            }
        }
}
  
   
   
   
}
