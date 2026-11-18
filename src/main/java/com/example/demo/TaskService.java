package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(Long id) {
        for (Task x : tasks) {
            if (x.getId().equals(id)) {
                return x;
            }
        }
        return null;
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public boolean updateTask(Long id, Task updatedTask) {
        for (Task x : tasks) {
            if (x.getId().equals(id)) {
                x.setTitle(updatedTask.getTitle());
                x.setCompleted(updatedTask.isCompleted());
                return true;
            }
        }
        return false;
    }

    public boolean deleteTask(Long id) {
        return tasks.removeIf(x -> x.getId().equals(id));
    }
}