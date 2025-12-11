package com.in28minutes.springboot.myfirstwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyfirstwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfirstwebappApplication.class, args);
	}

}

//Browser sends a HTTP Request to the Server
//Server is our Spring Boot Application which handles the HTTP Request and sends back a HTTP Response


//Model 1 Architecture : All code in JSP View ~ Very Complex, Zero Separation of Concerns, High Maintenance
//Model 2 Architecture : MVC Architecture ~ Controller handles the request & the Entire flow, Model contains the data, View renders the data
//Servlet : Java Class to handle HTTP Request and send back HTTP Response
//Controller : A Servlet which is part of Spring Framework to handle HTTP Request and send back HTTP Response
//Model : Data which needs to be rendered in the View
//View : JSP Page which renders the data
//Front Controller : All Requests flow to a Central Controller(Front Controller) which then identifies & delegates the request to appropriate Controller & View. All Common Functionality can be implemented in the Front Controller. Example : Authentication, Authorization, Logging, etc.
//DispatcherServlet : Front Controller provided by Spring Framework

//Flow of Request Processing in Spring MVC :
//1. Browser sends HTTP Request to DispatcherServlet(Front Controller)
//2. DispatcherServlet identifies the appropriate Controller to handle the request based on the URL(Ex : /login -> LoginController)
//3. Controller processes the request and prepares the data(Model) for the View
//4. Controller returns the View Name to DispatcherServlet
//5. DispatcherServlet identifies the actual View using ViewResolver(Prefix + View Name + Suffix)
//6. View is rendered with the data from the Model and HTTP Response is sent back to the Browser

//When we put anything in Model , it is available only for the scope of that request
//To maintain data across multiple requests , we can use HttpSession
//In Spring MVC , we can use @SessionAttributes to store attributes in session
//Request Scope -> Data active only for a single request , cannot be shared across multiple requests
//Session Scope -> Data is available across multiple requests for a particular session
