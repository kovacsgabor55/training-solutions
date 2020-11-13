package arrayofarrays;

public class ArrayOfArraysMain {
    int[][] multiplicationTable(int size) {
        int[][] returns = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                returns[i][j] = (i + 1) * (j + 1);
            }
        }
        return returns;
    }



    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();
        int[][] ma = arrayOfArraysMain.multiplicationTable(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ma[i][j] + " ");
            }
            System.out.println();
        }
    }
}
