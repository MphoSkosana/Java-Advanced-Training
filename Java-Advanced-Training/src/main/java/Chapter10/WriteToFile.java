package Chapter10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class WriteToFile {
    static void main() {
        //Path
        String filePath ="src/main/resources/Hobbies.txt";

        //Create file resource
        File hobbiesFile = new File(filePath);

        try {
            PrintStream pen = new PrintStream(hobbiesFile);

            //writing to a file
            pen.println("Tennis");
            pen.println("Cricket");
            pen.println("Mixed Martial Arts");

            //when done writing
            pen.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found..." +e.getMessage());
        }

        System.out.println("Abs Path: " +hobbiesFile.getAbsolutePath());
        System.out.println("Path: " +hobbiesFile.getPath());
        System.out.println("Parent: " +hobbiesFile.getParent());
        System.out.println("Last Modified: " +hobbiesFile.lastModified());
    }
}
