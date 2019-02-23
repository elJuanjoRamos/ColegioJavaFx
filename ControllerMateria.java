package org.juanjoseramos.controller;
import org.juanjoseramos.bean.Materia;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControllerMateria{
	Materia materia = new Materia();
	public ArrayList<Materia> arrayListMateria = new ArrayList();
	public static ControllerMateria ControllerMateria;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public int idMateria = 1;
	public boolean bandera 	= false;	
	String nombre;
	String horaInicio;
	String horaFin;
	String dia;

	public ControllerMateria(){
		arrayListMateria = new ArrayList();

	}

	public static ControllerMateria getControllerMateria() {
         if(ControllerMateria == null) {
             ControllerMateria = new ControllerMateria();
         }
         return ControllerMateria;
    }

	public void getMateria(){
		for(int x = 0; x< arrayListMateria.size(); x++){
			System.out.println("");
			System.out.println("	   Materias ingresadas");
			System.out.println("  	   -------------------");
			System.out.println("");
			System.out.println("Id de la Materia: " + arrayListMateria.get(x).getIdMateria());
			System.out.println("Nombre de la Materia: " + arrayListMateria.get(x).getNombre());
			System.out.println("Hora Inicio de la Materia: " + arrayListMateria.get(x).getHoraInicio());
			System.out.println("Hora Fin de la Materia: " + arrayListMateria.get(x).getHoraFin());
			System.out.println("Dia de clase: " + arrayListMateria.get(x).getDia());
			System.out.println("------------------------------------------");		
		}
	}
	public void addMateria(){
		try{
			System.out.println(""); 
			System.out.print("Ingrese el Nombre:"); 
			nombre = br.readLine();
			System.out.print("Ingrese la hora de inicio:"); 
			horaInicio = br.readLine();
			System.out.print("Ingrese la hora de finalizacion:"); 
			horaFin = br.readLine();
			System.out.print("Ingrese el dia de clases:"); 
			dia = br.readLine();			
			Materia mat = new Materia();			
			mat.setIdMateria(idMateria);
			mat.setNombre(nombre);
			mat.setHoraInicio(horaInicio);
			mat.setHoraFin(horaFin);
			mat.setDia(dia);
			arrayListMateria.add(mat);
			idMateria++;
			System.out.println("");
			System.out.println("Materia Ingresada correctamente");
			System.out.println("");
		} catch (IOException e) {
			System.out.println(e);	
		}	
	}
    
	public Materia buscar(String nombre) {
		for (Materia materia : arrayListMateria) {
			if (materia.getNombre().equals(nombre)) {
				return materia;
			}else{
				System.out.println("");
				System.out.println("No hay ningun materia con el nombre ingresado");
			}
		}
		return null;
	}

	public boolean verificarMaterias(){
		if(arrayListMateria.size() == 0){
			return bandera;
		}else{
			boolean bandera2 = true;
			return bandera2;
		}
	}
	public ArrayList<Materia> arrayDeMateria(){
    	for(int x = 0; x< arrayListMateria.size(); x++){
			return arrayListMateria;
		}
		return null;
    }

	public void addMateria2(String idMateria, String nombre, String horaInicio, String horaFin, String dia){
			Materia mat = new Materia();			
			mat.setIdMateria(Integer.parseInt(idMateria));
			mat.setNombre(nombre);
			mat.setHoraInicio(horaInicio);
			mat.setHoraFin(horaFin);
			mat.setDia(dia);
			arrayListMateria.add(mat);
			System.out.println("");
			System.out.println("Materia Ingresada correctamente");
			System.out.println("");
	}

}