package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

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

private final TaskService taskService; //final so that the taskcontroller object will always use the same taskservice object instead of accidently creating new ones

public TaskController(TaskService taskService){
    this.taskService = taskService; //constructor dependency injection used so that when a taskcontroller object is created a taskservice object is created always unlike @Autowired where its not mandatory to enforce it and where the field cant be made final
}


@GetMapping
public List<Task> getTasks() {
    return taskService.getTasks();
}
@GetMapping("/{id}")
public Task getTask(@PathVariable Long id) {
    return taskService.getTask(id);
}

@PutMapping("/{id}")
public ResponseEntity<Task> updateTask(
        @PathVariable Long id,
        @RequestBody Task updatedTask) {
            if(taskService.updateTask(id, updatedTask)){
                return     ResponseEntity.ok(updatedTask);
            }
            
 
    return ResponseEntity.notFound().build();


}

@PostMapping
public Task postMethodName(@RequestBody Task task) {
   return taskService.addTask(task);
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteTask(@PathVariable Long id){
     boolean done = taskService.deleteTask(id);
     if(done){
        return ResponseEntity.noContent().build();
     }
     else{
        return ResponseEntity.notFound().build();
     }
}

}

