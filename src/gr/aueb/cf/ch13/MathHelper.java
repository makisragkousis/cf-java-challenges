package gr.aueb.cf.ch13;

/**
 * Utility class για κοινές μαθηματικές
 * λειτουργίες όπως εύρεση του μέγιστου,
 * ελάχιστου, και μέσου όρου ενός array από
 * integers
 */

public class MathHelper {

    private MathHelper() {}

    /**
     * Βρίσκει και επιστρέφει τον μέγιστο αριθμό από ένα array ακεραίων.
     * @param arr το array από integers που θα ελεγχθεί.
     * @return τον μέγιστο αριθμό του array. Επιστρέφει 0 αν το array είναι null ή άδειο.
     */
    public static int getMax(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int maxPosition = 0;
        int maxValue = arr[maxPosition];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxPosition = i;
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    /**
     * Βρίσκει και επιστρέφει τον ελάχιστο αριθμό από ένα array ακεραίων.
     * @param arr το array από integers που θα ελεγχθεί.
     * @return τον ελάχιστο αριθμό του array. Επιστρέφει 0 αν το array είναι null ή άδειο.
     */
    public static int getMin(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int minPosition = 0;
        int minValue = arr[minPosition];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minPosition = i;
                minValue = arr[i];
            }
        }
        return minValue;
    }

    /**
     * Υπολογίζει και επιστρέφει τον μέσο όρο των αριθμών ενός array ακεραίων.
     * @param arr το array από integers για το οποίο θα υπολογιστεί ο μέσος όρος.
     * @return τον μέσο όρο των στοιχείων ως δεκαδικό (double). Επιστρέφει 0 αν το array είναι null ή άδειο.
     */
    public static double getAverage(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }
        return (double) sum / arr.length;
    }
}
