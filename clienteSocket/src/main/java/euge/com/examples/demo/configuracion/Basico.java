package euge.com.examples.demo.configuracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

public class Basico implements CommandLineRunner{

	@Value("${servidor}")
	private String servidor="127.0.0.1";
	final private int PORT = 12112;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try {
			Socket socket;
			try {
				socket = new Socket(servidor, PORT);
			} catch (final IOException ioe) {
				System.out.println(">>>");
				System.out.println(ioe.getMessage());
				System.out.println(">>>");
				throw ioe;
			}
			System.out.println("sending data: EmpDetails;");
			//Obtiene el stream de salida para escribir en el socket
			final OutputStream os = socket.getOutputStream();
			byte[] b = "egsmartin,******;fn111111ln111111232007-01-01100\nfn211111ln211111232007-11-01200\nfn311111ln311111232007-12-01300".getBytes();
			for (int i = 0; i < b.length; i++) {
				os.write(b[i]);
			}
			os.flush();
			socket.shutdownOutput();

			//Escucha el socket
			System.out.println("receiving data");
			final BufferedReader soc_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			final String successCode = soc_in.readLine();
			System.out.println("Codigo de retorno: " + successCode);

			//Cierra el socket
			socket.close();
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		}
	}


}
