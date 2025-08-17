import java.io.*;
import java.util.*;

public class FileHandling {

    public static void writeFile(String fileName, String content) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
        System.out.println("File written successfully.");
    }

    public static void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        System.out.println("File contents:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

        public static void modifyFile(String fileName, String oldText, String newText) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line.replace(oldText, newText)).append(System.lineSeparator());
        }
        reader.close();

        FileWriter writer = new FileWriter(fileName);
        writer.write(content.toString());
        writer.close();
        System.out.println("File modified successfully.");
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = "example.txt";

      
        System.out.println("Enter text to write:");
        String text = sc.nextLine();
        writeFile(fileName, text);

     
        readFile(fileName);

    
        System.out.println("Enter word to replace:");
        String oldWord = sc.nextLine();
        System.out.println("Enter new word:");
        String newWord = sc.nextLine();
        modifyFile(fileName, oldWord, newWord);


        readFile(fileName);

        sc.close();
    }
}
