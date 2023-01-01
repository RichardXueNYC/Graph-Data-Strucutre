class Vertex
   {
   public char label;        // label (e.g. 'A')
   public boolean wasVisited;
   public int friends_club_number;
   public String name;
   public String location;
   public int number;
   
   
   
   
   public Vertex(char lab)   // constructor
   {
   label = lab;
   wasVisited = false;
   friends_club_number= -1; //they belong yet.
	
   }
   
   
   
   
   
   
   public char getLabel() {
	return label;
}
public void setLabel(char label) {
	this.label = label;
}
public boolean getWasVisited() {
	return wasVisited;
}
public void setWasVisited(boolean wasVisited) {
	this.wasVisited = wasVisited;
}
public int getFriends_club_number() {
	return friends_club_number;
}
public void setFriends_club_number(int friends_club_number) {
	this.friends_club_number = friends_club_number;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}

// ------------------------------------------------------------
   public Vertex(String name, String location, int number)   // constructor
      {
      this.name = name;
      this.location = location;
      this.number = number;
      wasVisited = false;
	  friends_club_number= -1; //they belong yet.
	  
      }
// ------------------------------------------------------------
   }  // end class Vertex
