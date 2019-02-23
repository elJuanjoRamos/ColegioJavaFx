package org.juanjoseramos.controller;
import org.juanjoseramos.bean.Alumno;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


//import org.juanjoseramos.bean.Alumno;

public class ControllerAlumno{
	Alumno alumno = new Alumno();
	public ArrayList<Alumno> arrayListAlumno = new ArrayList();
	public static ControllerAlumno ControllerAlumno;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean bandera = false;
	String nombre;
	String carnet;
	String apellido;

    public ControllerAlumno() {
        arrayListAlumno = new ArrayList<>();
    }
	public static ControllerAlumno getControllerAlumno() {
         if(ControllerAlumno == null) {
             ControllerAlumno = new ControllerAlumno();
         }
         return ControllerAlumno;
    }
    	
	public void addAlumno(){
		Alumno alum = new Alumno();
		try {
			System.out.println(""); 
			System.out.print("Ingrese el Carnet:"); 
			carnet = br.readLine();
			System.out.print("Ingrese el Nombre:"); 
			nombre = br.readLine();
			System.out.print("Ingrese el Apellido:"); 
			apellido =br.readLine();
			alum.setCarnet(Integer.parseInt(carnet));
			alum.setNombre(nombre);
			alum.setApellido(apellido);
			arrayListAlumno.add(alum);
			System.out.println("");
			System.out.println("Alumno ingresado correctamente");
			System.out.println("");	
		} catch (IOException e) {
			System.out.println(e);	
		}	
	}
	
	public void getAlumno(){
		System.out.println("");
		System.out.println("	    Alumnos ingresados");
		System.out.println("	    ------------------");
		System.out.println("");		
		for(int x = 0; x< arrayListAlumno.size(); x++){
			System.out.println("Carnet del alumno: " + arrayListAlumno.get(x).getCarnet());
			System.out.println("Nombre del alumno: " + arrayListAlumno.get(x).getNombre());
			System.out.println("Apellido del alumno: " + arrayListAlumno.get(x).getApellido());	
			System.out.println("------------------------------------------");		
		}
	}
    public ArrayList<Alumno> arrayDeAlumno(){
    	for(int x = 0; x< arrayListAlumno.size(); x++){
			return arrayListAlumno;
		}
		return null;
    }
	public Alumno buscar(int carnet) {
		for (Alumno alumno : arrayListAlumno) {
			if (carnet == alumno.getCarnet()) {
				return alumno;
			}else{
				System.out.println("");
				System.out.println("No hay ningun alumno asociado al numero de carnet ingresado");
			}
		}
		return null;

	}

	public boolean verificarAlumno(){
		if(arrayListAlumno.size() ==0){
			return bandera;
		}else{
			bandera = true;
			return bandera;
		}
	}


	public void addAlumno2(String carnet, String nombre, String apellido){
		Alumno alum = new Alumno();
			alum.setCarnet(Integer.parseInt(carnet));
			alum.setNombre(nombre);
			alum.setApellido(apellido);
			arrayListAlumno.add(alum);
			System.out.println("");
			System.out.println("Alumno ingresado correctamente");
			System.out.println("");	
			
	}


}