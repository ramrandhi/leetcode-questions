package fileHandling;

import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class OutPutStreamReader {
    public static void main(String[] args) {
        /*try(OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            osw.write("hello world");
            osw.write(99);
            osw.write(10);
            osw.write('a');
            char[] ch = "hehe rawww".toCharArray();
            osw.write(ch);
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }

        try(FileWriter fw = new FileWriter("C:/Users/Ramanjaneyulu/Downloads/notes.txt", true)) {
            fw.write("this should be appendedd");
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }*/

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Ramanjaneyulu/Downloads/notes.txt"))) {
            bw.write("Hare Krishnaaaaaaaaaaaaaaaaaaaaaa");
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
