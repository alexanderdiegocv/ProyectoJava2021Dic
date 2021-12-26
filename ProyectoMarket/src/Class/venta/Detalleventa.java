package Class.venta;

public class Detalleventa {
     private int id_facturadetalle;
    private String producto;
    private int cantidad;
    private double precio;
    

    public Detalleventa() {
    }

    public int getId_facturadetalle() {
        return id_facturadetalle;
    }

    public void setId_facturadetalle(int id_facturadetalle) {
        this.id_facturadetalle = id_facturadetalle;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    

 
}
