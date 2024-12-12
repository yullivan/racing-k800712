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
            int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
            List<String> winners = cars.stream()
                    .filter(car -> car.getPosition() == maxPosition)
                    .map(Car::getName)
                    .collect(Collectors.toList());
            for (Car car : cars) {
                if (car.getPosition() == maxPosition) {
                    System.out.println(car + "🏁");
                } else {
                    System.out.println(car);
                }
            }

            System.out.println("🏆우승자는 " + String.join(", ", winners) + "!");
        }
    }

