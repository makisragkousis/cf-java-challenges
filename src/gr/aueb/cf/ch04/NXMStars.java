package gr.aueb.cf.ch04;

import java.util.Scanner;

/**
 * Ο χρήστης εισάγει έναν ακέραιο n
 * και το πρόγραμμα τυπώνει n x m stars.
 */

public class NXMStars {

    public static void main(String[] args) {

        //Δήλωση και Αρχικοποίηση Μεταβλητών
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int m = 0;

        //Λογική - Εντολές
        System.out.println("Δώστε το πλήθος των γραμμών (n) και των στηλών (m):");
        n = scanner.nextInt();
        m = scanner.nextInt();

        //Εκτύπωση
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
