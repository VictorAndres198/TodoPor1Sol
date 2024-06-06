package Modelo;

public class Usuario {
    private String dniEmpleado;
    private String nombre;
    private String clave;

    public Usuario(){
    }
    
    public Usuario(String dniEmpleado, String nombre, String clave) {
        this.dniEmpleado = dniEmpleado;
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
