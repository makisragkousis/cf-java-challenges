package gr.aueb.cf.ch09;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Διαβάζει ένα αρχείο κειμένου που περιέχει τοποθεσίες και συντεταγμένες
 * (με μορφή τιμών διαχωρισμένων με κόμμα) και δημιουργεί ένα νέο
 * αρχείο με τα ίδια δεδομένα τροποποιημένα.
 */

public class CopyAndModifyFile {

    public static void main(String[] args) {
        Path filePath = Path.of("C:/CF10-Java/Locations-Latitude-Longitude.txt");
        Path copiedFilePath = Path.of("C:/CF10-Java/NewJavaFile/Locations-Latitude-Longitude.txt");

        try (PrintWriter pw = new PrintWriter(copiedFilePath.toFile(), StandardCharsets.UTF_8)) {

            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);

            // Διαβάζει μόνο την πρώτη γραμμή για να πάρουμε τις επικεφαλίδες
//            String firstLine = lines.get(0);
//            String[] headers = firstLine.split(",");

            // Η λούπα ξεκινάει από το 1 για να αγνοήσουμε την πρώτη γραμμή (επικεφαλίδες)
            for (int line = 1; line < lines.size(); line++) {
                String nextLine = lines.get(line);
                String[] tokens = nextLine.split(",");
                String location = tokens[0];
                String latitude = tokens[1];
                String longitude = tokens[2];

                pw.printf("{ location: '%s', latitude: %s, longitude: %s },%n", location, latitude, longitude);
                System.out.printf("{ location: '%s', latitude: %s, longitude: %s },%n", location, latitude, longitude);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Γραμμή με λιγότερα από 3 πεδία: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Το αρχείο είναι κενό: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Σφάλμα I/O: " + e.getMessage());
        }
    }
}
