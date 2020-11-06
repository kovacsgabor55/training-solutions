package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (MeetingRoom item : meetingRooms) {
            System.out.println(item.getName());
        }
    }

    public void printNamesReserve() {
        for (int i = meetingRooms.size() - 1; i > 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEventNames() {
        for (int i = 0; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        for (MeetingRoom item : meetingRooms) {
            System.out.println(" Tárgyaló neve: " + item.getName() + " Szélesség: " + item.getWidth() + " Hosszúság: " + item.getLength() + " Területe: " + item.getArea());
        }
    }

    public void printMeetingRoomsWithNames(String name) {
        for (MeetingRoom item : meetingRooms) {
            if (item.getName().equals(name)) {
                System.out.println("Szélesség: " + item.getWidth() + " Hosszúság: " + item.getLength() + " Területe: " + item.getArea());
            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        for (MeetingRoom item : meetingRooms) {
            if (item.getName().toLowerCase().contains(part.toLowerCase())) {
                System.out.println("Szélesség: " + item.getWidth() + " Hosszúság: " + item.getLength() + " Területe: " + item.getArea());
            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom item : meetingRooms) {
            if (item.getArea() > area) {
                System.out.println(" Tárgyaló neve: " + item.getName() + " Szélesség: " + item.getWidth() + " Hosszúság: " + item.getLength() + " Területe: " + item.getArea());
            }
        }
    }
}
