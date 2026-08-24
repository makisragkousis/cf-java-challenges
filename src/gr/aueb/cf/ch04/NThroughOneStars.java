package gr.aueb.cf.ch04;

import java.util.Scanner;

/**
 * Ο χρήστης εισάγει έναν ακέραιο n
 * και το πρόγραμμα τυπώνει n έως 1 stars
 * ανά σειρά.
 */

public class NThroughOneStars {

    public static void main(String[] args) {

        //Δήλωση και Αρχικοποίηση Μεταβλητών
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        //Λογική - Εντολές
        System.out.println("Δώστε έναν ακέραιο αριθμό:");
        n = scanner.nextInt();

        //Εκτύπωση
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
