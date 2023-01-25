package com.example.streamapitutorial.controllers;

import com.example.streamapitutorial.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.streamapitutorial.services.interfaces.ProductInterface;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductInterface productInterface;




    @PostMapping("/add-product")
    public ProductDTO addProduct(@RequestBody ProductDTO newProduct){
        return productInterface.addProduct(newProduct);
    }


    @GetMapping("/without-streams")
    public List<Float> productPriceListWithoutStreams(){
        return productInterface.productPriceListWithoutStreams();
    }

    @GetMapping("/with-streams")
    public List <Float> productPriceListWithStreams(){
        return productInterface.productPriceListWithStreams();
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts(){
        return productInterface.limitedNumberOfProducts();
    }

}
