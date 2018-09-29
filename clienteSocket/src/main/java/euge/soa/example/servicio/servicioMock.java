package euge.soa.example.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import euge.soa.example.interfaces.servicioPersona;
import euge.soa.example.modelo.Estado;
import euge.soa.example.modelo.Persona;

public class servicioMock implements servicioPersona {
	private static Logger log=LoggerFactory.getLogger(servicioMock.class);
	@Override
	public Estado checkPersona(String DNI) {
		Estado est=new Estado();
		Persona per=new Persona();
		per.setApellido("Doe");
		per.setNombre("John");
		per.setDNI(DNI);
		per.setEdad("99");
		est.setCodigo("Ok");
		est.setPers(per);
		return est;
	}

	@Override
	public String notifica(Persona persona) {
		log.info(persona.getNombre()+" "+persona.getApellido());
		return "Ok";
	}

}
