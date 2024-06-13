
package Modelo;

import java.io.Serializable;

public class Proveedor implements Serializable{
    private String ruc;
    private String nombre;
    private String pais;
    private String telefono;
    private String correo;
    
//CONSTRUCTOR

    public Proveedor() {
    }

    public Proveedor(String ruc, String nombre, String pais, String telefono, String correo) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.pais = pais;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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
        return "Proveedor{" + "ruc=" + ruc + ", nombre=" + nombre + ", pais=" + pais + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
    



   

    
    
    
}
