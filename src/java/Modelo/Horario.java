package Modelo;

import java.sql.Date;
import java.sql.Time;

public class Horario {
    private int idHoraEmp;
    private Date fecha;
    private Time hentrada;
    private Time hsalida;
    
    //Constructor
    public Horario(){
    }

    public Horario(int idHoraEmp, Date fecha, Time hentrada, Time hsalida) {
        this.idHoraEmp = idHoraEmp;
        this.fecha = fecha;
        this.hentrada = hentrada;
        this.hsalida = hsalida;
    }

    public int getIdHoraEmp() {
        return idHoraEmp;
    }

    public void setIdHoraEmp(int idHoraEmp) {
        this.idHoraEmp = idHoraEmp;
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