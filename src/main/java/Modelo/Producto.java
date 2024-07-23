package Modelo;


import java.util.Date;
public class Producto {
    private  int ID_Prod ;
    private String Nombre; 
    private String Descripcion; 
    private Date FechaVencimiento;
    private double precio;
    private int Stock;
    private int ID_categoria; 
    private String ruc;
 public Producto() {
    }

    public Producto(int ID_Prod, String Nombre, String Descripcion, Date FechaVencimiento, double precio, int Stock, int ID_categoria, String ruc) {
        this.ID_Prod = ID_Prod;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.FechaVencimiento = FechaVencimiento;
        this.precio = precio;
        this.Stock = Stock;
        this.ID_categoria = ID_categoria;
        this.ruc = ruc;
    }
    
    

    public Producto(int ID_Prod, String Nombre) {
        this.ID_Prod = ID_Prod;
        this.Nombre = Nombre;
    }

    public Producto(String Descripcion, double precio) {
        this.Descripcion = Descripcion;
        this.precio = precio;
    }

    public Producto(int ID_Prod) {
        this.ID_Prod = ID_Prod;
    }
    
    
    
    public int getID_Prod() {
        return ID_Prod;
    }

    public void setID_Prod(int ID_Prod) {
        this.ID_Prod = ID_Prod;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getID_categoria() {
        return ID_categoria;
    }

    public void setID_categoria(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public void setNombreProveedor(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setNombreCategoria(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombreProveedor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombreCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setID(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "Producto{" + "ID_Prod=" + ID_Prod + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", precio=" + precio + ", Stock=" + Stock + ", ID_categoria=" + ID_categoria + '}';
    }



    



  
     }
