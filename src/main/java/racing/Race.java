package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
public class Race {

        private final List<Car> cars;
        private final int rounds;

        public Race(List<String> carNames, int rounds) {
            this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
            this.rounds = rounds;
        }

        public void start() {
            for (int i = 1; i <= rounds; i++) {
                System.out.println("(" + i + ")");
                moveCars();
                printCarPositions();
                System.out.println();
            }
            announceWinners();
        }

        private void moveCars() {
            for (Car car : cars) {
                car.move(RandomNumberGenerator.generate());
            }
        }

        private void printCarPositions() {
            for (Car car : cars) {
                System.out.println(car);
            }
        }

        private void announceWinners() {
            int maxDistance = cars.stream().mapToInt(Car::getTotalDistance).max().orElse(0);
            List<String> winners = cars.stream()
                    .filter(car -> car.getTotalDistance() == maxDistance)
                    .map(Car::getName)
                    .collect(Collectors.toList());

            for (Car car : cars) {
                if (car.getTotalDistance() == maxDistance) {
                    System.out.println(car + "🏁");
                } else {
                    System.out.println(car);
                }
            }

            System.out.println("🏆우승자는 " + String.join(", ", winners) + "!");
        }
    }

