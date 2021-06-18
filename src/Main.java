
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Properties props = new Properties();

        try(InputStream in = Files.newInputStream(Paths.get("props.Xml"))) {
            props.loadFromXML(in);
        }
        catch (Exception ex) {
            System.out.println(ex.getClass().getSimpleName() + " - " + ex.getMessage());
        }
        String val1 = props.getProperty("name");
        String val2 = props.getProperty("Surname");
        System.out.println(val1 + " " + val2);
    }

};