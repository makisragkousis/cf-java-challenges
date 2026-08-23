package gr.aueb.cf.ch03;

import java.util.Scanner;

/**
 * Εμφανίζει ένα μενού με συγκεκριμένες επιλογές,
 * που επαναλαμβάνεται μέχρι ο χρήστης να δώσει τον αριθμό 5.
 * Για κάθε επιλογή από 1–4 θα πρέπει να εμφανίζεται feedback,
 * για παράδειγμα αν ο χρήστης δώσει 1, θα εμφανίζεται το μήνυμα  <<Επιλέξατε Εισαγωγή>>.
 * Θα πρέπει επίσης να ελέγχεται αν ο χρήστης δώσει αριθμό < 1 ή > 5 και να δίνεται κατάλληλο μήνυμα.
 */
public class InteractiveMenuApp {

    public static void main(String[] args) {

        // Δήλωση και Αρχικοποίση Μεταβλητών
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;

        // Λογική - Εντολές
        do {
            System.out.println("""
                    Παρακαλώ εισάγετε μία από τις παρακάτω επιλογές:
                    
                    1. Εισαγωγή
                    2. Διαγραφή
                    3. Ενημέρωση
                    4. Αναζήτηση
                    5. Έξοδος""");

            userChoice = scanner.nextInt();

            if (userChoice == 5) {
                System.out.println("Ευχαριστούμε που χρησιμοποιήσατε την εφαρμογή μας."); // Δεν χρειάζεται break, καθώς αν το input είναι 5, τα άλλα if δεν γίνονται και λήγει το loop με την συνθήκη του while.
            }

            if (userChoice < 1 || userChoice > 5) {
                System.out.println("Δεν μπορείτε να εισάγετε αυτή την επιλογή.");
                System.out.println();
                continue;
            }

            if (userChoice == 1) {
                System.out.println("Επιλέξατε Εισαγωγή.");
                System.out.println();
            }else if (userChoice == 2) {
                System.out.println("Επιλέξατε Διαγραφή.");
                System.out.println();
            }else if (userChoice == 3) {
                System.out.println("Επιλέξατε Ενημέρωση.");
                System.out.println();
            }else if (userChoice == 4) {
                System.out.println("Επιλέξατε Αναζήτηση.");
                System.out.println();
            }
        }while (userChoice != 5);
    }
}
