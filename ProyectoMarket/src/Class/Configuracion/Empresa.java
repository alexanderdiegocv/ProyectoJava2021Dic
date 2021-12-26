package Class.Configuracion;

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
    
    //public static
}
