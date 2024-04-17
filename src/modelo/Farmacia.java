
package modelo;

public class Farmacia {
    private int id;
    private String ubicacion;
    private String direccion;
    private String correo;
    private Float sueldo;

    public Farmacia(int id, String ubicacion, String direccion, String correo, Float sueldo) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.correo = correo;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
