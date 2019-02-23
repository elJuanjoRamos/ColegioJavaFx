package org.juanjoseramos.bean;

public class Asignacion{
	private int idAsignacion;
	private Alumno alumno;
	private Materia materia;

	public Asignacion(){

	}

	public int getIdAsignacion(){
		return idAsignacion;
	}
	public void setIdAsignacion(int idAsignacion){
		this.idAsignacion = idAsignacion;
	}

	public Alumno getAlumno(){
		return alumno;
	}

	public void setAlumno(Alumno alumno){
		this.alumno = alumno;
	}

	public Materia getMateria(){
		return materia;
	}
	public void setMateria(Materia materia){
		this.materia = materia;
	}
}