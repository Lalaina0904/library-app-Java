package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connection_DB {
    private String username;
    private String password;
    private String databaseName;
    private Connection connection;

    public Connection_DB(String username, String password, String databaseName) {
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
        this.createConnection();
    }

    private void createConnection() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/" + this.databaseName,
                    this.username,
                    this.password
            );

            //afficher un message si la connexion est réussie
            System.out.println("----- Connexion réussie ! ------");
        } catch (SQLException e) {
            //afficher un message si la connexion est échouée
            System.out.println("----- Erreur de connexion ! ------");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
