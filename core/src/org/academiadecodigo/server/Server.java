package org.academiadecodigo.server;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by codecadet on 23/11/17.
 */
public class Server {

    private final int MAXPLAYERS = 2;
    private final int PORT = 9999;
    private ArrayList<ClientListener> players;
    private ServerSocket serverSocket;
    private ExecutorService cachedPool;


    public Server() {
        this.players = new ArrayList<ClientListener>();
        cachedPool = Executors.newCachedThreadPool();

    }


    public void init() {


        try {
            serverSocket = new ServerSocket(PORT);
            acceptClient();
            submitPlayers();
            broadcast("foda-SSSSse");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void acceptClient() throws IOException {


        while (players.size() < MAXPLAYERS) {

            Socket connection = serverSocket.accept();
            ClientListener clientListener = new ClientListener(connection);

            System.out.println("client accepted " + connection.getInetAddress().getHostName());

            players.add(clientListener);

        }
    }

    public void submitPlayers() {

        for (ClientListener clientListener : players) {
            cachedPool.submit(clientListener);
        }
        System.out.println("PLAYERS submited");
    }


    public void sendMessageTo(Socket clientSocket, String message) throws IOException {

        PrintStream out = new PrintStream((clientSocket.getOutputStream()));
        out.println(message);
    }


    public void broadcast(String message) throws IOException {

        for (int i = 0; i < players.size(); i++) {

            PrintStream out = new PrintStream(players.get(i).getClientSocket().getOutputStream());
            out.println(message);

        }
    }

    public void generateGameObjects() {

    }

}
