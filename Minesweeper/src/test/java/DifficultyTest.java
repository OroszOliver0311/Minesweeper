import org.example.Difficulty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DifficultyTest {

    @Test
    void testDifficultyCreation() {
        Difficulty diff = new Difficulty("Test", 10, 15, 20);

        Assertions.assertEquals("Test", diff.getName());
        Assertions.assertEquals(10, diff.getRows());
        Assertions.assertEquals(15, diff.getCols());
        Assertions.assertEquals(20, diff.getMineCount());
    }

    @Test
    void testPredefinedDifficulties() {
        Assertions.assertEquals("Easy", Difficulty.EASY.getName());
        Assertions.assertEquals(9, Difficulty.EASY.getRows());
        Assertions.assertEquals(9, Difficulty.EASY.getCols());
        Assertions.assertEquals(10, Difficulty.EASY.getMineCount());

        Assertions.assertEquals("Medium", Difficulty.MEDIUM.getName());
        Assertions.assertEquals(16, Difficulty.MEDIUM.getRows());
        Assertions.assertEquals(16, Difficulty.MEDIUM.getCols());
        Assertions.assertEquals(40, Difficulty.MEDIUM.getMineCount());

        Assertions.assertEquals("Hard", Difficulty.HARD.getName());
        Assertions.assertEquals(16, Difficulty.HARD.getRows());
        Assertions.assertEquals(30, Difficulty.HARD.getCols());
        Assertions.assertEquals(99, Difficulty.HARD.getMineCount());
    }
}
