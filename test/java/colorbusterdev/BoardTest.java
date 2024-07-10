package colorbusterdev;
import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
    @Test
    public void testGetGrid() {
        // Create a Board object with a specific size
        int size = 5; // Example size
        Board board = new Board(size);

        // Call the getGrid method
        Tile[][] grid = board.getGrid();

        // Assert the expected behavior of getGrid
        assertNotNull(grid);
        assertEquals(size, grid.length);
        assertEquals(size, grid[0].length);
    }

    @Test
    public void testGetSize() {
        // Create a Board object with a specific size
        int size = 5; // Example size
        Board board = new Board(size);

        // Call the getSize method
        int boardSize = board.getSize();

        // Assert the expected behavior of getSize
        // Add assertions based on the expected behavior of getSize method
        // For example:
        assertEquals(size, boardSize);
    }
}