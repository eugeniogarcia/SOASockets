package euge.com.examples.demo.configuracion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import euge.soa.example.beans.beanPersonas;
import euge.soa.example.modelo.Estado;

public class pruebaBeanFusion implements CommandLineRunner{
	private static Logger log=LoggerFactory.getLogger(pruebaBeanFusion.class);
	@Autowired
	beanPersonas beanAProbar;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Estado est=beanAProbar.procesa("1234567g");
		String resp=beanAProbar.envia(est.getPers());
		log.info(resp);
		beanAProbar.para();
	}

}
