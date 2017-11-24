package org.academiadecodigo.server;

import org.academiadecodigo.events.EventType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by codecadet on 23/11/17.
 */
public class ClientListener implements Runnable {

    private Socket clientSocket;
    private BufferedReader bufferedReader;
    private Server server;


    public ClientListener(Socket clientSocket, Server server) {

        this.clientSocket = clientSocket;
        this.server = server;
    }


    public void interpretMessage(String message) {

        String[] arguments = message.split(" ");
        EventType event = EventType.values()[Integer.parseInt(arguments[0])];

        switch (event) {
            case START:
                break;

            case PLAYER_MOVE:
                server.broadcast(message);
                break;

            case OBJECT_SPAWN:
                break;

            default:
                System.out.println("Unknown event");
        }
    }


    @Override
    public void run() {

        listen();
    }


    public void listen() {

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {

                String message = bufferedReader.readLine();

                if (message == null) {
                    continue;
                }

                interpretMessage(message);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
