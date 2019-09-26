import java.io.File;
import java.util.Scanner;

public class Printer {
    private File file;
    
    public Printer(String fileName) throws Exception {
        file = new File(fileName);
    }
    
    public void printLinesWhichContain(String word) throws Exception {
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (line.contains(word) || word.isEmpty()) {
                System.out.println(line);
            }
        }
    }
}
