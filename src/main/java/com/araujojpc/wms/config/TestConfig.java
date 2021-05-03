package com.araujojpc.wms.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.araujojpc.wms.entities.Category;
import com.araujojpc.wms.entities.Item;
import com.araujojpc.wms.entities.Movement;
import com.araujojpc.wms.repositories.CategoryRepository;
import com.araujojpc.wms.repositories.ItemRepository;
import com.araujojpc.wms.repositories.MovementRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private MovementRepository movementRepository;

	@Override
	public void run(String... args) throws Exception {

		Category ct1 = new Category(null, "Stationery");
		Category ct2 = new Category(null, "Computer");
		Category ct3 = new Category(null, "Musical Instrument");

		categoryRepository.saveAll(Arrays.asList(ct1, ct2, ct3));

		Item it1 = new Item(null, "Pencil", ct1);
		Item it2 = new Item(null, "Mouse", ct2);
		Item it3 = new Item(null, "Eraser", ct1);
		Item it4 = new Item(null, "Laptop", ct2);
		Item it5 = new Item(null, "Guitar", ct3);

		itemRepository.saveAll(Arrays.asList(it1, it2, it3, it4, it5));

		Movement mv1 = new Movement(null, Instant.now(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		Movement mv2 = new Movement(null, Instant.now(),
				"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");

		movementRepository.saveAll(Arrays.asList(mv1, mv2));

	}
}
