
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Properties props = new Properties();

        props.setProperty("name","Vaibhav");
        props.setProperty("Surname", "verma");

        try(OutputStream out = Files.newOutputStream(Paths.get("props.Xml"))) {
            props.storeToXML(out, "My comment");
        } catch (Exception ex) {
            System.out.println(ex.getClass().getSimpleName() + " - " + ex.getMessage());
        }
    }

};