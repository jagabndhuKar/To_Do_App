package com.jk.ToD0.TODO_App.Entety;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo_table")
public class ToDo {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	private String task;
	private boolean isFinish;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "ToDo [Id=" + Id + ", task=" + task + ", isFinish=" + isFinish + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, endTime, isFinish, startTime, task);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDo other = (ToDo) obj;
		return Id == other.Id && Objects.equals(endTime, other.endTime) && isFinish == other.isFinish
				&& Objects.equals(startTime, other.startTime) && Objects.equals(task, other.task);
	}

}
