
package Class.venta;

public class ventas {
   
  private int id_venta;
    private String dni_cliente;
    private String nombre_cliente;
    private double monto_total;
    private int id_facturadetalle;
    public ventas() {
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(String dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }

    public int getId_facturadetalle() {
        return id_facturadetalle;
    }

    public void setId_facturadetalle(int id_facturadetalle) {
        this.id_facturadetalle = id_facturadetalle;
    }

    
  
}
