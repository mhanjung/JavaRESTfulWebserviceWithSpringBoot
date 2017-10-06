package com.example.javarestfulwebserviceswithspringboot.controller;

import com.example.javarestfulwebserviceswithspringboot.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    static final Logger log = LoggerFactory.getLogger(ProductRestController.class);

    @RequestMapping(value = "find", method = RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> find() {
        try {
            Product product = new Product("p01", "name1");
            log.info(product.toString());
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "findall", method = RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Product>> findall() {
        try {
            List<Product> products = new ArrayList<Product>();
            products.add(new Product("p01", "name1"));
            products.add(new Product("p02", "name2"));
            products.add(new Product("p03", "name3"));
            log.info(products.toString());

            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
        }
    }
}
