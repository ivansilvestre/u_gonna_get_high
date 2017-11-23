package org.academiadecodigo.server;

import java.net.Socket;

/**
 * Created by codecadet on 23/11/17.
 */
public class ClientListener implements  Runnable{

    private Socket clientSocket;


    public ClientListener(Socket clientSocket){
        this.clientSocket = clientSocket;
    }


    public void interpretMessage(){

    }

    public void listen(){

    }

    @Override
    public void run() {

    }


    public Socket getClientSocket() {
        return clientSocket;
    }
}
