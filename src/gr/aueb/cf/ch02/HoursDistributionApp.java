package gr.aueb.cf.ch02;

import java.util.Scanner;

/**
 * Λαμβάνει τις ώρες εργασίας και τον αριθμό των εργαζομένων (και τα δύο σε ακεραίους)
 * και μοιράζει ισόποσα τις ώρες, δίνοντας όσες περισσεύουν στον manager.
 */
public class HoursDistributionApp {

    public static void main(String[] args) {

        // Δήλωση και Αρχικοποίηση Μεταβλητών
        Scanner scanner = new Scanner(System.in);
        int workHours = 0;
        int workers = 0;
        int hoursPerWorker = 0;
        int leftoverHours = 0;

        // Λογική - Εντολές
        System.out.println("Παρακαλώ εισάγετε τις ώρες εργασίας και τους εργαζομένους:");
        workHours = scanner.nextInt();
        workers = scanner.nextInt();
        hoursPerWorker = workHours / workers;
        leftoverHours = workHours % workers;

        // Εκτύπωση
        System.out.printf("Κάθε εργαζόμενος: %d ώρες. Ώρες που περισσεύουν: %d.%n", hoursPerWorker, leftoverHours);
    }
}
