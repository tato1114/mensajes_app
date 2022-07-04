import java.util.Scanner;

public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Escribe tu nombre");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);

        MensajesDAO.crearMensajeDB(registro);
    }

    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el id del mensaje a borrar");
        int idMensaje = sc.nextInt();

        MensajesDAO.borrarMensajesDB(idMensaje);

    }

    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Escribe el id del mensaje a actualizar");
        int idMensaje = sc.nextInt();

        Mensajes actualizacion = new Mensajes();
        actualizacion.setMensaje(mensaje);
        actualizacion.setIdMensaje(idMensaje);

        MensajesDAO.actualizarMensajesDB(actualizacion);

    }
}
