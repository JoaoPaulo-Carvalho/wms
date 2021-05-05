package com.araujojpc.wms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.araujojpc.wms.entities.Category;
import com.araujojpc.wms.entities.Item;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

	Item it6;

	@BeforeAll
	public void init() {
		ct1 = new Category(1L, "Stationery");
		ct2 = new Category(2L, "Computer");
		ct3 = new Category(3L, "Musical Instrument");

		it1 = new Item(1L, "Pencil", ct1);
		it2 = new Item(2L, "Mouse", ct2);
		it3 = new Item(3L, "Eraser", ct1);
		it4 = new Item(4L, "Laptop", ct2);
		it5 = new Item(5L, "Guitar", ct3);

		it6 = new Item(null, "iPhone", ct2);
	}

	@Test
	void insertShouldSaveNewItem() {
		service.insert(it6);
		assertEquals(it6, service.findById(6L));
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

	@AfterEach
	void tearDown() {
		if (it6.getId() != null && it6.getId() == 6L) {
			service.delete(6L);
			it6.setId(null);
		}
	}

}
