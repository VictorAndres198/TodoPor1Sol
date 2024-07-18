package Modelo;

import java.util.Date;

public class HoraEmpleado {
    private int idHoraEmp; // ID_HoraEmp (PK, autoincrementado)
    private Date fecha; // Fecha
    private String hEntrada; // Hentrada (hora de entrada)
    private String hSalida; // Hsalida (hora de salida)
    private String dniEmpleado; // DNI_empleado (FK)

    // Constructor vacío
    public HoraEmpleado() {
    }

    // Constructor con todos los campos
    public HoraEmpleado(Date fecha, String hEntrada, String hSalida, String dniEmpleado) {
        this.fecha = fecha;
        this.hEntrada = hEntrada;
        this.hSalida = hSalida;
        this.dniEmpleado = dniEmpleado;
    }

    // Getters y Setters
    public int getIdHoraEmp() {
        return idHoraEmp;
    }

    public void setIdHoraEmp(int idHoraEmp) {
        this.idHoraEmp = idHoraEmp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String gethEntrada() {
        return hEntrada;
    }

    public void sethEntrada(String hEntrada) {
        this.hEntrada = hEntrada;
    }

    public String gethSalida() {
        return hSalida;
    }

    public void sethSalida(String hSalida) {
        this.hSalida = hSalida;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    // Método toString para propósitos de depuración
    @Override
    public String toString() {
        return "HoraEmpleado{" +
                "idHoraEmp=" + idHoraEmp +
                ", fecha=" + fecha +
                ", hEntrada='" + hEntrada + '\'' +
                ", hSalida='" + hSalida + '\'' +
                ", dniEmpleado='" + dniEmpleado + '\'' +
                '}';
    }
}
