
public interface IFlightGeneratorFrontend {
	/**
     * The constructor that the implementation this interface will
     * provide. It takes the Scanner that will read user input as
     * a parameter as well as the backend.
     */
   // IFlightGeneratorFrontend(Scanner input, IFlightGeneratorBackend backend);
    /**
     * This method starts the command loop for the frontend, and will
     * terminate when the user exists the app.
     */
    public void runCommandLoop();

    /**
    * This method displays the user interface menu and shows the options for
    * airports to select from
    */
    public void displayMainMenu();

    /**
    * This method calls the backend to display the path of airports
    * the user will follow
    **/
    public String displayAirports();     //(String start, String destination); // displays the list of airports in the beginning of the app

    /**
    * This method calls the backend to get the total distance to be traveled
    * by the user for their specified airports
    **/
    public void airportDistances(String start, String destination);

}
