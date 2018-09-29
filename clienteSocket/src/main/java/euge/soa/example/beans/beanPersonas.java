package euge.soa.example.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import euge.soa.example.interfaces.gestionSocket;
import euge.soa.example.interfaces.servicioPersona;
import euge.soa.example.modelo.Estado;
import euge.soa.example.modelo.Persona;

public class beanPersonas implements gestionSocket, Runnable{

	private servicioPersona servicio;
	private String servidor;
	final private int PORT;
	final private int serverPORT;

	public beanPersonas(servicioPersona servicio,String servidor, Integer puerto,Integer puertoServidor) {
		super();
		this.servicio = servicio;
		this.servidor=servidor;
		this.PORT=puerto;
		this.serverPORT=puertoServidor;
	}

	private ServerSocket serverSocket;
	private Thread worker;
	private boolean para=false;

	public void arranca() throws IOException {
		para=false;
		serverSocket = new ServerSocket(this.serverPORT);
		//Activa un servidor Socket que escucha peticiones
		worker=new Thread(this);
		worker.start();
	}

	public void para() throws IOException, InterruptedException  {
		para=true;
		serverSocket.close();
	}

	@Override
	public void run() {
		try {
			while(!this.para) {
				System.out.println("Esperando que alguien se conecte en el puerto " + serverSocket.getLocalPort() + "...");
				//Espera a que llegue una petición
				final Socket server = serverSocket.accept();
				System.out.println("Alguien se conecto " + server.getRemoteSocketAddress());

				//Esto nos servira para leer desde el cliente
				final BufferedReader fromClient = new BufferedReader(new InputStreamReader(server.getInputStream()));
				//Leemos una linea del cliente
				final String line = fromClient.readLine();
				System.out.println("El servidor ha recibido: " + line);
				Persona per;
				try {
					per = construye(line);
					System.out.println("Notifica");
					servicio.notifica(per);
					System.out.println("Responde");
					//Enviamos este mensaje al cliente
					respondeCliente("Gracias por contactar con nosotros " + server.getLocalSocketAddress() ,server);
					System.out.println("Responde (hecho)");
					if(!server.isClosed()) {
						server.close();
					}
				}
				catch(SocketException se) {
					System.out.println("El cliente ya no esta");
				}
				catch (Exception e) {
					System.out.println("Una Excepcion:");
					System.out.println(e.getMessage());
					//Enviamos este mensaje al cliente
					respondeCliente("Error "+ server.getLocalSocketAddress(),server);
					System.out.println("Una Excepcion (hecho)");
					if(!server.isClosed()) {
						server.close();
					}
				}
			}
		}
		catch(SocketException se) {
			if(para) {
				System.out.println("Cierra el Servidor");
			}
			else {
				se.printStackTrace();
			}
		}
		catch(final UnknownHostException ex) {
			ex.printStackTrace();
		}
		catch(final IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public String envia(Persona persona) {
		//Se conecta a un servidor Sockets y proporciona los datos de la persona
		try {
			Socket socket;
			try {
				socket = new Socket(this.servidor, this.PORT);
			} catch (final IOException ioe) {
				System.out.println(">>>");
				System.out.println(ioe.getMessage());
				System.out.println(">>>");
				throw ioe;
			}
			System.out.println("Enviando datos Persona");
			//Obtiene el stream de salida para escribir en el socket
			final OutputStream os = socket.getOutputStream();
			byte[] b = aplana(persona).getBytes();
			for (int i = 0; i < b.length; i++) {
				os.write(b[i]);
			}
			os.flush();
			socket.shutdownOutput();

			//Cierra el socket
			socket.close();
		} catch (final IOException ioe) {
			ioe.printStackTrace();
			return "Ko";
		}
		return "Ok";
	}

	@Override
	public Estado procesa(String DNI) {
		if(DNI.toLowerCase().compareTo("09781214g")==0) {
			Estado est=new Estado();
			Persona per=new Persona();
			per.setApellido("Garcia San Martin");
			per.setNombre("Eugenio");
			per.setDNI(DNI);
			per.setEdad("xxx");
			est.setCodigo("Ok");
			est.setPers(per);
			this.servicio.notifica(per);
			return est;
		}
		else {
			Estado est= this.servicio.checkPersona(DNI);
			this.servicio.notifica(est.getPers());
			return est;
		}
	}

	private void respondeCliente(String mensaje,Socket salida) throws IOException ,SocketException{
		if(!salida.isClosed()) {
			OutputStream out=salida.getOutputStream();
			String resp=mensaje+";\n";
			byte[] b = resp.getBytes();
			for (int i = 0; i < b.length; i++) {
				out.write(b[i]);
			}
			out.flush();
		}
	}

	private String aplana(Persona per) {
		return per.getNombre()+","+per.getApellido()+","+per.getEdad()+","+per.getDNI()+";";
	}

	private Persona construye(String per ) throws Exception {
		char[] dummy=per.toCharArray();

		if(dummy[dummy.length-1]==';') {
		}
		else {
			throw new Exception("Formato incorrecto; No termina con ;");
		}
		String[] datos=per.substring(0,per.length()-1).split(",");
		if(datos.length!=4) {
			throw new Exception("Formato incorrecto; Faltan campos del dato Persona;");
		}
		Persona respuesta=new Persona();
		respuesta.setNombre(datos[0]);
		respuesta.setApellido(datos[1]);
		respuesta.setEdad(datos[2]);
		respuesta.setDNI(datos[3]);
		return respuesta;
	}
}
