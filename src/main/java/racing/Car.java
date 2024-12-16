package racing;

public class Car {
    private static final int MAX_NAME_LENGTH = 10;
    private static final int FORWARD_THRESHOLD = 6;
    private static final int FORWARD_DISTANCE = 1;

    private final String name;
    private int position;
    private int totalDistance;
    private int moveCount;


    public void move(int number) {
        if (number >= FORWARD_THRESHOLD) {
            position += FORWARD_DISTANCE;
            totalDistance += FORWARD_DISTANCE;
            moveCount++;
        }
    }

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 10자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = 0;
        this.totalDistance = 0;
        this.moveCount = 0;


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
    public int getMoveCount() {
        return moveCount;
    }


    @Override
    public String toString() {
        return name + " " + CAR_ICON + MOVE_ICON.repeat(position)+ " (이동 횟수: " + moveCount + ")";
    }

}
