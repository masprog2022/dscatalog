package com.masprogtechs.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.masprogtechs.dscatalog.entities.Product;

@DataJpaTest
public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository repository;
	
	@Test
	public void deleteShouldDeleteObjectWhenIdexist() {
		
		long existingId = 1L;
		
		repository.deleteById(existingId);
		
		Optional<Product> result = repository.findById(existingId);
		Assertions.assertFalse(result.isPresent());;
		
	}
	
	@Test
	public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
		
		long nonExistingId = 1000L;
		
		Assertions.assertThrows(EmptyResultDataAccessException.class, ()->{
			repository.deleteById(nonExistingId);
		});
	}

}
