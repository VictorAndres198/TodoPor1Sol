
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Factura extends ComprobantePago{
    private String rucCliente;
    private String razonSocial;
    private GuiaRemision guiaRemision;

    public Factura(String cod, LocalDate fecha, LocalTime hora, Cliente cliente,
            Empleado empleado, String formaPago,String rucCliente,String razonSocial, 
            GuiaRemision guiaremision) {
        super(cod, fecha, hora, cliente, empleado, formaPago);
        this.rucCliente = rucCliente;
        this.razonSocial = razonSocial;
        this.guiaRemision = guiaremision;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public GuiaRemision getGuiaRemision() {
        return guiaRemision;
    }

    public void setGuiaRemision(GuiaRemision guiaRemision) {
        this.guiaRemision = guiaRemision;
    }
    
    
    
    
    
    
}
