
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Boleta extends ComprobantePago{
    
    private String nombreCliente;

    public Boleta(String cod, LocalDate fecha, LocalTime hora, Cliente cliente, 
            Empleado empleado, String formaPago,String nombreCliente) {
        super(cod, fecha, hora, cliente, empleado, formaPago);
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

}
