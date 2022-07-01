import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_connection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","root");
            if(connection != null){
                System.out.println("conexion exitosa");
            }
        } catch (SQLException e){
            System.out.println("error " + e);
        }

        return connection;
    }
}
