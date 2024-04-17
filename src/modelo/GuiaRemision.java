
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;


public class GuiaRemision extends Comprobante{
    
    private String direccion;
    private String razonSocial;

    public GuiaRemision(String cod, LocalDate fecha, LocalTime hora, Cliente cliente, 
            Empleado empleado,String direccion,String razonSocial) {
        super(cod, fecha, hora, cliente, empleado);
        this.direccion = direccion;
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

}
