package colorbusterdev;
// Represents the game state and logic
class Game {
    private Board board;
    private int score;
    //Game constructor
    public Game(int boardSize) {
        this.board = new Board(boardSize);
        this.score = 0;
    }
    //Gets board
    public Board getBoard(){
        return board;
    }
    //Starts Game
    public void startGame(int boardSize) {
        score = 0;
        board = new Board(boardSize);
    }
    //Gets score
    public int getScore(){
        return score;
    }
    //Updates Score
    public void updateScore(int points) {
        score += points;
    }
    //Check Match Method
    public void checkMatches(int row, int col) {
        Tile[][] grid = board.getGrid();
        int size = board.getSize();
        
        // Get the color of the selected tile
        String color = grid[row][col].getColor();
        
        // Check for horizontal matches around the selected tile
        if (col >= 2 && color.equals(grid[row][col-1].getColor()) && color.equals(grid[row][col-2].getColor())) {
            // Handle matching tiles
            // For example, update the score
            updateScore(10); // Assuming 10 points per match
        }
        
        // Check for vertical matches around the selected tile
        if (row < size - 2 && color.equals(grid[row+1][col].getColor()) && color.equals(grid[row+2][col].getColor())) {
            // Handle matching tiles
            // For example, update the score
            updateScore(10); // Assuming 10 points per match
        }
    }
}    