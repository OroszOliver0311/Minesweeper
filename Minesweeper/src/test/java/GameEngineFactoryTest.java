
import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameEngineFactoryTest {

    @Test
    void testCreateGameEngine() {
        IGameEngine engine = GameEngineFactory.createGameEngine(Difficulty.EASY);

        assertNotNull(engine);
        assertInstanceOf(GameEngine.class, engine);
    }

    @Test
    void testEngineHasCorrectMapSize() {
        IGameEngine engine = GameEngineFactory.createGameEngine(Difficulty.MEDIUM);
        Map map = engine.getMap();

        assertEquals(16, map.getNumRows());
        assertEquals(16, map.getNumCols());
        assertEquals(40, map.getMineCount());
    }
}
