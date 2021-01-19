package week12d02;

public class ReportFence {
    private final Fence fenceType;
    private final int count;

    public ReportFence(Fence fenceType, int count) {
        this.fenceType = fenceType;
        this.count = count;
    }

    public Fence getFenceType() {
        return fenceType;
    }

    public int getCount() {
        return count;
    }
}
