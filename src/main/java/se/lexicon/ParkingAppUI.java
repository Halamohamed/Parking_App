package se.lexicon;

import se.lexicon.dao.*;
import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Reservation;

import static java.lang.IO.*;

public class ParkingAppUI {
    private ReservationDao reservationDao;
    private ParkingSpotDao parkingSpotDao;
    private CustomerDao customerDao;


    public ParkingAppUI() {
        this.reservationDao = new ReservationDaoImp();
        this.parkingSpotDao = new ParkingSpotDaoImp();
        this.customerDao = new CustomerDaoImp();
    }

    public void run() {
        System.out.println("Welcome to the Parking App!");
        for (int i = 1; i <= 10; i++) {
            ParkingSpot parkingSpot = new ParkingSpot(i, 101);
            parkingSpotDao.persist(parkingSpot);
        }
        System.out.println("Initialized 10 parking spots in area 101.");

        printParkingSpots();
        printMenu();
        String input = IO.readln();
        while (!input.equalsIgnoreCase("exit")) {
            switch (input){
                case "1":
                    reserveParkingSpot();
                    break;
                case "2":
                    removeParkingSpot();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            //reserveParkingSpot();
            printParkingSpots();
            printMenu();
            input = IO.readln();
        }
        System.out.println("Thank you for using the Parking App. Goodbye!");
    }

    private void removeParkingSpot() {
        System.out.println("You chose to move your car.");
        System.out.println("Enter parking spot ID to vacate:");
        String input = IO.readln();
        try {
            int spotId = Integer.parseInt(input);
            ParkingSpot spot = parkingSpotDao.findBySpotNumber(spotId).orElse(null);
            if (spot != null) {
                if (spot.isOccupied()) {
                    spot.vacate();
                    System.out.println("You have vacated parking spot ID: " + spotId);
                } else {
                    System.out.println("Parking spot ID: " + spotId + " is already available.");
                }
            } else {
                System.out.println("Parking spot ID: " + spotId + " does not exist.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid parking spot ID or 'exit' to quit.");
        }
    }

    private void reserveParkingSpot( ) {
        try {
            System.out.println("You chose to park today. Enter parking spot ID:");
            String input = IO.readln();
            int spotId = Integer.parseInt(input);
            ParkingSpot spot = parkingSpotDao.findBySpotNumber(spotId).orElse(null);
            if (spot != null) {
                if (!spot.isOccupied()) {
                    spot.occupy();
                    registerParkingSpot(spot);
                    System.out.println("You have occupied parking spot ID: " + spotId);
                } else {
                    System.out.println("Parking spot ID: " + spotId + " is already occupied.");
                }
            } else {
                System.out.println("Parking spot ID: " + spotId + " does not exist.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid parking spot ID or 'exit' to quit.");
        }
    }

    private void registerParkingSpot(ParkingSpot spot) {
        System.out.println("Registering parking spot ID: " + spot.getId());
        System.out.print("Enter your name: ");
        String name = IO.readln();
        System.out.print("Enter your phone number: ");
        String phone = IO.readln();
        System.out.print("Enter your vehicle plate number: ");
        String plateNumber = IO.readln();
        int customerId = customerDao.findAll().size() + 1;
        Customer customer = new Customer(customerId, name, phone, plateNumber);
        customerDao.persist(customer);
        reservationDao.persist(new Reservation(spot, customer, 2));
        System.out.println("Registration complete for parking spot ID: " + spot.getId());
        System.out.println(reservationDao.findAll().stream().toList().get(reservationDao.findAll().size() - 1));
    }

    private void printMenu() {
        System.out.println("Parking App is running...");
        System.out.println("1- Where do you want to park today?");
        System.out.println("2- would you move your car?");
        System.out.println("=============================");
        System.out.println("Chose an option or 'exit' to quit:");
    }

    private void printParkingSpots() {
        // Display all spots in Area 101 like a real parking place with lines
        println("\n=== Parking Lot - Area 101 ===");
        println("┌───────┬───────┬───────┬───────┬───────┐");
        for (int i = 0; i < parkingSpotDao.findAll().size(); i++) {
            ParkingSpot spot = parkingSpotDao.findAll().stream().toList().get(i);
            String status = spot.isOccupied() ? "[ X ]" : String.format("[%2d ]", spot.getId());
            print("│ " + status + " ");
            if ((i + 1) % 5 == 0) {
                println("│");
                if (i < parkingSpotDao.findAll().size() - 1) {
                    println("├───────┼───────┼───────┼───────┼───────┤");
                }
            }
        }
        println("└───────┴───────┴───────┴───────┴───────┘");
    }


}
