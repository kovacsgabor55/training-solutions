package stringbasic;

import java.util.ArrayList;
import java.util.List;

public class Vet {
    List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    public void add(Pet pet) {
        boolean exists = false;

        for (Pet onePet : pets) {
            if (areEquals(pet, onePet)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            pets.add(pet);
        }
    }

    private boolean areEquals(Pet pet1, Pet pet2) {
        return pet1.registrationNumber.equals(pet2.registrationNumber);
    }
}