
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;


public class Horario {
    private int id;
    private LocalDate fecha;
    private LocalTime Hentrada;
    private LocalTime Hsalida;
    private Empleado empleado;

    public Horario(int id, LocalDate fecha, LocalTime Hentrada, LocalTime Hsalida, Empleado empleado) {
        this.id = id;
        this.fecha = fecha;
        this.Hentrada = Hentrada;
        this.Hsalida = Hsalida;
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHentrada() {
        return Hentrada;
    }

    public void setHentrada(LocalTime Hentrada) {
        this.Hentrada = Hentrada;
    }

    public LocalTime getHsalida() {
        return Hsalida;
    }

    public void setHsalida(LocalTime Hsalida) {
        this.Hsalida = Hsalida;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
