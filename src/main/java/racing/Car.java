package racing;

public class Car {
    private static final int MaxNameLength = 10;
    private static final int ForwardThreshold = 6;
    private static final String CAR_ICON = "🚗";
    private static final String MOVE_ICON = "‍🌈";
    private static final int MaxMove = 3;

    private final String name;
    private int position;

    public void move(int number) {
        if (number >= ForwardThreshold) {

            position += RandomNumberGenerator.generateBetween(1, MaxMove);
        }
    }

    public Car(String name) {
        if (name.length() > MaxNameLength) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 10자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " " + CAR_ICON + MOVE_ICON.repeat(position);
    }

}
