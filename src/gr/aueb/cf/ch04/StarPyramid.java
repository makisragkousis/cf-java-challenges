package gr.aueb.cf.ch04;

/**
 * Φτιάχνει μία πυραμίδα
 * από * με 4 σειρές.
 */

public class StarPyramid {

    public static void main(String[] args) {

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (i * 2) - 1; k++) { // Ο τύπος (2*i)-1 δίνει τα περιττά αστεράκια (1, 3, 5, 7) ανάλογα με τη γραμμή i.
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
