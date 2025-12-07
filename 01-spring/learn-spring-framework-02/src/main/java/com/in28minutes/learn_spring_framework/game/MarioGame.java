package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // Marks this bean as the primary bean to be injected when multiple beans of the same type are present
public class MarioGame implements GamingConsole{
      public void up()
      {
          System.out.println("Jump");
      }

      public void down()
      {
          System.out.println("Go into a hole");
      }

      public void left()
      {
          System.out.println("Go back");
      }

      public void right()
      {
          System.out.println("Accelerate");
      }
}
