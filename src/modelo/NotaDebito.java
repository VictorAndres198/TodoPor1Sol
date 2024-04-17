
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;


public class NotaDebito extends ComprobanteAjustePago{
    
    private Float IncrementoDeuda;
    private String motivo;

    public NotaDebito(String cod, LocalDate fecha, LocalTime hora, Cliente cliente, 
            Empleado empleado, ComprobantePago comprobantePago,Float IncrementoDeuda,
            String motivo) {
        super(cod, fecha, hora, cliente, empleado, comprobantePago);
        this.IncrementoDeuda = IncrementoDeuda;
        this.motivo = motivo;
    }

    public Float getIncrementoDeuda() {
        return IncrementoDeuda;
    }

    public void setIncrementoDeuda(Float IncrementoDeuda) {
        this.IncrementoDeuda = IncrementoDeuda;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
    
}
