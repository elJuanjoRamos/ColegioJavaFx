package org.juanjoseramos.bean;

public class Alumno {
    private int carnet;
    private String nombre;
    private String apellido;

    public Alumno() {
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	
	  public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String nombreCompleto = nombre + apellido;    
    public String toString() {
        return this.nombre;
        
    }
/*
    public Grado getGrado() {
        return Grado;
    }

    public void setGrado(Grado Grado) {
        this.Grado = Grado;
    }
*/
    
}
