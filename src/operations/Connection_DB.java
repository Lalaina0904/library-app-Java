package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connection_DB {
    private String username;
    private String password;
    private String databaseName;
    private Connection connection;
    private static Connection_DB connection_DB;

    private Connection_DB() {
        username="prog_admin";
        password = System.getenv("password");
        databaseName = "library_management";
        createStatement();
    }

    private void createStatement() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost/" + this.databaseName,this.username, this.password );
            //afficher un message si la connexion est réussie
            System.out.println("----- Connexion réussie ! ------");
        } catch (SQLException e) {
            //afficher un message si la connexion est échouée
            System.out.println("----- Erreur de connexion ! ------");
        }
    }
    public static Connection_DB getInstance() {
        if(connection_DB == null){
            connection_DB = new Connection_DB();
        }
        return connection_DB;
    }

    public Connection ConnectToDatabase(){
        return connection;
    }
}
