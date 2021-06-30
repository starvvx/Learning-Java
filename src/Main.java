
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) {
        _bank bk = new _bank(150,"vaibhav ka account");
        saveAccount(bk,"accountInfo.dat");
        _bank bk1 = loadAccount("accountInfo.dat");
        bk1.showData();
    }

    public static void saveAccount(_bank bk, String filename) {
        try(ObjectOutputStream ob =
        new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            ob.writeObject(bk);
        } catch (Exception ex) {
            System.out.println(ex.getClass().getSimpleName() + " - " + ex.getMessage());
        }
    }

    public static _bank loadAccount(String filename) {
        _bank ac = null;
        try(ObjectInputStream is =
                    new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            ac = (_bank)is.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getClass().getSimpleName() + " - " + ex.getMessage());
        }
        return ac;
    }
};