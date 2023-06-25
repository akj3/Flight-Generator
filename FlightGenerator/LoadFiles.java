// --== CS400 File Header Information ==--
// Name: Tyler Gee
// Email: TGee2@wisc.edu
// Team: EE
// TA: Sujitha
// Lecturer: Flo
// Notes to Grader:

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;



public class LoadFiles extends CS400Graph implements ILoadFiles{
	ArrayList<String> list = new ArrayList<>();


	protected class Airport {
		public String name; // vertex label or application specific data
		public LinkedList<Integer> edgesLeaving;
		public boolean isVisited;

		public Airport(String name) {
			this.name = name;
			this.edgesLeaving = new LinkedList<>();
			this.isVisited = false;
		}
	}

	/**
	 * This method takes in a DOT file and returns a CS400 Graph 
	 * @Param String fileName is the name of the dot file
	 */
	@Override
	public CS400Graph<String, Integer> DOTtoGraph(String fileName) throws FileNotFoundException {

		String line;
		ArrayList<String> source = new ArrayList<>();
		CS400Graph<String, Integer> graph = new CS400Graph<>();
		ArrayList<String> target = new ArrayList<>();
		ArrayList<String> source2 = new ArrayList<>();
		ArrayList<Integer> weight = new ArrayList<>();





		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));


			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String segment[] = line.split("->");

					if(segment.length == 2) {
						String location1 = segment[0].substring(2);
						location1 = location1.substring(0, location1.length() - 2);
						source.add(location1);
						String edge = segment[1];
						target.add(edge);
					}
				}

			}

		}catch (Exception e) {

		}
		//these next for loops will separate the values accordingly which then adds
		//vertices with edges
		for(int i = 0; i < source.size(); i ++) {
			graph.insertVertex(source.get(i));
			
		}
		for(int i = 0; i < target.size(); i++) {
			source2.add(target.get(i).substring(2, target.get(i).lastIndexOf("\"")));
		}
		for(int i = 0; i < target.size(); i ++) {
			String num = target.get(i).substring(target.get(i).indexOf("=") + 1, target.get(i).indexOf("]"));
			weight.add(Integer.parseInt(num));
		}
		for(int i = 0; i < source.size(); i++) {
			graph.insertVertex(source.get(i));
			graph.insertVertex(source2.get(i));
		}


		for(int i = 0; i < source.size(); i++) {
			graph.insertEdge(source.get(i), source2.get(i), weight.get(i));
		}
		return graph;
	}

	/**
	 * This method is essentially the same as the one above, however
	 * it only makes use of the one arraylist. The purpose of this is to make usability easier
	 * for the Backend and AlgorithmEngineer
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException if file is not found
	 */
	public ArrayList<String> airportList(String fileName) throws FileNotFoundException {

		String line;
		ArrayList<String> source = new ArrayList<>();
		CS400Graph<String, Integer> graph = new CS400Graph<>();
		ArrayList<String> target = new ArrayList<>();
		ArrayList<String> newList = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));


			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String segment[] = line.split("->");

					if(segment.length == 2) {
						String location1 = segment[0].substring(2);
						location1 = location1.substring(0, location1.length() - 2);
						source.add(location1);
						String edge = segment[1];
						target.add(edge);
					}
				}

			}

		}catch (Exception e) {

		}
		for(int i = 0; i < source.size(); i ++) {
			if(graph.insertVertex(source.get(i))) {
				list.add(source.get(i));
			}
		}
		for(int i = 0; i < list.size(); i ++) {
			if (newList.contains(list.get(i))) {
				continue;
			}
			else {
				newList.add(list.get(i));
			}
		}
		return newList;
}
}
