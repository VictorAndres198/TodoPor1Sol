
package Modelo;


public  class Categoria {
    private int ID_categoria; 
    private String Nombre; 
//Constructor

    public Categoria() {
    }

    public Categoria(int ID_categoria, String Nombre) {
        this.ID_categoria = ID_categoria;
        this.Nombre = Nombre;
    }
    
    
     //Metodos getters y setters

    public int getID_categoria() {
        return ID_categoria;
    }

    public void setID_categoria(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    
    
}
