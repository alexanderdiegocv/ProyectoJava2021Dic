/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admi
 */
public class login {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
      public usuario iniciarsesion(String usuario,String contraseña)
    {
        usuario user=new usuario();
        
        String sql= "SELECT * FROM usuarios WHERE usuario =? and contraseña = ?";
        try
        {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            rs=ps.executeQuery();
            if(rs.next())
            {
           
            user.setUsuario(rs.getString("usuario"));
            user.setContraseña(rs.getString("contraseña"));
         
            }    
        }catch(SQLException e)
                {
                    System.out.println(e.toString());       
                }
        return user;
    }
}
