package com.example.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ProductRepository extends MongoRepository<Products,
        ObjectId>{
    Optional<Products> findProductsByProductID(String productId);
    @DeleteQuery(value = "{ 'productID' : ?0 }")
    void deleteProductsByProductID(String productId);
}
