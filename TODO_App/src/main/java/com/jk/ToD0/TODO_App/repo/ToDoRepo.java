package com.jk.ToD0.TODO_App.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jk.ToD0.TODO_App.Entety.ToDo;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Integer>{

}
