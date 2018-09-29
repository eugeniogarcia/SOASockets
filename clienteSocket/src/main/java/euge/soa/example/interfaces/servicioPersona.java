package euge.soa.example.interfaces;

import euge.soa.example.modelo.Estado;
import euge.soa.example.modelo.Persona;

public interface servicioPersona {
	//Servicio que recupera el estado de un DNI
	public Estado checkPersona(String DNI);
	//Servicio al que se notifican cambios de persona
	public String notifica(Persona persona);
}
