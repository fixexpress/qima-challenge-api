package com.qima.challenge.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qima.challenge.model.Category;
import com.qima.challenge.model.Product;

import java.io.InputStream;
import java.util.List;

public class DataLoaderTest {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<DataLoader.Data> typeReference = new TypeReference<DataLoader.Data>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/products.json");

            if (inputStream == null) {
                throw new RuntimeException("products.json not found");
            }

            DataLoader.Data data = mapper.readValue(inputStream, typeReference);

            List<Category> categories = data.getCategories();
            System.out.println("Categories loaded: " + categories.size());

            for (Category category : categories) {
                System.out.println("Category: " + category.getName());
                List<Product> products = category.getProducts();
                System.out.println("Products in category '" + category.getName() + "': " + products.size());
                
                for (Product product : products) {
                    System.out.println("Product Name: " + product.getName() + ", Price: " + product.getPrice());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
