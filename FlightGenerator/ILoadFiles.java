// --== CS400 File Header Information ==--
// Name: Tyler Gee
// Email: TGee2@wisc.edu
// Team: EE
// TA: Sujitha
// Lecturer: Flo
// Notes to Grader:

import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * Interface for Data Wrangler
 */
public interface ILoadFiles<NodeType, EdgeType> {
	
	/**
	 * 
	 * @param fileName CSV file name to convert
	 * @throws FileNotFoundException is thrown if file is not found
	 */
	public CS400Graph<String, Integer> DOTtoGraph(String fileName) throws FileNotFoundException;
		
}

