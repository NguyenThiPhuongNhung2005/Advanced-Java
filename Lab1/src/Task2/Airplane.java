package Task2;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Airplane {
    // Attributes
    private String flightNumber;
    private String destination;
    private LocalTime scheduledDeparture;
    private int delayMinutes; // delay in minutes

    // Constructor
    public Airplane(String flightNumber, String destination, LocalTime scheduledDeparture) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.scheduledDeparture = scheduledDeparture;
        this.delayMinutes = 0; // default: no delay
    }

    // Getters and Setters
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(LocalTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public int getDelayMinutes() {
        return delayMinutes;
    }

    // Method to delay a flight
    public void delayFlight(int minutes) {
        this.delayMinutes += minutes;
        this.scheduledDeparture = this.scheduledDeparture.plusMinutes(minutes);
    }

    // Method to check flight status
    public String checkStatus() {
        if (delayMinutes == 0) {
            return "Flight " + flightNumber + " is on time.";
        } else {
            return "Flight " + flightNumber + " is delayed by " + delayMinutes + " minutes.";
        }
    }

    // Display flight information
    public void displayInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Flight: " + flightNumber);
        System.out.println("Destination: " + destination);
        System.out.println("Scheduled Departure: " + scheduledDeparture.format(formatter));
        System.out.println("Status: " + checkStatus());
        System.out.println("------------------------------");
    }

    // Main method to test
    public static void main(String[] args) {
        // Create an airplane object
        Airplane flight1 = new Airplane("VN123", "Tokyo", LocalTime.of(10, 30));

        // Display initial info
        flight1.displayInfo();

        // Delay flight by 45 minutes
        flight1.delayFlight(45);

        // Display updated info
        flight1.displayInfo();
    }
}

