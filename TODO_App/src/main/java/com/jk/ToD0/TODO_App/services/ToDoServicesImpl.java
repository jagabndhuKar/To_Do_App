package com.jk.ToD0.TODO_App.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.ToD0.TODO_App.Entety.ToDo;
import com.jk.ToD0.TODO_App.repo.ToDoRepo;

@Service
public class ToDoServicesImpl implements ToDoServices {

	@Autowired
	protected ToDoRepo toDoRepo;

	@Override
	public LocalDateTime getPresentTime() {
		return LocalDateTime.now();
	}

	@Override
	public ToDo saveTask(ToDo task) {
		if (task.getStartTime() == null) {
			task.setStartTime(makeDateTime(getPresentTime()));
		} else {
			task.setStartTime(makeDateTime(task.getStartTime()));

		}
		return toDoRepo.save(task);
	}

	@Override
	public boolean isStartTimeValid(ToDo task) {
		return false;
	}

	@Override
	public List<ToDo> getAllToDo() {
		return toDoRepo.findAll();
	}

	@Override
	public ToDo findTaskById(int id) {

		return toDoRepo.findById(id).get();
	}

	private LocalDateTime makeDateTime(LocalDateTime dateTime) {
		String pattern = "yyyy-MM-dd HH:mm";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		String formattedDateTimeString = dateTime.format(formatter);
		LocalDateTime formattedDateTime = LocalDateTime.parse(formattedDateTimeString, formatter);
		return formattedDateTime;
	}

	@Override
	public void deleteToDo(int id) {
		toDoRepo.deleteById(id);
	}
}
