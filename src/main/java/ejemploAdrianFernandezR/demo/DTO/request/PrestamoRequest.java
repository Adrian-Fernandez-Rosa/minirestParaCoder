package ejemploAdrianFernandezR.demo.DTO.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
public class PrestamoRequest {

    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPrestamo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaDevolucion;

    private boolean estadoPrestamo;

    private long libroID;

    private long socioID;



}
