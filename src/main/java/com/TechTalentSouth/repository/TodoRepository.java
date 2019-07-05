package com.TechTalentSouth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TechTalentSouth.model.TodoList;



@Repository
public interface TodoRepository extends CrudRepository<TodoList, Long>{

	public List<TodoList> findByOrderByDateDueAsc();
}
