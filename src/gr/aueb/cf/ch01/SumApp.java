package gr.aueb.cf.ch01;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * Δηλώνει δύο ακεραίους και τυπώνει το άθροισμα τους
 */
public class SumApp {

    public static void main(String[] args) {

        // Δήλωση Μεταβλητών
        Scanner scanner = new Scanner(System.in);
        BigInteger num1 = BigInteger.valueOf(0);
        BigInteger num2 = BigInteger.valueOf(0);
        BigInteger sum = BigInteger.valueOf(0);

        // Λογική - Εντολές
        System.out.println("Παρακαλώ εισάγετε δύο ακεραίους:");
        num1 = scanner.nextBigInteger();
        num2 = scanner.nextBigInteger();
        sum = num1.add(num2);

        // Εκτύπωση
        System.out.println("To αποτέλεσμα της πρόσθεσης είναι ίσο με " + sum);

    }
}
