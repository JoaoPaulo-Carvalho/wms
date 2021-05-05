package com.araujojpc.wms.resources;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.araujojpc.wms.services.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CategoryResource.class)
class CategoryResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategoryService service;

	ObjectMapper Obj;

	Category ct1;
	Category ct2;
	Category ct3;

	Category ct4;

	@BeforeEach
	public void init() {
		Obj = new ObjectMapper();

		ct1 = new Category(1L, "Stationery");
		ct2 = new Category(2L, "Computer");
		ct3 = new Category(3L, "Musical Instrument");

		ct4 = new Category(null, "Book");
	}

	@Test
	public void itemsShouldReturnFirst() throws Exception {
		long id = ct1.getId();

		when(service.findById(id)).thenReturn(ct1);

		this.mockMvc.perform(get("/categories/" + id)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(Obj.writeValueAsString(ct1)));
	}

	@Test
	public void itemsShouldReturnAll() throws Exception {
		List<Category> list = Arrays.asList(ct1, ct2, ct3);

		when(service.findAll()).thenReturn(list);

		this.mockMvc.perform(get("/categories")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(Obj.writeValueAsString(list)));
	}

	@Test
	public void itemsShouldBeInsertedAndReturned() throws Exception {
		this.mockMvc.perform(post("/categories").contentType("application/json").content(Obj.writeValueAsString(ct4)))
				.andDo(print()).andExpect(status().isCreated()).andExpect(content().json(Obj.writeValueAsString(ct4)));
	}

	@Test
	public void itemsShouldBeRemoved() throws Exception {
		this.mockMvc.perform(delete("/categories/" + ct1.getId())).andDo(print()).andExpect(status().isNoContent());
	}

	@Test
	public void itemsShouldBeUpdatedAndReturned() throws Exception {
		Category obj = new Category(2L, "Electronics");

		when(service.update(obj.getId(), obj)).thenReturn(obj);

		this.mockMvc
				.perform(put("/categories/" + obj.getId()).contentType("application/json")
						.content(Obj.writeValueAsString(obj)))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(Obj.writeValueAsString(obj)));
	}
}
