package week15d04;

import org.jetbrains.annotations.NotNull;

public class CovidCaseByWeek implements Comparable<CovidCaseByWeek> {
    private final String week;
    private final int cases;

    public CovidCaseByWeek(String week, int cases) {
        this.week = week;
        this.cases = cases;
    }

    public String getWeek() {
        return week;
    }

    @Override
    public String toString() {
        return "CovidCaseByWeek{" + "week='" + week + '\'' + ", cases=" + cases + '}';
    }

    @Override
    public int compareTo(@NotNull CovidCaseByWeek o) {
        return o.cases - this.cases;
    }
}
