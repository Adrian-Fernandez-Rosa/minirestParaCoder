package ejemploAdrianFernandezR.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @Column(name = "id_prestamo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //TemporalType.DATE: Acotara el campo solo a la Fecha, descartando la hora.
    @Temporal(TemporalType.DATE)
    //datetimeformat formato de fecha
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPrestamo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaDevolucion;


    private boolean estadoPrestamo;

    @ManyToOne(cascade = CascadeType.MERGE)
    //CascadeType.MERGE Propaga la actualización en la base de datos de una entidad a las entidades relacionadas.
    @JoinColumn(name = "libro_id")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

}
