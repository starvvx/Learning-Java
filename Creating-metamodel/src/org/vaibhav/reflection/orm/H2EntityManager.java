package org.vaibhav.reflection.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2EntityManager<T> extends AbstractEntityManager{
    public Connection buildConnection() throws SQLException {
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:h2:/home/vaibhav/IdeaProjects/Creating-metamodel/db-files/dv",
                        "sa","");
        return connection;
    }
}
