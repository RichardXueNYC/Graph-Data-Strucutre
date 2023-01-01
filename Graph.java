class Graph
   {
   private final int MAX_VERTS = 20;
   private Vertex vertexList[]; // list of vertices
   private int adjMat[][];      // adjacency matrix
   private int nVerts = 20;      
   private StackX theStack;
   private  String [] Confirm = new String [nVerts]; //will be used in connectivity test
   
   
   
   private String Signal = "Undecided";




// ------------------------------------------------------------
   public Graph()               // constructor
      {
      vertexList = new Vertex[MAX_VERTS];
                                          // adjacency matrix
      adjMat = new int[MAX_VERTS][MAX_VERTS];
      nVerts = 0;
      for(int y=0; y<MAX_VERTS; y++)      // set adjacency
         for(int x=0; x<MAX_VERTS; x++)   //    matrix to 0
            adjMat[x][y] = 0;
      theStack = new StackX();
      }  // end constructor
   
   
   
   
   public Graph(int numberofvertices)               // constructor
   {
   vertexList = new Vertex[MAX_VERTS];
                                       // adjacency matrix
   adjMat = new int[MAX_VERTS][MAX_VERTS];
   nVerts = numberofvertices;
   for(int y=0; y<MAX_VERTS; y++)      // set adjacency
      for(int x=0; x<MAX_VERTS; x++)   //    matrix to 0
         adjMat[x][y] = 0;
   theStack = new StackX();
   } 
   
   
// ------------------------------------------------------------
   public void addVertex(String name, String location, int number)
      {
      vertexList[nVerts++] = new Vertex(name, location, number);
      vertexList[nVerts-1].number = nVerts-1;
      }
// ------------------------------------------------------------
   public void addEdge(int start, int end)
      {
      adjMat[start][end] = 1;
      adjMat[end][start] = 1;
      }
// ------------------------------------------------------------
   public void displayVertex(int v)
      {
	  System.out.println("Airport name: "+ vertexList[v].name);
	  System.out.println("Airport location: "+ vertexList[v].location);
      System.out.println("Connected Airport number: "+connectednumber(v));
      System.out.println();
      }
   
   
// ------------------------------------------------------------

   /*public void DisplaySubGraphs()
{
	dfs(0);
	
	while(// there is a vertex X with friends_club_number being -1)
	{
		
		dfs(x);
	}
	
	
}  */
   
  public void dfs(int start){  // depth-first search Revised version
	 
	  //String [] Confirm = {"U", "U", "U", "U", "U","U"};
	  
	  int count=1;
      vertexList[start].wasVisited = true;  // mark it
      Confirm[start] = "V";
      vertexList[start].friends_club_number = start;
	 
      theStack.push(start);                 // push it

      while( !theStack.isEmpty() )      // until stack empty,
         {
         // get an unvisited vertex adjacent to stack top
         int v = getAdjUnvisitedVertex( theStack.peek() );
         if(v == -1)                    // if no such vertex,
            theStack.pop();
         else                           // if it exists,
            {
            vertexList[v].wasVisited = true;
            Confirm[v] = "V";
			vertexList[v].friends_club_number= start;
		     count++; 
			// mark it
            theStack.push(v);                 // push it
            }
         }  // end while
		 
  }  // end of dfs
	
// ------------------------------------------------------------
   // returns an unvisited vertex adj to v
   
   public int getAdjUnvisitedVertex(int v)
      {
      for(int j=0; j<nVerts; j++)
         if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
            return j;
      return -1;
      }  // end getAdjUnvisitedVertex()
   
   
   
   
   
   //all possibly usef
public Vertex[] getVertexList() {
	return vertexList;
}
public void setVertexList(Vertex[] vertexList) {
	this.vertexList = vertexList;
}
public int[][] getAdjMat() {
	return adjMat;
}
public void setAdjMat(int[][] adjMat) {
	this.adjMat = adjMat;
}
public int getnVerts() {
	return nVerts;
}
public void setnVerts(int nVerts) {
	this.nVerts = nVerts;
}
public StackX getTheStack() {
	return theStack;
}
public void setTheStack(StackX theStack) {
	this.theStack = theStack;
}
public int getMAX_VERTS() {
	return MAX_VERTS;
}
   
   
   
   
   
 public int connectednumber(int v) {
	 int count = 0;
	 for (int i = 0; i<6; i++) {
		 if (adjMat[v][i]==1) {
			 count +=1;
		 }
	 }
	 return count;
 }
   
 
 public String[] getConfirm() {
		return Confirm;
	}




	public void setConfirm(String[] confirm) {
		Confirm = confirm;
	}




	public String getSignal() {
		return Signal;
	}




	public void setSignal(String signal) {
		Signal = signal;
	}
   
   
// ------------------------------------------------------------
   }  // end class Graph