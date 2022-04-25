package com.niit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {

	public List<Routes> storingDetailsOfFlightRoute() throws IOException {
		FileReader fr = new FileReader("D:\\\\StudyMaterial\\\\WEB DEVLOPMENT\\\\Resources\\\\routes1.csv");
		BufferedReader br = new BufferedReader(fr);
		List<Routes> route=new ArrayList<>();
		String line ="";
		while((line=br.readLine())!=null) {
			String[] linebyline=line.split(",");
			Routes r=new Routes(linebyline[0],linebyline[1],linebyline[2],linebyline[3],linebyline[4]);
			route.add(r);
		}
		br.close();
		return route;
	}

	public void displayingAllRoutes(List<Routes> routes) {

		if(routes.size()>0) {
			System.out.format("%-20s %-15s %-20s %-18s %-20s\n", "From","To","Distance in km","Travel Time","Typical Airfare");
			System.out.println("____________________________________________________________________________________________");
			for(Routes str:routes) {
					System.out.format("%-20s",str);												//Display Method
				System.out.println();
				System.out.println("-------------------------------------------------------------------------------------------");
			}
		}else {
			System.out.println("For This Route, The Flight Is Not Available \nThank You For Checking Out.");
		}
		
	}

	public List<Routes>showDirectFlights(List<Routes> routes, String fromCity) {
		List<Routes> result=routes.stream().filter(s->s.getSource().equalsIgnoreCase(fromCity)).collect(Collectors.toList());
		return result;
	}

	public List<Routes> sortDirectFlights(List<Routes> directFlights) {
		Collections.sort(directFlights,(s1,s2)->s1.getDestination().compareTo(s2.getDestination()));
		return directFlights;
	}

	public void showIndirectConnections(String fromCity, String toCity, List<Routes> routes, String emptyString) {
		for(int i=0;i<routes.size();i++) {
			if(routes.get(i).getSource().equalsIgnoreCase(fromCity) && routes.get(i).getDestination().equalsIgnoreCase(toCity)){
				System.out.println(emptyString+routes.get(i));
			}else if(routes.get(i).getSource().equalsIgnoreCase(fromCity)) {
				showIndirectConnections(routes.get(i).getDestination(),toCity,routes,emptyString+routes.get(i));
			}
		}
	}

}
