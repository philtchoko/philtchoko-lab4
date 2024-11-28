import java.util.*;
public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }

    // This method implements decrypting(outer -> middle -> outer -> inner) a message in an enigma
    // Takes a string representing a message as an argument
    // Returns the encrypted message as a string
    public String decrypt(String message){        
        //TODO
	    char [] letters = message.toCharArray();
        char [] newMessage = new char [letters.length];
        // saving the value of the index when searching for a letter in the rotor
        int checkOne = 0;
        int checkTwo = 0;
        char searchVal = 'B'; // assigning a random default search value
        char decryptedChar = 'B'; // variable that holds a character of the new message
        // going through each letter of the message
	    for(int i = 0; i<letters.length; i++){
             // outer to middle
             checkOne = checkRotor(letters[i], rotors[2]);
             searchVal = rotors[1].charAt(checkOne);
             // middle to outer
             checkTwo = checkRotor(searchVal, rotors[2]);
             // outer to inner
             decryptedChar = rotors[0].charAt(checkTwo);
             // updating the new message array
             newMessage[i] = decryptedChar;
             rotate();
                  
             // System.out.println(rotors[1].toString());
            }
            String decryptedMessage = String.valueOf(newMessage);
            return decryptedMessage;
		
        }
    
    // This method parses a rotor for a specific character
    // Takes a single character and rotor as arguments
    public int checkRotor(char value, Rotor rotor){
	    for(int i=0; i<rotor.length();i++){
	        if(rotor.charAt(i) == value){
		    return i;
	    }
      } 
    return 0;
   }  

    // This method implements encrypting(inner -> outer -> middle -> outer) a message in an enigma
    // Takeks a string representing a message as an argument
    // Returns the encrypted message as a string
    public String encrypt(String message){
        //TODO
	char [] letters = message.toCharArray();
	char [] newMessage = new char [letters.length];
	// saving the value of the index when searching for a letter in the rotor
	int checkOne = 0; 
	int checkTwo = 0;
	char searchVal = 'B'; // assigning a random default search value
	char encryptedChar = 'B'; // variable that holds a character of the new message
	// going through each letter of the message
	for (int i=0; i<letters.length; i++){
	    // inner to outer
  	    checkOne = checkRotor(letters[i], rotors[0]); 
	    searchVal = rotors[2].charAt(checkOne);
	    // outer to middle
	    checkTwo = checkRotor(searchVal, rotors[1]);
	    // middle to outer
	    encryptedChar = rotors[2].charAt(checkTwo);
	    // updating the new message array
	    newMessage[i] = encryptedChar;
        rotate(); // rotates the rotor clockwise by one click
        // if the inner rotor is back to its org orientation, rotate the middle rotor by one click
    
        //System.out.println(rotors[1].toString());
	}
	String encryptedMessage = String.valueOf(newMessage);
	return encryptedMessage;
	
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
