package com.example.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Products> allProducts(){
        return productRepository.findAll();
    }
    public Optional<Products> singleProduct(String productId){
        return productRepository.findProductsByProductID(productId);
    }
    public Products addProduct(Products product) {
        return productRepository.save(product);
    }
    public Products updateProduct(String productId, Products updatedProduct)
    {
        Optional<Products> existingProduct =
                productRepository.findProductsByProductID(productId);
        if (existingProduct.isPresent()) {
            Products productToUpdate = existingProduct.get();
            productToUpdate.setPrice(updatedProduct.getPrice());
            productToUpdate.setName(updatedProduct.getName());
// Add other fields that you want to update
            return productRepository.save(productToUpdate);
        } else {
            throw new RuntimeException("Product with ID " + productId + " not found");
        }
    }
    public void deleteProduct(String productId) {
        productRepository.deleteProductsByProductID(productId);
    }
}