
import org.example.GameEngine;
import org.example.Map;
import org.example.MineTile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WinConditionTest {

    @Test
    void testCheckWinWithSmallBoard() {
        GameEngine engine = new GameEngine(2, 2, 1);
        Map map = engine.getMap();

        MineTile bombTile = new MineTile(0, 0);
        bombTile.setType("B");
        map.getMineList().add(bombTile);
        map.getBoard()[0][0] = bombTile;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (i != 0 || j != 0) {
                    MineTile safeTile = new MineTile(i, j);
                    safeTile.setEnabled(false);
                    map.getBoard()[i][j] = safeTile;
                }
            }
        }

        assertTrue(engine.checkWin());
    }

}
