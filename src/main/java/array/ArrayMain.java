package array;

public class ArrayMain {
    public static void main(String[] args) {
        String[] days = {"Hétfő", "Kedd", "Szerda", "Csütörök", "Péntek", "Szombat", "Vasárnap"};
        System.out.println(days[1]);
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) Math.pow(2, i);
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
                    }

        boolean[] booleans = {false, true, false, true, false, true};
        for (int i = 0; i < booleans.length; i++) {
            System.out.println(booleans[i]);
        }
    }
}
