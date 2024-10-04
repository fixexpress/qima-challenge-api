package com.qima.challenge.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qima.challenge.model.Category;
import com.qima.challenge.model.Product;
import com.qima.challenge.repository.CategoryRepository;
import com.qima.challenge.repository.ProductRepository;

@Component
public class DataLoader implements CommandLineRunner {


    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ProductRepository productRepository;    

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    public void loadData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Data> typeReference = new TypeReference<Data>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/products.json");

        if (inputStream == null) {
            throw new RuntimeException("products.json not found");
        }

        Data data = mapper.readValue(inputStream, typeReference);

        for (Category category : data.getCategories()) {
            if (category.getProducts() == null) {
                category.setProducts(new ArrayList<>());
            }
            
            Category savedCategory = categoryRepository.save(category); 
            
            for (Product product : category.getProducts()) {
                product.setCategory(savedCategory); 
                productRepository.save(product); 
            }
        }
    }

    static class Data {
        private List<Category> categories;

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }
    }
}
