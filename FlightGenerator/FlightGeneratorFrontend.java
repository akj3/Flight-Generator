import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FlightGeneratorFrontend implements IFlightGeneratorFrontend {

  // fields
  private Scanner userInput;
  private FlightGeneratorBackend backend;
  CS400Graph<String, Integer> airports;
  ArrayList<String> list = (new LoadFiles()).airportList("US_Flights.dot");


  /**
   * The constructor implements this provided interface. It takes the Scanner that will read user
   * input as a parameter as well as the backend data as a following parameter.
   */
  // Switch FrontendPlacerHolder with backend obj
  FlightGeneratorFrontend(Scanner userInput, FlightGeneratorBackend backend,
      CS400Graph<String, Integer> graph) throws FileNotFoundException {
    this.userInput = userInput;
    this.backend = backend;
    this.airports = graph;

  }

  /**
   * This method starts the command loop for the frontend, and will terminate when the user exists
   * the app.
   */
  @Override
  public void runCommandLoop() {
    displayMainMenu();
    runCommandLoop();
  }

  /**
   * This method displays the user interface menu and shows the options for airports to select from
   */
  @Override
  public void displayMainMenu() {

    System.out.println(displayAirports());
    System.out.println("Please enter your Starting Airport:\n");
    int startingAirport = userInput.nextInt();
    // System.out.println(backend.alphabeticalFlights.get(startingAirport));
    System.out.println("Please enter your Airport Destination");
    int airportDestination = userInput.nextInt();

    if (startingAirport > backend.alphabeticalFlights(list).size()) {
      System.out.println("Your starting airport is not in the list. Terminating program.");
      System.exit(0);
    }
    if (airportDestination > backend.alphabeticalFlights(list).size()) {
      System.out.println("Your airport destination is not in the list. Terminating program.");
      System.exit(0);
    }

    airportDistances("" + startingAirport, "" + airportDestination);

  }

  /**
   * This method calls the backend to display the path of airports the user will follow
   **/
  @Override
  public String displayAirports() {
    // System.out.println(list);
    ArrayList<String> newList = backend.alphabeticalFlights(list);
    String message = "";
    message += "Here is your list of starting airports:\n";
    // System.out.println("Here is your list of starting airports:\n");

    if (backend.alphabeticalFlights(list) == null) {
      // System.out.println("There are no starting airports");
      message += "There are no starting airports";
    } else {
      for (int i = 0; i < list.size(); i++) {

        // System.out.println((i ) +backend.alphabeticalFlights().get(i));
        message += (i + 1) + ": " + newList.get(i) + "\n";
      }
    }

    return message;
  }

  /**
   * This method calls the backend to get the total distance to be traveled by the user for their
   * specified airports
   **/
  @Override
  public void airportDistances(String start, String destination) {
    // prints out airport distances message
    System.out.println("Your shortest path between "
        + backend.alphabeticalFlights(list).get(Integer.parseInt(start) - 1) + " and "
        + backend.alphabeticalFlights(list).get(Integer.parseInt(destination) - 1) + " "
        + "is a total of "
        + (backend.totalMiles(airports, Integer.parseInt(start), Integer.parseInt(destination)))
        + " miles. Your first flight path distance is "
        + backend.totalMiles(airports, Integer.parseInt(start), Integer.parseInt(destination))
        + " miles. Then your second flight path distance is "
        + backend.totalMiles(airports, Integer.parseInt(start), Integer.parseInt(destination))
        + " miles.");

    // System.out.println(backend.getPath(airports, Integer.parseInt(start),
    // Integer.parseInt(destination)));
    // asks user if they want to do the process again
    System.out
        .println("Would you like to find another shortest path between any of the airports? (y/n)");
    String userChoice = userInput.next();

    // goes through each scenario
    if (userChoice.equals("y")) {
      runCommandLoop();
    } else if (userChoice.equals("n")) {
      System.out.println("GoodBye!");
      System.exit(0);
    }
  }

}

