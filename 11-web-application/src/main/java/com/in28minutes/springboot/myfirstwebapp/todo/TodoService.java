package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static{
        todos.add(new Todo(++todosCount , "Sudeshna" , "Get AWS Certified" ,
                LocalDate.now().plusYears(1) , false));
        todos.add(new Todo(++todosCount , "Sudeshna" , "Learn DevOps" ,
                LocalDate.now().plusYears(2) , false));
        todos.add(new Todo(++todosCount , "Sudeshna" , "Learn Full Stack Development" ,
                LocalDate.now().plusYears(3) , false));

    }

    public List<Todo> findByUsername(String username){
        Predicate<Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id){
        todos.removeIf(todo -> todo.getId() == id); //Lambda Expression , removeIf method implements the predicate on every element of the list
    }

    public Todo findById(int id){
        Predicate<Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(Todo todo){
        deleteById(todo.getId());
        todos.add(todo);
    }
}
