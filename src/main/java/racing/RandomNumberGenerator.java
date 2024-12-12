package racing;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int MIN = 1;
    private static final int MAX = 6;

    public static int generate() {
        return RANDOM.nextInt(MAX - MIN + 1) + MIN;
    }

    public static int generateBetween(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

}