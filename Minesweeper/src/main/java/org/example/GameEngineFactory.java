package org.example;

public class GameEngineFactory {
    public static IGameEngine createGameEngine(Difficulty difficulty) {
        return new GameEngine(
                difficulty.getRows(),
                difficulty.getCols(),
                difficulty.getMineCount()
        );
    }
}