package com.example.streamapitutorial.services.interfaces;

import com.example.streamapitutorial.dto.ProductDTO;
import com.example.streamapitutorial.models.Product;

import java.util.List;

public interface ProductInterface {

    ProductDTO addProduct(ProductDTO newProduct);

    List <Float> productPriceListWithoutStreams();

    List <Float> productPriceListWithStreams();

    List <ProductDTO> limitedNumberOfProducts();
}
