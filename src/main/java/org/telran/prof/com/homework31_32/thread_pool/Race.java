package org.telran.prof.com.homework31_32.thread_pool;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Race {

    private List<Horse> horses;
    private Hippodrome hippodrome;
    private int initialDistance = 0;

    private Map<Horse, Long> resultMap = new ConcurrentHashMap<>();

    public Race(List<Horse> horses, Hippodrome hippodrome) {
        this.horses = horses;
        this.hippodrome = hippodrome;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome getHippodrome() {
        return hippodrome;
    }

    public int getInitialDistance() {
        return initialDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return initialDistance == race.initialDistance && Objects.equals(horses, race.horses) && Objects.equals(hippodrome, race.hippodrome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horses, hippodrome, initialDistance);
    }

    public Map<Horse, Long> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<Horse, Long> resultMap) {
        this.resultMap = resultMap;
    }

    public void startRace() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Horse h : horses) {
            executorService.execute(h);
        }
        executorService.shutdown();
    }

    @Override
    public String toString() {
        return "Race{" +
                "horses=" + horses +
                ", hippodrome=" + hippodrome +
                ", initialDistance=" + initialDistance +
                '}';
    }
}
