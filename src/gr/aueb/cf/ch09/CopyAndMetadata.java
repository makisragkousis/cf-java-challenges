package gr.aueb.cf.ch09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.UUID;

/**
 * Δημιουργεί το αντίγραφο ενός αρχείου, με Binary Copy,
 * δίνοντας του ένα νέο όνομα και στη συνέχεια τυπώνει
 * το πλήρες όνομα του αρχικού και του νέου αρχείου,
 * καθώς και την κατάληξη του νέου.
 */

public class CopyAndMetadata {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Παρακαλώ, δώστε το όνομα του αρχείου:");
        String userInputFile = scanner.nextLine();

        String newFileName = UUID.randomUUID().toString().replace(":", "_") + "-" + userInputFile;

        Path inputPath = Path.of("C:/tmp/" + userInputFile);
        Path outputPath = Path.of("C:/tmp/" + newFileName);

        // Ελέγχει αν υπάρχει το αρχείο που επιστρέφει ο χρήστης
        if (!Files.exists(inputPath)) {
            System.out.println("Σφάλμα: Το αρχείο '" + userInputFile + "' δεν βρέθηκε στο φάκελο C:/tmp/.");
            return; // Για να τερματίσει τη main
        }

        binaryCopy(inputPath, outputPath);

    }

    /**
     * Πραγματοποιεί τη διαδικασία Binary Copy και εν συνεχεία
     * τυπώνει το πλήρες όνομα του αρχικού και του νέου αρχείου,
     * καθώς και την κατάληξη του νέου.
     * @param sourcePath το Path του αρχείου που εισάγει ο χρήστης
     * @param destPath   το Path όπου θα δημιουργηθεί το νέο αντιγραμμένο αρχείο
     */
    public static void binaryCopy(Path sourcePath, Path destPath) {
        try {
            // Ελέγχει αν υπάρχει ο φάκελος για να μπει το αντίγραφο, αν όχι το δημιουργεί με το .createDirectories
            if (destPath.getParent() != null) {
                Files.createDirectories(destPath.getParent());
            }

            try (var sourceStream = Files.newInputStream(sourcePath);
                 var outputStream = Files.newOutputStream(destPath)) {

                sourceStream.transferTo(outputStream);

                String inputFileName = sourcePath.toAbsolutePath().toString();
                String outputFileName = destPath.toAbsolutePath().toString();

                // Εξάγουμε το extension από το ίδιο String που βρήκαμε την τελεία,
                // για να αποφύγουμε StringIndexOutOfBoundsException λόγω διαφοράς μήκους.
                String extension = "";
                int dotIndex = outputFileName.lastIndexOf(".");

                if (dotIndex > 0 && dotIndex < outputFileName.length() - 1) {
                    extension = outputFileName.substring(dotIndex + 1); // +1 για να μη συμπεριληφθεί η τελεία
                }

                System.out.println(inputFileName);
                System.out.println(outputFileName);
                System.out.println(extension);
            }
        } catch (IOException e) {
            System.err.println("Σφάλμα ΙΟ: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
