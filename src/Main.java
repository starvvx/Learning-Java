
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;
import java.util.logging.Formatter;

public class Main {
    static class Adder implements Callable<Integer> {
        private String infile;
        public Adder(String infile) {
            this.infile = infile;
        }
        public int doadd() throws IOException{
            int total = 0;
            String line = null;
            try(BufferedReader reader = Files.newBufferedReader(Paths.get(this.infile))) {
                while((line = reader.readLine()) != null) {
                    total += Integer.parseInt(line);
                }
            }
            return total;
        }
        public Integer call() throws IOException {
            return doadd();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        String[] infiles = {"file1.txt","file2.txt"};
        String[] outfiles = {"file1.out.txt","file2.out.txt"};
        Future<Integer>[] results = new Future[infiles.length];
        ExecutorService es = Executors.newFixedThreadPool(3);
        for(int i = 0;i<infiles.length;i++) {
            Adder adder = new Adder(infiles[i]);
            results[i] = es.submit(adder);

        }
        for(int i = 0;i<results.length;i++) {
            try {
                int value = results[i].get();
                System.out.println(value);
                try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(outfiles[i]))) {
                    writer.write("total: " + value);
                }

            } catch (ExecutionException e) {
                Throwable ex = e.getCause();
                System.out.println(ex);
            }
            catch (IOException e) {
                System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
            }


        }
        try {
            es.shutdown();
            es.awaitTermination(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

    }
};