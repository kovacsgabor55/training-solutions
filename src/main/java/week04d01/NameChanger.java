package week04d01;

import java.util.Scanner;

public class NameChanger {
    private String fullName;
    Scanner scanner = new Scanner(fullName);

    public NameChanger(String fullName) {
        if (fullName == null || fullName.trim().equals("")) {
            throw new IllegalArgumentException("Invalid name: " + fullName);
        }
        this.fullName = fullName;
    }

    public void changeFirstName(String firstName) {
        //String[] temp = fullName.split(" ");
        /*fullName=new  StringBuilder((temp[0]))*/
        String vezetek = scanner.next();
        this.fullName = vezetek + " " + firstName;
    }
}
