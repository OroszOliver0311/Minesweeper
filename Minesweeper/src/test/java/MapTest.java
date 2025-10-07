
import org.example.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void testMapCreation() {
        Map map = new Map(10, 15, 20);

        assertEquals(10, map.getNumRows());
        assertEquals(15, map.getNumCols());
        assertEquals(20, map.getMineCount());
        assertNotNull(map.getBoard());
        assertNotNull(map.getMineList());
    }

    @Test
    void testMapBoardDimensions() {
        Map map = new Map(8, 12, 10);

        assertEquals(8, map.getBoard().length);
        assertEquals(12, map.getBoard()[0].length);
    }

    @Test
    void testEmptyMineListOnCreation() {
        Map map = new Map(5, 5, 5);
        assertTrue(map.getMineList().isEmpty());
    }
}
