package euge.com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import euge.com.examples.demo.configuracion.Basico;
import euge.com.examples.demo.configuracion.Complejo;
import euge.com.examples.demo.configuracion.SoloEntrada;
import euge.com.examples.demo.configuracion.pruebaBeanFusion;
import euge.soa.example.beans.beanPersonas;
import euge.soa.example.servicio.servicioMock;

@SpringBootApplication
public class ClienteSocketApplication{

	public static void main(String[] args) {
		SpringApplication.run(ClienteSocketApplication.class, args);
	}


	//@Bean
	public Basico clienteBasico() {
		return new Basico();
	}

	//@Bean
	public Complejo clienteComplejo() {
		return new Complejo();
	}

	//@Bean
	public SoloEntrada clienteSoloEntrada() {
		return new SoloEntrada();
	}

	@Bean
	public servicioMock servicio() {
		return new servicioMock();
	}

	private static int PORT = 12116;

	@Bean
	public beanPersonas beanAProbar(@Value("${servidor}") String servidor) {
		beanPersonas miServ=new beanPersonas(servicio(), servidor, PORT, PORT);
		try {
			miServ.arranca();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return miServ;
	}

	@Bean
	public pruebaBeanFusion prueba() {
		return new pruebaBeanFusion();
	}
}
