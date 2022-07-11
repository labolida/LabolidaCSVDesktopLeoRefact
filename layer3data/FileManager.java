package layer3data;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



public class FileManager {
	

    public static byte[] read( String fileName ) throws Exception {
        try {
            File file = new File( fileName ) ;
            FileInputStream fis = new FileInputStream(file);
            byte content[] = new byte[ (int)file.length() ];
            fis.read( content );
            fis.close();
            return content;
        }
        catch (Exception e) {
            throw new Exception("Error at FileManager.read() " + e.getMessage() );
        }
    }

    public static void write( String filename, String body , boolean appender ) throws Exception {
        try {
            FileOutputStream grv = new FileOutputStream(filename,appender);
            PrintStream grv2 = new PrintStream(grv);
            grv2.print(body);
        }
        catch(Exception e) {
            throw new Exception(" Error at FileManager.write():" + e.getMessage() );
        }
    }
	



    public static void copyFileNIO(String from, String to) throws IOException {
        Path fromFile = Paths.get(from);
        Path toFile = Paths.get(to);
        if (Files.notExists(fromFile)) {
            System.out.println("File doesn't exist? " + fromFile);
            return;
        }
        Files.copy(fromFile, toFile, StandardCopyOption.REPLACE_EXISTING);
    }

}
