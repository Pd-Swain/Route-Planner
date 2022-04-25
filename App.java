package com.niit;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		
		Flight flight=new Flight();
		
		//Task 1
		List<Routes> routes=flight.storingDetailsOfFlightRoute();
		flight.displayingAllRoutes(routes);	
		//routes.forEach(i->System.out.println(i));
		System.out.println();
		
		//Task 2
		System.out.print("Please Enter The City, From Where You Want To Catch Flight :-> ");
		Scanner scanner=new Scanner(System.in);											
		String fromCity=scanner.nextLine();
		System.out.println();
		List<Routes> directFlights=flight.showDirectFlights(routes,fromCity);
		System.out.println("Details Of Direct Flight From "+fromCity.toUpperCase()+" : \n");
		flight.displayingAllRoutes(directFlights);
		System.out.println();
		
		//Task 3
		List<Routes> directFlightsSorting=flight.sortDirectFlights(directFlights);
		System.out.println("Details Of Your Direct Flight in Sorted Way : \n");
		flight.displayingAllRoutes(directFlightsSorting);
		System.out.println();
		
		//Task 4
		System.out.print("Please Enter The City, Where You Want To Go :-> ");
		String toCity=scanner.nextLine();
		System.out.println();
		String emptyString="";
		flight.showIndirectConnections(fromCity,toCity,routes,emptyString);
		scanner.close();
	}

}
