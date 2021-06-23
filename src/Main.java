
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import java.util.logging.Formatter;

public class Main {
    static class Adder implements Runnable{
        private String infile, outfile;
        public Adder(String infile, String outfile) {
            this.infile = infile;
            this.outfile = outfile;
        }
        public void doadd() throws Exception{
            int total = 0;
            String line = null;
            try(BufferedReader reader = Files.newBufferedReader(Paths.get(this.infile))) {
                while((line = reader.readLine()) != null) {
                    total += Integer.parseInt(line);
                }
            }
            try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(this.outfile))) {
                writer.write("Total: " + total);
            }
        }
        public void run() {
            try {
                doadd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        String[] infiles = {"file1.txt","file2.txt"};
        String[] outfiles = {"file1.out.txt","file2.out.txt"};
        ExecutorService es = Executors.newFixedThreadPool(3);
        for(int i = 0;i<infiles.length;i++) {
            Adder adder = new Adder(infiles[i],outfiles[i]);
            es.submit(adder);
        }
        try {
            es.shutdown();
            es.awaitTermination(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

    }
};