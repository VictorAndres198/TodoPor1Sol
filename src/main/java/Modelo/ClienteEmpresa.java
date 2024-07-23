
package Modelo;

public class ClienteEmpresa extends Cliente{
    
    private String razonSocial;
    private String direccion;

    public ClienteEmpresa(String ruc,String razonSocial, String direccion,String telefono, String correo) {
        super(ruc, telefono, correo);
        this.razonSocial = razonSocial;
        this.direccion = direccion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
 
    
    
}
