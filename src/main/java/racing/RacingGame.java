package racing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class RacingGame {
    private Scanner scanner;

    public RacingGame() {
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        List<String> carNames = inputCarNames();
        int rounds = inputRounds();

        Race race = new Race(carNames, rounds);
        race.start();
    }

    private List<String> inputCarNames() {
        while (true) {
            try {
                System.out.println("레이스에 참가할 자동차들의 이름을 쉼표(,)로 구분하여 입력하세요.");
                String input = scanner.nextLine();
                List<String> carNames = Arrays.asList(input.split(","));
                InputValidator.validateCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputRounds() {
        while (true) {
            try {
                System.out.println("몇 회 시행할까요?");
                int rounds = Integer.parseInt(scanner.nextLine());
                InputValidator.validateRounds(rounds);
                return rounds;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}





