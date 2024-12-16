package racing;

import java.util.List;

public class InputValidator {

        public static void validateCarNames(List<String> carNames) {
            if (carNames.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름을 입력해주세요.");
            }

            for (String name : carNames) {
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 문자열일 수 없습니다.");
                }
                if (name.length() > 10) {
                    throw new IllegalArgumentException("[ERROR] 자동차 이름은 10자를 초과할 수 없습니다.");
                }
            }
        }
        public static void validateRounds(int rounds) {
            if (rounds <= 0) {
                throw new IllegalArgumentException("[ERROR] 시행 횟수는 1 이상이어야 합니다.");
            }
        }
    }

