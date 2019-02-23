package org.juanjoseramos.principal;
import org.juanjoseramos.controller.ControllerAlumno;
import org.juanjoseramos.controller.ControllerMateria;
import org.juanjoseramos.controller.ControllerAsignacion;
import org.juanjoseramos.reportes.LeerXML;
import org.juanjoseramos.reportes.Imprimir;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuGeneral{
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static MenuGeneral MenuGeneral;
	String variable;
	String respuesta;
	
	int idAsignacion = 1;
	String carnet;
	String nombreMateria;
	public MenuGeneral(){
	
	}
	public static MenuGeneral getMenuGeneral() {
         if(MenuGeneral == null) {
             MenuGeneral = new MenuGeneral();
         }
         return MenuGeneral;
    }

    public void menuGeneral(){
    	System.out.println("");
		System.out.println("         Bienvenido!!!");
		System.out.println("");
		try {
			do{
				System.out.println("");
				System.out.println("	Menu Principal");
				System.out.println("	--------------");
				System.out.println("");
				System.out.println("Indique el numero de lo que desea hacer ");	
				System.out.println(""); 
				System.out.println("1.Materias");
				System.out.println("2.Alumnos");
				System.out.println("3.Asignaciones");
				System.out.println("4.Leer XML"); 
				System.out.println(""); 
				System.out.print("Introduce el numero: ");
				variable = br.readLine();
				opciones(variable);
				System.out.println(""); 					
				System.out.println("Desea hacer algo mas? Si= 1/No=Otro numero");
				System.out.println("");
				System.out.print("Respuesta: ");
				respuesta = br.readLine();
			} while(Integer.parseInt(respuesta) == 1);		 
		} catch (IOException e) {
			System.out.println(e);	
		}	
    }

    public void opciones(String variable){
    	try{
    		if(Integer.parseInt(variable) == 1){
    			System.out.println(""); 
				System.out.println(" 		+--------+"); 
				System.out.println(" 		|Materias|"); 
				System.out.println(" 		+--------+"); 
				System.out.println(""); 
				System.out.println("1.Ingresar Materias"); 
				System.out.println("2.Ver Materias");
				System.out.println("3.Imprimir Materias");
				System.out.println("4.Regresar al menu principal");
				System.out.println(""); 
				System.out.print("Introduce el numero: "); 
				variable = br.readLine();
				if(Integer.parseInt(variable) == 1){
					ControllerMateria.getControllerMateria().addMateria();
				}else if(Integer.parseInt(variable) == 2){
					boolean verificarMateria = ControllerMateria.getControllerMateria().verificarMaterias();
					if(verificarMateria == true){
						ControllerMateria.getControllerMateria().getMateria();
					}else{
						System.out.println("Todavia no se ha ingresado ninguna Materia");
					}
				}else if(Integer.parseInt(variable)==3){
					boolean verificarMateria = ControllerMateria.getControllerMateria().verificarMaterias();
					if(verificarMateria ==true){
						Imprimir.getImprimir().imprimirMateria();
					}else{
						System.out.println("");
						System.out.println("Todavia no se han ingresado Materias");
					}					
				}else if(Integer.parseInt(variable)==4){
					menuGeneral();
				}																					
			}else if(Integer.parseInt(variable) == 2){
				System.out.println(""); 
				System.out.println(" 		+-------+"); 
				System.out.println(" 		|Alumnos|"); 
				System.out.println(" 		+-------+"); 
				System.out.println(""); 
				System.out.println("1.Ingresar Alumnos"); 
				System.out.println("2.Ver Alumnos");
				System.out.println("3.Imprimir Alumnos");
				System.out.println("4.Regresar al menu principal");
				System.out.println(""); 
				System.out.print("Introduce el numero: ");
				variable = br.readLine();
				if(Integer.parseInt(variable) ==1){						
					ControllerAlumno.getControllerAlumno().addAlumno();
				}else if(Integer.parseInt(variable) ==2){
					boolean verificarAlumno = ControllerAlumno.getControllerAlumno().verificarAlumno();
					if(verificarAlumno == true){
						ControllerAlumno.getControllerAlumno().getAlumno();
					}else{
						System.out.println("");
						System.out.println("Todavia no se ha ingresado ningun Alumno");
					}
				}else if(Integer.parseInt(variable) ==3){
					boolean verificarAlumno = ControllerAlumno.getControllerAlumno().verificarAlumno();
					if(verificarAlumno ==true){
						Imprimir.getImprimir().imprimirAlumnos();
					}else{
						System.out.println("");
						System.out.println("Todavia no se han ingresado alumnos");
					}
				}else if(Integer.parseInt(variable) ==4){
					menuGeneral();
				}					 
			}else if(Integer.parseInt(variable) ==3){
				System.out.println(""); 
				System.out.println(" 		+------------+"); 
				System.out.println(" 		|Asignaciones|"); 
				System.out.println(" 		+------------+"); 
				System.out.println("");  
				System.out.println("1.Ingresar Asignaciones"); 
				System.out.println("2.Ver Asignaciones");
				System.out.println("3.Imprimir Asignaciones");
				System.out.println("4.Regresar al menu principal");
				System.out.println(""); 
				System.out.print("Introduce el numero: ");
				variable = br.readLine();
				if(Integer.parseInt(variable) ==1){
					boolean verificarMateria = ControllerMateria.getControllerMateria().verificarMaterias();
					boolean verificarAlumno = ControllerAlumno.getControllerAlumno().verificarAlumno();
					if(verificarMateria == true && verificarAlumno == true){
						ControllerAsignacion.getControllerAsignacion().addAsignacion();
					}else{
						System.out.println("");
						System.out.println("Todavia no se han igresado alumnos o materias");
					}
				}else if(Integer.parseInt(variable) ==2){
					ControllerAsignacion.getControllerAsignacion().getAsignacion();							
				}else if(Integer.parseInt(variable) ==3){
					boolean verificarAsignacion = ControllerAsignacion.getControllerAsignacion().verificarAsignacion();
					if(verificarAsignacion ==true){
						Imprimir.getImprimir().imprimirDatosAlumno();	
					}else{
						System.out.println("");
						System.out.println("Todavia no se ha hecho ninguna Asignacion");
					}					
				}else if(Integer.parseInt(variable) ==4){
					menuGeneral();
				}
			}else if(Integer.parseInt(variable) ==4){
				System.out.println("");
				System.out.println("1.Leer Alumnos"); 
				System.out.println("2.Leer Materias");
				System.out.println("3.Leer Asignaciones");
				System.out.println("4.Regresar al menu principal");
				System.out.println(""); 
				System.out.print("Introduce el numero: ");
				variable = br.readLine();
				if(Integer.parseInt(variable) ==1){
					LeerXML.getLeerXML().leerAlumno();
				}else if(Integer.parseInt(variable) ==2){
					LeerXML.getLeerXML().leerMateria();							
				}else if(Integer.parseInt(variable) ==3){
					boolean verificarMateria = ControllerMateria.getControllerMateria().verificarMaterias();
					boolean verificarAlumno = ControllerAlumno.getControllerAlumno().verificarAlumno();
					if(verificarMateria == true && verificarAlumno == true){
						LeerXML.getLeerXML().leerAsignacion();
					}else{
						System.out.println("");
						System.out.println("Todavia no se han igresado alumnos o materias");
					}					
										
				}else if(Integer.parseInt(variable) ==4){
					menuGeneral();
				}	
			}
    	} catch (IOException e) {
			System.out.println(e);	
		}	
    	
    }

}