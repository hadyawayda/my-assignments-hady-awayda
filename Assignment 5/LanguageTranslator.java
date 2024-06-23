import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LanguageTranslator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a language (English or French): ");
        String language = scanner.nextLine().trim().toLowerCase();

        String filePath = "languages/" + language + ".txt";
        String defaultFilePath = "languages/english.txt";

        try {
            readFile(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("The requested translation file doesn't exist...switching to the default language");
            try {
                readFile(defaultFilePath);
            } catch (FileNotFoundException ex) {
                System.out.println("The default translation file also doesn't exist.");
            }
        }
    }

    private static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();
    }
}
