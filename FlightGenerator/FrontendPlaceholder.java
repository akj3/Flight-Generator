// --== CS400 Project Three File Header ==--
// Name: Arber Jonuzi
// CSL Username: arber
// Email: akjonuzi@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to Grader: N/A


import java.util.ArrayList;

public class FrontendPlaceholder {

	 /**
     * Alphabetized list of possible flights.
     **/

	public ArrayList<String> alphabeticalFlights() {
	
		
		ArrayList<String> readSong = new ArrayList();
		readSong.add(" Atlanta Hartsfield Jackson International");
		readSong.add(" Chicago O'hare International");
		readSong.add(" LaGuardia International");
		readSong.add(" LAX International");
		readSong.add(" Minneapolis-St.Paul International ");
		readSong.add(" Madison Dane County Airport ");
		
		return readSong;
	}
	
	/**
     * Uses AE's shortest path algorithm to find the shortest path between selected cities.
     **/
	
	public String getPath(int city1, int city2) {
		
		if(city1 - city2 == 0) {
			System.out.println("0 miles because it is the same airport from start to finish.");
		}
		
		//hardcodes the same miles for each of the cities for the sake of 
		//the frontend code running properly
		city1 = 4000;
		city2 = 12000;
		
		int distance = city2 - city1;
		
		return Integer.toString(distance);
	}

	/**
     * Total miles between airports
     **/
	
	public double totalMiles(int city1, int city2) {
		
		//hardcodes of a simple sum of two cities for the sake of the frontend running 
		city1 = 4000;
		city2 = 8000;
		int total = city1 + city2;
		return total;
	}

	

}
