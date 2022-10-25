package ejemploAdrianFernandezR.demo.controllers;

import ejemploAdrianFernandezR.demo.DTO.request.PrestamoRequest;
import ejemploAdrianFernandezR.demo.DTO.response.PrestamoResponse;
import ejemploAdrianFernandezR.demo.excepciones.ResourceNotFoundException;
import ejemploAdrianFernandezR.demo.model.Prestamo;
import ejemploAdrianFernandezR.demo.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/prestamo")
@RestController
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping()
    public ResponseEntity<Prestamo> create(@RequestBody PrestamoRequest prestamoRequest) throws Exception, ResourceNotFoundException {
        return new ResponseEntity<>(prestamoService.create(prestamoRequest), HttpStatus.OK);
    }

}
