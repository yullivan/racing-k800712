package racing;

public class Car {
    private static final int MaxNameLength = 10;
    private static final int ForwardThreshold = 6;
    private static final String CarIcon = "🚗";
    private static final String MoveIcon = "‍🌈";
    private static final int MaxMove = 3;

    private final String name;
    private int position;
    private int totalDistance;

    public void move(int number) {
        if (number >= ForwardThreshold) {

            int moveDistance = RandomNumberGenerator.generateBetween(1, MaxMove);
            position += moveDistance;
            totalDistance += moveDistance;
        }
    }

    public Car(String name) {
        if (name.length() > MaxNameLength) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 10자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = 0;
        this.totalDistance = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getTotalDistance() {
        return totalDistance;
    }


    @Override
    public String toString() {
        return name + " " + CarIcon + MoveIcon.repeat(position);
    }

}
