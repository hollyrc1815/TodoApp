package com.TechTalentSouth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TechTalentSouth.model.TodoList;

@Repository
public interface TodoRepository extends CrudRepository<TodoList, Long>{

}
