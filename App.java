import java.util.*;
import java.io.*;

public class App {
	public static void main(String[] args)
    {{	{
		
		Methods m1 = new Methods();
		
		
		String stnumberofvertex = "123";
		String readline;
		ArrayList<Airport> Airportarray = new ArrayList<Airport> ();
		int time = 0;
		Graph theGraph = new Graph();
		
		
		try {
			//Please use the E2 and V2 in my src to test the function about connectivity test
			//The E2 and V2 I left in the source are unconnected:
			//Two of them are connected, and the other four are connected
			//But these two groups are divided
			
			//Warm tip: if the graph is already disconnected,
			//then there is no need to discuss the existence of articulation points
			//So if you use E2 and V2, there will be bugs if you want to know the articulation points
			//Because graph2 is unconnected
			
			
			BufferedReader reader = new BufferedReader(new FileReader("./src/V.txt"));
			String line = reader.readLine();
			
				//readline = reader.readLine();
				//Because the instruction has already clarified that the first line is the number of vertices
				//I just stored it for future usage
				//This is a fair assumption
				
				stnumberofvertex = line;
				line = reader.readLine();
				
				
				while (line != null &line.length()!=0) {
					
					//System.out.println(line);
					String[] everyline = line.split(",");
					// read next line
					//System.out.println(everyline[0]);
					//System.out.println(everyline[1]);
					Airportarray.add(new Airport(everyline[0],everyline[1], time));
					theGraph.addVertex(everyline[0],everyline[1], time);
					line = reader.readLine();
					time ++;
				}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Now we know the number of vertices
		int numberofvertex = Integer.parseInt(stnumberofvertex);
		theGraph.setnVerts(numberofvertex);
		int start = -1;
		int end = -1;
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("./src/E.txt"));
			String line = reader.readLine();
			
				
				
				while (line != null && line.length() > 0) {
					
					
					String[] everyline = line.split(",");
					
					for(int i =0;i<Airportarray.size();i++){
					if(everyline[0].equals(Airportarray.get(i).name)){
					 start = Airportarray.get(i).label;
					break;
					}
					}//end of first for
					//System.out.println(start);
					
					for(int j =0;j<Airportarray.size();j++){
					if(everyline[1].equals(Airportarray.get(j).name)){
					 end = Airportarray.get(j).label;
					break;
					}}//end of second for
					
					//System.out.println(end);
					
					
					theGraph.addEdge(start, end);
					line = reader.readLine();
					time ++;
					}//end of while
				
			
			reader.close();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	
		
		//////////////
		
		
		
		
		Scanner input = new Scanner(System.in);
		Boolean Next = false;
		
		while (true) {
			
			System.out.println("1. Load Airport Data");
			System.out.println("2. Print All Airports");
			System.out.println("3. Check if there is a path between every given two airports in the data");
			System.out.println("4. Display all the critical airports");
			System.out.println("5. Check if there is a path (flight) in between two given airports");
			System.out.println("6. Exit");
			System.out.println("Warm tip: you need to load the data first to use all the functions");
			System.out.println();
			
			
			String choice1 = input.nextLine();
			
			
			if (choice1.equals("6")) {
				System.out.println("bye");
				break;
			}
			
			else if (choice1 .equals("2") || choice1.equals("3")|| choice1 .equals("4")|| choice1 .equals("5")) {
				System.out.println("You need to load the data first");
				System.out.println();
			}
			
			else if (choice1.equals("1")) {
				System.out.println("Loaded");
				System.out.println();
				Next = true;
				break;
				
			}
			
			else {
				System.out.println("Wrong input, try again");
				System.out.println();
			}
			
		}//end of the first while
		
		Scanner input2 = new Scanner(System.in);
		
		while (Next == true) {
			System.out.println("2. Print All Airports");
			System.out.println("3. Check if there is a path between every given two airports in the data");
			System.out.println("4. Display all the critical airports");
			System.out.println("5. Check if there is a path (flight) in between two given airports");
			System.out.println("6. Exit");
			System.out.println();
			
			String choice2 = input2.nextLine();
			
			if (choice2.equals("6")) {
				System.out.println("bye");
				break;
			}
			else if (choice2.equals("2")) {
				m1.PrintallAirports(theGraph);
			}
			
			else if (choice2.equals("3")){
				m1.Connectedtest(theGraph);
				
			}
			
			else if (choice2.equals("4")) {
				m1.Articulation(theGraph);
			}
			
			else if(choice2.equals("5")) {
				
				System.out.println("Give me THE FIRST airport' codes (names).");
				String a = input.nextLine();
				System.out.println("Give me THE SECOND airport' codes (names).");
				String b = input.nextLine();
				System.out.println();
				
				m1.findpath(a, b, theGraph);
			}}}
			
		}//end of the second while 
		
		
		
		
		
		
    }  // end main()
    

}
