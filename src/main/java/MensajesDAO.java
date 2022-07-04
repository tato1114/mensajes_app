import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    private static Connection conexionDB = null;

    private static Connection getConexionDB() {
        if(conexionDB == null) {
            Conexion db_connect = new Conexion();
            conexionDB = db_connect.get_connection();
        }
        return conexionDB;
    }

    public static void crearMensajeDB(Mensajes mensaje) {
        PreparedStatement ps = null;
        try {
            Connection conexion = getConexionDB();
            String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
            ps = conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutorMensaje());

            ps.executeUpdate();
            System.out.println("El mensaje ha sido creado");
        } catch (SQLException e) {
            System.out.println("No se pudo crear el mensaje");
            System.out.println(e);
        }
    }

    public static void leerMensajesDB() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conexion = getConexionDB();
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("*******************************");
            }
        } catch (SQLException e) {
            System.out.println("No se pudieron obtener datos");
            System.out.println(e);
        }
    }

    public static void borrarMensajesDB(int idMensaje) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conexion = getConexionDB();
            String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, idMensaje);
            ps.executeUpdate();
            System.out.println("El mensaje ha sido borrado");
        } catch (SQLException e) {
            System.out.println("No se pudo borrar el mensaje");
            System.out.println(e);
        }

    }

    public static void actualizarMensajesDB(Mensajes mensaje) {
        PreparedStatement ps = null;
        try {
            Connection conexion = getConexionDB();
            String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
            ps = conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setInt(2, mensaje.getIdMensaje());

            ps.executeUpdate();
            System.out.println("El mensaje ha sido actualizado");
        } catch (SQLException e) {
            System.out.println("No se pudo actualizar el mensaje");
            System.out.println(e);
        }

    }
}
