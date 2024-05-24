package Modelo;

import java.sql.Date;
import java.sql.Time;

public class EmpleadoHorario {
    private String nombre;
    private String apellidos;
    private Date fecha;
    private Time hentrada;
    private Time hsalida;

    public EmpleadoHorario() {
    }
    
    public EmpleadoHorario(String nombre, String apellidos, Date fecha, Time hentrada, Time hsalida) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha = fecha;
        this.hentrada = hentrada;
        this.hsalida = hsalida;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHentrada() {
        return hentrada;
    }

    public void setHentrada(Time hentrada) {
        this.hentrada = hentrada;
    }

    public Time getHsalida() {
        return hsalida;
    }

    public void setHsalida(Time hsalida) {
        this.hsalida = hsalida;
    }
    
}
