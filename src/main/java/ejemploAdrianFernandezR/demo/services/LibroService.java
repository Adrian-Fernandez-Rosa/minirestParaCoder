package ejemploAdrianFernandezR.demo.services;

import ejemploAdrianFernandezR.demo.excepciones.ResourceNotFoundException;
import ejemploAdrianFernandezR.demo.model.Libro;
import ejemploAdrianFernandezR.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;


    /**
     * Crear Libro
      */

    public Libro  create(Libro newLibro){

        return libroRepository.save(newLibro);
    }


    /**
     * Obtener un Libro
     */

    public Libro obtenerLibro(Long id) throws ResourceNotFoundException {

        Optional<Libro> libroBD = libroRepository.findById(id);

        if(libroBD.isPresent()){
            Libro libro = libroBD.get();

            return libro;
        }else {
            throw new ResourceNotFoundException("El libro no existe");
        }
    }

    /**
     * Obtener todos los libros
     */

    public List<Libro> findAll(){
        return libroRepository.findAll();
    }


    /**
     * Actualizar Libro
     */
    public Libro update(Libro libro, Long id) throws ResourceNotFoundException{

        Libro libroBD= obtenerLibro(id);

        libroBD.setTitulo(libro.getTitulo());
        libroBD.setAutor(libro.getTitulo());
        libroBD.setNumeroEjemplares(libro.getNumeroEjemplares());

        return libroRepository.save(libroBD);


    }


    /**
     * Eliminar Libro
     */

    public void delete(Long id) {

        libroRepository.deleteById(id);
    }



}
