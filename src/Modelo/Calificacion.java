
package Modelo;


public class Calificacion {
    private double asesor;
    private double tecnico;
    private double ventas;
    private double total;
    private String caracteristicas;

    public Calificacion(String caracteristicas, double asesor, double tecnico, double ventas, double total) {
        this.caracteristicas = caracteristicas;
        this.asesor = asesor;
        this.tecnico = tecnico;
        this.ventas = ventas;
        this.total = total;
    }

    
    public double getAsesor() {
        return asesor;
    }

    public void setAsesor(double asesor) {
        this.asesor = asesor;
    }

    public double getTecnico() {
        return tecnico;
    }

    public void setTecnico(double tecnico) {
        this.tecnico = tecnico;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    
    
    
    
}
