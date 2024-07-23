
package Modelo;

public class ClientePersona extends Cliente{
    private String nombres;
    private String apellidos;

    public ClientePersona(String dni,String nombres, String apellidos, String telefono, String correo) {
        super(dni, telefono, correo);
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public ClientePersona(String id) {
        super(id);
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    @Override
    public String toString() {
        return "ClientePersona{" + "dni=" + getId() + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + getTelefono() + ", correo=" + getCorreo() + '}';
    }
    
    
    
}
