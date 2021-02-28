import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String path = "./resources/fruits.txt";
        printFile(path);
    }

    public static boolean doesFileExist(String path) {
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    public static void printFile(String path) {
        if (!doesFileExist(path)) {
            System.out.println("File doesn't exist!");
            return;
        }

        try (Scanner scan = new Scanner(new File(path))) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] arr = line.split("–");
                String word = arr[0].trim();
                String[] meanings = arr[1].trim().split(",");

                System.out.println(word);
                for (String meaning : meanings) {
                    System.out.println(meaning.trim());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
