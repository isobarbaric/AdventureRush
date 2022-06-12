package adventurerush;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaderWriter {
    
    private Scanner reader;
    private PrintWriter writer;
    private String filePath; // "src/adventurerush/loginDetails.txt"
    
    public ReaderWriter(String filePath) {
        this.filePath = filePath;            
    }

    public String readSpecificLine(int lineNumber) {
        try {
            reader = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int currentLineNumber = 0; currentLineNumber != lineNumber-1 && reader.hasNext(); currentLineNumber++) {
            reader.next();
        }
        return reader.next();
    }    
            
    public boolean replaceLine(int lineNumber, String revision) {
        try {
            reader = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter("src/adventurerush/loginDetails.temp")));
        } catch (IOException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        String line; 
        for (int i = 0; i < lineNumber-1; i++) {
            line = reader.nextLine();
            writer.println(line);
        }
        writer.println(revision);
        reader.nextLine();
        while (reader.hasNext()) {
            line = reader.nextLine();
            writer.println(line);
        }
        writer.flush();
        File realName = new File(filePath);
        realName.delete(); 
        new File("src/adventurerush/loginDetails.temp").renameTo(new File(filePath)); // Rename temp file
        return true;
    }
    
    public static void main(String[] args) {
        ReaderWriter test = new ReaderWriter("src/adventurerush/loginDetails.txt");
        System.out.println(test.readSpecificLine(5));
        test.replaceLine(6, "100");
    }
            
}
