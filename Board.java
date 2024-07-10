package colorbusterdev;
import java.util.Random;
// Represents the game board
class Board {
    private int size;
    private Tile[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Tile[size][size];
        // Initialize the board with random colors
        initializeBoard();
    }
    private void initializeBoard() {
        Random random = new Random();
        String[] colors = { "red", "blue", "green", "yellow", "orange" };
    
        // Randomly select a row and column for the horizontal match
        int matchRow = random.nextInt(size);
        int matchCol = random.nextInt(size - 2);
    
        // Randomly select a column for the vertical match
        int verticalMatchCol = random.nextInt(size);
        while (verticalMatchCol == matchCol || verticalMatchCol == matchCol + 1 || verticalMatchCol == matchCol + 2) {
            // Ensure vertical match column is different from horizontal match column
            verticalMatchCol = random.nextInt(size);
        }
    
        // Generate the color for the match
        String matchColor = colors[random.nextInt(colors.length)];
    
        // Fill the board with random colors and ensure matches of three horizontally and vertically
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i == matchRow && j >= matchCol && j < matchCol + 3) || (j == verticalMatchCol && i >= matchRow && i < matchRow + 3)) {
                    // Set the color of the match
                    grid[i][j] = new Tile(matchColor);
                } else {
                    // Generate a random color from the colors array
                    String randomColor = colors[random.nextInt(colors.length)];
                    // Create a new tile with the random color and add it to the grid
                    grid[i][j] = new Tile(randomColor);
                }
            }
        }
    }
    //Get dimensions, X*X
    public int getSize() {
        return size;
    }
    //Get Grid
    public Tile[][] getGrid() {
        return grid;
    }
    //Print Board
    public void printBoard() {
        Tile[][] grid = this.getGrid();
        int size = this.getSize();

        // Print the grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getColor() + "\t");
            }
            System.out.println();
        }
    }

    // Method to set a tile at a specific position
    public void setTile(int row, int col, Tile tile) {
        grid[row][col] = tile;
    }
}
