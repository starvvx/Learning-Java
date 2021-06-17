import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
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

        String data1[] = new String[]{"String 1", "String 2","String 3"};

        try(FileSystem zipfs = openZip(Paths.get("myData.zip"))) {
            writeToFileInZip(zipfs,data1);
            copyToZip(zipfs);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String,String > providerProps = new HashMap<>();
        providerProps.put("create","true");
        URI zipUri = new URI("jar:file",zipPath.toUri().getPath(),null);
        FileSystem zipFs = FileSystems.newFileSystem(zipUri,providerProps);
        return zipFs;
    }

    private static void copyToZip(FileSystem zipFs) throws IOException{
        Path srcFile = Paths.get("file.txt");
        Path dstFile = zipFs.getPath("/copiedfile.txt");
        Files.copy(srcFile,dstFile,StandardCopyOption.REPLACE_EXISTING);
    }

    private static void writeToFileInZip(FileSystem zipFs, String[] data) throws IOException {

//        one way of doing it
//        try(BufferedWriter bw = Files.newBufferedWriter(zipFs.getPath("/newFile.txt"))) {
//            for(String string:data) {
//                bw.write(string);
//                bw.newLine();
//            }
//        }

//        other way of doing the same
        Files.write(zipFs.getPath("/newFile.txt"),Arrays.asList(data),
                Charset.defaultCharset(), StandardOpenOption.CREATE);
//        we did aslist because it do not have any interface for string datatype

    }

};