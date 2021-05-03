package com.araujojpc.wms.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.araujojpc.wms.entities.Item;
import com.araujojpc.wms.repositories.ItemRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void run(String... args) throws Exception {

		Item it1 = new Item(null, "Pencil");
		Item it2 = new Item(null, "Mouse");
		Item it3 = new Item(null, "Eraser");
		Item it4 = new Item(null, "Laptop");
		Item it5 = new Item(null, "Guitar");

		itemRepository.saveAll(Arrays.asList(it1, it2, it3, it4, it5));

	}
}
