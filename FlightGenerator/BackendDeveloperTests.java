// --== CS400 File Header Information ==--
// Name: Parker Johnson
// Email: pljohnson2@wisc.edu
// Team: Blue: EE
// TA: Sujitha
// Lecturer: Florian
// Notes to Grader: NA
/*** JUnit imports ***/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
/*** JUnit imports end  ***/

/**
 * Tests the implementation of FlightGeneratorBackend
 */
public class BackendDeveloperTests {

    private CS400Graph<String, Integer> graph;
    private PlaceholderDW placeholderDW;
    private FlightGeneratorBackend backend;
    
    /**
     * Instantiate graph, placeholder arraylist, and alphabetical list.
     */
    @BeforeEach public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices A-F
        graph.insertVertex("Alpha");
        graph.insertVertex("BLAKE");
        graph.insertVertex("Cole P");
        graph.insertVertex("Drew");
        graph.insertVertex("EdWard GEE");
        graph.insertVertex("Finn");
        // insert edges
        graph.insertEdge("Alpha", "BLAKE", 6);
        graph.insertEdge("Alpha", "Cole P", 2);
        graph.insertEdge("Alpha", "Drew", 5);
        graph.insertEdge("BLAKE", "EdWard GEE", 1);
        graph.insertEdge("BLAKE", "Cole P", 2);
        graph.insertEdge("Cole P", "BLAKE", 3);
        graph.insertEdge("Cole P", "Finn", 1);
        graph.insertEdge("Drew", "EdWard GEE", 3);
        graph.insertEdge("EdWard GEE", "Alpha", 4);
        graph.insertEdge("Finn", "Alpha", 1);
        graph.insertEdge("Finn", "Drew", 1);

        placeholderDW = new PlaceholderDW();
        backend = new FlightGeneratorBackend();
        backend.alphabeticalFlights(placeholderDW.arrayListDW());
    }
    /**
     * Checks the ordered sequence of data within vertices from points 
     * on the arraylist located in the backend.
     */
    @Test public void test1() {
        assertTrue(backend.getPath(graph, 1, 4).equals("[Alpha, Cole P, Finn, Drew]"));
    }
    /**
     * Checks the total cost/distance between vertices from points 
     * on the arraylist located in the backend.
     */
    @Test public void test2() {
        assertTrue(backend.totalMiles(graph, 1, 4) == 4);
    }
    /**
     * Checks the ordered sequence of data within vertices from points 
     * on the arraylist located in the backend.
     */
    @Test public void test3() {
        assertTrue(backend.getPath(graph, 2, 5).equals("[BLAKE, EdWard GEE]"));
    }
    /**
     * Checks the total cost/distance between vertices from points 
     * on the arraylist located in the backend.
     */
    @Test public void test4() {
        assertTrue(backend.totalMiles(graph, 2, 5) == 1);
    }
    /**
     * Checks the ordered sequence of data within vertices from points 
     * on the arraylist located in the backend.
     */
    @Test public void test5() {
        assertTrue(backend.getPath(graph, 1, 2).equals("[Alpha, Cole P, BLAKE]"));
    }
}
