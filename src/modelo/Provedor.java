
package modelo;


public class Provedor {
    private String ruc;
    private String nombre;
    private String paisOrigen;
    private String telefono;
    private String correo;

    public Provedor(String ruc, String nombre, String paisOrigen, String telefono, String correo) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
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
   
    
}
