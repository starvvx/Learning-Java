package org.vaibhav.reflection.Provider;

import org.vaibhav.reflection.annotation.Provides;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionProvider {

    @Provides
    public Connection buildConnection() throws SQLException {
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:h2:/home/vaibhav/IdeaProjects/Creating-metamodel/db-files/dv",
                        "sa","");
        return connection;
    }
}
