
package Modelo;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalTime;

public class Empleado {
    private String dni;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private BigDecimal sueldo;
    private int idFarm;
    private LocalTime horarioE;
    private LocalTime horarioS;
    
    
    //Constructor vacio
    public Empleado(){
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

    public int getIdFarm() {
        return idFarm;
    }

    public void setIdFarm(int idFarm) {
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

    

    
    
}