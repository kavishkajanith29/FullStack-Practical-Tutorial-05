package com.example.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts(){
        return new ResponseEntity<List<Products>>(productService.allProducts(), HttpStatus.OK);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<Optional<Products>> getSingleProduct(@PathVariable String productId ){
        return new ResponseEntity<Optional<Products>>(productService.singleProduct(productId),HttpStatus.OK );
    }
    @PostMapping
    public ResponseEntity<Products> addProduct(@RequestBody Products product)
    {
        Products savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    @PutMapping("/{productId}")
    public ResponseEntity<Products> updateProduct(@PathVariable String productId, @RequestBody Products updatedProduct) {
        Products updated = productService.updateProduct(productId, updatedProduct);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId)
    {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}