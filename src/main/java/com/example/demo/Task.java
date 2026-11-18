package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getters and setters
@AllArgsConstructor 
@NoArgsConstructor 
public class Task {
private Long id;
private String title;
private boolean completed;

}
