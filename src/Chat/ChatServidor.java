package Chat;

import java.io.*;
import java.net.*;
import javax.swing.*; // Para manejar JTextArea

public class ChatServidor {

    private ServerSocket serverSocket;
    private JTextArea dondEstaranMensajes; // Referencia al JTextArea real de tu ventana gráfica

    /**
     * Constructor del servidor.
     *
     * @param puerto Puerto en el que escuchará el servidor.
     * @param dondEstaranMensajes JTextArea donde se mostrarán los mensajes
     * recibidos.
     * @throws IOException Si ocurre algún error al iniciar el servidor.
     */
    public ChatServidor(int puerto, JTextArea dondEstaranMensajes) throws IOException {
        this.serverSocket = new ServerSocket(puerto);
        this.dondEstaranMensajes = dondEstaranMensajes;
        this.dondEstaranMensajes.append("Servidor iniciado en el puerto " + puerto + "\n");
        iniciarServidor();
    }

    /**
     * Método para iniciar el servidor en un hilo separado.
     */
    private void iniciarServidor() {
        new Thread(() -> {
            while (true) {
                try (Socket socket = serverSocket.accept(); BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    // Leer el mensaje enviado por el cliente
                    String mensaje = reader.readLine();

                    // Mostrar el mensaje recibido en el área de texto
                    dondEstaranMensajes.append("Mensaje recibido: " + mensaje + "\n");
                } catch (IOException e) {
                    dondEstaranMensajes.append("Error al recibir el mensaje: " + e.getMessage() + "\n");
                }
            }
        }).start();
    }

    /**
     * Método para enviar un mensaje al cliente conectado.
     *
     * @param socket El socket conectado al cliente.
     * @param mensaje El mensaje a enviar.
     */
    public void enviarMensaje(Socket socket, String mensaje) {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println(mensaje);
            dondEstaranMensajes.append("Mensaje enviado: " + mensaje + "\n");
        } catch (IOException e) {
            dondEstaranMensajes.append("Error al enviar el mensaje: " + e.getMessage() + "\n");
        }
    }

    /**
     * Método para cerrar el servidor.
     *
     * @throws IOException Si ocurre un error al cerrar el servidor.
     */
    public void cerrar() throws IOException {
        serverSocket.close();
        dondEstaranMensajes.append("Servidor cerrado.\n");
    }
}
