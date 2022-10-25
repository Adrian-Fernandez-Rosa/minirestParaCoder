package ejemploAdrianFernandezR.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "socio")
public class Socio {


    @Id
    @Column(name = "id_socio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_apellido")
    private String nombreApellido;

    private int dni;

    private long telefono;

}
