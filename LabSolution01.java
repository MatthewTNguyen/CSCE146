// Matthew Nguyen
// Zodiac Sign Lab
package ZodiacSign;

import java.util.Scanner;

public class LabSolution01 {
	private int day;
	private int month;
	public static void main(String[] args) {		
		LabSolution01 Zodiac=new LabSolution01(); 
		Zodiac.run();
		
	}	
// Using Scanner to get input
// Storing input in month and day variables  
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your zodiac? Enter your birthday -- Month followed by Day as numbers.");
		month = sc.nextInt();
		day = sc.nextInt();
		if (ValidationMonth() && ValidationDay()) {
			System.out.println( "You are a " + Zodiac()+"!");
		}
	}
        
        // Validate month: Using user input to check if its true or false 
        public boolean ValidationMonth () {
        	if ((month<1)||(month > 12)){
        		System.out.println("Invalid Month!");
        		return false;
        		
        		}
        	else {
        		return true;
        	}
        	}
     
        public boolean ValidationDay () {
        //Validate day based on month: If the month given is valid then return true if not then false             
        	boolean validDay = true;
        	if (month == 2) {
        		if (day < 1 || day > 29) validDay= false;
        	}
        	else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
        	if (day <1 || day > 30) validDay = false;
        }		 
        	else {
        	if ((day < 1) || (day > 31)) validDay = false;
        }
        	if (validDay == false) System.out.println("Invalid Day!");
        	return validDay;
        	
        }
        
// If true, print out return  
        public String Zodiac() {
        	if (((month == 3) && (day <=21))||((month == 4) && (day >= 19)))
        		return ("Aries");
        	else if (((month == 4) && (day <=20))||((month == 5) && (day >= 20)))
        		return ("Taurus");
        	 else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) 
        		 return "Gemini";
        	 else if ((month == 6 && day >= 21) || (month == 7 && day <= 22))
        		 return "Cancer";
        	 else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) 
        		 return "Leo";
        	 else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) 
        		 return "Virgo";
        	 else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) 
        		 return "Libra";
        	 else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) 
        		 return "Scorpio";
        	 else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) 
        		 return "Sagittarius";
        	 else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) 
        		 return "Capricorn";
        	 else if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) 
        		 return "Aquarius";
        	 else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) 
        		 return "Pisces";
        	    else return "Invalid Date"; // catch invalid cases
        }
}
	

