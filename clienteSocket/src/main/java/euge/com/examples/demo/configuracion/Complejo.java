package euge.com.examples.demo.configuracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

public class Complejo implements CommandLineRunner{

	@Value("${servidor}")
	private String servidor="127.0.0.1";
	final private int PORT = 12110;

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
			final BufferedReader soc_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			byte[] b = "egsmartin,pass;".getBytes();
			for (int i = 0; i < b.length; i++) {
				os.write(b[i]);
			}
			os.flush();

			String Code;
			Code = soc_in.readLine();
			switch(Code) {
			case "0x02":
				System.out.println("Usuario incorrecto");
				Code = soc_in.readLine();
				System.out.println("Codigo de retorno: " + Code);
				break;
			case "0x03":
				System.out.println("Password incorrecta");
				break;
			case "0x01":
				System.out.println("Ok");
				byte[] b1 = "egsmartin,*****;fn111111ln111111232007-01-01100\nfn211111ln211111232007-11-01200\nfn311111ln311111232007-12-01300".getBytes();
				for (int i = 0; i < b1.length; i++) {
					os.write(b1[i]);
				}
				os.flush();
				socket.shutdownOutput();
				break;
			}
			//Cierra el socket
			socket.close();
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
