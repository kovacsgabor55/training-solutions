package methodargvars.examstats;

public class ExamStats {
    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {

        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        int count = 0;
        for (int item : results) {
            if (item > limitInPercent) {
                count++;
            }
        }
        return count;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        for (int item : results) {
            if (item < limitInPercent) {
                return true;
            }
        }
        return false;
    }
}
