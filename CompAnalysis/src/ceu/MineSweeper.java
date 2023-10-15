package ceu;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper
{
    private int rows;
    private int cols;
    private int numMines;
    private char[][] minefield;
    private char[][] gameBoard;
    private boolean gameOver;
    
    public MineSweeper( int rows, int cols, int numMines ) 
    {
        this.rows = rows;
        this.cols = cols;
        this.numMines = numMines;
        minefield = new char[ rows ][ cols ];
        gameBoard = new char[ rows ][ cols ];
        gameOver = false;
        initializeGame();
    }

    private void initializeGame() 
    {
        // Initialize minefield with mines
        placeMines();

        // Initialize game board
        for ( int i = 0; i < rows; i++ ) {
            for ( int j = 0; j < cols; j++ ) 
            {
                gameBoard[ i ][ j ] = '-';
            }
        }
    }

    private void placeMines() 
    {
        Random random = new Random();
        int minesPlaced = 0;

        while ( minesPlaced < numMines ) 
        {
            int row = random.nextInt( rows );
            int col = random.nextInt( cols );

            if ( minefield[ row ][ col ] != '*' ) 
            {
                minefield[ row ][ col ] = '*';
                minesPlaced++;
            }
        }
    }

    private void printGameBoard() 
    {
        // Print the game board
        for ( int i = 0; i < rows; i++ ) 
        {
            for ( int j = 0; j < cols; j++ ) 
            {
                System.out.print( gameBoard[ i ][ j ] + " " );
            }
            System.out.println();
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("Current board:");
            printGameBoard();

            System.out.print("Enter row and column (e.g., 0 1): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            if (minefield[row][col] == '*') {
                System.out.println("Game over! You hit a mine.");
                gameOver = true;
            } else {
                // Update the game board
                updateGameBoard(row, col);
                
                if (checkWin()) {
                    System.out.println("Congratulations! You win!");
                    gameOver = true;
                }
            }
        }

        scanner.close();
    }

    private void updateGameBoard( int row, int col ) 
    {
      if ( minefield[ row ][ col ] == '*' ) 
      {
        // The selected cell is a mine
        gameBoard[ row ][ col ] = '*';
      } 
      else 
      {
        // The selected cell is not a mine; reveal the number of adjacent mines
        int countMines = countAdjacentMines( row, col );
        gameBoard[ row ][ col ] = ( char ) ( countMines + '0' );
      }
    }

    private int countAdjacentMines( int row, int col ) 
    {
      int count = 0;
  
      // Define the eight possible directions to check for adjacent cells
      int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
      int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
  
      for ( int i = 0; i < 8; i++ ) 
      {
          int newRow = row + dr[ i ];
          int newCol = col + dc[ i ];
  
          // Check if the new position is within the bounds of the minefield
          if ( newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols ) 
          {
              // Check if there's a mine in the adjacent cell
              if ( minefield[ newRow ][ newCol ] == '*' ) 
              {
                  count++;
              }
          }
      }
  
      return count;
  }
  

    private boolean checkWin() 
    {
      for ( int i = 0; i < rows; i++ ) 
      {
          for ( int j = 0; j < cols; j++ ) 
          {
              if ( gameBoard[ i ][ j ] == '-' && minefield[ i ][ j ] != '*' ) 
              {
                  return false; // There are unrevealed safe cells, game not won yet
              }
          }
      }
      return true; // All safe cells are revealed, the player wins
    }

    public static void main( String[] args ) 
    {
        MineSweeper minesweeper = new MineSweeper( 8, 8, 10 );
        minesweeper.playGame();
    }
}
