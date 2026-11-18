package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@RestController 
@RequestMapping("/task")
public class TaskController {
private List<Task>tasks  = new ArrayList<>();
@GetMapping
public List<Task> getTasks() {
    return tasks;
}
@GetMapping("/{id}")
public Task getTask(@PathVariable Long id) {
    for(Task x:tasks){
        if(x.getId().equals(id)){
            return x;
        }
    }
    System.out.println("Task not found");
    return null;

}
@PutMapping("/{id}")
public ResponseEntity<Task> updateTask(
        @PathVariable Long id,
        @RequestBody Task updatedTask) {
  for(Task x:tasks){
        if(x.getId().equals(id)){
            x.setTitle(updatedTask.getTitle());
            x.setCompleted(updatedTask.isCompleted());
            return ResponseEntity.ok(x);
        }
    }
    return ResponseEntity.notFound().build();


}

@PostMapping
public Task postMethodName(@RequestBody Task task) {
   tasks.add(task);
    
    return task;
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteTask(@PathVariable Long id){
     boolean done = tasks.removeIf((x)->x.getId().equals(id));
     if(done){
        return ResponseEntity.noContent().build();
     }
     else{
        return ResponseEntity.notFound().build();
     }
}

}

