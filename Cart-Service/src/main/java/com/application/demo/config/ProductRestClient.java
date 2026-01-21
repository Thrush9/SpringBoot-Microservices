package com.application.demo.config;

import com.application.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductRestClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public Product getProductInfo() {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("PRODUCT-SERVICE");
        String apiUrl = serviceInstanceList.get(0).getUri() + "/product/productInfo";
        RestTemplate restTemplate = new RestTemplate();
        Product productResp = restTemplate.getForObject(apiUrl,Product.class);
        return productResp;
    }
}
