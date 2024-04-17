
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;


public abstract class Comprobante {
    protected String cod;
    private final String RUC="390210921"; //constante
    protected LocalDate fecha;
    protected LocalTime hora;
    protected Cliente cliente;
    protected Empleado empleado;

    public Comprobante(String cod, LocalDate fecha, LocalTime hora,Cliente cliente,
            Empleado empleado) {
        this.cod = cod;
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    
    
}
