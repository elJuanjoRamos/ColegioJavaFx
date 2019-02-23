package org.juanjoseramos.bean;

public class Materia{
	private int idMateria;
	private String nombre;
	private String horaInicio;
	private String horaFin;
	private String dia;
	public Materia(){
	}

	public int getIdMateria(){
		return idMateria;
	}
	public void setIdMateria(int idMateria){
		this.idMateria = idMateria;
	}

	public String getNombre(){
		return nombre;
	}
	public void	 setNombre(String nombre){
		this.nombre = nombre;
	}
 	
 	public void setHoraInicio(String horaInicio){
 		this.horaInicio = horaInicio;
 	}
 	public String getHoraInicio(){
 		return horaInicio;
 	}

 	public void setHoraFin(String horaFin){
 		this.horaFin = horaFin;
 	}
 	public String getHoraFin(){
 		return horaFin;
 	}
    public String toString() {
        return this.nombre;
    }

    public String getDia(){
		return dia;
	}
	public void	 setDia(String dia){
		this.dia = dia;
	}
}