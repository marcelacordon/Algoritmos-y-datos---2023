import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * 
 * @since:30/01/2023
 **/


public class Read {

    Read(){}

    /**
     * para leer el archivo 
     * 
     * 
     **/    
    
    String leer(String scs){
        String data = " ";
        String fpath = scs;
            
     try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
            data = myReader.nextLine();
              System.out.println(data);
              return data;
            }
            myReader.close();
     } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
     }
        return data;
    }
    
}
