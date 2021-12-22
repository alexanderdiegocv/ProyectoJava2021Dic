
package Class.productos;

import Class.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    
    //Atributos para la conección a la base de Datos
    private final Conexion cn= new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    //Atributos de la clase Productos
    private int id_producto;
    private String nombre;
    private String descripcion;
    private String precio;
    private String unidades;
    private String cantidad;
    private int id_proveedor;

    public Producto(String nombre, String descripcion, String precio, String unidades, String cantidad, int id_proveedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;
        this.cantidad = cantidad;
        this.id_proveedor = id_proveedor;
    }
    
    public boolean RegistrarProducto(Producto producto){
       String sql = "INSERT INTO productos(nombre,descripcion,precio,unidades,cantidad,id_proveedor) VALUES (?,?,?,?,?,?)";
       try
       {
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.setString(1,producto.getNombre());
        ps.setString(2,producto.getDescripcion());
        ps.setString(3,producto.getPrecio());
        ps.setString(4,producto.getUnidades());
        ps.setString(5,producto.getCantidad());
        ps.setInt(6,producto.getId_proveedor());
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
    
    public static List ListarProductos(){
      List< Producto > ListaProd = new ArrayList();
      
      String sql = "SELECT*FROM productos";
      
       try {
           Conexion cn= new Conexion();
           Connection con;
           PreparedStatement ps;
           ResultSet rs;
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next())
           {
                Producto pr = new Producto(rs.getString("nombre"),rs.getString("descripcion"),rs.getString("precio"),rs.getString("unidades"),rs.getString("cantidad"),rs.getInt("id_proveedor"));
                pr.setId_producto(rs.getInt("id_producto"));
                ListaProd.add(pr);
                    
           }
       } catch (SQLException e) {
           System.out.println(e.toString()); 
       }
       
        for (Producto producto : ListaProd) {
            System.out.println(producto.getDescripcion());
        }
       
      return ListaProd;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    
}
