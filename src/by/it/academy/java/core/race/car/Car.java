package by.it.academy.java.core.race.car;

import by.it.academy.java.core.race.Distance;
import java.util.ArrayList;
import java.util.List;

public abstract class Car {

    private final int number;
    private final int startPosition;
    private final int finishPosition;
    private final int speed;
    private final List<Distance> distances;
    private int currentPosition;

    public Car(int number, int startPosition, int finishPosition, int speed) {
        this.number = number;
        this.startPosition = startPosition;
        this.finishPosition = finishPosition;
        this.speed = speed;
        this.distances = new ArrayList<>();
        this.currentPosition = startPosition;
    }

    public boolean forwardMove() {
        if (currentPosition < finishPosition) {
            int finishDistancePosition = currentPosition + speed;
            distances.add(new Distance(number, currentPosition, finishDistancePosition));
            currentPosition = finishDistancePosition;
            return true;
        }
        return false;
    }

    public int getNumber() {
        return number;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getFinishPosition() {
        return finishPosition;
    }

    public List<Distance> getDistances() {
        return distances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (number != car.number) return false;
        if (startPosition != car.startPosition) return false;
        if (finishPosition != car.finishPosition) return false;
        if (speed != car.speed) return false;
        if (currentPosition != car.currentPosition) return false;
        return distances.equals(car.distances);
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + startPosition;
        result = 31 * result + finishPosition;
        result = 31 * result + speed;
        result = 31 * result + distances.hashCode();
        result = 31 * result + currentPosition;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number=" + number +
                ", startPosition=" + startPosition +
                ", finishPosition=" + finishPosition +
                ", speed=" + speed +
                ", distances=" + distances +
                ", currentPosition=" + currentPosition +
                '}';
    }
}
