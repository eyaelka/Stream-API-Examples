package com.example.streamapitutorial.services.implementations;

import com.example.streamapitutorial.dto.ProductDTO;
import com.example.streamapitutorial.models.Product;
import com.example.streamapitutorial.services.interfaces.ProductInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.streamapitutorial.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductInterface {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDTO addProduct(ProductDTO newProduct) {
        Product product = new Product();
        product.setId(null);
        product.setProductName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productRepository.save(product);

        return modelMapper.map(product,ProductDTO.class);
    }

    @Override
    public List<Float> productPriceListWithoutStreams() {

        List<Product> products = productRepository.findAll();

        ArrayList< Float > priceList = new ArrayList<>();
        for (Product prod : products){
            if (prod.getPrice() > 20){
                priceList.add(prod.getPrice());
            }
        }
        return priceList;
    }

    @Override
    public List<Float> productPriceListWithStreams() {
        List< Product> products = productRepository.findAll();
        return products.stream()
                .map(Product::getPrice)
                .filter(price -> price >20).toList();
    }

    @Override
    public List<ProductDTO> limitedNumberOfProducts() {
        List< Product> products = productRepository.findAll();

        List <ProductDTO> productDTOs= products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class)).toList();

        return productDTOs.stream().limit(2).toList();
    }
}
