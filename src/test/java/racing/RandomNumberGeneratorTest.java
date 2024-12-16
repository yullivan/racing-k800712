package racing;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomNumberGeneratorTest {

    @Test
    void testGenerate() {
        for (int i = 0; i < 1000; i++) {
            int number = RandomNumberGenerator.generate();
            assertTrue(number >= 1 && number <= 6);
        }
    }

    @Test
    void testGenerateBetween() {
        for (int i = 0; i < 1000; i++) {
            int number = RandomNumberGenerator.generateBetween(1, 3);
            assertTrue(number >= 1 && number <= 3);
        }
    }
}
