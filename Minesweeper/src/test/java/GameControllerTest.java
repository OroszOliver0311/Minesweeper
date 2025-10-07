
import org.example.GameController;
import org.example.IGameEngine;
import org.example.IGameView;
import org.example.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    private GameController controller;
    private TestGameEngine testEngine;

    @BeforeEach
    void setUp() {
        testEngine = new TestGameEngine();
        TestGameView testView = new TestGameView();
        controller = new GameController(testEngine, testView);
    }

    @Test
    void testInitializeGame() {
        controller.initializeGame();
        assertTrue(testEngine.setMinesCalled);
    }

    @Test
    void testTileClickWhenGameOver() {
        testEngine.gameOver = true;
        controller.tileClick(0, 0);
        assertFalse(testEngine.gameLogicCalled);
    }

    @Test
    void testRightClickWhenGameOver() {
        testEngine.gameOver = true;
        controller.rightClick(0, 0);

        assertTrue(testEngine.gameOver);
    }


    static class TestGameEngine implements IGameEngine {
        public boolean setMinesCalled = false;
        public boolean gameLogicCalled = false;
        public boolean gameOver = false;
        public Map map = new Map(5, 5, 5);

        @Override
        public void setMines() {
            setMinesCalled = true;
        }

        @Override
        public void gameLogic(int row, int col) {
            gameLogicCalled = true;
        }

        @Override
        public int countMine(int row, int col) {
            return 0;
        }

        @Override
        public boolean gameOver() {
            return gameOver;
        }

        @Override
        public void setGameOver(boolean state) {
            gameOver = state;
        }

        @Override
        public Map getMap() {
            return map;
        }

        @Override
        public boolean checkWin() {
            return false;
        }
    }

    static class TestGameView implements IGameView {
        public boolean revealMinesCalled = false;
        public boolean victoryShown = false;
        public String lastStatus = "";

        @Override
        public void revealMines() {
            revealMinesCalled = true;
        }

        @Override
        public void updateGameStatus(String message) {
            lastStatus = message;
        }

        @Override
        public void showVictory() {
            victoryShown = true;
        }
    }
}