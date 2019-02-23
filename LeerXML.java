package org.juanjoseramos.reportes;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import org.juanjoseramos.controller.ControllerAlumno;
import org.juanjoseramos.controller.ControllerAsignacion;
import org.juanjoseramos.controller.ControllerMateria;
import org.juanjoseramos.bean.Alumno;
import org.juanjoseramos.bean.Materia;
import org.juanjoseramos.bean.Asignacion;


public class LeerXML {
	public static LeerXML LeerXML;
	
	public LeerXML(){
	}

	public static LeerXML getLeerXML() {
         if(LeerXML == null) {
             LeerXML = new LeerXML();
         }
         return LeerXML;
    }


public void leerAlumno(){	
    try {
		File fXmlFile = new File("Alumnos.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		System.out.println("----------------------------");
		System.out.println("Origen de datos : " + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("Alumnos");
		System.out.println("----------------------------");
		for (int temp = 1; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				String carnet = eElement.getElementsByTagName("carnet").item(0).getTextContent();
				String nombre = eElement.getElementsByTagName("nombreAlumno").item(0).getTextContent();
				String apellido = eElement.getElementsByTagName("apellidoAlumno").item(0).getTextContent();
				System.out.println("Carnet: " + carnet);
				System.out.println("Nombre: " + nombre);
				System.out.println("Apellido: " + apellido);			
				System.out.println("----------------------------");
				ControllerAlumno.getControllerAlumno().addAlumno2(carnet, nombre, apellido);


				}
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
}




public void leerMateria(){	
    try {

		File fXmlFile = new File("Materias.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		doc.getDocumentElement().normalize();
		System.out.println("----------------------------");
		System.out.println("Origen de datos : " + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("Materias");
		System.out.println("----------------------------");
		for (int temp = 1; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				String idMateria = eElement.getElementsByTagName("Id_De_Materia").item(0).getTextContent();
				String nombre = eElement.getElementsByTagName("Nombre_de_Materia").item(0).getTextContent();
				String horaInicio= eElement.getElementsByTagName("Hora_Inicio").item(0).getTextContent();
				String horaFin=  eElement.getElementsByTagName("Hora_Fin").item(0).getTextContent();
				String dia= eElement.getElementsByTagName("Dia_de_clases").item(0).getTextContent();
				System.out.println("Id: " + idMateria);
				System.out.println("Nombre: " + nombre);
				System.out.println("Hora de inicio: " +horaInicio);			
				System.out.println("Hora de fin: " + horaFin);			
				System.out.println("Dia de clases: " + dia);			
				System.out.println("----------------------------");
				//ControllerMateria.getControllerMateria().addMateria2(idMateria, nombre, horaInicio, horaFin, dia);
				}
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
}



public void leerAsignacion(){	
    try {

		File fXmlFile = new File("Asignaciones.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		doc.getDocumentElement().normalize();
		System.out.println("----------------------------");
		System.out.println("Origen de datos : " + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("Asignacion");
		System.out.println("----------------------------");
		for (int temp = 1; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				String carnet =  eElement.getElementsByTagName("Carnet_del_alumno").item(0).getTextContent();
				String nombreMateria = eElement.getElementsByTagName("Nombre_del_Alumno").item(0).getTextContent();

				System.out.println("Id: " + eElement.getElementsByTagName("idAsignacion").item(0).getTextContent());
				System.out.println("Carnet del Alumno: " + carnet);
				System.out.println("Nombre de la Materia: " + nombreMateria);			
				System.out.println("Hora de inicio: " + eElement.getElementsByTagName("Materia_del_Alumno").item(0).getTextContent());			
				System.out.println("Hora de fin: " + eElement.getElementsByTagName("Hora_Fin").item(0).getTextContent());			
				System.out.println("Dia de clases: " + eElement.getElementsByTagName("Dia_de_clases").item(0).getTextContent());			
				System.out.println("----------------------------");
				ControllerAsignacion.getControllerAsignacion().addAsignacion2(carnet, nombreMateria);
				}
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
}




}