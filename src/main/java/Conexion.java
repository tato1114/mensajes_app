import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection connection = null;

    public Connection get_connection(){
        if (connection == null) {
            try {
                String host="jdbc:mysql://localhost:3306/";
                String database = "mensajes_app";
                String url = host + database;
                String user="root";
                String pass="root";
                connection = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                System.out.println("error " + e);
            }
        }
        return connection;
    }
}
