package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name") //We add the Session Attribute over every Controller which needs to access name , Session attribute name will be available in the Model of all those Controllers
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("Sudeshna");
        model.addAttribute("todos" , todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo" , method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = (String) model.get("name");
        Todo todo = new Todo(0 , username , "" , LocalDate.now().plusYears(1) , false);
        model.put("todo" , todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo" , method = RequestMethod.POST)
    public String addNewTodo(ModelMap model , Todo todo) {

        //Bind form data directly to the fields in Todo Bean
        //Command Bean or Form Backing Object - todo
        //We use this form backing object in the JSP using Spring Form Tags

        String username = (String)model.get("name"); //Getting the username from the Session Attribute
        todoService.addTodo(username , todo.getDescription() , LocalDate.now().plusYears(1) , false);
        return "redirect:list-todos";
    }

}
