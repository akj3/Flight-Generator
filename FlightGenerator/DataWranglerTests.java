// --== CS400 File Header Information ==--
// Name: Tyler Gee
// Email: TGee2@wisc.edu
// Team: EE
// TA: Sujitha
// Lecturer: Flo
// Notes to Grader:

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class DataWranglerTests {

	protected CS400Graph<String, Integer> airports;
	protected FlightGeneratorBackend backend;
	@BeforeEach
	public void createGraph() throws FileNotFoundException {
        airports = (new LoadFiles()).DOTtoGraph("US_Flights.dot");
        backend = new FlightGeneratorBackend();
		backend.arrayList = (new LoadFiles()).airportList("US_Flights.dot");
    }
	
	@Test
	public void testContainsVertexSLC() {
		assertEquals(airports.containsVertex("Salt Lake City, UT"), true);
	}
	
	@Test
	public void testContainsEdgeSLCtoBurley() {
		assertEquals(airports.containsEdge("Salt Lake City, UT", "Burley, ID"), true);
	}
	
	@Test
	public void testContainsVertexCHI() {
		assertEquals(airports.containsVertex("Chicaco, IL"), false);
	}
	
	@Test
	public void testContainsEdgeLVtoFL() {
		assertEquals(airports.containsEdge("Las Vegas, NV", "Fort Lauderdale, FL"), true);
	}
	
	@Test
	public void testShortestPathLVtoFL() {
		assertEquals(airports.shortestPath("Las Vegas, NV", "Fort Lauderdale, FL").toString(),"[Las Vegas, NV, Albuquerque, NM, Fort Lauderdale, FL]");
	}
	
	@Test
	public void testContainsVertexIntegration() {
		assertEquals(airports.containsVertex("Minneapolis, MN"), true);
	}
	
	@Test
	public void testPathCostIntegration() {
		assertEquals(airports.getPathCost("Las Vegas, NV", "Fort Lauderdale, FL"), 2168.0);
	}
	
	@Test
	public void codeReviewOfBackendDeveloper2() {
		assertEquals(backend.totalMiles(airports, 3, 4), 133.0);
	}

	@Test
	public void codeReviewOfBackendDeveloper1() {
		assertEquals(backend.getPath(airports, 45, 60), "[Las Vegas, NV, Cedar City, UT, Casper, WY]");
	}
}

