
import java.util.ArrayList;

public interface IFlightGeneratorBackend {
    /**
     * Alphabetized list of possible flights.
     **/
    public ArrayList<String> alphabeticalFlights(ArrayList list);

     /**
     * Uses AE's shortest path algorithm to find the shortest path between selected cities.
     **/
    public String getPath(CS400Graph graph, int city1, int city2);

    /**
     * Total miles between airports.
     **/
    public double totalMiles(CS400Graph graph, int city1, int city2);

}
