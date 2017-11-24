package org.academiadecodigo.server;

import org.academiadecodigo.Constants;
import org.academiadecodigo.Utils;
import org.academiadecodigo.client.ObjectType;
import org.academiadecodigo.client.objects.Chore;
import org.academiadecodigo.client.objects.ChoreType;
import org.academiadecodigo.client.objects.ObjectFactory;
import org.academiadecodigo.client.objects.WeedType;
import org.academiadecodigo.events.ChoreSpawnEvent;

/**
 * Created by codecadet on 24/11/17.
 */
public class CreateRandomChore implements Runnable {

    Server server;

    public CreateRandomChore(Server server) {
        this.server = server;
    }

    @Override
    public void run() {


        while (true) {
            ChoreType randomChore;
            int randomChoreX;
            int randomChoreY;


            randomChoreX = Utils.generateRandomInt(Constants.LEFT_HOUSE_X, Constants.HOUSE_WIDTH + Constants.LEFT_HOUSE_X);
            randomChoreY = Utils.generateRandomInt(Constants.HOUSE_Y, Constants.HOUSE_HEIGHT + Constants.HOUSE_Y);


            randomChore = ChoreType.getRandomChore();

            System.out.println(randomChore.ordinal());

            server.broadcast(new ChoreSpawnEvent(ObjectType.CHORE, randomChore.ordinal(), randomChoreX, randomChoreY));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
