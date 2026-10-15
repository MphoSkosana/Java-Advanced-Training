package Chapter10;

import java.io.*;

public class ReadFromFile {
    static void main() {
        String filePath = "src/main/resources/Modules.txt";
        File moduleFile = new File(filePath);
        String text;


        try {
            //opens the file for reading
            FileReader fileReader = new FileReader(moduleFile);

            //read contents of the file
            BufferedReader reader = new BufferedReader(fileReader);

            while( (text = reader.readLine()) != null ){
                System.out.println(text);
            }

            reader.close();
            fileReader.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
