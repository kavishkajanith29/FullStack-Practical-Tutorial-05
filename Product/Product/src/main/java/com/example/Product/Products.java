package com.example.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "Products")
public class Products {
    private ObjectId id;
    private String productID;
    private String name;
    private double price;
    public String setId(String id) {
        return this. productID;
    }
    public String getId() {
        return productID;
    }
}
