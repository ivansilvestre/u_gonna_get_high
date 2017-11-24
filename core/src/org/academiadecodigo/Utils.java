package org.academiadecodigo;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by codecadet on 24/11/17.
 */
public class Utils {

    public static int[] argumentsToInt(String[] arguments) {

        int[] result = new int[arguments.length];

        for (int i = 0; i < result.length; i++) {

            result[i] = Integer.parseInt(arguments[i]);

        }

        return result;
    }

    public static int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
