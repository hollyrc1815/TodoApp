package com.TechTalentSouth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.TechTalentSouth.model.TodoList;
import com.TechTalentSouth.repository.TodoRepository;



@Controller
@RequestMapping
public class TodoController {

	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping(value="/")
	public String index(TodoList todoList, Model model) {
		model.addAttribute("todo", todoRepository.findAll());
		return "index";
	    }
	
	
	@PostMapping(value = "/")
	public String create(TodoList todoList, Model model) {
		
	    
			model.addAttribute("title", todoList.getTitle());
			model.addAttribute("author", todoList.getAuthor());
	        model.addAttribute("todo", todoList.getTodo());
	        model.addAttribute("difficulty", todoList.getDifficulty());
	        model.addAttribute("createdAt", todoList.getCreatedAt());
	        model.addAttribute("dateDue", todoList.getDateDue());
	        model.addAttribute("status", todoList.getStatus());
	        todoRepository.save(todoList);
	        return "result";
	}
	
	@GetMapping(value = "/new")
    public String newTodo (TodoList todoList) {
        return "new";
    }
	
	@RequestMapping(value = "/todo_list/{id}", method = RequestMethod.DELETE)
    public String deletePostWithId(@PathVariable Long id, TodoList todoList, Model model) {
		todoRepository.deleteById(id);
        model.addAttribute("todos", todoRepository.findAll());
        return "deleted";
    }
	
//	@RequestMapping(value = "/todo_list/{id}", method = RequestMethod.DELETE)
//    public String deletePostWithId(@PathVariable Long id, TodoList todoList, Model model) {
//		todoRepository.deleteById(id);
//        model.addAttribute("todos", todoRepository.findAll());
//        return "index";
//    }
	
	
	@RequestMapping(value = "/todo_list/show/{id}", method = RequestMethod.GET)
    public String getPostWithId(@PathVariable Long id, Model model) {
		TodoList todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID:" + id));
    	model.addAttribute("todo", todo);
        return "show";
    }
	
	 @RequestMapping(value = "/todo_list/edit/{id}", method = RequestMethod.GET)
	    public String editPostWithId(@PathVariable Long id, Model model) {
		 	TodoList todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID: " + id));
	    	model.addAttribute("todo", todo);
	        return "edit";
	    }
	
	 @RequestMapping(value="/todoList/edit/{id}", method=RequestMethod.PUT)
	    public String updatePostById(@PathVariable Long id, Model model, TodoList formData) {
		 	TodoList todo = todoRepository.findById(id).orElse(null);
		 	todo.setAuthor(formData.getAuthor());
		 	todo.setTitle(formData.getTitle());
		 	todo.setTodo(formData.getTodo());
		 	todo.setDifficulty(formData.getDifficulty());
		 	todo.setDateDue(formData.getDateDue());
		 	todo.setStatus(formData.getStatus());
		 	todoRepository.save(todo);
	    	model.addAttribute("title", todo.getTitle());
	    	model.addAttribute("author", todo.getAuthor());
	    	model.addAttribute("todo", todo.getTodo());
	    	model.addAttribute("difficulty", todo.getDifficulty());
	    	model.addAttribute("id", todo.getId());
	    	model.addAttribute("dateDue", todo.getDateDue());
	    	model.addAttribute("status", todo.getStatus());
	    	return "result";
	    }
	
	
	
	
	
	
	
	
	
	
	
}