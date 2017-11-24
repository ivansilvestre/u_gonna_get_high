package org.academiadecodigo.client;

import org.academiadecodigo.Utils;
import org.academiadecodigo.events.Event;
import org.academiadecodigo.events.EventType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by codecadet on 23/11/17.
 */
public class ServerListener implements Runnable {

    private final String SERVER_IP = "localhost";
    private Socket socket;
    private GameLogic game;

    public ServerListener(GameLogic game) {
        this.game = game;
    }

    @Override
    public void run() {

        connectToServer();
        listen();
    }

    private void connectToServer() {

        try {
            socket = new Socket(SERVER_IP, 9999);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listen() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

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

    public void interpretMessage(String message) {

        int[] arguments = Utils.argumentsToInt(message.split(" "));
        EventType event = EventType.values()[(arguments[0])];

        switch (event) {
            case START:
                // game.start();
                break;

            case PLAYER_ASSIGN:
                game.setPlayerId(arguments[1]);
                break;

            case PLAYER_MOVE:
                game.movePlayer(arguments[1], arguments[2], arguments[3]);
                break;

            case CHORE_SPAWN:
                // game.spawnObject(type, x, y);
                break;

            default:
                System.out.println("Unknown event");
        }
    }

    public void sendMessage(Event event) {

        try {
            PrintStream out = new PrintStream((socket.getOutputStream()), true);
            out.println(event.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
