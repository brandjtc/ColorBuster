package colorbusterdev;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        // Create a new Game object before each test case
        game = new Game(5); // Assuming a board size of 5 for testing
    }

    @Test
    public void testCheckMatches_NoMatches() {
        int initialScore = game.getScore();
        // No matching tiles in the initial board setup attached to 0,0
        game.getBoard().setTile(0, 0, new Tile("blue"));
        game.getBoard().setTile(1, 0, new Tile("red"));
        game.getBoard().setTile(0, 1, new Tile("green"));
        // Perform checkMatches method
        game.checkMatches(0, 0); // Provide row and column inputs
        
        // Assert that the score remains unchanged
        assertEquals(initialScore, game.getScore());
    }
    @Test
    public void testCheckMatches_VerticalMatch() {
        // Setting up a vertical match scenario
        int initialScore = game.getScore();
        Board board = game.getBoard();
        board.setTile(0, 0, new Tile("blue"));
        board.setTile(1, 0, new Tile("blue"));
        board.setTile(2, 0, new Tile("blue"));
    
        // Perform checkMatches method
        game.checkMatches(1, 0); // Provide row and column inputs
    
        // Assert that the score is updated by at least 10 points
        assertEquals(initialScore + 10, game.getScore());
    }
    
    @Test
    public void testCheckMatches_HorizontalMatch() {
        // Setting up a horizontal match scenario
        int initialScore = game.getScore();
        Board board = game.getBoard();
        board.setTile(0, 0, new Tile("red"));
        board.setTile(0, 1, new Tile("red"));
        board.setTile(0, 2, new Tile("red"));
    
        // Perform checkMatches method
        game.checkMatches(0, 1); // Provide row and column inputs
    
        // Assert that the score is updated by 10 points
        assertEquals(initialScore + 10, game.getScore());
    }
    @Test
    public void testStartGame() {
        // Assuming the startGame method initializes a new board
        // Update the board with some initial configuration
        Board board = game.getBoard();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.setTile(i, j, new Tile("color")); // Set some dummy color for testing
            }
        }

        // Update the score to ensure it's not zero initially
        game.updateScore(50); // Update score before starting a new game
        
        // Start a new game
        game.startGame(5); // Start a new game with a board size of 5
        
        // Assert that the game score is reset to zero after starting a new game
        assertEquals(0, game.getScore());
        
        // Assert that the board has been reinitialized with random colors
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                assertNotNull(board.getGrid()[i][j].getColor());
            }
        }
    }
}