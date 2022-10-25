package ejemploAdrianFernandezR.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "libro")
public class Libro {

    @Id
    @Column(name = "id_libro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String autor;

    private String titulo;



    @Column(name= "numero_ejemplares")
    private int numeroEjemplares;








}
