package ejemploAdrianFernandezR.demo.repository;

import ejemploAdrianFernandezR.demo.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
