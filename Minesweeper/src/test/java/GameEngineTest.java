
import org.example.GameEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {

    private GameEngine engine;

    @BeforeEach
    void setUp() {
        engine = new GameEngine(5, 5, 5);
    }

    @Test
    void testInitialGameState() {
        assertFalse(engine.gameOver());
        assertNotNull(engine.getMap());
    }

    @Test
    void testSetGameOver() {
        engine.setGameOver(true);
        assertTrue(engine.gameOver());

        engine.setGameOver(false);
        assertFalse(engine.gameOver());
    }

    @Test
    void testCountMineOutOfBounds() {
        assertEquals(0, engine.countMine(-1, 0));
        assertEquals(0, engine.countMine(0, -1));
        assertEquals(0, engine.countMine(10, 0));
        assertEquals(0, engine.countMine(0, 10));
    }

    @Test
    void testGameLogicOutOfBounds() {
        engine.gameLogic(-1, 0);
        engine.gameLogic(0, -1);
        engine.gameLogic(10, 0);
        engine.gameLogic(0, 10);
    }
}
