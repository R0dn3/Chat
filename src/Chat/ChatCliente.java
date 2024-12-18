/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

import java.io.*;
import java.net.*;

public class ChatCliente {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ChatCliente(String host, int puerto) throws IOException {
        socket = new Socket(host, puerto);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void enviarMensaje(String mensaje) {
        writer.println(mensaje);
    }

    public String recibirMensaje() throws IOException {
        return reader.readLine();
    }

    public void cerrar() throws IOException {
        socket.close();
    }
}
