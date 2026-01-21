package com.application.demo.controller;

import com.application.demo.config.ProductFeignClient;
import com.application.demo.config.ProductRestClient;
import com.application.demo.model.Cart;
import com.application.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductRestClient productRestClient;

    @Autowired
    private ProductFeignClient productFeignClient;

    @GetMapping("/cartInfo")
    public ResponseEntity<Cart> getProduct(){
        List<Product> productList = Arrays.asList(
                new Product(1,"Mobile","Electronics",1,29999.00),
                new Product(2,"Charger","Accessories",1,599.00),
                new Product(3,"EarPhones","Accessories",1,999.00));
        Cart cart = new Cart(111,productList,new Date());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/cartEnvInfo")
    public ResponseEntity<String> getCartEnvInfo(){
        String result = "From CartService calling :: " + productFeignClient.getProductEnvInfo().getBody();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/getProductInfoByRest")
    public ResponseEntity<Product> getProductInoByRest(){
        Product productResp = productRestClient.getProductInfo();
        System.out.println("Product Info From Rest Client " + productResp.toString());
        return new ResponseEntity<>(productResp, HttpStatus.OK);
    }

    @GetMapping("/getProductInfoByFeign")
    public ResponseEntity<Product> getProductInoByFeign(){
        Product productResp = productFeignClient.getProduct().getBody();
        System.out.println("Product Info From Feign Client " + productResp.toString());
        return new ResponseEntity<>(productResp, HttpStatus.OK);
    }

}
