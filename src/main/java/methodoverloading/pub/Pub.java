package methodoverloading.pub;

import methodoverloading.Time;

public class Pub {
    private String name;
    private Time time;

    public Pub(String name, int hours, int minutes) {

        this.name = name;
        this.time = new Time(hours, minutes);
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return time.getHours();
    }

    public int getMinutes() {
        return time.getMinutes();
    }

    public Time getTime() {
        return time;
    }

    @Override
    public String toString() {
        return name + ';' + time.getHours() + ':' + time.getMinutes();
    }

    public Pub getOpenFrom() {
        return this;
    }
}
