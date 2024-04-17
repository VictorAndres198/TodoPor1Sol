package modelo;

public class Empresa extends Cliente{
    String correo,telefono;

    public Empresa(String cod, String nombre,String correo,String telefono) {
        super(cod, nombre);
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
  
}
