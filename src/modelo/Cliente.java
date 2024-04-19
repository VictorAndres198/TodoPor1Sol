
package modelo;


public abstract class Cliente {
    protected String cod;
    protected String nombre;

    public Cliente(String cod,String nombre) {
        this.cod=cod;
        this.nombre = nombre;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    
}
