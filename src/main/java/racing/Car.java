package racing;

public class Car {
    private static final int MaxNameLength = 10;
    private static final int ForwardThreshold = 6;
    private static final String CAR_ICON = "🚗";
    private static final String MOVE_ICON = "-";

    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > MaxNameLength) {
            throw new IllegalArgumentException("[ERROR]");
        }
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number <= ForwardThreshold) {
            position++;
        }
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
