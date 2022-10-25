package ejemploAdrianFernandezR.demo;

import ejemploAdrianFernandezR.demo.model.Libro;
import ejemploAdrianFernandezR.demo.model.Prestamo;
import ejemploAdrianFernandezR.demo.model.Socio;
import ejemploAdrianFernandezR.demo.repository.LibroRepository;
import ejemploAdrianFernandezR.demo.repository.PrestamoRepository;
import ejemploAdrianFernandezR.demo.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private PrestamoRepository prestamoRepository;

	@Autowired
	private SocioRepository socioRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("*******************************************************");


		Libro libro = new Libro(1, "Garcia M","Cronicas del mañana",4);

		libroRepository.save(libro);

		Socio socio = new Socio(1,"Juan Perez",12345678,54300120341042L);

		socioRepository.save(socio);

		Socio socio2 =new Socio(2,"Juancito2",12345679,543000L);

		socioRepository.save(socio2);


		Prestamo prestamo = new Prestamo(1,new Date(2022-1900,10,24),new Date(2022-1900,10,26),false,libro,socio);

		Prestamo prestamo2 = new Prestamo(2,new Date(2022-1900,10,24),new Date(2022-1900,10,26),true,libro,socio2);


		prestamoRepository.save(prestamo);

		prestamoRepository.save(prestamo2);

		prestamo2.getLibro().setNumeroEjemplares(prestamo2.getLibro().getNumeroEjemplares()-1);

		prestamoRepository.save(prestamo2);
	}

}
