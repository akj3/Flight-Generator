// --== CS400 Project Three File Header ==--
// Name: Arber Jonuzi
// CSL Username: arber
// Email: akjonuzi@wisc.edu
// Lecture #: 003 @2:25pm
// Notes to Grader: N/A

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Scanner;

public class FrontendDeveloperTests {
	
	
	//JUnit tests
	
	//tests displayAirports() method pt1
	@Test
	public void test1() {
		
		Scanner scr = new Scanner("1");
		FrontendPlaceholder backend = new FrontendPlaceholder();
		FlightGeneratorFrontend test = new FlightGeneratorFrontend(scr, backend);
		
		assertTrue(test.displayAirports().contains("Atlanta Hartsfield Jackson International\n"));
		
	}
	
	//tests displayAirports() method pt2
	@Test
	public void test2() {
		
		Scanner scr = new Scanner("1");
		FrontendPlaceholder backend = new FrontendPlaceholder();
		FlightGeneratorFrontend test = new FlightGeneratorFrontend(scr, backend);
		
		assertTrue(test.displayAirports().contains("Chicago O'hare International\n"));
	}
	
	//tests displayAirpoirts() method pt3
	@Test
	public void test3() {
		
		Scanner scr = new Scanner("1");
		FrontendPlaceholder backend = new FrontendPlaceholder();
		FlightGeneratorFrontend test = new FlightGeneratorFrontend(scr, backend);
		
		assertTrue(test.displayAirports().contains("LaGuardia International\n"));
	}
	
	//tests displayMainMenu() method pt1
	@Test
	public void test4() {
		
		Scanner scr = new Scanner("1");
		FrontendPlaceholder backend = new FrontendPlaceholder();
		FlightGeneratorFrontend test = new FlightGeneratorFrontend(scr, backend);
		
		assertTrue(test.displayAirports().contains("LAX International\n"));
	}
	
	//tests displayMainMenu() method pt2 but when the order is changed in the list of airports so ohare is called again
	@Test
	public void test5() {
		
		Scanner scr = new Scanner("1");
		FrontendPlaceholder backend = new FrontendPlaceholder();
		FlightGeneratorFrontend test = new FlightGeneratorFrontend(scr, backend);
		
		assertTrue(test.displayAirports().contains("Chicago O'hare International\n"));
	}
	
	
//	
//	public static void main(String[] args) {
//		
//		Scanner scr = new Scanner(System.in);
//		FrontendPlaceholder backend = new FrontendPlaceholder();
//		
//		FlightGeneratorFrontend test = new FlightGeneratorFrontend(scr, backend);
//		
//		test.runCommandLoop();
//	}
}
