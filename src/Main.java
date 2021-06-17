import java.io.*;

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
        readData();
    }

    public static void writeData(String[] data) throws IOException{
        try(BufferedWriter bw =
                new BufferedWriter(new FileWriter("file.txt"))) {
            for(String string:data) {
                bw.write(string);
                bw.newLine();
            }
        }
    }

    public static void readData() throws IOException{
        try(BufferedReader br =
                    new BufferedReader(new FileReader("file.txt"))) {
            String inValue;
            while((inValue = br.readLine()) != null) {
                System.out.println(inValue);
            }
        }
    }

}
