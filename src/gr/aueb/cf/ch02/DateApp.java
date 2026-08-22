package gr.aueb.cf.ch02;

import java.util.Scanner;

/**
 * Λαμβάνει 3 ακεραίους που αναπαριστούν
 * ημέρα, μήνα και έτος και τους εμφανίζει
 * σε μορφή: ΗΗ/ΜΜ/ΕΕ.
 */
public class DateApp {

    public static void main(String[] args) {

        // Δήλωση και Αρχικοποίηση Μεταβλητών
        Scanner scanner = new Scanner(System.in);
        int day = 0;
        int month = 0;
        int year = 0;

        // Λογική - Εντολές
        System.out.println("Παρακαλώ εισάγετε τρεις αριθμούς ως ημέρα, μήνα και έτος:");
        day = scanner.nextInt();
        month = scanner.nextInt();
        year = scanner.nextInt();

        // Εκτύπωση
        System.out.printf("Η ημερομηνία είναι: %02d/%02d/%02d%n", day, month, year % 100);

        /*
        Το %02d στοιχίζει τον αριθμό δεξιά και συμπληρώνει τα κενά (αν υπάρχουν) με 0 στα αριστερά.
        Για να πάρουμε μόνο τα δύο τελευταία ψηφία του έτους, χρησιμοποιούμε το %
         και παίρνουμε το υπόλοιπο της διαίρεσης με το 100.
         */
    }
}
