
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;


public abstract class ComprobantePago extends Comprobante{
    protected String formaPago;

    public ComprobantePago(String cod, LocalDate fecha, LocalTime hora, Cliente cliente, 
            Empleado empleado,String formaPago) {
        super(cod, fecha, hora, cliente, empleado);
        this.formaPago = formaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    
}
