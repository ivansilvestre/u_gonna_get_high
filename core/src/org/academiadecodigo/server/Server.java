package org.academiadecodigo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 * Created by codecadet on 23/11/17.
 */
public class Server {

    private final int MAXPLAYERS = 2 ;
    private final int PORT = 9999;
    private ArrayList<ClientListener> players;
    private ServerSocket serverSocket;


    public Server() {
        this.players = new ArrayList<ClientListener>();
        serverSocket = null;
    }


    public void init() {


        try {

            serverSocket = new ServerSocket(PORT);
            acceptClient();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void acceptClient() throws IOException {


        while(players.size() < MAXPLAYERS) {

            Socket connection = serverSocket.accept();
            ClientListener clientListener = new ClientListener();

            System.out.println("client accepted "+ connection.getInetAddress().getHostName());

            players.add(clientListener);
        }
    }


    public void sendMessageTo() {

    }


    public void broadcast() {

    }

    public void generateGameObjects() {

    }

}
