import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String data[] = new String[]{
                "Line 1",
                "Line 2 2",
                "Line 3 3 3",
                "Line 4 4 4 4",
                "Line 5 5 5 5 5"
        };

        writeData(data);
//        readData();

        Collection<String > stringsInFile = copyData();
        System.out.println(stringsInFile);
    }

    public static void writeData(String[] data) throws IOException{
        try(BufferedWriter bw =
                Files.newBufferedWriter(Paths.get("file.txt"))) {
            for(String string:data) {
                bw.write(string);
                bw.newLine();
            }
        }
    }

    public static void readData() throws IOException{
        try(BufferedReader br =
                    Files.newBufferedReader(Paths.get("file.txt"))) {
            String inValue;
            while((inValue = br.readLine()) != null) {
                System.out.println(inValue);
            }
        }
    }

    public static List<String> copyData() throws IOException{
        List<String> line =
                Files.readAllLines(Paths.get("file.txt"));
        return line;
    }


};