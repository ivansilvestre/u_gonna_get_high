package org.academiadecodigo.server;

import org.academiadecodigo.Constants;
import org.academiadecodigo.Utils;
import org.academiadecodigo.client.ObjectType;
import org.academiadecodigo.client.objects.ObjectFactory;
import org.academiadecodigo.client.objects.Weed;
import org.academiadecodigo.client.objects.WeedType;
import org.academiadecodigo.events.WeedSpawnEvent;

/**
 * Created by codecadet on 24/11/17.
 */
public class CreateRandomWeed implements Runnable {

    Server server;

    public CreateRandomWeed(Server server) {
        this.server = server;
    }

    @Override
    public void run() {

        while (true) {
            WeedType randomWeed;
            int randomWeedX;
            int randomWeedY;

            randomWeedX = Utils.generateRandomInt(Constants.LEFT_GARDEN_X, Constants.GARDEN_WIDTH + Constants.LEFT_GARDEN_X - 50);
            randomWeedY = Utils.generateRandomInt(Constants.GARDEN_Y, Constants.GARDEN_HEIGHT + Constants.HOUSE_Y);
            randomWeed = WeedType.getRandom();

            System.out.println(randomWeed.ordinal() + "\n" + "-----");

            server.broadcast(new WeedSpawnEvent(randomWeed.ordinal(), randomWeedX, randomWeedY));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
