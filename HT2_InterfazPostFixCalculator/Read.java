import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * 
 * @since:30/01/2023
 **/


public class Read {

    void leer(){
        System.out.println("Ingrese la ruta del archivo ej C:\\ejemplos\\example1.txt");
        Scanner in = new Scanner(System.in);
        String fpath = in.nextLine();
        
      try {
        File myObj = new File(fpath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          System.out.println(data);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
    
}
