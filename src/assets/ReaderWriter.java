package assets;

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
            return false;
        }
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter("src/adventurerush/loginDetails.temp")));
        } catch (IOException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        String line = new String(), revisedText = new String(); 
        for (int i = 0; i < lineNumber-1; i++) {
            line = reader.nextLine();
            if (i != 0) revisedText += "\n";
            revisedText += line;
        }
        revisedText += "\n" + revision;
        reader.nextLine();
        while (reader.hasNext()) {
            line = reader.nextLine();
            revisedText += "\n" + line;
        }
        // writer.print(revisedText.substring(revisedText.indexOf("\n")+1));
        writer.print(revisedText);
        writer.flush();
        File realName = new File(filePath);
        realName.delete(); 
        new File("src/adventurerush/loginDetails.temp").renameTo(new File(filePath));
        return true;
    }
    
    public static void main(String[] args) {
        ReaderWriter test = new ReaderWriter("src/adventurerush/loginDetails.txt");
        System.out.println(test.readSpecificLine(9));
        test.replaceLine(6, Integer.toString(40));
    }
            
}