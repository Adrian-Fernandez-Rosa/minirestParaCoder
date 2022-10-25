package ejemploAdrianFernandezR.demo.repository;

import ejemploAdrianFernandezR.demo.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio, Long> {
}
