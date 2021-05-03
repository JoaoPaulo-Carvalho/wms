package com.araujojpc.wms.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.araujojpc.wms.entities.Item;

@Service
public class ItemService {

	public List<Item> findAll() {
		Item i1 = new Item(1L, "Pencil");
		Item i2 = new Item(2L, "Eraser");
		
		return Arrays.asList(i1, i2);
	}

}
