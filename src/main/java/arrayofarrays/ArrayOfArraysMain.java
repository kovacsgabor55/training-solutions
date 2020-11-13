package arrayofarrays;

public class ArrayOfArraysMain {
    public int[][] multiplicationTable(int size) {
        int[][] returns = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                returns[i][j] = (i + 1) * (j + 1);
            }
        }
        return returns;
    }

    public void printArrayOfArrays(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.multiplicationTable(4));
    }
}
