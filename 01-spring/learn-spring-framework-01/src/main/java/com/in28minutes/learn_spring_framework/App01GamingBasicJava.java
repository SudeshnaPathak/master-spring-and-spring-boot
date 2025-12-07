package com.in28minutes.learn_spring_framework;
import com.in28minutes.learn_spring_framework.game.GameRunner;
//import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacmanGame;
//import com.in28minutes.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args){
//        MarioGame game = new MarioGame();
//        SuperContraGame game = new SuperContraGame();
        PacmanGame game = new PacmanGame(); // 1. Object Creation
        GameRunner gameRunner = new GameRunner(game);
        // 2. Object Creation + Wiring of dependencies
        // game is the dependency of GameRunner
        // Dependency Injection (DI)
        gameRunner.run();
    }
}
