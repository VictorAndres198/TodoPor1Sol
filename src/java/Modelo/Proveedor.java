/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andres
 */
public class Proveedor {
    private String RUC;
    private String Nombre;
    private String Pais;
    private String Telefono;
    private String Correo;
//CONSTRUCTOR

    public Proveedor() {
    }

    public Proveedor(String RUC, String Nombre, String Pais, String Telefono, String Correo) {
        this.RUC = RUC;
        this.Nombre = Nombre;
        this.Pais = Pais;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }

 
   //Metodos getters y setters

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

   

    
    
    
}
