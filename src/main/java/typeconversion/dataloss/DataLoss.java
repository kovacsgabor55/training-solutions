package typeconversion.dataloss;

public class DataLoss {
    public void dataLoss() {
        long original = 0;
        long counter = 0;
        while (counter < 3) {
            long converted = (long) (float) original;
            if (converted != original) {
                System.out.println("Original : " + original + " in binary: " + Long.toBinaryString(original));
                System.out.println("Converted: " + converted + " in binary: " + Long.toBinaryString(converted));
                counter++;
            }
            original++;
        }
    }

    public static void main(String[] args) {
        new DataLoss().dataLoss();
    }
}
