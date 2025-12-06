package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.game") // To scan for @Component classes in the specified package
public class GamingAppLauncherApplication {
    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class))
       {
           // Auto-wiring by Spring Framework - it will search for beans of type GamingConsole and type GameRunner using @ComponentScan and inject it here
           // Spring Scans the right Package -> finds the classes with @Component -> creates the instances -> Auto Wires the instances -> Gets the application up and running
           context.getBean(GamingConsole.class).up();
           context.getBean(GameRunner.class).run();
       }
    }
}
