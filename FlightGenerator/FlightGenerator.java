import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Main class to run the Flight Generator Application
 */
public class FlightGenerator {


	public static void main(String[] args) throws FileNotFoundException {

		CS400Graph<String, Integer> airports;
		FlightGeneratorBackend backend;
		Scanner userInputScanner;
		FlightGeneratorFrontend frontend;

		airports = (new LoadFiles()).DOTtoGraph("US_Flights.dot"); //Load DOT file and create CS400 Graph
		backend = new FlightGeneratorBackend(); //Creates a new backend instance

		userInputScanner = new Scanner(System.in);
		frontend = new FlightGeneratorFrontend(userInputScanner, backend, airports);
		backend.arrayList = (new LoadFiles()).airportList("US_Flights.dot");
		

		frontend.runCommandLoop();
	}
}

