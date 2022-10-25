package ejemploAdrianFernandezR.demo.services;

import ejemploAdrianFernandezR.demo.DTO.request.PrestamoRequest;
import ejemploAdrianFernandezR.demo.excepciones.ResourceNotFoundException;
import ejemploAdrianFernandezR.demo.model.Libro;
import ejemploAdrianFernandezR.demo.model.Prestamo;
import ejemploAdrianFernandezR.demo.model.Socio;
import ejemploAdrianFernandezR.demo.repository.LibroRepository;
import ejemploAdrianFernandezR.demo.repository.PrestamoRepository;
import ejemploAdrianFernandezR.demo.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private SocioRepository socioRepository;

    /**
     * TAREA: Para cumplir con la tarea del código limpio
     * deben separar este método en 2, este método cumple con 2 responsabilidades, que es validar
     * el prestamo y guardar,
     * @param prestamoRequest
     * @return
     * @throws Exception
     */
    public Prestamo create(PrestamoRequest prestamoRequest) throws Exception {

        Optional<Libro> libro= libroRepository.findById(prestamoRequest.getLibroID());

        Optional<Socio> socio = socioRepository.findById(prestamoRequest.getSocioID());

        if(libro.isPresent() && socio.isPresent()) {
            int cantidadLibros = libro.get().getNumeroEjemplares();

            if(cantidadLibros != 0 ){
                Prestamo prestamoBD = new Prestamo();

                //tenemos que disminuir la cantidad de ejemplares disponible en nuestro libro
                libro.get().setNumeroEjemplares(--cantidadLibros); // es lo mismo que colocar cantidadLibros-1

                prestamoBD.setLibro(libro.get());
                prestamoBD.setEstadoPrestamo(true);
                prestamoBD.setFechaPrestamo(prestamoRequest.getFechaPrestamo());
                prestamoBD.setFechaDevolucion(prestamoRequest.getFechaDevolucion());
                prestamoBD.setSocio(socio.get());

                return prestamoRepository.save(prestamoBD);

            } else {
                throw new Exception("No hay stock de ete libro");
            }
        }

            throw new ResourceNotFoundException("El libro o el socio no existen");


       }


}


