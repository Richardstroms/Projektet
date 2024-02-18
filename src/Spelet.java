import java.util.Scanner;

public class Spelet {
    public static void start(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[][] playerBoard = new int[5][5]; // Spelarens spelbräde
        char[][] enemyBoard = new char[5][5]; // Motståndarens spelbräde
        int numPlayerShips = 5; // Antal spelares skepp
        int numEnemyShips = 5; // Antal motståndares skepp

        // Placera spelarens skepp på spelbrädet
        placePlayerShips(scanner, playerBoard, numPlayerShips);

        // Placera motståndarens skepp på spelbrädet
        placeEnemyShips(enemyBoard, numEnemyShips);

        // Spel-loop som fortsätter tills antingen spelaren eller motståndaren har inga
        // skepp kvar
        while (numPlayerShips > 0 && numEnemyShips > 0) {

            // Visa det aktuella tillståndet för spelarens och motståndarens spelbräden
            displayBoards(playerBoard, enemyBoard);

            // Spelarens tur: Mata in koordinater för att attackera motståndarens skepp
            System.out.println(" +-------------------------------+");
            System.out.println(" |   Enter y coordinate (1-5):   |");
            System.out.println(" +-------------------------------+");
            int x = scanner.nextInt() - 1;

            System.out.println(" +-------------------------------+");
            System.out.println(" |   Enter x coordinate (1-5):   |");
            System.out.println(" +-------------------------------+");
            int y = scanner.nextInt() - 1;

            if (isValidCoordinate(x, y)) {
                if (enemyBoard[x][y] == 'S') {
                    System.out.println(System.lineSeparator().repeat(50));
                    System.out.println(" +---------------------------------+");
                    System.out.println(" |   Hit! You sank an enemy ship!  |");
                    System.out.println(" +---------------------------------+");
                    enemyBoard[x][y] = 'X';
                    numEnemyShips--;
                    Thread.sleep(3000);
                } else {
                    System.out.println(System.lineSeparator().repeat(50));
                    System.out.println(" +------------------------------------------+");
                    System.out.println(" |   Miss! No enemy ship at this position.  |");
                    System.out.println(" +------------------------------------------+");
                    enemyBoard[x][y] = 'O';
                    Thread.sleep(3000);
                }
                // Motståndarens tur
                enemyTurn(enemyBoard, playerBoard, numPlayerShips);

            } else {
                // Hantera ogiltig koordinat
                handleInvalidCoordinate();
            }
        }
        // Visa slutresultatet efter spelet
        displayBoards(playerBoard, enemyBoard);
        System.out.println(" +---------------------------------------+");
        System.out.println(" |   You sank all enemy ships! You win!  |");
        System.out.println(" +---------------------------------------+");
        scanner.close();
    }

    // Metod för att placera spelarens skepp på spelbrädet
    private static void placePlayerShips(Scanner scanner, int[][] board, int numShips) throws InterruptedException {
        System.out.println(" +--------------------+");
        System.out.println(" |  Place your ships  |");
        System.out.println(" +--------------------+");
        System.out.println(" +-------------------------------------+");
        System.out.println(" |  (Enter coordinates for each ship): |");
        System.out.println(" +-------------------------------------+");
        System.out.println();
        Thread.sleep(3000);

        for (int i = 0; i < numShips; i++) {
            displayBoard(board);
            System.out.printf("Enter y coordinate for ship %d: ", i + 1);
            int x = scanner.nextInt() - 1;

            System.out.printf("Enter x coordinate for ship %d: ", i + 1);
            int y = scanner.nextInt() - 1;

            if (isValidCoordinate(x, y) && board[x][y] == 0) {
                board[x][y] = 1;
            } else {
                System.out.println(System.lineSeparator().repeat(50));
                System.out.println("Invalid coordinates. Please choose a different location.");
                i--;
                Thread.sleep(3000);
            }
        }
    }

    // Metod för att placera motståndarens skepp på spelbrädet
    private static void placeEnemyShips(char[][] board, int numShips) throws InterruptedException {

        System.out.println("Enemy is placing ships...");
        Thread.sleep(3000);
        System.out.println(System.lineSeparator().repeat(50));
        for (int i = 0; i < numShips; i++) {
            int x, y;

            do {
                x = (int) (Math.random() * 5);
                y = (int) (Math.random() * 5);
            } while (board[x][y] == 'S');

            board[x][y] = 'S';
        }
    }

    // Metod för att visa spelbrädena
    private static void displayBoards(int[][] playerBoard, char[][] enemyBoard) {
        System.out.println("   Your Board           Enemy's Board (Hidden)");
        System.out.println("     1  2  3  4  5        1  2  3  4  5");
        System.out.println("   +---------------+    +---------------+");

        for (int i = 0; i < 5; i++) {
            System.out.printf("%2d |", (i + 1));

            for (int j = 0; j < 5; j++) {
                if (playerBoard[i][j] == 1) {
                    System.out.print(" S ");
                } else if (playerBoard[i][j] == 0 || playerBoard[i][j] == 2) {
                    System.out.print(" ■ ");
                } else {
                    System.out.print("   ");
                }
            }

            System.out.print("|    |");

            for (int j = 0; j < 5; j++) {
                if (enemyBoard[i][j] == ' ') {
                    System.out.print("   ");
                } else {
                    System.out.print(" ■ ");
                }
            }

            System.out.println("|");
        }

        System.out.println("   +---------------+    +---------------+");
    }

    // Metod för motståndarens tur
    private static void enemyTurn(char[][] enemyBoard, int[][] playerBoard, int numPlayerShips)
            throws InterruptedException {
        int enemyX, enemyY;

        do {
            enemyX = (int) (Math.random() * 5);
            enemyY = (int) (Math.random() * 5);
        } while (playerBoard[enemyX][enemyY] == 2 || enemyBoard[enemyX][enemyY] == 'X');

        System.out.println(System.lineSeparator().repeat(50));
        System.out.println(" +-----------------+");
        System.out.println(" |  Enemy's turn:  |");
        System.out.println(" +-----------------+");
        Thread.sleep(3000);

        if (playerBoard[enemyX][enemyY] == 1) {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println(" +----------------------+");
            System.out.println(" |   Your ship is hit!  |");
            System.out.println(" +----------------------+");
            playerBoard[enemyX][enemyY] = 0;
            numPlayerShips--;

            if (numPlayerShips == 0) {
                displayBoards(playerBoard, enemyBoard);
                System.out.println(" +---------------------------------------+");
                System.out.println(" |   All your ships are sunk! You lose!  |");
                System.out.println(" +---------------------------------------+");
                System.exit(0);
            }
        } else {
            System.out.println(System.lineSeparator().repeat(50));
            System.out.println(" +------------------+");
            System.out.println(" |   Enemy missed!  |");
            System.out.println(" +------------------+");
            Thread.sleep(3000);
            System.out.println(System.lineSeparator().repeat(50));
            enemyBoard[enemyX][enemyY] = 'O';
        }
    }

    // Metod för att visa spelbrädet
    private static void displayBoard(int[][] board) {
        System.out.println(System.lineSeparator().repeat(50));
        System.out.println("     1  2  3  4  5       ");
        System.out.println("   +---------------+");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%2d |", (i + 1));
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 1) {
                    System.out.print(" S ");
                } else if (board[i][j] == 0 || board[i][j] == 2) {
                    System.out.print(" ■ ");
                }
            }
            System.out.println("|");
        }
        System.out.println("   +---------------+");
    }

    // Metod för att kontrollera om koordinaten är giltig
    private static boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    // Metod för att hantera ogiltig koordinat
    private static void handleInvalidCoordinate() throws InterruptedException {
        System.out.println(System.lineSeparator().repeat(50));
        System.out.println(" +------------------------------------------------+");
        System.out.println(" |      Invalid coordinates.                      |");
        System.out.println(" |      Please enter values between 1 and 5.      |");
        System.out.println(" +------------------------------------------------+");
        Thread.sleep(3000);
    }
}