import java.util.Scanner;

public class Spelet {
    public static void start(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int[][] playerBoard = new int[10][10];
        int[][] enemyBoard = new int[10][10];
        int numPlayerShips = 5;
        int numEnemyShips = 5;

        placePlayerShips(scanner, playerBoard, numPlayerShips);

        placeEnemyShips(enemyBoard, numEnemyShips);

        while (numPlayerShips > 0 && numEnemyShips > 0) {
            displayBoard(playerBoard);
            displayEnemyBoard(enemyBoard);

            System.out.println(" +---------------------------------+");
            System.out.println(" |   Enter x coordinate (1-10):    |");
            System.out.println(" +---------------------------------+");
            int x = scanner.nextInt() - 1;

            System.out.println(" +---------------------------------+");
            System.out.println(" |   Enter y coordinate (1-10):    |");
            System.out.println(" +---------------------------------+");
            int y = scanner.nextInt() - 1;

            if (x < 0 || x >= 10 || y < 0 || y >= 10) {
                System.out.println(" +-------------------------------------------------+");
                System.out.println(" |      Invalid coordinates.                       |");
                System.out.println(" |      Please enter values between 1 and 10.      |");
                System.out.println(" +-------------------------------------------------+");
                Thread.sleep(1000);
                continue;
            }

            if (enemyBoard[x][y] == 1) {
                System.out.println(" +---------------------------------+");
                System.out.println(" |   Hit! You sank an enemy ship!  |");
                System.out.println(" +---------------------------------+");
                enemyBoard[x][y] = 0;
                numEnemyShips--;
            } else if (playerBoard[x][y] == 0 || playerBoard[x][y] == 2) {
                System.out.println(" +---------------------------------------------------+");
                System.out.println(" |   You already attacked this position. Try again.  |");
                System.out.println(" +---------------------------------------------------+");
            } else {
                System.out.println(" +------------------------------------------+");
                System.out.println(" |   Miss! No enemy ship at this position.  |");
                System.out.println(" +------------------------------------------+");
                playerBoard[x][y] = 2;
            }

            int enemyX = (int) (Math.random() * 10);
            int enemyY = (int) (Math.random() * 10);

            System.out.println(" +-----------------+");
            System.out.println(" |  Enemy's turn:  |");
            System.out.println(" +-----------------+");
            if (playerBoard[enemyX][enemyY] == 1) {
                System.out.println(" +----------------------+");
                System.out.println(" |   Your ship is hit!  |");
                System.out.println(" +----------------------+");
                numPlayerShips--;
            } else if (enemyBoard[enemyX][enemyY] == 0 || enemyBoard[enemyX][enemyY] == 2) {
                System.out.println(" +------------------------------------------+");
                System.out.println(" |   Enemy already attacked this position.  |");
                System.out.println(" +------------------------------------------+");
            } else {
                System.out.println(" +------------------+");
                System.out.println(" |   Enemy missed!  |");
                System.out.println(" +------------------+");
                enemyBoard[enemyX][enemyY] = 2;
            }

        }

        displayBoard(playerBoard);
        System.out.println(" +---------------------------------------+");
        System.out.println(" |   You sank all enemy ships! You win!  |");
        System.out.println(" +---------------------------------------+");
        scanner.close();
    }

    private static void placePlayerShips(Scanner scanner, int[][] board, int numShips) {
        System.out.println(" +--------------------+");
        System.out.println(" |  Place your ships  |");
        System.out.println(" +--------------------+");
        System.out.println(" +-------------------------------------+");
        System.out.println(" |  (Enter coordinates for each ship): |");
        System.out.println(" +-------------------------------------+");
        System.out.println(System.lineSeparator().repeat(1));

        for (int i = 0; i < numShips; i++) {
            displayBoard(board);
            System.out.printf("Enter x coordinate for ship %d: ", i + 1);
            int x = scanner.nextInt() - 1;

            System.out.printf("Enter y coordinate for ship %d: ", i + 1);
            int y = scanner.nextInt() - 1;

            if (x < 0 || x >= 10 || y < 0 || y >= 10 || board[x][y] == 1) {
                System.out.println("Invalid coordinates. Please choose a different location.");
                i--;
            } else {
                board[x][y] = 1;
            }
        }
    }

    private static void placeEnemyShips(int[][] board, int numShips) {
        System.out.println("Enemy is placing ships...");

        for (int i = 0; i < numShips; i++) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);

            if (board[x][y] == 1) {
                i--;
            } else {
                board[x][y] = 1;
            }
        }
    }

    private static void displayBoard(int[][] board) {
        System.out.println("     1  2  3  4  5  6  7  8  9 10");
        System.out.println("   +------------------------------+");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%2d |", (i + 1));
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 1) {
                    System.out.print(" S ");
                } else if (board[i][j] == 0 || board[i][j] == 2) {
                    System.out.print(" ■ ");
                }
            }
            System.out.println("|");
        }
        System.out.println("   +------------------------------+");
    }

    private static void displayEnemyBoard(int[][] board) {
        System.out.println("  Enemy's Board (Hidden)");
        System.out.println("     1  2  3  4  5  6  7  8  9 10");
        System.out.println("   +------------------------------+");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%2d |", (i + 1));
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 1) {
                    System.out.print(" ■ ");
                } else {
                    System.out.print(" ■ ");
                }
            }
            System.out.println("|");
        }
        System.out.println("   +------------------------------+");

    }
}
