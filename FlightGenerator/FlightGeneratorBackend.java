// --== CS400 File Header Information ==--
// Name: Parker Johnson
// Email: pljohnson2@wisc.edu
// Team: Blue: EE
// TA: Sujitha
// Lecturer: Florian
// Notes to Grader: NA
import java.util.ArrayList;

/**
 * The FlightGeneratorBackend class creates an alphabetically sorted ArrayList of
 * airports for the user to select from, gets the shortest path between airports,
 * and finds the total miles between airports.
 **/
@SuppressWarnings("unchecked")
public class FlightGeneratorBackend implements IFlightGeneratorBackend {
    ArrayList<String> arrayList = new ArrayList<>();
    

    /**
     * Alphabetized list of possible flights.
     *
     * @param list passed from Data Wrangler.
     * @return sorted list
     **/
    @Override
    public ArrayList<String> alphabeticalFlights(ArrayList list) {
        if (list.isEmpty()) {
            throw new NullPointerException("Data Wrangler ArrayList is empty.");
        }
//        for (Object airport : list) {
//            this.arrayList.add(airport.toString());
//        }
        ArrayList<String> listHolder = new ArrayList<>();
        
        for(int i = 0; i < list.size(); i ++) {
        	String airport = list.get(i).toString();
        	listHolder.add(airport);
        }
        listHolder.sort(String::compareToIgnoreCase);
        
        for(int i = 0; i < listHolder.size(); i++) {
        	if (this.arrayList.contains(listHolder.get(i))) {
        		continue;
        	}
        	else {
        		this.arrayList.add(listHolder.get(i));
        	}
        }
        
        return this.arrayList;
    }
    /**
     * Uses AE's shortest path algorithm to find the shortest path between selected cities.
     *
     * @param graph CS400Graph to implement shortest path.
     * @param city1 User selected airport/city.
     * @param city2 User selected airport/city.
     * @return shortest path
     **/
    @Override
    public String getPath(CS400Graph graph, int city1, int city2) {
        String s1 = this.arrayList.get(city1 - 1);
        String s2 = this.arrayList.get(city2 - 1);
        for(int i = 0; i < arrayList.size(); i++) {
        	System.out.println(i + arrayList.get(i));
        }

        return graph.shortestPath(s1, s2).toString();
    }

    /**
     * Total miles between airports.
     *
     * @param graph CS400Graph to implement shortest path.
     * @param city1 User selected airport/city.
     * @param city2 User selected airport/city.
     * @return total miles between airports
     **/
    @Override
    public double totalMiles(CS400Graph graph, int city1, int city2) {
    	 return graph.getPathCost(this.arrayList.get(city1 - 1), this.arrayList.get(city2 - 1));
    }
}
