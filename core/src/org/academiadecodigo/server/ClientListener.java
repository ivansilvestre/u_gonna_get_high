package org.academiadecodigo.server;

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
        }
        catch (IOException e){

            e.printStackTrace();
        }


    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
