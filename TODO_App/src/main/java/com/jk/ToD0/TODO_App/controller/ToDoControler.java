package com.jk.ToD0.TODO_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jk.ToD0.TODO_App.Entety.ToDo;
import com.jk.ToD0.TODO_App.services.ToDoServices;

@RestController
public class ToDoControler {

	@Autowired
	protected ToDoServices toDoServices;

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@GetMapping("/add_task")
	public ModelAndView addTask() {
		return new ModelAndView("add_task");
	}

	@GetMapping("/all_task")
	public ModelAndView pandingTask() {
		ModelAndView allToDos = new ModelAndView();
		List<ToDo> toDoList = toDoServices.getAllToDo();
		allToDos.setViewName("all_task");
		allToDos.addObject("allToDo", toDoList);
		return allToDos;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute ToDo task,
			@RequestParam(value = "isFinish", defaultValue = "false") Boolean isFinish) {
		ModelAndView modelAndView = new ModelAndView("add_task");
		if (task.getTask().isEmpty()) {
			modelAndView.addObject("taskNameError", "Task name is required");
		}
		if (task.getStartTime() == null) {
			task.setStartTime(toDoServices.getPresentTime());
		}
		if (modelAndView.getModel().containsKey("taskNameError")
				|| modelAndView.getModel().containsKey("otherFieldError")) {
			return modelAndView;
		}
		task.setFinish(isFinish);
		toDoServices.saveTask(task);
		return new ModelAndView("redirect:/all_task");
	}

	@RequestMapping("/edit_task/{id}")
	public ModelAndView editTask(@PathVariable int id, Model model) {
		ToDo upDatedTask = toDoServices.findTaskById(id);
		model.addAttribute("upDatedTask", upDatedTask);
		return new ModelAndView("edit_task");
	}
	
	@RequestMapping("/delete_task/{id}")
	public ModelAndView deleteTask(@PathVariable int id) {
		toDoServices.deleteToDo(id);
		return new ModelAndView("redirect:/all_task");
	}
}
