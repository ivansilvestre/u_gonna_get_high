package org.academiadecodigo.server;

import com.badlogic.gdx.utils.Timer;
import org.academiadecodigo.Constants;
import org.academiadecodigo.Utils;
import org.academiadecodigo.client.ObjectType;
import org.academiadecodigo.client.objects.Chore;
import org.academiadecodigo.client.objects.ObjectFactory;
import org.academiadecodigo.client.objects.Weed;
import org.academiadecodigo.events.Event;
import org.academiadecodigo.events.IdAssignEvent;
import org.academiadecodigo.events.ChoreSpawnEvent;
import org.academiadecodigo.events.WeedSpawnEvent;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by codecadet on 23/11/17.
 */
public class Server {

    private final int MAX_PLAYERS = 2;
    private final int PORT = 9999;
    private ServerSocket serverSocket;
    private Socket[] sockets;
    private ExecutorService cachedPool;


    public Server() {
        cachedPool = Executors.newCachedThreadPool();
        sockets = new Socket[MAX_PLAYERS];
    }


    public void init() {
        try {
            serverSocket = new ServerSocket(PORT);
            acceptClients();     //accepts 2 players
            CreateRandomChore createRandomChore = new CreateRandomChore(this);
            CreateRandomWeed createRandomWeed = new CreateRandomWeed(this);
            new Thread(createRandomChore).start();
            new Thread(createRandomWeed).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void acceptClients() throws IOException {

        for (int i = 0; i < MAX_PLAYERS; i++) {


            Socket connection = serverSocket.accept();
            sockets[i] = connection;

            ClientListener clientListener = new ClientListener(connection, this);
            cachedPool.submit(clientListener);

            sendMessageTo(connection, (new IdAssignEvent(i)).toString());

            System.out.println("client accepted " + connection.getInetAddress().getHostName());

        }
    }

    public void sendMessageTo(Socket clientSocket, String message) throws IOException {

        System.out.println(message);

        PrintStream out = new PrintStream((clientSocket.getOutputStream()), true);
        out.println(message);

    }

    public void broadcast(Event event) {
        broadcast(event.toString());
    }

    public void broadcast(String message) {

        for (Socket s : sockets) {

            try {
                PrintStream out = new PrintStream(s.getOutputStream());
                out.println(message);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
