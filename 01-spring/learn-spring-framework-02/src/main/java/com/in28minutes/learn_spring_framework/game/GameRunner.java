package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private final GamingConsole game;
    public GameRunner(@Qualifier("superContraGame")GamingConsole game){
        // Using lowercase of class name inside @Qualifier to specify which bean to inject
        this.game = game;
    }
    public void run(){
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
