
package Modelo;

public class ClientePersona {
    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    public ClientePersona(String dni, String nombres, String apellidos, String telefono, String correo) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "ClientePersona{" + "dni=" + dni + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
    
    
}
