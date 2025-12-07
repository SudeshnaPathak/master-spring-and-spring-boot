package com.in28minutes.learn_spring_framework.examples.h1;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Arrays;

public class XmlConfigurationContextLauncherApplication {
    public static void main(String[] args){
        try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml"))
        {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();

        }
    }
}
