package week04;

import java.util.Scanner;

public class NameChanger {
    private String fullName;

    public NameChanger(String fullName) {
        if (fullName == null || fullName.trim().equals("")) {
            throw new IllegalArgumentException("Invalid name: " + fullName);
        }
        this.fullName = fullName;
    }

    public void changeFirstName(String firstName) {
        String[] temp = fullName.split(" ");
        /*fullName=new  StringBuilder((temp[0]))*/
        Scanner scanner = new Scanner(fullName);
        String vezetek = scanner.next();
        this.fullName = vezetek + " " + firstName;
    }
}
