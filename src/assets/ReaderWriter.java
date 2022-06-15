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
    private String filePath;
    private Scanner reader;
    private PrintWriter writer;
    
    // constructors
    
    /**
     * Default constructor
     */
    public ReaderWriter() {
        // initializing the filePath attribute
        this.filePath = new String();
        
        // using a try-catch to initialize the reader object
        try {
            
            // initializing the reader attribute
            reader = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            
            // logging the error if an exception is raised
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // using a try-catch to initialize the writer object
        try {
            
            // initializing the writer attribute
            writer = new PrintWriter(new FileWriter(filePath, true));
        } catch (IOException ex) {
            
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
        
        // using a try-catch to initialize the reader object
        try {
            
            // initializing the reader attribute with the filePath attribute
            reader = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            
            // logging the error if an exception is raised
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // using a try-catch to initialize the writer object
        try {
            
            // initializing the writer attribute with the filePath attribute
            writer = new PrintWriter(new FileWriter(filePath, true));
        } catch (IOException ex) {
            
            // logging the error if an exception is raised
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // getters
    
    /**
     * Accessor for the filePath attribute
     * @return the file path to the file to be read and written to
     */
    public String getFilePath() {
        return filePath;
    }
    
    /**
     * Accessor for the reader attribute
     * @return the Scanner object working to read the file at filePath
     */
    public Scanner getReader() {
        return reader;
    }

    /**
     * Accessor for the writer attribute
     * @return the PrintWriter object working to write to the file at filePath
     */
    public PrintWriter getWriter() {
        return writer;
    }

    // setters

    /**
     * Mutator for the filePath attribute
     * @param filePath the file path to the file to be read and written to
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Mutator for the reader attribute
     * @param reader the Scanner object working to read the file at filePath
     */
    public void setReader(Scanner reader) {
        this.reader = reader;
    }

    /**
     * Mutator for the writer attribute
     * @param writer the PrintWriter object working to write to the file at filePath
     */
    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    // behavior methods
    
    /**
     * Reading a specific line from the file at filePath
     * @param lineNumber the line number of the content to be returned
     * @return the lineNumber-th in the file at filePath
     */
    public String readSpecificLine(int lineNumber) {
        // using a try-catch to initialize the reader object
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
     * Replacing the content on a particular line 
     * @param lineNumber the line number of the content to be returned
     * @param revision the String content to replace the content at lineNumber
     * @return a boolean representing whether or not the operation was successful
     */
    public boolean replaceLine(int lineNumber, String revision) {
        // using a try-catch to initialize the reader object
        try {
            
            // initializing the reader attribute with the filePath attribute            
            reader = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {

            // logging the error if an exception is raised
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);

            // returning false to indicate that the operation was not performed successfully
            return false;
        }
        // using a try-catch to initialize the writer object
        try {

            // initializing the writer attribute with the filePath attribute               
            writer = new PrintWriter(new BufferedWriter(new FileWriter("src/adventurerush/loginDetails.temp")));
        } catch (IOException ex) {

            // logging the error if an exception is raised
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);

            // returning false to indicate that the operation was not performed successfully
            return false;
        }

        // declaring and initializing strings to store the contents of the current line and the revised text overall
        String line = new String(), revisedText = new String(); 

        // looping through the lines preceding the line to be changed
        for (int i = 0; i < lineNumber-1; i++) {

            // taking input of the current line and storing this in the variable storing the current line
            line = reader.nextLine();

            // dealing with an edge case regarding adding a new line to the current line
            if (i != 0) revisedText += "\n";

            // adding the current line to the revised text
            revisedText += line;
        }

        // adding the revised line
        revisedText += "\n" + revision;

        // moving the Scanner to the next line to ignore the line to be ignored
        reader.nextLine();

        // taking input of the remainder of the document with a while loop
        while (reader.hasNext()) {

            // taking input of the current line and storing this in the variable storing the current line
            line = reader.nextLine();

            // adding the current line to the revised text
            revisedText += "\n" + line;
        }

        // sending the string containing the revised text to the writer object to replace the current contents of the file
        writer.print(revisedText);

        // calling the flush method to perform the printing of the revised text in the file
        writer.flush();

        // declaring and initializing a variable to be assigned to the current file path
        File realName = new File(filePath);

        // deleting the current file so that the revised copy can be set to the appropriate file path
        realName.delete(); 

        // taking the temporary file and renaming it to the 
        new File("src/adventurerush/loginDetails.temp").renameTo(new File(filePath));

        // returning false to indicate that the operation was performed successfully
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
     * @return an identical ReaderWriter object to the current one
     */
    public ReaderWriter clone() {
        return new ReaderWriter(filePath);
    }
    
}