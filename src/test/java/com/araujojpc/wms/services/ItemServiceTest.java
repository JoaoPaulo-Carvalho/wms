package com.araujojpc.wms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.araujojpc.wms.entities.Category;
import com.araujojpc.wms.entities.Item;

@SpringBootTest
class ItemServiceTest {

	@Autowired
	private ItemService service;
	
	Category ct1;
	Category ct2;
	Category ct3;

	Item it1;
	Item it2;
	Item it3;
	Item it4;
	Item it5;

	@BeforeEach
	public void initAll() {
		ct1 = new Category(1L, "Stationery");
		ct2 = new Category(2L, "Computer");
		ct3 = new Category(3L, "Musical Instrument");

		it1 = new Item(1L, "Pencil", ct1);
		it2 = new Item(2L, "Mouse", ct2);
		it3 = new Item(3L, "Eraser", ct1);
		it4 = new Item(4L, "Laptop", ct2);
		it5 = new Item(5L, "Guitar", ct3);
	}

	@Test
	void findByIdShouldGetItems() {
		long id = it1.getId();
		
		assertEquals(it1, service.findById(id));
	}
	
	@Test
	void findAllShouldGetItems() {		
		assertEquals(Arrays.asList(it1, it2, it3, it4, it5), service.findAll());
	}

}
