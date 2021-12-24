
package Class.proveedores;

import Class.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Proveedor {
    
    private final Conexion cn= new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private int id_proveedor;
    private String dni;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    private String razon;  

    public Proveedor() {
    }

    public Proveedor(String dni, String nombre, String telefono, String direccion, String correo, String razon) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.razon = razon;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
    
    public String BuscarProveedor(int id_proveedor){

        String sql="SELECT*FROM proveedores WHERE id_proveedor LIKE '%"+id_proveedor+"%'";
        String nombre = "";
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
                nombre = rs.getString("nombre_proveedor");
            }
        }catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        return nombre;
    }
    
}

