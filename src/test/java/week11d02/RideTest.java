package week11d02;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RideTest {
    @Test
    void invalidRideTest() {
        assertThrows(IllegalArgumentException.class, () -> new Ride(0, 1, 2.8));
        assertThrows(IllegalArgumentException.class, () -> new Ride(8, 1, 2.8));
        assertThrows(IllegalArgumentException.class, () -> new Ride(1, 1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Ride(1, 1, -1));
        assertThrows(IllegalArgumentException.class, () -> new Ride(1, 0, 2.8));
    }

    @Test
    void rideCreateTest() {
        Ride ride = new Ride(1, 1, 1);
        assertEquals(1, ride.getDay());
        assertEquals(1, ride.getRideNr());
        assertEquals(1, ride.getLength());
    }

}