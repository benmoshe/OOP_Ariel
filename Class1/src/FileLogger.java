/**
 * This class represents a simple file based logger. The main use is to simplify the use of text-files
 */

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

/**
 * try(FileWriter fileWriter = new FileWriter(absolutePath)) {
 *     String fileContent = "This is a sample text.";
 *     fileWriter.write(fileContent);
 * } catch (IOException e) {
 *     // exception handling
 * }
 *
 * // read the content from file
 * try(FileReader fileReader = new FileReader(absolutePath)) {
 *     int ch = fileReader.read();
 *     while(ch != -1) {
 *         System.out.print((char)ch);
 *         ch = fileReader.read();
 *     }
 * } catch (FileNotFoundException e) {
 *     // exception handling
 * } catch (IOException e) {
 *     // exception handling
 * }
 *
 *
 */
public class FileLogger {
    public static final String  START_NAME = "FileLogger_";
    private String _file_name;
    private FileWriter _file;

    public FileLogger() {
        this(START_NAME+new Date().getTime()+".txt");
    }
    public FileLogger(String file) {
        File f = new File(file);
        if(!f.exists()) {
            String _file_name = file;
            try {
                _file = new FileWriter(file);
            }
            catch(Exception e){ e.printStackTrace();}
        }
        else {
            throw new RuntimeException("FileLogger should not rewrite on existing file. Do choose a new log file name");
        }

    }
    public void log(String s) {
        try {
            _file.write(s+"\n");
            _file.flush();
        }
        catch(Exception e){ e.printStackTrace();}
    }
    public void flush() {
        try {
            _file.flush();
        }
        catch(Exception e){ e.printStackTrace();}
    }
    public void close() {
        try {
            _file.close();
        }
        catch(Exception e){ e.printStackTrace();}
    }
}
