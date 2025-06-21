package fileHandling;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.BufferedReader;

public class InputStreamReaderUsecase {
    public static void main(String[] args) {

        // Input stream Reader
        /*try(InputStreamReader reader = new InputStreamReader(System.in)) {
            System.out.print("Enter some words : ");
            // why here we used int insted of char becaues read() method returns int.
            int letters = reader.read();
            while(reader.ready()) {
                System.out.println((char)letters);
                letters = reader.read();
            }*/
         /*   reader.close();  // not required becaue try catch block will close the resource automatically
            System.out.println();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }*/

        // File Reader
//        try(FileReader fr = new FileReader("C:/Users/Ramanjaneyulu/Downloads/OrderPopulation.sql")) {
//            int letters = fr.read();
//            while(fr.ready()) {
//                System.out.println((char) letters);
//                letters = fr.read();
//            }
//            System.out.println();
//        } catch(IOException e) {
//            System.err.println(e.getMessage());
//        }

//        InputStreamReader converts byte stream to character stream and if we use BufferedReader we need to use InputStreamReader to  read the stream
//        of characters from InputStreamReader.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int chars = br.read();

            System.out.println("you typed: " + br.read());
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }

        try(BufferedReader bufReader = new BufferedReader(new FileReader("C:/Users/Ramanjaneyulu/Downloads/OrderPopulation.sql"))) {
            while(bufReader.ready()) {
                System.out.println(bufReader.readLine());
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
