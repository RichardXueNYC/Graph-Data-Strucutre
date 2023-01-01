
public class Airport {
//This class is mainly provided for storing the initial information

	public Airport() {
		// TODO Auto-generated constructor stub
	}
	public String name;
	public String location;
	public int label;
	
		  // public char label;        // label (e.g. 'A')
		   public boolean wasVisited;
		   public int friends_club_number;
		   
		// ------------------------------------------------------------
	public Airport(char lab)   // constructor
		      {
		      label = lab;
		      wasVisited = false;
			  friends_club_number= -1; //they belong yet.
		      }
	
	public Airport(String a, String b, int label) {
		this.name = a;
		this.location = b;
		this.label = label;
	}
		      
}
