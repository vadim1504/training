package by.it.academy.java.core.race;

public class Distance {

    private final int numberCar;
    private final int startPosition;
    private final int finishPosition;
    private final int length;

    public Distance(int numberCar, int startPosition, int finishPosition) {
        this.numberCar = numberCar;
        this.startPosition = startPosition;
        this.finishPosition = finishPosition;
        this.length = finishPosition - startPosition;
    }

    public int getNumberCar() {
        return numberCar;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getFinishPosition() {
        return finishPosition;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distance distance = (Distance) o;

        if (numberCar != distance.numberCar) return false;
        if (startPosition != distance.startPosition) return false;
        if (finishPosition != distance.finishPosition) return false;
        return length == distance.length;
    }

    @Override
    public int hashCode() {
        int result = numberCar;
        result = 31 * result + startPosition;
        result = 31 * result + finishPosition;
        result = 31 * result + length;
        return result;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "numberCar=" + numberCar +
                ", startPosition=" + startPosition +
                ", finishPosition=" + finishPosition +
                ", length=" + length +
                '}';
    }
}
