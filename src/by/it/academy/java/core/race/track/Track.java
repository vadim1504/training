package by.it.academy.java.core.race.track;

public abstract class Track {

    private final int length;
    private final int startPosition;
    private final int finishPosition;
    private final TrackType type;

    public Track(int length, TrackType type) {
        this.length = length;
        this.type = type;
        this.startPosition = 0;
        this.finishPosition = length;
    }

    public int getLength() {
        return length;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getFinishPosition() {
        return finishPosition;
    }

    public TrackType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (length != track.length) return false;
        if (startPosition != track.startPosition) return false;
        if (finishPosition != track.finishPosition) return false;
        return type == track.type;
    }

    @Override
    public int hashCode() {
        int result = length;
        result = 31 * result + startPosition;
        result = 31 * result + finishPosition;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Track{" +
                "length=" + length +
                ", startPosition=" + startPosition +
                ", finishPosition=" + finishPosition +
                ", type=" + type +
                '}';
    }
}
