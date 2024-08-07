
package Modelo;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalTime;
import com.google.gson.annotations.Expose;

public class Empleado {    
    @Expose
    private String dni;
    @Expose
    private String nombre;
    @Expose
    private String apellidos;
    @Expose
    private String correo;
    @Expose
    private String telefono;
    @Expose
    private BigDecimal sueldo;
    @Expose
    private Integer idFarm;
    private LocalTime horarioE;
    private LocalTime horarioS;
    
    
    //Constructor vacio
    public Empleado(){
    }

    public Empleado(String dni) {
        this.dni = dni;
    }

    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public Integer getIdFarm() {
        return idFarm;
    }

    public void setIdFarm(Integer idFarm) {
        this.idFarm = idFarm;
    }

    public LocalTime getHorarioE() {
        return horarioE;
    }

    public void setHorarioE(LocalTime horarioE) {
        this.horarioE = horarioE;
    }

    public LocalTime getHorarioS() {
        return horarioS;
    }

    public void setHorarioS(LocalTime horarioS) {
        this.horarioS = horarioS;
    }

    @Override
    public String toString() {
        return "Empleado{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", telefono=" + telefono + ", sueldo=" + sueldo + ", idFarm=" + idFarm + ", horarioE=" + horarioE + ", horarioS=" + horarioS + '}';
    }

    
}