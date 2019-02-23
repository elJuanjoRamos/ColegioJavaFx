package org.juanjoseramos.reportes;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.juanjoseramos.controller.ControllerAlumno;
import org.juanjoseramos.controller.ControllerAsignacion;
import org.juanjoseramos.controller.ControllerMateria;
import org.juanjoseramos.bean.Alumno;
import org.juanjoseramos.bean.Materia;
import org.juanjoseramos.bean.Asignacion;



public class Imprimir{

	public static Imprimir Imprimir;
	public Imprimir(){
	}

	public static Imprimir getImprimir() {
         if(Imprimir == null) {
             Imprimir = new Imprimir();
         }
         return Imprimir;
    }

    public void imprimirDatosAlumno(){
    	try {
    		ArrayList<Asignacion> arrayListAsignacion = ControllerAsignacion.getControllerAsignacion().arrayDeAsignacion();
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Asignacion");
			doc.appendChild(rootElement);
			for(int x = 0; x<arrayListAsignacion.size(); x++){
				Element asignacion = doc.createElement("Asignacion");
			

	    		Element id = doc.createElement("idAsignacion");
				id.appendChild(doc.createTextNode(String.valueOf(arrayListAsignacion.get(x).getIdAsignacion())));
				asignacion.appendChild(id);
				
				///Carnet
	    		Element carnet = doc.createElement("Carnet_del_alumno");
				carnet.appendChild(doc.createTextNode(String.valueOf(arrayListAsignacion.get(x).getAlumno().getCarnet())));
				asignacion.appendChild(carnet);
				
				///Nombre
				Element nombre = doc.createElement("Nombre_del_Alumno");
				nombre.appendChild(doc.createTextNode(arrayListAsignacion.get(x).getAlumno().getNombre()));
				asignacion.appendChild(nombre);
				//Materia			
				Element materia = doc.createElement("Materia_del_Alumno");
				materia.appendChild(doc.createTextNode(arrayListAsignacion.get(x).getMateria().getNombre()));
				asignacion.appendChild(materia);

				Element horaInicio = doc.createElement("Hora_Inicio");
				horaInicio.appendChild(doc.createTextNode(arrayListAsignacion.get(x).getMateria().getHoraInicio()));
				asignacion.appendChild(horaInicio);

				Element horaFin = doc.createElement("Hora_Fin");
				horaFin.appendChild(doc.createTextNode(arrayListAsignacion.get(x).getMateria().getHoraFin()));
				asignacion.appendChild(horaFin);

				Element dia = doc.createElement("Dia_de_clases");
				dia.appendChild(doc.createTextNode(arrayListAsignacion.get(x).getMateria().getDia()));
				asignacion.appendChild(dia);

				rootElement.appendChild(asignacion);
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("C:\\Users\\juan_\\Desktop\\Java\\Asignaciones.xml"));
				transformer.transform(source, result);	
    		}
   			System.out.println("");
   		    System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

	public void imprimirAlumnos(){
    	try {
    		ArrayList<Alumno> arrayListAlumnos = ControllerAlumno.getControllerAlumno().arrayDeAlumno();
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Alumnos");
			doc.appendChild(rootElement);

    		for(int x = 0; x<arrayListAlumnos.size(); x++){
				Element alumnos = doc.createElement("Alumnos");				
				///Carnet
	    		Element carnet = doc.createElement("carnet");
				carnet.appendChild(doc.createTextNode(String.valueOf(arrayListAlumnos.get(x).getCarnet())));
				alumnos.appendChild(carnet);
				
				///Nombre
				Element nombre = doc.createElement("nombreAlumno");
				nombre.appendChild(doc.createTextNode(arrayListAlumnos.get(x).getNombre()));
				alumnos.appendChild(nombre);
				//Materia			
				Element apellido = doc.createElement("apellidoAlumno");
				apellido.appendChild(doc.createTextNode(arrayListAlumnos.get(x).getApellido()));
				alumnos.appendChild(apellido);

				rootElement.appendChild(alumnos);
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("C:\\Users\\juan_\\Desktop\\Java\\Alumnos.xml"));
				transformer.transform(source, result);	
    		}
    		System.out.println("");   		
    		System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}		
	}

	public void imprimirMateria(){
    	try {
    		ArrayList<Materia> arrayListMateria = ControllerMateria.getControllerMateria().arrayDeMateria();
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Materias");
			doc.appendChild(rootElement);
			
    		for(int x = 0; x<arrayListMateria.size(); x++){
				Element materias = doc.createElement("Materias");
					
				///id
	    		Element idMateria = doc.createElement("Id_De_Materia");
				idMateria.appendChild(doc.createTextNode(String.valueOf(arrayListMateria.get(x).getIdMateria())));
				materias.appendChild(idMateria);
				
				///Nombre
				Element nombre = doc.createElement("Nombre_de_Materia");
				nombre.appendChild(doc.createTextNode(arrayListMateria.get(x).getNombre()));
				materias.appendChild(nombre);
				//hora inicio			
				Element horaInicio = doc.createElement("Hora_Inicio");
				horaInicio.appendChild(doc.createTextNode(arrayListMateria.get(x).getHoraInicio()));
				materias.appendChild(horaInicio);

				Element horaFin = doc.createElement("Hora_Fin");
				horaFin.appendChild(doc.createTextNode(arrayListMateria.get(x).getHoraFin()));
				materias.appendChild(horaFin);

				Element dia = doc.createElement("Dia_de_clases");
				dia.appendChild(doc.createTextNode(arrayListMateria.get(x).getDia()));
				materias.appendChild(dia);

				rootElement.appendChild(materias);
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("C:\\Users\\juan_\\Desktop\\Java\\Materias.xml"));
				transformer.transform(source, result);	
    		}
    		System.out.println("");
    		System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}		
	}

}