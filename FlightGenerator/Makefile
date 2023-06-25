DataWranglerTests.class: DataWranglerTests.java
	javac -cp .:junit5.jar DataWranglerTests.java
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=DataWranglerTests
ILoadFiles.class: ILoadFiles.java
	javac ILoadFiles.java

LoadFiles.class: LoadFiles.java
	javac LoadFiles.java

runBackendDeveloperTests: BackendDeveloperTests.java
	javac -cp .:junit5.jar BackendDeveloperTests.java
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=BackendDeveloperTests
AlgorithmEnigeerTests: AlgorithmEngineerTests.java
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=AlgorithmEngineerTests
FlightGraph.class: FlightGraph.java
	javac FlightGraph.java
FlightGeneratorBackend.class: FlightGeneratorBackend.java
	javac FlightGeneratorBackend.java

IFlightGeneratorBackend.class: IFlightGeneratorBackend.java
	javac IFlightGeneratorBackend.java

PlaceholderDW.class: PlaceholderDW.java
	javac PlaceholderDW.java

CS400Graph.class: CS400Graph.java
	javac CS400Graph.java

GraphADT.class: GraphADT.java
	javac GraphADT.java
FlightGenerator.class: FlightGenerator.java
	javac FlightGenerator.java

FlightGeneratorFrontend.class: FlightGeneratorFrontend.java
	javac FlightGeneratorFrontend.java

FrontendPlaceholder.class: FrontendPlaceholder.java
	javac FrontendPlaceholder.java

FrontendDeveloperTests.class: FrontendDeveloperTests.java
	javac -cp .:junit5.jar FrontendDeveloperTests.java
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=FrontendDeveloperTests

run:  FlightGenerator.class

runTests: runBackendDeveloperTests DataWranglerTests.class FrontendDeveloperTests.class

clean:
	rm *.class
