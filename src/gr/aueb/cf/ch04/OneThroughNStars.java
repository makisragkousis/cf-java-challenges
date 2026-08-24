package gr.aueb.cf.ch04;

import java.util.Scanner;

/**
 * Ο χρήστης εισάγει έναν ακέραιο n
 * και το πρόγραμμα τυπώνει 1 έως n stars
 * ανά σειρά.
 */

public class OneThroughNStars {

    public static void main(String[] args) {

        //Δήλωση και Αρχικοποίηση Μεταβλητών
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        //Λογική - Εντολές
        System.out.println("Δώστε έναν ακέραιο αριθμό:");
        n = scanner.nextInt();

        //Εκτύπωση
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
