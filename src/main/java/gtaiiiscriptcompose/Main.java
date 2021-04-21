package gtaiiiscriptcompose;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        if (Progressor.loadFileList(name)) {
            Progressor.compose();
        }
    }
}
