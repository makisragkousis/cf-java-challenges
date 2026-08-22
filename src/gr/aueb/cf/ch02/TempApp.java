package gr.aueb.cf.ch02;

import java.util.Scanner;

/**
 * Μετατρέπει ακέραιες τιμές θερμοκρασίας,
 * από Fahrenheit σε Celsius.
 */
public class TempApp {

    public static void main(String[] args) {

        // Δήλωση και Αρχικοποίηση Μεταβλητών
        Scanner scanner = new Scanner(System.in);
        int tempF = 0;
        int tempC = 0;

        // Λογική - Εντολές
        System.out.println("Παρακαλώ εισάγετε σε θερμοκρασία Fahrenheit:");
        tempF = scanner.nextInt();
        tempC = 5 * (tempF - 32) / 9; // Αν γράφαμε (5/9)*(F-32), τότε επειδή 5/9(είναι int) δίνει 0, το τελικό αποτέλεσμα θα ήταν κι αυτό 0.

        // Εκτύπωση
        System.out.printf("Η θερμοκρασία σε Celsius είναι: %d%n", tempC);

        // Αφού είναι int, δεν παίρνουμε την ακριβή θερμοκρασίσα.
    }
}
