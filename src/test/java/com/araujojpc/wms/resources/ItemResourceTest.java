package com.araujojpc.wms.resources;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.araujojpc.wms.entities.Category;
import com.araujojpc.wms.entities.Item;
import com.araujojpc.wms.services.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ItemResource.class)
class ItemResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemService service;

	ObjectMapper Obj;

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
		Obj = new ObjectMapper();

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
	public void itemsShouldReturnFirst() throws Exception {
		long id = it1.getId();

		when(service.findById(id)).thenReturn(it1);

		this.mockMvc.perform(get("/items/" + id)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(Obj.writeValueAsString(it1)));
	}

	@Test
	public void itemsShouldReturnAll() throws Exception {
		List<Item> list = Arrays.asList(it1, it2, it3, it4, it5);
		
		when(service.findAll()).thenReturn(list);

		this.mockMvc.perform(get("/items")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(Obj.writeValueAsString(list)));
	}

}
