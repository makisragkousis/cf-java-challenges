package gr.aueb.cf.ch04;

/**
 * Υπολογίζει το άθροισμα των ακεραίων
 * από το 1 έως και το 50.
 */

public class AddFirstFifty {

    public static void main(String[] args) {

        int result = 0;

        for (int i = 1; i <= 50; i++) {
            result += i;
        }

        System.out.printf("Το άθροισμα των ακεραίων από το 1 έως και το 50 είναι: %d.%n", result);
    }
}
