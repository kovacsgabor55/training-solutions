package testpractice;

public class TestPracticeMain {
    public static void main(String[] args) {
        String number = Integer.toBinaryString(9);//Eredmény "1001"
        number = Integer.toBinaryString(9 >> 1);//Eredmény "100"

        System.out.println(number);

        //1001 -> 0100

        BankAccount ba = new BankAccount("223456", 100);
        ba.deposit(200);

        int[][] array = new int[11][11];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                //for (int j = 0; j <= i; j++) {
                //array[i][j] = i;
                array[i][j] = i * j;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }
}
