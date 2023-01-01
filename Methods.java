
public class Methods {

	public void PrintallAirports(Graph myGraph) {
		
		for (int i = 0; i<myGraph.getnVerts(); i++) {
			myGraph.displayVertex(i);
		}
		
	}//end of print all airports
	
	//The key point is to use the dfs method provided by Professor Bari to test
	//if you can get from any point to all other points in one rotation (time)
	//Test all points that are not visited with the revised DFS
	//However, if the graph is connected
	//from any random point, all other points can be visited because of DFS
	//Which means, in one time, all elements in the confirm array will become all V
	//Thus, if there is only 1 time of DFS looping, then we have a connected graph
	
	//You can also count the number of counts in the original DFS method to see if it equals 6
	
	public void Connectedtest(Graph myGraph) {
           
		   int n = 0;
		   int bigcount = 1;
		   
		   for (int i = 0; i<myGraph.getnVerts();i++) {
			   myGraph.getConfirm()[i]  = "U";
		   }
		   
		   
		   for (int i = 0; i<myGraph.getnVerts();i++) {
			   if(myGraph.getConfirm()[i] == "U") {
				   myGraph.dfs(i);
				   n=n+1;
			   }//end of if
		   }//end of for loop
		   
		   for (int j = 0; j < myGraph.getnVerts(); j++) {          
	            myGraph.getVertexList()[j].setWasVisited(false);
	            myGraph.getConfirm()[j] = "U";
		   }//Remember to reset
		   
		   if (n == 1) {
			   System.out.println("there is a path between every given two airports in the data");
			   System.out.println();
			   
			   myGraph.setSignal("C");
			   
			   for (int j = 0; j < myGraph.getnVerts(); j++) {          
		            myGraph.getVertexList()[j].setWasVisited(false);
		            myGraph.getConfirm()[j] = "U";
			   }
			   
		   }
		   
		   
		   
		   else {
			   System.out.println("the graph is not connected");
			   myGraph.setSignal("UC");
			   System.out.println("But displaying already connected parts: ");
			   
			   
		        for (int k = 0; k < myGraph.getnVerts(); k++) {
		        	if(myGraph.getConfirm()[k] == "U") {
		                System.out.println("Already connectPart " + bigcount + ":");
		                ConnectedComponents(myGraph,  k, myGraph.getConfirm());
		                
		                bigcount = bigcount+1;
		                System.out.println();
		            }
		        }
		        for (int a = 0; a < myGraph.getnVerts(); a++) {          
		            myGraph.getVertexList()[a].setWasVisited(false);
		            myGraph.getConfirm()[a] = "U";
			   }//Always remember to reset 
			   
			   
			   
			   
			   
		  
		   }//end of else
		   
		   
		   
		   
	   }//end of connectedtest method
	
	
	//From Sample Code with a bit modification
	//It's basically a refinement of the DFS in the sample code
	
	public void ConnectedComponents(Graph myGraph, int start, String[] Confirm) {
			int count=0;
	      myGraph.getVertexList()[start].setWasVisited(true);   // mark it, as always
	      myGraph.getConfirm()[start] = "V";
	      myGraph.getVertexList()[start].setFriends_club_number(start);
		  myGraph.displayVertex(start);                 // display it
		  myGraph.getTheStack().push(start);                 // push it

	      while( !myGraph.getTheStack().isEmpty() )      // until stack empty,
	         {
	         // get an unvisited vertex adjacent to stack top
	         int v = myGraph.getAdjUnvisitedVertex( myGraph.getTheStack().peek() );
	         if(v == -1)                    // if no such vertex,
	        	 myGraph.getTheStack().pop();
	         else                           // if it exists,
	            {
	        	 myGraph.getVertexList()[v].setWasVisited(true);
	        	 myGraph.getConfirm()[v] = "V";
	        	 myGraph.getVertexList()[v].setFriends_club_number(start);
			     count++; 
				
	            myGraph.displayVertex(v);                 // display it
	            myGraph.getTheStack().push(v);                 // push it
	            }
	         }  
		  
	   
	   
	   
		
	}//end of connected part method
	
	//Logic Explanation:
	//We know an articulation is a point crucial to the connectivity of the graph
	//In other words, if we lost it, the graph would become disconnected
	
	
	
	public String Articulationpro(int i, Graph myGraph) {
		  String result = "A";
		        myGraph.getVertexList()[i].wasVisited = true;
		        int c1 = 0;
		        for (int j = 0; j < myGraph.getVertexList().length-1; j++) {
		   if (myGraph.getVertexList()[j] != null){
		    if (myGraph.getVertexList()[j].wasVisited == false) {
		     myGraph.dfs(j);
		     c1=c1+1;
		    }
		   }

		        }//end of for
		        
		        
		        for (int a = 0; a < myGraph.getnVerts(); a++) {          
		            myGraph.getVertexList()[a].setWasVisited(false);
		            myGraph.getConfirm()[a] = "U";
		    }
		        
		        
		        if (c1>1) {
		         return "B";
		        }
		        else {
		         //do nothing
		         return "A";
		        }
		        
		    
		    }
		 
		 
		 
		 
		 
		 
		 
		 public void Articulation(Graph myGraph) {
		  
		  int count = 0;
		  
		  
		  for (int i = 0; i < myGraph.getVertexList().length; i++) {
		   if(myGraph.getVertexList()[i] != null){
		    if (Articulationpro(i,myGraph).equals("B")) {
		     count++;
		     System.out.println("critical airport " + count + ": " + myGraph.getVertexList()[i].name);
		     System.out.println();

		    }
		   }

		        }  
		        
		        
		        
		        
		        
		        
		        
		       
		      
		  }//end of the articulation point test
	
	
	
	
	
	
	public void Connectedtestnew(Graph myGraph) {
        
		   int n = 0;
		   int bigcount = 1;
		   
		   
		   
		   for (int i = 0; i<myGraph.getnVerts();i++) {
			   if(myGraph.getConfirm()[i] == "U") {
				   myGraph.dfs(i);
				   n=n+1;
			   }//end of if
		   }//end of for loop
		   
		   /*
		   for (int j = 0; j < myGraph.getnVerts(); j++) {          
	            myGraph.getVertexList()[j].setWasVisited(false);
	            myGraph.getConfirm()[j] = "U";
		   }//Remember to reset
		   */
		   
		   
		   
		   if (n == 1) {
			   //System.out.println("there is a path between every given two airports in the data");
			   myGraph.setSignal("C");
		   }
		   
		   
		   
		   else {
			   //System.out.println("the graph is not connected");
			   myGraph.setSignal("UC");
			   //System.out.println("But displaying already connected parts: ");
			   
			   
		       
		        
			   
			   
			   
			   
			   
		  
		   }//end of else
		   
		   for (int a = 0; a < myGraph.getnVerts(); a++) {          
	            myGraph.getVertexList()[a].setWasVisited(false);
	            myGraph.getConfirm()[a] = "U";
		   }//Always remember to reset 
		   
		   
	   }//end of connectedtest method
	
	public void findpath(String a, String b, Graph myGraph) {
		int n1 = -10086, n2 = -10086;
		
		for (int i = 0; i<myGraph.getnVerts();i++) {
			if(myGraph.getVertexList()[i].getName().equalsIgnoreCase(a)){
				n1 = myGraph.getVertexList()[i].number;
			}
		}//end of for 1
		
		for (int j = 0; j<myGraph.getnVerts();j++) {
			if(myGraph.getVertexList()[j].getName().equalsIgnoreCase(b)){
				n2 = myGraph.getVertexList()[j].number;
			}
		}//end of for 1
		
		if (n1 ==-10086 & n2 == -10086) {
			System.out.println("At least one wrong input. TrY again.");
		}
		
		else {
			myGraph.dfs(n1);
			String thesignal = myGraph.getConfirm()[n2];
			
			if (thesignal.equals("V")) {
				System.out.println("There is a fight between "+ a+" and "+b);
			}
			
			else {
				System.out.println("There is not a fight between "+ a+" and "+b);
			}
		}//end of else
		
		for (int j = 0; j < myGraph.getnVerts(); j++) {          
            myGraph.getVertexList()[j].setWasVisited(false);
            myGraph.getConfirm()[j] = "U";
	   }
		
	}

}//end of class
