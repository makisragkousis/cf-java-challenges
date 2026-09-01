package gr.aueb.cf.fp;

import java.util.Scanner;

/**
 * Προσομοίωση εφαρμογής κράτησης και ακύρωσης θέσεων σε θέατρο.
 * Οι θέσεις αναπαριστώνται με ένα δισδιάστατο boolean πίνακα.
 * Κράτηση και ακύρωση πραγματοποιούνται μέσω κατάλληλων μεθόδων, όπου πετούν
 * Exception αν η θέση είναι κατειλημμένη ή όχι αντίστοιχα.
 * Άλλες μέθοδοι ελέγχουν αν οι επιλογές row και column είναι valid.
 */

public class TheaterReservationApp {
    static Scanner scanner = new Scanner(System.in);
    static boolean[][] reservationTable = new boolean[30][12];

    public static void main(String[] args) {
        int row = 0;
        char column;
        int userChoice = 0;
        final int EXIT = 3;

        while (true) {
            try {
                System.out.println("""
                Επιλέξτε μία από τις παρακάτω επιλογές:
                1) Κράτηση.
                2) Ακύρωση.
                3) Έξοδος.""");

                // Μπαίνει πριν εκχωρηθεί τιμή μέσω του scanner στο userChoice
                if (!scanner.hasNextInt()) {
                    System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
                    System.out.println();
                    scanner.nextLine(); // Καθαρίζει τα μη επιθυμητά, πχ enter
                    continue;
                }

                userChoice = scanner.nextInt();

                if (userChoice < 1 || userChoice > 3) {
                    System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
                    System.out.println();
                    continue;
                }

                if (userChoice == EXIT) {
                    System.out.println("Έξοδος. Ευχαριστούμε που χρησιμοποιήσατε την εφαρμογή μας.");
                    break;
                }

                System.out.println("Εισάγετε τον αριθμό της στήλης:");
                column = scanner.next().charAt(0); // Ό,τι και αν δώσει ο χρήστης, παίρνουμε το πρώτο γράμμα που χρειαζόμαστε (η isValidColumn ελέγχει αν η επιλογή είναι εντός ορίων)

                if (!isValidColumn(column)) {
                    scanner.nextLine(); // Καθαρίζει τα μη επιθυμητά, πχ enter
                    continue;
                }

                System.out.println("Εισάγετε τον αριθμό της γραμμής:");
                if (!scanner.hasNextInt()) { // Πρέπει να βεβαιωθούμε ότι ο χρήστης θα δώσει αποκλειστικά ακέραιο
                    System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
                    System.out.println();
                    scanner.nextLine(); // Καθαρίζει τα μη επιθυμητά, πχ enter
                    continue;
                }
                row = scanner.nextInt();

                if (!isValidRow(row)) {
                    scanner.nextLine(); // Καθαρίζει τα μη επιθυμητά, πχ enter
                    continue;
                }

                if (userChoice == 1) {
                    book(column, row);
                } else if (userChoice == 2) {
                    cancel(column, row);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Ελέγχει αν η θέση με βάση το πίνακα είναι κρατημένη (false) ή όχι και την
     * κάνει book αν όχι(γίνεται true η θέση του πίνακα). Αλλιώς πετάει Exception
     * @param column η στήλη του πίνακα
     * @param row η γραμμή του πίνακα
     * @throws Exception Αν η θέση είναι κρατημένη, δίνει το συναφές μήνυμα
     */
    public static void book(char column, int row) throws Exception {
        try {
            if (reservationTable[row - 1][column - 'A']) { // Αν (true) η θέση είναι κρατημένη, δημιούργησε το Exception
                throw new Exception("Η θέση που προσπαθήσατε να κρατήσετε, είναι ήδη κρατημένη.");
            }
            reservationTable[row - 1][column - 'A'] = true; // Με το -Α ο πίνακας ξεκινάει από το 0
            System.out.println("Η κράτηση πραγματοποιήθηκε με επιτυχία.");
            System.out.println();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.flush(); // εξασφαλίζει ότι το err εκτυπώνεται πριν συνεχίσει
            throw e;
        }
    }

    /**
     * Ελέγχει αν η θέση με βάση το πίνακα δεν είναι κρατημένη (true) ή όχι και την
     * κάνει cancel αν ναι(γίνεται false η θέση του πίνακα). Αλλιώς πετάει Exception
     * @param column η στήλη του πίνακα
     * @param row η γραμμή του πίνακα
     * @throws Exception Αν η θέση δεν είναι κρατημένη, δίνει το συναφές μήνυμα
     */
    public static void cancel(char column, int row) throws Exception {
        try {
            if (!reservationTable[row - 1][column - 'A']) { // Αν (false) η θέση δεν είναι ήδη κρατημένη, δημιούργησε το Exception
                throw new Exception("Η κράτηση που προσπαθήσατε να ακυρώσετε, δεν αντιστοιχεί σε κρατημένη θέση.");
            }
            reservationTable[row - 1][column - 'A'] = false; // Με το -Α ο πίνακας ξεκινάει από το 0
            System.out.println("Η ακύρωση της κράτησης πραγματοποιήθηκε με επιτυχία.");
            System.out.println();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.flush(); // εξασφαλίζει ότι το err εκτυπώνεται πριν συνεχίσει
            throw e;
        }
    }

    /**
     * Ελέγχει αν το input του χρήστη για την επιλογή γραμμής είναι
     * επιθυμητή ή όχι
     * @param row η γραμμή του πίνακα
     * @return false αν είναι εκτός ορίων, true αν δεν είναι
     */
    public static boolean isValidRow(int row) {
        if (row < 1 || row > 30) {
            System.out.println("Μη έγκυρη επιλογή γραμμής. Παρακαλώ προσπαθήστε ξανά.");
            return false;
        }
        return true;
    }

    /**
     * Ελέγχει αν το input του χρήστη για την επιλογή στήλης είναι
     * επιθυμητή ή όχι
     * @param column η στήλη του πίνακα
     * @return false αν είναι εκτός ορίων, true αν δεν είναι
     */
    public static boolean isValidColumn(int column) {
        if (column < 'A' || column > 'L') {
            System.out.println("Μη έγκυρη επιλογή στήλης. Παρακαλώ προσπαθήστε ξανά.");
            return false;
        }
        return true;
    }
}
