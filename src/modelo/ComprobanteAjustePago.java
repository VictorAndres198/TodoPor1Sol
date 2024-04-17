
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class ComprobanteAjustePago extends Comprobante{

    protected ComprobantePago comprobantePago;

    public ComprobanteAjustePago(String cod, LocalDate fecha, LocalTime hora, 
            Cliente cliente, Empleado empleado,ComprobantePago comprobantePago) {
        super(cod, fecha, hora, cliente, empleado);
        this.comprobantePago = comprobantePago;
    }

    public ComprobantePago getComprobantePago() {
        return comprobantePago;
    }

    public void setComprobantePago(ComprobantePago comprobantePago) {
        this.comprobantePago = comprobantePago;
    }
    
    
    
    
}
