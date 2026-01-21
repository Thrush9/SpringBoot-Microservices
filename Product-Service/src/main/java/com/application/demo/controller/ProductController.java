package com.application.demo.controller;

import com.application.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private Environment environment;

    @GetMapping("/productInfo")
    public ResponseEntity<Product> getProduct(){
        Product product = new Product(1,"Mobile","Electronics",1,29999.00);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/productEnvInfo")
    public ResponseEntity<String> getProductEnvInfo(){
        String result = "Product-Service running on Port ::: " + environment.getProperty("local.server.port");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
