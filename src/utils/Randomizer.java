package utils;

import java.util.Random;

/**
 * Created by borys on 03.06.2016.
 */
public class Randomizer {

    public int getRandomInt (int x){
        final Random random = new Random();
        int val = random.nextInt(x+1);
        return val;

    }

}
