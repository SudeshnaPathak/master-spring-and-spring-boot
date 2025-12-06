package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.game") // To scan for @Component classes in the specified package
public class App03GamingSpringBeans {

    @Bean
    public GameRunner gameRunner(GamingConsole game)
    {
        // Auto-wiring by Spring Framework - it will search for a bean of type GamingConsole using @ComponentScan and inject it here
        return new GameRunner(game);
    }
    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class))
       {
           context.getBean(GamingConsole.class).up();
           context.getBean(GameRunner.class).run();
       }
    }
}
