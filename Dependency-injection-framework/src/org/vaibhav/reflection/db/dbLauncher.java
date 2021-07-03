package org.vaibhav.reflection.db;

import org.h2.tools.Server;

import java.sql.SQLException;

public class dbLauncher {

    public static void main(String[] args) throws SQLException {

        Server.main();
        System.out.println("Db launched");
    }
}
