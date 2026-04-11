package com.devsuperior.dscommerce.service;

import com.devsuperior.dscommerce.dto.ProductMinDTO;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.ProductService;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ProductServiceIT {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    private Long existingId;
    private Long nonExistingId;
    private Long countTotalProducts;


    @BeforeEach
    public void setUp() throws Exception {
        existingId = 25L;
        nonExistingId = 1000L;
        countTotalProducts = 25L;
    }

    @Test
    public void deleteShouldDeleteResourceWhenIdExists()   {

        productService.delete(existingId);

        Assertions.assertEquals(countTotalProducts - 1, productRepository.count());

    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist()   {

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            productService.delete(nonExistingId);
        });
    }

    @Test
    public void findAllPagedShouldReturnPageWhenPage0Size10()  {
        PageRequest pageRequest = PageRequest.of(0, 10);

        Page<ProductMinDTO> result = productService.findAllPaged("PC", pageRequest );

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(0, result.getNumber());
        Assertions.assertEquals(10, result.getSize());
        Assertions.assertEquals(countTotalProducts - 4, result.getTotalElements());

    }

    @Test
    public void findAllPagedShouldReturnEmptyPageWhenPageDoesNotExist()  {
        PageRequest pageRequest = PageRequest.of(50, 10);

        Page<ProductMinDTO> result = productService.findAllPaged("PC", pageRequest );

        Assertions.assertTrue(result.isEmpty());

    }

    @Test
    public void findAllPagedShouldReturnSortedPageWhenSortByName()  {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("name"));

        Page<ProductMinDTO> result = productService.findAllPaged("PC", pageRequest );

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals("PC Gamer", result.getContent().get(0).getName());
        Assertions.assertEquals("PC Gamer Alfa", result.getContent().get(1).getName());
        Assertions.assertEquals("PC Gamer Boo", result.getContent().get(2).getName());

    }

}
