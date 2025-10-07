
import org.example.MineTile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MineTileTest {

    @Test
    void testMineTileCreation() {
        MineTile tile = new MineTile(3, 4);

        assertEquals(3, tile.getRowPosition());
        assertEquals(4, tile.getColPosition());
        assertEquals("", tile.getText());
    }

    @Test
    void testMineTileType() {
        MineTile tile = new MineTile(0, 0);

        tile.setType("B");
        tile.setText("B");

        assertEquals("B", tile.getText());
    }
}
