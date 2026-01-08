package se.lexicon;

import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Main {

    void main() {

        ParkingAppUI parkingAppUI = new ParkingAppUI();
        parkingAppUI.run();



      /*  List<ParkingSpot> parkingSpots = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            parkingSpots.add(new ParkingSpot(i, 101));
        }

        // Display all spots in Area 101 like a real parking place with lines
        IO.println("\n=== Parking Lot - Area 101 ===");
        IO.println("┌───────┬───────┬───────┬───────┬───────┐");
        for (int i = 0; i < parkingSpots.size(); i++) {
            ParkingSpot spot = parkingSpots.get(i);
            String status = spot.isOccupied() ? "[ X ]" : String.format("[%2d ]", spot.getId());
            IO.print("│ " + status + " ");
            if ((i + 1) % 5 == 0) {
                IO.println("│");
                if (i < parkingSpots.size() - 1) {
                    IO.println("├───────┼───────┼───────┼───────┼───────┤");
                }
            }
        }
        IO.println("└───────┴───────┴───────┴───────┴───────┘");


        IO.println("Registration: ");
        Customer sarah = new Customer(1, "Sarah Johnson", "1234567890", "XYZ-123");
        IO.println("Customer registered: " + sarah);

        IO.println("Making Reservation: ");
        Reservation reservation = new Reservation( parkingSpots.get(2), sarah, 2);
        IO.println("Reservation created: " + reservation);


        // Display all spots in Area 101 like a real parking place with lines
        IO.println("\n=== Parking Lot - Area 101 ===");
        IO.println("┌───────┬───────┬───────┬───────┬───────┐");
        for (int i = 0; i < parkingSpots.size(); i++) {
            ParkingSpot spot = parkingSpots.get(i);
            String status = spot.isOccupied() ? "[ X ]" : String.format("[%2d ]", spot.getId());
            IO.print("│ " + status + " ");
            if ((i + 1) % 5 == 0) {
                IO.println("│");
                if (i < parkingSpots.size() - 1) {
                    IO.println("├───────┼───────┼───────┼───────┼───────┤");
                }
            }
        }
        IO.println("└───────┴───────┴───────┴───────┴───────┘");

        IO.println("Making Departure: ");
        reservation.complete();

        // Display all spots in Area 101 like a real parking place with lines
        IO.println("\n=== Parking Lot - Area 101 ===");
        IO.println("┌───────┬───────┬───────┬───────┬───────┐");
        for (int i = 0; i < parkingSpots.size(); i++) {
            ParkingSpot spot = parkingSpots.get(i);
            String status = spot.isOccupied() ? "[ X ]" : String.format("[%2d ]", spot.getId());
            IO.print("│ " + status + " ");
            if ((i + 1) % 5 == 0) {
                IO.println("│");
                if (i < parkingSpots.size() - 1) {
                    IO.println("├───────┼───────┼───────┼───────┼───────┤");
                }
            }
        }
        IO.println("└───────┴───────┴───────┴───────┴───────┘");

*/
    }
}
