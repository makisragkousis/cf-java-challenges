package gr.aueb.cf.ch05;

import java.util.Scanner;

/**
 * Μέσω μιας μεθόδου πραγματοποιεί την μετατροπή
 * θερμοκρασίας αριθμού κινητής υποδιαστολής
 * από Celsius σε Fahrenheit.
 */

public class CelsiusToFahrenheitMethodApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        double tempC = 0d;
        double tempF = 0d;

        System.out.println("Εισάγετε την θερμοκρασία σε Celsius:");
        tempC = getTempC();

        tempF = celsiusToFahrenheit(tempC);

        System.out.printf("Η θερμοκρασία σε Fahrenheit είναι: %.2f.", tempF);
    }

    /**
     * Λαμβάνει τον αριθμό κινητής υποδιαστολής που δίνει ο χρήστης
     * @return τον αριθμό κινητής υποδιαστολής που δίνει ο χρήστης
     */
    public static double getTempC () {
        return scanner.nextDouble();
    }

    /**
     * Πραγματοποιεί την μετατροπή από Celsius σε Fahrenheit
     * @param tempC η θερμοκρασία σε Celsius
     * @return τη θερμοκρασία σε Fahrenheit
     */
    public static double celsiusToFahrenheit (double tempC) {
        return tempC * ( 9.0 / 5.0 ) + 32.0;
    }
}
