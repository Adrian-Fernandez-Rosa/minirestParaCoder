package ejemploAdrianFernandezR.demo.controllers;

import ejemploAdrianFernandezR.demo.excepciones.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler({ResourceNotFoundException.class, IllegalArgumentException.class})
        public ResponseEntity<String> resourceNotFoundException(Exception ex){
            return new ResponseEntity<>("EL Libro o Socio NO EXISTEN", HttpStatus.NOT_FOUND);
        }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception ex){
        return new ResponseEntity<>("No hay Stock suficiente", HttpStatus.NOT_FOUND);
    }




}
