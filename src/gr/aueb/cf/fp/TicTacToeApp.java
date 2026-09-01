package gr.aueb.cf.fp;

import java.util.Scanner;

/**
 * Υλοποιεί το παιχνίδι τρίλιζα, για δύο παίκτες σε
 * πίνακα 3×3. Νικητής αναδεικνύεται ο παίκτης που θα συμπληρώσει πρώτος τρία ίδια
 * σύμβολα σε οποιαδήποτε γραμμή, στήλη ή διαγώνιο. Αν συμπληρωθούν και οι 9
 * θέσεις χωρίς νικητή, το παιχνίδι λήγει σε ισοπαλία.
 */

public class TicTacToeApp {
    static Scanner scanner = new Scanner(System.in);
    static int[][] board = new int[3][3]; // Όπως και το scanner, θέλουμε να μπορούν να το καλούν όλες οι μέθοδοί

    public static void main(String[] args) {
        int row = 0;
        int column = 0;
        int currentPlayer = 1;

        int filled = 0;
        final int numOfRows = board.length;
        final int numOfColumns = board[0].length;
        int draw = numOfRows * numOfColumns;

        boolean isMoveValid = false;

        while (filled < draw) {
            printGrid();

            System.out.println("Εισάγετε έναν αριθμό ως γραμμή(1-3) και έναν ως στήλη(1-3):");
            row = scanner.nextInt();
            column = scanner.nextInt();
            if (row < 1 || row > 3 || column < 1 || column > 3) {
                System.out.println("Μη έγκυρες επιλογές. Παρακαλώ προσπαθήστε ξανά.");
                continue;
            }

            isMoveValid = placeMove(currentPlayer, row - 1, column - 1);
            if (!isMoveValid) continue;
            filled++;

            if (isWin(currentPlayer)) {
                System.out.println("Συγχαρητήρια παίχτη " + currentPlayer + ", κερδίσατε!");
                printGrid();
                break;
            }

            if (filled == draw) {
                System.out.println("Ισοπαλία. Δεν δημιουργήθηκε τριάδα σε καμία κατεύθυνση.");
                printGrid();
                break;
            }

            currentPlayer = (currentPlayer == 1) ? 2 : 1; // Στο τέλος κάθε iteration, αν το currentPlayer είναι το κάνει 2 και ανάποδα
        }
    }

    /**
     * Ελέγχει αν η θέση που δίνει ο παίχτης είναι κατειλημμένη, αν όχι τοποθετεί
     * εκεί τον αριθμό του παίχτη
     * @param player ο παίχτης που παίζει εκείνη τη στιγμή
     * @param row η γραμμή του 2D πίνακα
     * @param column η στήλη του 2D πίνακα
     * @return true αν η τοποθέτηση του αριθμού του παίχτη είναι έγκυρη, false αν όχι
     */
    public static boolean placeMove(int player, int row, int column) {
        if (board[row][column] != 0) {
                System.out.println("Κατειλημμένη θέση. Παρακαλώ προσπαθήστε ξανά.");
                return false;
        }

        board[row][column] = player;
        return true;
    }

    /**
     * Ελέγχει αν ο παίχτης που μόλις έπαιξε κέρδισε το παιχνίδι
     * με τη χρήση μεθόδων που ελέγχουν για τριάδες ίδιων αριθμών
     * προς κάθε κατεύθυνση του 2D πίνακα
     * @param player ο παίχτης που παίζει εκείνη τη στιγμή
     * @return true αν επιστρέφει true οποιαδήποτε από τις εμπεριεχόμενες μεθόδους, αλλιώς false
     */
    public static boolean isWin(int player) {
        return isRowWin(player) || isColumnWin(player) || isMainDiagonalWin(player) || isAntiDiagonalWin(player);
    }

    /**
     * Ελέγχει αν δημιουργείται γραμμή στον 2D πίνακα με τον αριθμό
     * ενός εκ των δύο παικτών
     * @param player ο παίχτης που παίζει εκείνη τη στιγμή
     * @return true αν δημιουργείται γραμμή στον 2D πίνακα με τον αριθμό ενός εκ των δύο παικτών, αλλιώς false
     */
    public static boolean isRowWin(int player) {
        for (int i = 0; i < board.length; i++ ) {
            int count = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * Ελέγχει αν δημιουργείται στήλη στον 2D πίνακα με τον αριθμό
     * ενός εκ των δύο παικτών
     * @param player ο παίχτης που παίζει εκείνη τη στιγμή
     * @return true αν δημιουργείται στήλη στον 2D πίνακα με τον αριθμό ενός εκ των δύο παικτών, αλλιώς false
     */
    public static boolean isColumnWin(int player) {
        for (int i = 0; i < board.length; i++ ) {
            int count = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == player) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Ελέγχει αν η διαγώνιος από πάνω αριστερά προς κάτω δεξιά στον 2D πίνακα, έχει μόνο τον αριθμό
     * ενός εκ των δύο παικτών
     * @param player ο παίχτης που παίζει εκείνη τη στιγμή
     * @return true αν η διαγώνιος από πάνω αριστερά προς κάτω δεξιά στον 2D πίνακα, έχει μόνο τον αριθμό
     *         ενός εκ των δύο παικτών, αλλιώς false
     */
    public static boolean isMainDiagonalWin(int player) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == player) {
                count++;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ελέγχει αν η διαγώνιος από πάνω δεξιά προς κάτω αριστερά στον 2D πίνακα, έχει μόνο τον αριθμό
     * ενός εκ των δύο παικτών
     * @param player ο παίχτης που παίζει εκείνη τη στιγμή
     * @return true αν η διαγώνιος από πάνω δεξιά προς κάτω αριστερά στον 2D πίνακα, έχει μόνο τον αριθμό
     *         ενός εκ των δύο παικτών, αλλιώς false
     */
    public static boolean isAntiDiagonalWin(int player) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - 1 - i] == player) {
                count++;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * Εκτυπώνει κάθε γραμμή του 2D πίνακα ξεχωριστά (τη μία κάτω από την άλλη)
     * και όπου υπάρχει 0 αντικαθίσταται με ".", όπου υπάρχει 1 με "Χ" και όπου
     * υπάρχει 2 με "Ο"
     */
    public static void printGrid() {
        for (int[] row : board) {
            for (int el : row) {
                if (el == 0) {
                    System.out.print(". ");
                } else if (el == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
}
