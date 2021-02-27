package covid;

public class IRSZ {
    private int irsz;
    private String settlement;

    public IRSZ(int irsz, String settlement) {
        this.irsz = irsz;
        this.settlement = settlement;
    }

    public int getIrsz() {
        return irsz;
    }

    public String getSettlement() {
        return settlement;
    }

    @Override
    public String toString() {
        return "IRSZ{" +
                "irsz=" + irsz +
                ", settlement='" + settlement + '\'' +
                '}';
    }
}
