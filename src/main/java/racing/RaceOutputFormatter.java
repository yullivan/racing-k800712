package racing;

import java.util.List;

public class RaceOutputFormatter {
    private static final String CarIcon = "🚗";
    private static final String MoveIcon = "‍🌈";
    private static final String FinishIcon = "🏁";
    private static final String TrophyIcon = "🏆";


    public static String formatMoveCount(Car car) {
        return car.getName() + ": " + car.getMoveCount() + "회";
    }

    public static String formatCarPosition(Car car) {
        return car.getName() + " " + CarIcon + MoveIcon.repeat(car.getPosition())
                + " (이동 횟수: " + car.getMoveCount() + ")";
    }

    public static String formatWinner(Car car) {
        return formatCarPosition(car) + FinishIcon;
    }

    public static String formatWinnerAnnouncement(List<String> winners) {
        if (winners.size() > 1) {
            return TrophyIcon + "공동 우승자는 " + String.join(", ", winners) + "!";
        } else {
            return TrophyIcon + "우승자는 " + String.join(", ", winners) + "!";
        }

    }
}

