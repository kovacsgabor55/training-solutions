package arraylist;

import java.util.ArrayList;

public class Capsules {
    private ArrayList<String> pipe = new ArrayList<>();

    public void addLast(String capsule) {
        pipe.add(capsule);
    }

    public void addFirst(String capsule) {
        pipe.add(0, capsule);
    }

    public void removeFirst() {
        pipe.remove(0);
    }

    public void removeLast() {
        pipe.remove(pipe.size() - 1);
    }

    public ArrayList<String> getColors() {
        return pipe;
    }

    public static void main(String[] args) {
        Capsules capsules = new Capsules();
        capsules.addFirst("fekete");
        capsules.addFirst("fehér");
        capsules.addFirst("lila");
        capsules.addLast("sárga");
        ArrayList<String> returned = capsules.getColors();
        for (String item : returned) {
            System.out.println(item);
        }
        System.out.println();
        capsules.removeFirst();
        capsules.removeLast();

        returned = capsules.getColors();
        for (String item : returned) {
            System.out.println(item);
        }

    }
}
