package com.application.demo.model;

import java.util.Date;
import java.util.List;

public record Cart(Integer cartId, List<Product> productList, Date orderDate) {
}
