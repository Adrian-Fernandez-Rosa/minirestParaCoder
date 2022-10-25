package ejemploAdrianFernandezR.demo.controllers;

import ejemploAdrianFernandezR.demo.excepciones.ResourceNotFoundException;
import ejemploAdrianFernandezR.demo.model.Libro;
import ejemploAdrianFernandezR.demo.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/libro")
@RestController
public class LibroController {


    @Autowired
    private LibroService libroService;


    @PostMapping()
    public ResponseEntity<Libro> create(@RequestBody Libro libro){
        return new ResponseEntity<>(libroService.create(libro), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Libro>> findAll(){
        return new ResponseEntity<>(libroService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> update(@RequestBody Libro libro, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.libroService.update(libro, id), HttpStatus.OK);
    }





}
