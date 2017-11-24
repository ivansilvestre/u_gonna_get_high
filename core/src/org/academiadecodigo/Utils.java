package org.academiadecodigo;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by codecadet on 24/11/17.
 */
public class Utils {

    public static Integer[] argumentsToInt(String[] arguments) {

        List<Integer> result = new LinkedList<Integer>();

        for (int i = 0; i < arguments.length; i++) {

            if(arguments[i].isEmpty()) continue;
             result.add(Integer.parseInt(arguments[i]));

        }

        return result.toArray(new Integer[]{});
    }

    public static int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
