package by.it.academy.java.core.race;

import by.it.academy.java.core.race.car.Car;
import by.it.academy.java.core.race.car.RacingCar;
import by.it.academy.java.core.race.track.DirectTrack;
import by.it.academy.java.core.race.track.Track;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Race {

    private Logger log = Logger.getLogger(Race.class.getName());

    private static Random random = new Random();

    private final Set<Car> carsAtStart;
    private Track track;
    private List<Car> carsOnWay;

    public Race(Track track, Set<Car> carsAtStart) {
        this.track = track;
        this.carsAtStart = carsAtStart;
    }

    public void start() {
        log.info("Гонка началась!");
        carsOnWay = new ArrayList<>(carsAtStart);
        carsAtStart.clear();
        go();
    }

    private void go() {
        while (!carsOnWay.isEmpty()) {
            carsOnWay.removeIf(next -> !next.forwardMove());
            checkOvertaking();
        }
        finish();
    }

    private void checkOvertaking() {
        List<Distance> lastDistances = carsOnWay.stream()
                .map(Car::getDistances)
                .map(distances -> distances.get(distances.size() - 1))
                .collect(Collectors.toList());

        lastDistances.forEach(lastDistance -> {
            List<Integer> overtaking = lastDistances.stream()
                    .filter(distance -> lastDistance.getStartPosition() <= distance.getStartPosition() && lastDistance.getFinishPosition() > distance.getFinishPosition())
                    .map(Distance::getNumberCar)
                    .collect(Collectors.toList());

            if (!overtaking.isEmpty()) {
                log.log(Level.INFO, "Автомобиль номер: {0} обогнал автомобили номер: {1}", new Object[]{lastDistance.getNumberCar(),  overtaking});
            }
        });
    }

    private void finish() {
        log.info("Гонка закончилась!");
    }

    public static void main(String[] args) {
        DirectTrack directTrack = new DirectTrack(1000);
        int startPosition = directTrack.getStartPosition();
        int finishPosition = directTrack.getFinishPosition();

        Set<Car> racingCars = Stream.of(
                new RacingCar(1, startPosition, finishPosition, 10),
                new RacingCar(2, random.nextInt(directTrack.getFinishPosition()), finishPosition, 100),
                new RacingCar(3, startPosition, finishPosition, 200),
                new RacingCar(4, random.nextInt(directTrack.getFinishPosition()), finishPosition, 10),
                new RacingCar(5, startPosition, finishPosition, 50),
                new RacingCar(6, random.nextInt(directTrack.getFinishPosition()), finishPosition, 5),
                new RacingCar(7, startPosition, finishPosition, 55)
        ).collect(Collectors.toSet());

        Race race = new Race(directTrack, racingCars);
        race.start();
    }
}