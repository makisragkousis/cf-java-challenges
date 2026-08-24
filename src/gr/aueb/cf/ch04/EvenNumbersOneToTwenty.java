package gr.aueb.cf.ch04;

/**
 * Τυπώνει όλους τους ζυγούς αριθμούς
 * από το 1 έως και το 20.
 */

public class EvenNumbersOneToTwenty {

    public static void main(String[] args) {

        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

//        for (int i = 2; i <= 20; i += 2) {
//            System.out.print(i + " ");
//        }
    }
}
