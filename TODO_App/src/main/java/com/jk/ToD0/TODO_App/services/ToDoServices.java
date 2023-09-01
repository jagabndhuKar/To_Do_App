package com.jk.ToD0.TODO_App.services;

import java.time.LocalDateTime;
import java.util.List;

import org.glassfish.jaxb.core.v2.TODO;

import com.jk.ToD0.TODO_App.Entety.ToDo;

public interface ToDoServices {
public LocalDateTime getPresentTime();
public ToDo saveTask(ToDo task);
public boolean isStartTimeValid(ToDo task);
public List<ToDo>getAllToDo();
public ToDo findTaskById(int id);
public void deleteToDo(int id);
}
