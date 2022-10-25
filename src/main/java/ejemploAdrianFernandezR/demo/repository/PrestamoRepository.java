package ejemploAdrianFernandezR.demo.repository;

import ejemploAdrianFernandezR.demo.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
