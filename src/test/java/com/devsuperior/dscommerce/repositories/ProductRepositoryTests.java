package com.devsuperior.dscommerce.repositories;

import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;
    private long existingId;
    private long nonExistingId;
    private long countTotalProducts;

    @BeforeEach
    public void setup() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        countTotalProducts = 25L;

    }


    @Test
    public void searchByNameShouldReturnProductsWhenNameContainsText() {
        //Arrange
        Product product = new Product();
        product.setName("Notebook Gamer");
        productRepository.save(product);

        //ACT
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> result = productRepository.searchByName("NOTE", pageable);

        //ASSERT
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getTotalElements());
        Assertions.assertEquals(1, result.getTotalPages());
        Assertions.assertFalse(result.getContent().isEmpty());
        Assertions.assertTrue(result.getContent().contains(product));
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists () {

       Assertions.assertDoesNotThrow(() -> {
           productRepository.deleteById(existingId);
       });

       Optional<Product> result = productRepository.findById(existingId);
       Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull () {

        Product product = Factory.createProduct();
        product.setId(null);

        productRepository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts + 1, product.getId());
    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalWhenIdExists () {

        Optional<Product> result = productRepository.findById(existingId);

        Assertions.assertTrue(result.isPresent());

    }

    @Test
    public void findByIdShouldReturnOptionalWhenIdDoesNotExist () {

        Optional<Product> result = productRepository.findById(nonExistingId);

        Assertions.assertTrue(result.isEmpty());

    }
}
