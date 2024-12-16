package racing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;


public class RaceTest {
    @Test
    void testRaceConstructor() {
        Race race = new Race(Arrays.asList("Car1", "Car2", "Car3"), 5);
        assertNotNull(race);
    }

    @Test
    void testRaceWithMultipleRounds() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Race race = new Race(Arrays.asList("Car1", "Car2"), 3);
        race.start();

        String output = outContent.toString();
        assertTrue(output.contains("(1)"));
        assertTrue(output.contains("(2)"));
        assertTrue(output.contains("(3)"));
        assertTrue(output.contains("Car1") || output.contains("Car2"));

        assertTrue(output.contains("🏆우승자는") || output.contains("🏆공동 우승자는"));

        System.setOut(System.out);
    }

    @Test
    void testWinnersAnnouncement() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Race race = new Race(Arrays.asList("Car1", "Car2"), 1);

        race.start();

        String output = outContent.toString();

        assertTrue(output.contains("🏆공동 우승자는 Car1, Car2!"));

        System.setOut(System.out);
    }

    @Test
    void testRaceProgress() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        int rounds = 5;
        Race race = new Race(carNames, rounds);

        race.start();

        // 레이스 후 적어도 하나의 차가 이동했는지 확인
        boolean atLeastOneCarMoved = race.getCars().stream()
                .anyMatch(car -> car.getPosition() > 0);
        assertTrue(atLeastOneCarMoved);
    }

    @Test
    void testWinnerSelection() {
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");
        Race race = new Race(carNames, 10);
        race.start();

        List<String> winners = race.getWinners();
        assertFalse(winners.isEmpty());

        // 우승자의 거리가 다른 차들보다 크거나 같은지 확인
        int winningDistance = race.getCars().stream()
                .filter(car -> winners.contains(car.getName()))
                .findFirst()
                .map(Car::getTotalDistance)
                .orElse(0);

        for (Car car : race.getCars()) {
            assertTrue(car.getTotalDistance() <= winningDistance);
        }
    }
}


