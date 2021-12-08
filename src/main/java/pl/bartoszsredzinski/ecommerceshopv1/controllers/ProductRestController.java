package pl.bartoszsredzinski.ecommerceshopv1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product/")
public class ProductRestController{

    @GetMapping("{id}")
    public String getProductById(@PathVariable Integer id){
        return "apple: " + id.toString();
    }

}
