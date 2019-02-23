package org.juanjoseramos.controller;
import org.juanjoseramos.bean.Asignacion;
import org.juanjoseramos.bean.Alumno;
import org.juanjoseramos.bean.Materia;
import org.juanjoseramos.controller.ControllerAlumno;
import org.juanjoseramos.controller.ControllerMateria;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControllerAsignacion{
	ControllerAlumno controllerAlumno = new ControllerAlumno();
	ControllerMateria controllerMateria = new ControllerMateria();	

	Asignacion asignacion = new Asignacion();
	Alumno alumno = new Alumno();
	Materia materia = new Materia();
	public ArrayList<Asignacion> arrayListAsignacion = new ArrayList();
	
	public static ControllerAsignacion ControllerAsignacion;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int idAsignacion = 1;
	int carnet;
	String nombreMateria;
	int contador = 2;
	public boolean bandera 	= false;
	public ControllerAsignacion(){
		arrayListAsignacion = new ArrayList();
	}

	public static ControllerAsignacion getControllerAsignacion() {
         if(ControllerAsignacion == null) {
             ControllerAsignacion = new ControllerAsignacion();
         }
         return ControllerAsignacion;
    }	


	public void getAsignacion(){
		for(int x=0; x<arrayListAsignacion.size(); x++){
			System.out.println("");
			System.out.println("	  Asinaciones ingresadas");
			System.out.println("	  ----------------------");
			System.out.println("");
			System.out.println("Id de la asignacion: " +arrayListAsignacion.get(x).getIdAsignacion());
			System.out.println("Carnet del alumno: " + arrayListAsignacion.get(x).getAlumno().getCarnet());
			System.out.println("Nombre del alumno: " + arrayListAsignacion.get(x).getAlumno());
			System.out.println("Nombre de la Materia: " + arrayListAsignacion.get(x).getMateria());
			System.out.println("Hora Inicio de la Materia: " + arrayListAsignacion.get(x).getMateria().getHoraInicio());
			System.out.println("Hora Finalizacion de la Materia: " + arrayListAsignacion.get(x).getMateria().getHoraFin());
			System.out.println("Dia de clase: " + arrayListAsignacion.get(x).getMateria().getDia());
			System.out.println("------------------------------------------");
		}
	}
	public void addAsignacion(){
		System.out.println("");		
		ControllerAlumno.getControllerAlumno().getAlumno();
		System.out.println(""); 
		ControllerMateria.getControllerMateria().getMateria();
		
		try{
			System.out.println("");
			System.out.print("Ingrese el numero de carnet: ");
			carnet = Integer.parseInt(br.readLine());
			System.out.print("Ingrese el nombre de Materia: ");
			nombreMateria = br.readLine();
			Asignacion asig = new Asignacion();
			int carnetAlumno = idAlumno();
				if(carnet == carnetAlumno){
					if(contador <=6){
						asig.setIdAsignacion(idAsignacion);
						asig.setAlumno(ControllerAlumno.getControllerAlumno().buscar(carnet));
						asig.setMateria(ControllerMateria.getControllerMateria().buscar((nombreMateria)));				
						arrayListAsignacion.add(asig);
						idAsignacion++;
						System.out.println("");
						System.out.print("Asignacion ingresada correctamente");	
						System.out.println("");
						contador++;
					}else{
						System.out.println("");
						System.out.println("El alumno ya tiene 6 materias asignadas");
						System.out.println("");
					}

				}else{
					asig.setIdAsignacion(idAsignacion);
					asig.setAlumno(ControllerAlumno.getControllerAlumno().buscar(carnet));
					asig.setMateria(ControllerMateria.getControllerMateria().buscar((nombreMateria)));				
					arrayListAsignacion.add(asig);
					idAsignacion++;
					System.out.println("");
					System.out.print("Asignacion ingresada correctamente");	
					System.out.println("");
						
				}
		
		} catch (IOException e) {
			System.out.println(e);	
		}	
	}

	public ArrayList<Asignacion> arrayDeAsignacion(){
		for(int x = 0; x< arrayListAsignacion.size(); x++){
			return arrayListAsignacion;
		}
		return null;
	}
	public int idAlumno(){
		for(int x =0; x<arrayListAsignacion.size(); x++){
			return arrayListAsignacion.get(x).getAlumno().getCarnet();
		}
		return 0;
	}

	public boolean verificarAsignacion(){
		if(arrayListAsignacion.size() == 0){
			return bandera;
		}else{
			boolean bandera2 = true;
			return bandera2;
		}
	}

	public void addAsignacion2(String carnet, String nombreMateria){
		System.out.println("");		
		ControllerAlumno.getControllerAlumno().getAlumno();
		System.out.println(""); 
		ControllerMateria.getControllerMateria().getMateria();
		Asignacion asig = new Asignacion();
			int carnetAlumno = idAlumno();
				if(Integer.parseInt(carnet) == carnetAlumno){
					if(contador <=6){
						asig.setIdAsignacion(idAsignacion);
						asig.setAlumno(ControllerAlumno.getControllerAlumno().buscar(Integer.parseInt(carnet)));
						asig.setMateria(ControllerMateria.getControllerMateria().buscar((nombreMateria)));				
						arrayListAsignacion.add(asig);
						idAsignacion++;
						System.out.println("");
						System.out.print("Asignacion ingresada correctamente");	
						System.out.println("");
						contador++;
					}else{
						System.out.println("");
						System.out.println("El alumno ya tiene 6 materias asignadas");
						System.out.println("");
					}

				}else{
					asig.setIdAsignacion(idAsignacion);
					asig.setAlumno(ControllerAlumno.getControllerAlumno().buscar(Integer.parseInt(carnet)));
					asig.setMateria(ControllerMateria.getControllerMateria().buscar((nombreMateria)));				
					arrayListAsignacion.add(asig);
					idAsignacion++;
					System.out.println("");
					System.out.print("Asignacion ingresada correctamente");	
					System.out.println("");
						
				}
	
	}

}