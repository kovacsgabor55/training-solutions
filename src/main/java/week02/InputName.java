package week02;

import java.util.Scanner;

public class InputName {
    public static void main(String[] args) {
        String[] nevek;
        Scanner sc = new Scanner(System.in);
        nevek = new String[5];
        System.out.println("kérek 5 nevet enterrel elválasztva:");
        for (int i = 0; i < nevek.length; i++) {
            nevek[i] = sc.nextLine();
        }

        for (int i = 0; i < nevek.length; i++) {
            System.out.println("elem: " + (i + 1) + " tartalom: " + nevek[i]);
        }
    }
}
