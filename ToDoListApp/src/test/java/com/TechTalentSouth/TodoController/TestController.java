package com.TechTalentSouth.TodoController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestController {

	
	@Autowired
    private com.TechTalentSouth.controller.TodoController TodoController;
	
	com.TechTalentSouth.controller.TodoController todoController = new com.TechTalentSouth.controller.TodoController();
	
	@Test
    public void contextLoads() throws Exception {
		assertThat(TodoController).isNotNull();
    }
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void shouldReturnIndex() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
                
    }
	
	@Test
    public void shouldReturnNewPage() throws Exception {
        this.mockMvc.perform(get("/new")).andDo(print()).andExpect(status().isOk());
                
    }
   
//	@Test
//    public void shouldReturnShowPage() throws Exception {
//        this.mockMvc.perform(get("/show")).andDo(print()).andExpect(status().isOk());
//                
//    }
	
	
//	@Test
//    public void shouldReturnResultPage() throws Exception {
//        this.mockMvc.perform(get("/result")).andDo(print()).andExpect(status().isOk());
//                
//    }
//	
//	@Test
//    public void shouldReturnDeletedPage() throws Exception {
//        this.mockMvc.perform(get("/deleted")).andDo(print()).andExpect(status().isOk());
//                
//    }
//	
//	@Test
//    public void shouldReturnEditPage() throws Exception {
//        this.mockMvc.perform(get("/edit")).andDo(print()).andExpect(status().isOk());
//                
//    }
	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@Test
//	public void testIndex() {
//		assertThat(todoController.index(TodoList, Model)).isNotNull();
//	}
//
//	@Test
//	public void testCreate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testNewTodo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeletePostWithId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPostWithId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testEditPostWithId() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdatePostById() {
//		fail("Not yet implemented");
//	}

}
