package gr.aueb.cf.ch06;

/**
 * Βρίσκει και επιστρέφει τη θέση όπου βρίσκεται
 * το μεγαλύτερο στοιχείο σε έναν πίνακα,
 * με τη χρήση μεθόδου.
 */

public class MaxPositionApp {

    public static void main(String[] args) {
        int[] exampleNumbers = {2, -5, 8, 2, 10, 3};
        int maxPosition = 0;

        maxPosition = getMaxPosition(exampleNumbers, 0, exampleNumbers.length -1);

        System.out.printf("Η θέση του μέγιστου στοιχείου είναι: %d.%n", maxPosition);
    }

    public static int getMaxPosition(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low < 0 || low > high || high >= arr.length) return -1;

        int maxPosition = low;
        int maxValue = arr[low];

        for (int i = low + 1; i <= high; i++) {
            if (arr[i] > maxValue) {
                maxPosition = i;
                maxValue = arr[i];
            }
        }
        return maxPosition;
    }
}
