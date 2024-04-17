
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class NotaCredito extends ComprobanteAjustePago{
    private Float cantidadPagar;
    private String concepto;

    public NotaCredito(String cod, LocalDate fecha, LocalTime hora, Cliente cliente, 
            Empleado empleado, ComprobantePago comprobantePago,Float cantidadPagar, 
            String concepto) {
        super(cod, fecha, hora, cliente, empleado, comprobantePago);
        this.cantidadPagar = cantidadPagar;
        this.concepto = concepto;
    }

    public Float getCantidadPagar() {
        return cantidadPagar;
    }

    public void setCantidadPagar(Float cantidadPagar) {
        this.cantidadPagar = cantidadPagar;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    
    
}
