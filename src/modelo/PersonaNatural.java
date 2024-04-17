
package modelo;


public class PersonaNatural extends Cliente{
    private String apellidos;

    public PersonaNatural(String cod,String nombre,String apellidos) {
        super(cod,nombre);
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
    
}
