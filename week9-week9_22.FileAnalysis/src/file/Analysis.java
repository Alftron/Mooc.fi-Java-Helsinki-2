
package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {
    private File fileToAnalyse;
    
    public Analysis(File file) {
        fileToAnalyse = file;
    }
    
    public int lines() throws Exception {
        // Returns the number of lines in the file
        Scanner reader = new Scanner(fileToAnalyse, "UTF-8");
        int linecount = 0;
        while (reader.hasNext()) {
            linecount++;
            reader.nextLine();
        }
        return linecount;
    }
    
    public int characters() throws Exception {
        // Returns the number of characters in the file
        Scanner reader = new Scanner(fileToAnalyse, "UTF-8");
        int charCount = 0;
        while (reader.hasNext()) {
            String line = reader.nextLine();
            charCount += line.length() + 1; // +1 for line break chars
        }
        return charCount;
    }
}
