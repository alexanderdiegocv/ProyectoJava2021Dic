package Class.Configuracion;

import Class.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String RUC;
    private String ciudad;
    private String telefono;
    private String nombre;
    private String dirección;
    private String gerente;

    public Empresa(String RUC, String ciudad, String telefono, String nombre, String dirección, String gerente) {
        this.RUC = RUC;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.nombre = nombre;
        this.dirección = dirección;
        this.gerente = gerente;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }
    
    public static List Call_Datos(){
        String sql="SELECT*FROM empresa";
        List<String> data = new ArrayList<String>();
        try
        {   
            Conexion cn= new Conexion();
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
            
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);

            if(rs.next())
            {
                data.add(rs.getString("RUC"));
                data.add(rs.getString("ciudad"));
                data.add(rs.getString("telefono"));
                data.add(rs.getString("nombre"));
                data.add(rs.getString("direccion"));
                data.add(rs.getString("gerente"));
            }
        }catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        
        return data;
    }
}
