package euge.soa.example.interfaces;

import euge.soa.example.modelo.Estado;
import euge.soa.example.modelo.Persona;

public interface gestionSocket {
	//Envia datos an servidor Socket, y retorna el codigo
	public String envia(Persona persona);
	//Obtiene el estado de un DNI
	public Estado procesa(String DNI);

}
