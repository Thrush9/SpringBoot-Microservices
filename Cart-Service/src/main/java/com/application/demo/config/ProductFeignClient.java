package com.application.demo.config;

import com.application.demo.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductFeignClient {

    @GetMapping("/product/productEnvInfo")
    public ResponseEntity<String> getProductEnvInfo();

    @GetMapping("/product/productInfo")
    public ResponseEntity<Product> getProduct();
}
