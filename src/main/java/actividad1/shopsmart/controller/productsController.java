package actividad1.shopsmart.controller;

import actividad1.shopsmart.model.products;
import actividad1.shopsmart.repository.productsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class productsController {

    @Autowired
    private productsRepository productsRepository;

    @GetMapping
    public ResponseEntity<List <products>> getAllProducts(){
        List<products> products = productsRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public products post(@RequestBody products product){
        return productsRepository.save(product);
    }


}
