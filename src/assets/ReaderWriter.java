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
    
    // attributes of a ReaderWriter attribute
    private Scanner reader;
    private PrintWriter writer;
    private String filePath; // "src/adventurerush/loginDetails.txt"
    
    // constructors
    
    /**
     * Default constructor
     */
    public ReaderWriter() {
        // initializing the filePath attribute
        this.filePath = new String();
        try {
            // initializing the reader attribute
            reader = new Scanner(new File(filePath));
            // initializing the writer attribute
            writer = new PrintWriter(new File(filePath));
        } catch (FileNotFoundException ex) {
            // logging the error if an exception is raised
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Primary constructor
     * @param filePath the file path of the file to be read and written from
     */
    public ReaderWriter(String filePath) {
        // initializing the filePath attribute with the provided filePath attribute
        this.filePath = filePath;
        try {
            // initializing the reader attribute with the filePath attribute
            reader = new Scanner(new File(filePath));
            // initializing the writer attribute with the filePath attribute
            writer = new PrintWriter(new File(filePath));
        } catch (FileNotFoundException ex) {
            // logging the error if an exception is raised
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // getters

    public Scanner getReader() {
        return reader;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public String getFilePath() {
        return filePath;
    }
    
    // setters

    public void setReader(Scanner reader) {
        this.reader = reader;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    // behavior methods
    
    /**
     * Reading a specific line from the file at filePath
     * @param lineNumber the line number of the content to be returned
     * @return the lineNumber-th file in 
     */
    public String readSpecificLine(int lineNumber) {
        try {
            // initializing the reader attribute with the filePath attribute            
            reader = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            // logging the error if an exception is raised
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        // looping through the file up until the lineNumber-th line in the file
        for (int currentLineNumber = 0; currentLineNumber != lineNumber-1 && reader.hasNext(); currentLineNumber++) {
            // moving the Scanner to the next line
            reader.next();
        }
        // returning the lineNumber-th line at the file located at filePath
        return reader.next();
    }    
           
    /**
     * 
     * @param lineNumber
     * @param revision
     * @return 
     */
    public boolean replaceLine(int lineNumber, String revision) {
        try {
            // initializing the reader attribute with the filePath attribute            
            reader = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            // logging the error if an exception is raised
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
            // 
            return false;
        }
        try {
            // initializing the writer attribute with the filePath attribute               
            writer = new PrintWriter(new BufferedWriter(new FileWriter("src/adventurerush/loginDetails.temp")));
        } catch (IOException ex) {
            // logging the error if an exception is raised
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
            // 
            return false;
        }
        // 
        String line = new String(), revisedText = new String(); 
        // 
        for (int i = 0; i < lineNumber-1; i++) {
            // 
            line = reader.nextLine();
            //
            if (i != 0) revisedText += "\n";
            //
            revisedText += line;
        }
        // adding the revised line
        revisedText += "\n" + revision;
        //
        reader.nextLine();
        //
        while (reader.hasNext()) {
            //
            line = reader.nextLine();
            //
            revisedText += "\n" + line;
        }
        // 
        writer.print(revisedText);
        // 
        writer.flush();
        // 
        File realName = new File(filePath);
        // 
        realName.delete(); 
        // 
        new File("src/adventurerush/loginDetails.temp").renameTo(new File(filePath));
        // returning true as the file was 
        return true;
    }
 
    // standard methods

    /**
     * Standard Java toString() method
     * @return a new ReaderWriter object that is a clone of the current ReaderWriter object
     */
    @Override
    public String toString() {
        return "ReaderWriter{" + "reader=" + reader + ", writer=" + writer + ", filePath=" + filePath + '}';
    }
    
    /**
     * Standard Java equals() method
     * @param otherReaderWriter
     * @return whether the two ReaderWriter objects are identical or not
     */
    public boolean equals(ReaderWriter otherReaderWriter) {
        return filePath.equals(otherReaderWriter.getFilePath());
    }
    
    /**
     * Standard Java clone() method
     * @return 
     */
    public ReaderWriter clone() {
        return new ReaderWriter(filePath);
    }
    
    public static void main(String[] args) {
        ReaderWriter test = new ReaderWriter("src/adventurerush/loginDetails.txt");
        test.replaceLine(4, "monkey");
    }
    
}