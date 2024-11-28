public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    // This method implements the rotation of a rotor 
	// Returns a boolean of true or false depending on whether the current char is its original starting char
    public boolean rotate(){
        //TODO
		// putting the rotor values in a char array
	   char[] rotorChars = rotorValues.toCharArray();
	   int rotorSize = rotorChars.length;
	   char newStart = rotorChars[rotorSize - 1]; // holds the single char that starts the new rotor
	   char [] newrotorEnd = new char [rotorSize-1];
	   //creating a char array of the rotors following the new start rotor 
	   for(int i=0; i<rotorSize-1; i++){
		newrotorEnd[i] = rotorChars[i];
	   }
	   String start = String.valueOf(newStart);
	   String end  = String.valueOf(newrotorEnd);
	   // creating a new rotor by concatenating the new end and start
	   String newRotor = start + end; 
	   // updating part of the constructor
	   this.rotorValues = new String(newRotor); 
	   if (rotorChars[0] == this.startChar){
			return true;
	   }
	   
        

	  return false;  
    }
/* 
	public void click(char [] rotorChars, int rotorSize, char newStart, char [] newrotorEnd){
		for(int i=0; i<rotorSize-1; i++){
			newrotorEnd[i] = rotorChars[i];
		 }
		 String start = String.valueOf(newStart);
		 String end  = String.valueOf(newrotorEnd);
		 // creating a new rotor by concatenating the ends
		 String newRotor = start + end; 
		 // updating the constructor
		 this.rotorValues = new String(newRotor); 
	}
*/
	public String toString(){
		return rotorValues;

	}
    // Returns the length of a rotors string
	public int length(){
		return rotorValues.length();
	}

	// This method returns the index of a character in a rotor
	// Takes a single char as an argument
    public int indexOf(char c){
        //TODO
	char [] rotorChars = rotorValues.toCharArray();
	int count = 0;
	while(c != rotorChars[count]){
	     count++;
	     
	}
	return count;
    }
	// This method returns a character at a specific index
	// Takes a single integer as an argument
    public char charAt(int idx){
        //TODO
	char [] rotorChars = rotorValues.toCharArray();
	return rotorChars[idx];
    }
}
    
