// January 22, 2022
// Nearhos Hatzinikoalou
// Langopoly
package hojfjeo;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.text.NumberFormat;


	
	public class whatever {
		public static void main(String[] args) {
			Scanner scan = new Scanner (System.in);
		
		
		  // allows for replaying
			 int replay = 1;
				while (replay == 1){
					// Instructions 
					System.out.println ("Mr. Langopoly: Hello, LangCorp employee, ill call you P1 !! Are you ready to become a polyglot and use that to your financial benifit!!! \n\n What did I hear!?!?!??! You would rather use that skill for fun!?!??! \n\n Nonsense my child!! Heres a small loan of $2000 to get you started!!! \n\n The way this game will work is you will pick a language you want to learn and you will memorise 10 words these words will be shown at random and you must translate them to english!!!! \n\n This will give you money to buy properties in a game of monopoly!!!\n\n But be careful if you translate wrong you lose money this could mean you losing your job!!!! \n\n One last thing dont lose because my competitors robot, Corpbot will win, anyways dont let me down or else....... \n\n (remember to press ENTER after every line) ");
					System.out.println ("\n \n");
			String[] language = new String[10];
			String[] languagetrans = new String[10];
			String[] languageai = new String[10];
			String[] languagetransai = new String[10];
			String[] lands = new String[40];
			int[] plands = new int[40];
			int[] plandsai = new int[40];
			// Declares what each land does
			lands = declaration(lands);
			int p1 = 1;
			int p2 = 1;
			int bal1 = 2000;
			int bal2 = 2000;
     
		
			// allows user to chose a language
			String lang = langchose();
			System.out.println ("     ");
			// gets the list of the language
			langlist(language,lang);
			// makes AI pick a language
			String langai = langchoseai();
			System.out.println ("     ");
			// list the translations of the language 
			langlisttrans(languagetrans, lang);
			System.out.println ("     ");
			// lets the user memorise before the game
	        flashcards(languagetrans, language);
	    	// gets lang list for ai
	        languageai =	langlist(languageai,langai);
	    	// gets lang trans for ai
		    languagetransai = langlisttrans(languagetransai, langai);
			// these methods declares ownership of properties for each
		    plands = pdeclaration(plands);
		    plandsai = pdeclaration(plandsai);
		    
		   
		   
			
			System.out.println("\nLets play!!!");
			System.out.println("The ai chose "+langai);
			System.out.println ("     ");
			// checks if users has money
			while (bal1 >= 1 && bal2 >= 1 ) {
				// drawns the monopoly board go to method for more info
			drawBoard(p1,p2,plands);
			System.out.println ("   \n  ");
			System.out.println ("Board Key: \n\n + = P1 \n\n * = P2 \n\n G = Go, this your starting spot \n \n (: = The funny zone, something funny will happen \n \n C = Chance cards, what will your fate be? \n \n 0 = Unowned property \n \n 1 = p1 owned property \n \n 2 = p2 owned property  ");
			System.out.println ("   \n  ");
			// picks random word for user to translate from their 10 words
			int win = randlang (languagetrans, language, bal1);
			// checks if they guessed correct, iff they did this will allow for a chance card to give them a postive out come
			int fortune = fortune(win);
			//* checks users bal
			System.out.println ("   \n  ");
			bal1 = balcheck(bal1,win);
			System.out.println ("     ");
			// allows user to move spaces
			p1 = dice(p1,bal1);
			scan.nextLine();
			System.out.println ("     ");
			drawBoard(p1,p2,plands);
			System.out.println ("   \n  ");
			System.out.println ("Board Key: \n\n + = P1 \n * = P2 \n G = Go, this your starting spot \n \n (: = The funny zone, something funny will happen \n \n C = Chance cards, what will your fate be? \n \n 0 = Unowned property \n \n 1 = p1 owned property \n \n 2 = p2 owned property  ");
			System.out.println ("   \n  ");
			// checks the status of each property they landed on 0 would be nobody owns, 3 would be a special land, 1 would be player owned, 2 would be ai owned
			int pindent = landingpropeties(  p1,  plands);
			if (pindent == 3) {
			System.out.println ("     ");
			// check what special card it was
			bal1 = landing( bal1, p1, fortune,  lands);
			System.out.println ("     ");
			bal1 = wincheck ( bal1);
			if (bal1 >= 1) {
			
			
			}}
			else if(pindent == 0) {
				// allows user  to see if they want to buy
				int ubuy = yesorno(p1, lands);
				if (ubuy == 1) {
					// changes identity to owned by you in your perspective
					plands = ownerlistyou( p1, plands);
					// changes identity to owned by you in AI perspective
					plandsai = ownerlistother(p1, plandsai);
					// makes you pay for your purchase
					bal1 = bankwithdrawl( p1,  bal1);
					bal1 = wincheck ( bal1);
						}
				else {
					
				}
			}
            else if(pindent == 1) {
            	System.out.println("You landed on your property");
            	// pays you landing on your land
            	bal1 = landbounus( p1,   bal1);
            	
            	bal1 = wincheck ( bal1);
			}
            else if(pindent == 2) {
            	System.out.println("You landed on others property");
            	// Penalizes you landing on others land
            	bal1 = landpenal(  p1,  bal1);
            	bal1 = wincheck ( bal1);
			}
			if (bal1 >= 1) {
			  	System.out.println ("     ");
		       	System.out.println("---- End of P1 turn ----\n");
				scan.nextLine();
           drawBoard(p1,p2,plands);
           System.out.println ("   \n  ");
			System.out.println ("Board Key: \n\n + = P1 \n\n * = P2 \n\n G = Go, this your starting spot \n \n (: = The funny zone, something funny will happen \n \n C = Chance cards, what will your fate be? \n \n 0 = Unowned property \n \n 1 = p1 owned property \n \n 2 = p2 owned property  ");
			System.out.println ("   \n  ");
     
		
			 int win1 = randlangai (languagetransai, languageai, bal2);
				System.out.println ("     ");
			int fortuneai = fortune(win1);
			System.out.println ("   \n  ");
			bal2 = balcheck(bal2,win1);
			System.out.println ("     ");
			p2 = dice(p2,bal2);
			scan.nextLine();
			System.out.println ("     ");
			drawBoard(p1,p2,plands);
			System.out.println ("   \n  ");
			System.out.println ("Board Key: \n\n + = P1 \n\n * = P2 \n\n G = Go, this your starting spot \n \n (: = The funny zone, something funny will happen \n \n C = Chance cards, what will your fate be? \n \n 0 = Unowned property \n \n 1 = p1 owned property \n \n 2 = p2 owned property  ");
			System.out.println ("   \n  ");
			int pindentai = landingpropeties(  p2,  plandsai);
			System.out.println ("     ");
			if (pindentai == 3) {
				System.out.println ("     ");
			bal2 = landing( bal2, p2, fortuneai,  lands);
			System.out.println ("     ");
			 bal2 = wincheckai ( bal2);
			 if (bal2 >= 1) {
					
					
				}}
			
			 else if(pindentai == 0) {
				 // allows AI to buy or not
					int ubuyai = yesornoai(p2, lands, bal2);
					if (ubuyai == 1) {
						plandsai = ownerlistyou( p2, plandsai);
						plands = ownerlistother(p2, plands);
						bal2 = bankwithdrawl( p2,  bal2);
						bal2 = wincheckai ( bal2);
							}
					else {
						
					}
				}
	            else if(pindentai == 1) {
	            	System.out.println("You landed on your property");
	            	bal2 = landbounus( p2,   bal2);
	            	
	            	bal2 = wincheckai ( bal2 );
				}
	            else if(pindentai == 2) {
	            	System.out.println("You landed on others property");
	            	bal2 = landpenal(  p2,  bal2);
	            	bal2 = wincheckai ( bal2);
				}
			System.out.println("---- End of P2 turn ----\n ");
			scan.nextLine();
			}}
      System.out.println("If you would like to not play again please type \"end\" otherwise type anything else to play again");
      String again = scan.next();
      if (again.equals("end")){
        System.out.println("Thank you for playing (: ");
        replay = 0;
      }
      else {
        replay = 1;
      }
      }}
			
			
			
			
			
		
		
		
		public static String langchose(){
			Scanner scan = new Scanner (System.in);
			String lang = "";
			int error = 1;
			while (error == 1) {
			System.out.println("Chose a langague to reveiw Mandarin, Spainish, Japanese, Russian, Korean, Greek, Turkish, or German, \n type out the name of Langauge you want ");
			lang = scan.next();
			if (lang.equals("Mandarin")) {
				error = 0;
				
			}
			else if (lang.equals("Spainish")) {
				error = 0;
				
			}
			else if (lang.equals("Japanese")) {
				error = 0;
			}
			else if (lang.equals("Russian")) {
				error = 0;
			}
			else if (lang.equals("Korean")) {
				error = 0;
			}
			else if (lang.equals("Greek")) {
				error = 0;
			}
			else if (lang.equals("Turkish")) {
				error = 0;
			}
			else if (lang.equals("German")) {
				error = 0;
			}
			else {
				
			}}
			return lang;}
		// Chooses what language AI will pick
		public static String langchoseai(){
			Random rand = new Random ();
			String langai = "";
			int numlang = rand.nextInt(8)+1;
		
			
			if (numlang == 1) {
				langai = "Mandarin";
				
			}
			else if (numlang == 2) {
				langai = "Spainish";
				
			}
			
			else if (numlang == 3) {
				langai = "Japanese";
				
			}
			else if (numlang == 4) {
				langai = "Russian";
				
			}
			else if (numlang == 5) {
				langai = "Korean";
				
			}
			else if (numlang == 6) {
				langai = "Greek";
				
			}
			else if (numlang == 7) {
				langai = "Turkish";
				
			}
			else if (numlang == 8) {
				langai = "German";
				
			}
			
			return langai;}
		// Gets the list of words from each language into an array
		public static String [] langlist(String[] language, String lang) {
			Scanner scan = new Scanner (System.in);
			int error = 1;
			while(error == 1) {
				error = 0;
		
		
if (lang.equals("Mandarin")) {
			language [0] = "ba4ng";
			language [1] = "ba4o qia4n";
			language [2] = "ko3ng bu4";
			language [3] = "we1i xia3n";
			language [4] = "she1ng qi4";
			language [5] = "nia2n qi1ng";
			language [6] = "cha1";
			language [7] = "an1 ji4ng";
			language [8] = "ho1ng";
			language [9] = "ma4n";
			
	
		}

else if (lang.equals("Spainish")) {
	language [0] = "tenedor";
	language [1] = "chuchara";
	language [2] = "Cuchillo";
	language [3] = "hija";
	language [4] = "manana";
	language [5] = "despue2s";
	language [6] = "aqui2";
	language [7] = "antigua";
	language [8] = "nuevo";
	language [9] = "pequeno";
	
	
}
else if (lang.equals("Japanese")) {
	language [0] = "ookii";
	language [1] = "yoi";
	language [2] = "tanoshii";
	language [3] = "totemo";
	language [4] = "densha";
	language [5] = "kuruma";
	language [6] = "heya";
	language [7] = "mizu";
	language [8] = "eiga";
	language [9] = "machi";
	
	
}
else if (lang.equals("Russian")) {
	language [0] = "nozh";
	language [1] = "derevo";
	language [2] = "sneg";
	language [3] = "skobka";
	language [4] = "protivnik";
	language [5] = "doroga";
	language [6] = "tufli";
	language [7] = "pochta";
	language [8] = "kamen'";
	language [9] = "bashnya";
	
	

}
else if (lang.equals("Korean")) {
	language [0] = "cholog";
	language [1] = "gong";
	language [2] = "sogogi";
	language [3] = "teuleog";
	language [4] = "badag";
	language [5] = "chong";
	language [6] = "bich";
	language [7] = "yangtanja";
	language [8] = "gisbal";
	language [9] = "byeogdol";
	
	

	
}
else if (lang.equals("Greek")) {
	language [0] = "ki2trino";
	language [1] = "ko2kino";
	language [2] = "tei2xos";
	language [3] = "dro2mo";
	language [4] = "daxtilo";
	language [5] = "ske2los";
	language [6] = "da2ktilo";
	language [7] = "so2ma";
	language [8] = "pla2ti";
	language [9] = "o2mos";
	
	
	
}
else if (lang.equals("Turkish")) {
	language [0] = "herhangi";
	language [1] = "yeni";
	language [2] = "almak";
	language [3] = "olsun";
	language [4] = "zemin";
	language [5] = "elma";
	language [6] = "tolga (shout out to Tolga btw he's a cool guy)";
	language [7] = "sonra";
	language [8] = "kulak";
	language [9] = "kol";
	
	

	
}
else if (lang.equals("German")) {
	language [0] = "haar";
	language [1] = "wasser";
	language [2] = "licht";
	language [3] = "welt";
	language [4] = "herzt";
	language [5] = "freund";
	language [6] = "fenster";
	language [7] = "tisch";
	language [8] = "umhauen";
	language [9] = "mauer";
	
	
	
	
}
else  {
	System.out.println ("error");
	error = 1;
}
}
			return language;
				}
// gets the translation of the languages
	public static String [] langlisttrans(String[] languagetrans, String lang) {
		Scanner scan = new Scanner (System.in);
		int error = 1;
		while(error == 1) {
			error = 0;
	
	
if (lang.equals("Mandarin")) {
		
	languagetrans [0] = "stick";
	languagetrans [1] = "sorry";
	languagetrans [2] = "horror";
	languagetrans [3] = "danger";
	languagetrans [4] = "anger";
	languagetrans [5] = "young";
	languagetrans [6] = "difference";
	languagetrans [7] = "quiet";
	languagetrans [8] = "red";
	languagetrans [9] = "slow";

	}

else if (lang.equals("Spainish")) {
	languagetrans [0] = "fork";
	languagetrans [1] = "spoon";
	languagetrans [2] = "knive";
	languagetrans [3] = "daughter";
	languagetrans [4] = "tommorow";
	languagetrans [5] = "after";
	languagetrans [6] = "here";
	languagetrans [7] = "old";
	languagetrans [8] = "new";
	languagetrans [9] = "small";



}
else if (lang.equals("Japanese")) {
	languagetrans [0] = "big";
	languagetrans [1] = "good";
	languagetrans [2] = "enjoyable";
	languagetrans [3] = "very";
	languagetrans [4] = "train";
	languagetrans [5] = "car";
	languagetrans [6] = "room";
	languagetrans [7] = "water";
	languagetrans [8] = "movie";
	languagetrans [9] = "town";



}
else if (lang.equals("Russian")) {
	languagetrans [0] = "knife";
	languagetrans [1] = "tree";
	languagetrans [2] = "snow";
	languagetrans [3] = "bracelet";
	languagetrans [4] = "opponent";
	languagetrans [5] = "road";
	languagetrans [6] = "shoes";
	languagetrans [7] = "mail";
	languagetrans [8] = "stone";
	languagetrans [9] = "tower";




}
else if (lang.equals("Korean")) {

	languagetrans [0] = "green";
	languagetrans [1] = "ball";
	languagetrans [2] = "beef";
	languagetrans [3] = "truck";
	languagetrans [4] = "opponent";
	languagetrans [5] = "road";
	languagetrans [6] = "shoes";
	languagetrans [7] = "mail";
	languagetrans [8] = "stone";
	languagetrans [9] = "tower";




}
else if (lang.equals("Greek")) {

	languagetrans [0] = "yellow";
	languagetrans [1] = "red";
	languagetrans [2] = "wall";
	languagetrans [3] = "road";
	languagetrans [4] = "finger";
	languagetrans [5] = "leg";
	languagetrans [6] = "toe";
	languagetrans [7] = "body";
	languagetrans [8] = "back";
	languagetrans [9] = "shoulder";



}
else if (lang.equals("Turkish")) {
	languagetrans [0] = "any";
	languagetrans [1] = "new";
	languagetrans [2] = "take";
	languagetrans [3] = "get";
	languagetrans [4] = "floor";
	languagetrans [5] = "apple";
	languagetrans [6] = "helmet";
	languagetrans [7] = "after";
	languagetrans [8] = "ear";
	languagetrans [9] = "arm";




}
else if (lang.equals("German")) {
	languagetrans [0] = "hair";
	languagetrans [1] = "water";
	languagetrans [2] = "light";
	languagetrans [3] = "world";
	languagetrans [4] = "heart";
	languagetrans [5] = "friend";
	languagetrans [6] = "window";
	languagetrans [7] = "toe";
	languagetrans [8] = "floor";
	languagetrans [9] = "wall";





}
else  {
System.out.println ("error");
error = 1;
}
}
		return languagetrans;
			}
	// Puts the translations and langauges in flashcard program to display to the user
	public static void flashcards (String[] languagetrans, String [] language ) {
		Scanner scan = new Scanner (System.in);
		int replay = 1;
		while (replay == 1) {
			
System.out.println("Note the some languages have a 1,2,3 or 4 in their words this indicates the way they should be pronouned \n for example a1 would be a flat tone \n a2 would be a rising tone \n a3 would be a falling and rising tone \n a4 would be a falling tone \n Memorize these words if you want to succeed!!!");
for(int i = 0; i<10;) {
	
	System.out.println(language[i]);
	System.out.println(languagetrans[i]);
	String t = scan.nextLine();
	i++;


}System.out.println("To go through the flashcards again type again otherwise press ENTER to continue");
String reps = scan.nextLine();
if(reps.equals("again")) {
	replay = 1;
}
else {
	replay = 0;
}
}
		
	}
	// Draws the board
	 public static void drawBoard(int p1, int p2, int [] plands){
		 // This the two are for check what property number it is
		    int topCount = 1;
		    int bottomCount = 40;
		    //bottom two are for ownership status number
		    int topCountplands = 0;
		    int bottomCountplands = 39;
		    
// The way this method works is with for loops that it first print a top row, then it prints out the middle rows and then the bottom rows
		    //does top row
		    for (int i=0; i<11; i++){
		    	if (i >= 1 && i <= 9 && i != 5) {
		      System.out.print("P" + topCount + " " + plands[topCountplands] + checkPlayer(p1, p2, topCount) + "  ");
		      //Increment top count
		      topCount++;
		      topCountplands++;
		    }
		    	else if (i == 5) {
		    		 System.out.print("C" + checkPlayer(p1, p2, topCount) + "  ");
				      //Increment top count
				      topCount++;
				      topCountplands++;}
              else if (i == 0) {
		    		 System.out.print("G" + checkPlayer(p1, p2, topCount) + "  ");
				      //Increment top count
				      topCount++;
				      topCountplands++;}
              else {
                System.out.print(":)" + checkPlayer(p1, p2, topCount) + "  ");
				      //Increment top count
                topCount++;
                topCountplands++;
              }
              
		    	}
		    //new line for formatting
		    System.out.print("\n\n");

		    //does middle rows
		    for (int i=0; i<9; i++){
              if (i != 4) {
		      //position on the left side of the board
		      System.out.print("P"+ bottomCount + " "+ plands[bottomCountplands] + checkPlayer(p1, p2, bottomCount) );
		      //Increment bottom count
		      bottomCount--;
		      bottomCountplands--;

		      //prints out the middle padding/spaces
		      for (int j=0; j<50; j++){
		        System.out.print(" ");
		      }

		      //Position on the right side of the board
		      System.out.print("P" + topCount + " " + plands[topCountplands] +  checkPlayer(p1, p2, topCount));
		      //Increment top count
		      topCount++;
		      topCountplands++;

		      //new line for formatting
		      System.out.print("\n\n");
              }
              else{
            	//position on the left side of the board
    		      System.out.print("C" + checkPlayer(p1, p2, bottomCount) );
    		      //Increment bottom count
    		      bottomCount--;
    		      bottomCountplands--;


    		      //prints out the middle padding/spaces
    		      for (int j=0; j<52; j++){
    		        System.out.print(" ");
    		      }

    		      //Position on the right side of the board
    		      System.out.print("C" + checkPlayer(p1, p2, topCount));
    		      //Increment top count
    		      topCount++;
    		      topCountplands++;

    		      //new line for formatting
    		      System.out.print("\n\n");
            	  }
              }

		    //does the bottom row
		    for (int i=0; i<11; i++){
		    	if (i >= 1 && i <= 9 && i != 5) {
		      System.out.print("P" + bottomCount + " "+ plands[bottomCountplands] +  checkPlayer(p1, p2, bottomCount ) + " ");
		      //Increment bottom count
		      bottomCount--;
		      bottomCountplands--;}
		      else if (i == 5){
		    		 System.out.print("C" + checkPlayer(p1, p2, bottomCount) + "  ");
				      //Increment bottom count
				      bottomCount--;
				      bottomCountplands--;}
              else {
                System.out.print(":)" + checkPlayer(p1, p2, bottomCount) + "  ");
				      //Increment bottom count
				      bottomCount--;
				      bottomCountplands--;
              }
		    }

		  }
           // Checks the position of a player
		  public static String checkPlayer(int p1, int p2, int pos){
		    String player = "";

		    if (p1 == pos){
		      player += "+";
		    }
		    if (p2 == pos){
		      player += "*";
		    }

		    return(player);
		  }
		  // pulls up a random for the user to translate
		  public static int randlang (String[] languagetrans, String[] language, int bal) {
			  if (bal > 0) {
			  Scanner scan = new Scanner (System.in);
			  Random rand = new Random ();
			  int i = rand.nextInt((9)+1);
			  System.out.println("\n What does "+ language[i]+" mean");
			  String ans = scan.next();
			  if (ans.equals(languagetrans[i])){
				  System.out.println("You are right, heres $200 dollars!");
				  int win = 200;
				  return win;
				  
			  }
			  else {
				  System.out.println("You are wrong, say goodbye to your $200 dollars");
				  int win = -200;
				  return win;    
			  }}
			  else {
				  int win = 0;
				 
				  return win; 
				  
			  }
				
				
			  }
		  //checks if translation was right or wrong
		  public static int fortune (int win) {
			  if(win == 200) {
				  int fortune = 1;
				  return fortune;
			  }
			  else {
				  int fortune = 0;
				  return fortune;
			  }
		  }
		  // checks the users balance
			  public static int balcheck (int bal, int win) { 
				  bal = bal+win;
				  System.out.println(" balance is $" + bal);
				  return bal;
			  }
			  //Changes postion with two numbers that can be from 1 to 6 
			  public static int dice (int p, int bal) { 
				  Scanner scan = new Scanner (System.in);
				  if (bal > 0) {
					 
					   Random rand = new Random();
					   int i = rand.nextInt(6)+1;
					   int y = rand.nextInt(6)+1;
					 if (i == 1) {
						 System.out.println("____________\n|          |\n|     .    |\n|          |\n____________");
					 }
					 else if (i == 2) {
						 System.out.println("____________\n|          |\n|  .     . |\n|          |\n____________");
					 }
					 else if (i == 3) {
						 System.out.println("____________\n|          |\n|  .  .  . |\n|          |\n____________");
					 }
					 else if (i == 4) {
						 System.out.println("____________\n|    .     |\n| .      . |\n|    .     |\n____________");
					 }
					 else if (i == 5) {
						 System.out.println("____________\n|  .    .  |\n|    .     |\n|  .    .  |\n____________");
					 }
					 else if (i == 6) {
						 System.out.println("____________\n|  .    .  |\n|  .    .  |\n|  .    .  |\n____________");
					 }
					 
					 scan.nextLine();
					 if (y == 1) {
						 System.out.println("____________\n|          |\n|     .    |\n|          |\n____________");
					 }
					 else if (y == 2) {
						 System.out.println("____________\n|          |\n|  .     . |\n|          |\n____________");
					 }
					 else if (y == 3) {
						 System.out.println("____________\n|          |\n|  .  .  . |\n|          |\n____________");
					 }
					 else if (y == 4) {
						 System.out.println("____________\n|    .     |\n| .      . |\n|    .     |\n____________");
					 } 
					 else if (y == 5) {
						 System.out.println("____________\n|  .    .  |\n|    .     |\n|  .    .  |\n____________");
					 }
					 else if (y == 6) {
						 System.out.println("____________\n|  .    .  |\n|  .    .  |\n|  .    .  |\n____________");
					 }
					 scan.nextLine();
					   System.out.println("you rolled a "+i+" and a "+y);
					   int dice = i+y+p;
					   if(dice > 40) {
						   dice = dice-40;
						   return dice;
					   }
					   else {
						   return dice;  
					   }
					  
				  }
				  else {int dice = 0;
					  return dice;
				  }
				  }
			  // what each property will say
			  public static String [] declaration(String [] lands) {
				
					
						 lands [0] = "You have passed go, heres $200 :)";
						 lands [1] = "Would you like to buy a tea store in London it costs $200";
						 lands [2] = "Would you like to buy a bread store in Paris it costs $200";
						 lands [3] = "Would you like to buy a noddle store in Taipei it costs $200";
						 lands [4] = "Would you like to buy a rubic's cube store in Budapest it costs $200";
						 lands [5] = "You rolled on a chance card, what will your fate be?";
						 lands [6] = "Would you like to buy a house in Los Angeles it costs $1000";
						 lands [7] = "Would you like to buy a house in Miami it costs $1000";
						 lands [8] = "Would you like to buy a house in Vancover it costs $1000 ";
						 lands [9] = "Would you like to buy a house in Toronto it costs $1000";
						 lands [10] = "You have entered the funny zone :))))))";
						 lands [11] = "Would you like to buy a gym in Sydney it costs $800";
						 lands [12] = "Would you like to buy a gym in Athens it costs $800";
						 lands [13] = "Would you like to buy a gym in Perth it costs $800";
						 lands [14] = "Would you like to buy a gym in Shanghai it costs $800";
						 lands [15] = "You rolled on a chance card, what will your fate be?";
						 lands [16] = "Would you like to buy a jet in Moscow it costs $1200";
						 lands [17] = "Would you like to buy a jet in Belgrade it costs $1200";
						 lands [18] = "Would you like to buy a jet in Aleppo it costs $1200";
						 lands [19] = "Would you like to buy a jet in Warsaw it costs $1200";
						 lands [20] = "You have entered the funny zone :))))))";
						 lands [21] = "Would you like to buy a mall in Saint Petersburg it costs $2000";
						 lands [22] = "Would you like to buy a mall in Almaty it costs $2000";
						 lands [23] = "Would you like to buy a mall in Barcelona it costs $2000";
						 lands [24] = "Would you like to buy a mall in Berlin it costs $2000";
						 lands [25] = "You rolled on a chance card, what will your fate be?";
						 lands [26] = "Would you like to buy a yaught in Limossol it costs $3000";
						 lands [27] = "Would you like to buy a yaught in Antalya it costs $3000";
						 lands [28] = "Would you like to buy a yaught in Santorini it costs $3000";
						 lands [29] = "Would you like to buy a mall in Montego Bay it costs $3000";
						 lands [30] = "You have entered the funny zone :))))))";
						 lands [31] = "Would you like to buy a club in Bali it costs $4000";
						 lands [32] = "Would you like to buy a club in Hong Kong it costs $4000";
						 lands [33] = "Would you like to buy a club in Cape Town it costs $4000";
						 lands [34] = "Would you like to buy a club in Mikonos it costs $4000";
						 lands [35] = "You rolled on a chance card, what will your fate be?";
						 lands [36] = "Would you like to buy a Penthouse in Dubai it costs $5000";
						 lands [37] = "Would you like to buy a  Penthouse in Busan it costs $5000";
						 lands [38] = "Would you like to buy a Penthouse in Tokyo it costs $5000";
						 lands [39] = "Would you like to buy a Penthouse in Bangkok it costs $5000";
						 return lands;
				
				  
			  }
			  // Checks what each land on the board is 
				  public static int landing(int bal, int p1, int fortune, String [] lands) {
					  if (bal <= 0) {
						  return bal;
					  }
					  else {
						  int landnum = p1-1;
						  if (landnum == 0 ) {
							 bal = bal+200;
							 System.out.println("You have passed go, heres $200 :)");
							 return bal;
							 
						  }
						  else if(landnum == 5 || landnum == 15 || landnum == 25 || landnum == 35 && fortune == 1 ) {
							  System.out.println("You rolled on a chance card, what will your fate be?");
							  System.out.println("Luck is sign of hard work, you shall be rewarded");
							  Random rand = new Random ();
							  int chance = rand.nextInt(4-1)+1;
							  if(chance == 1) {
								  System.out.println("Samar makes you eat an onion from Science club, she gives $100 for this ");
								  bal = bal+100;
								  return bal;
							  }
							  else if(chance == 2) {
								  System.out.println("You get $300 dollars from your growing youtube channel (subscribe to Nearhos on youtube rn) ");
								  bal = bal+300;
								  return bal;
							  }
							  else if(chance == 3) {
								  System.out.println("You get $500 from your protein powder company");
								  bal = bal+500;
								  return bal;
							  }
							  else if(chance == 4) {
								  System.out.println("You get a protein bar from Tolga at lunch, this speeds up the gains to the point that you win the olympia \n you and your family finacial suition has inproved, you have made it out of the trenches");
								  bal = bal+3000;
								  return bal;
							  }
							  
							  
						  }
						  else if   (landnum == 5 || landnum == 15 || landnum == 25 || landnum == 35 && fortune == 0 ) {
							  System.out.println("You rolled on a chance card, what will your fate be?");
							  System.out.println("you get what you give, you were not generous :(");
							  Random rand = new Random ();
							  int chance = rand.nextInt(4)+1;
							  if(chance == 1) {
								  System.out.println("You trip on a banana you pay $100 dollars in medical bills  ");
								  bal = bal-100;
								  return bal;
							  }
							  else if(chance == 2) {
								  System.out.println("You get a bad haircut, you pay $300 ");
								  bal = bal-300;
								  return bal;
							  }
							  else if(chance == 3) {
								  System.out.println("Janky code, bye bye $500");
								  bal = bal-500;
								  return bal;
							  }
							  else if(chance == 4) {
								  System.out.println("You have an existenial crisis say goodbye to $3000");
								  bal = bal-3000;
								  return bal;
							  }}
							  else if   (landnum == 10 || landnum == 20 || landnum == 30 ) {
								System.out.println("You have entered the funny zone :))))))");
								  Random rand1 = new Random ();
								  int chance1 = rand1.nextInt(4)+1;
								  if(chance1 == 1) {
									  System.out.println("banana, $100");
									  bal = bal+100;
									  return bal;
								  }
								  else if(chance1 == 2) {
									  System.out.println("Onion, $3000 ");
									  bal = bal+3000;
									  return bal;
								  }
								  else if(chance1 == 3) {
									  System.out.println("burger, say goodbye to $500");
									  bal = bal-500;
									  return bal;
								  }
								  else if(chance1 == 4) {
									  System.out.println("You smell like socks gimme $100");
									  bal = bal-100;
								  
							  }
							  }
						  
						  else{
							  return bal;  }
						  }
					return bal;}
				  //Checks ownership status of property
				  public static int landingpropeties( int p1, int [] plands) {
					  int indent = 0;
					  if(p1 == 0 || p1 == 1 || p1 == 6 || p1 == 11 || p1 == 16 || p1 == 21|| p1 == 26 || p1 == 31 || p1 == 36 ) {
						   indent = 3;
						  return indent;
					  }
					  else { int pos = p1-1;
					  int i = plands [pos];
					  if (i == 0) {
						  indent = 0;
						  return indent;  }
					  else if (i == 1) {
						  indent = 1;
						  return indent; 
					  }
					  else if (i == 2) {
						  indent = 2;
						  return indent; 
					  }
					  }
					return indent;
					  
				  }
	               // Declares an array of what the user owns and doesn't own
				  public static int [] pdeclaration(int [] plands) {
						for(int i = 0; i<39; i++) {
						
						 plands [i] = 0;
						}
					
						 return plands;
	
	
	
	
	// Allows the user to decide to purchase or not
	
	}  public static int yesorno( int p1, String [] lands) {
		Scanner scan = new Scanner (System.in);
	int i = p1-1;
	System.out.println("    \n"+lands[i]);
	System.out.println("Would you like to buy this property  type no to decline, press anything else to accept");
	String buy = scan.nextLine();
	int ubuy = 0;
	if(buy.equals("no")) {
		ubuy = 0;
	}
	else {
		ubuy = 1;
	}
	return ubuy;}
	// Changes what you own
	public static int [] ownerlistyou( int p1, int [] plands) {
		int i = p1-1;
		plands [i] = 1;
		return plands;
	}
	// Changes what other owns
	public static int [] ownerlistother( int p1, int [] plandsai) {
		int i = p1-1;
		plandsai [i] = 2;
		return plandsai;
	}
	// makes a purchase fee
	public static int bankwithdrawl( int p1,  int bal) {
		int i = p1-1;
		
		
		if(i == 1 || i == 2 || i == 3 || i == 4 ) { 
			bal = bal - 200;
			return bal;
			
		}
		else if (i == 6 || i == 7 || i == 8 || i == 9) {
			bal = bal - 1000;
			return bal;
		}
		
		else if (i == 11 || i == 12 || i == 13 || i == 14)
			{bal = bal - 800;
			return bal;}
		else if(	i == 16 || i == 17 || i == 18 || i == 19 ) {
			bal = bal - 1200;
			return bal;	
		}
		else if ( i == 21 || i == 22 || i == 23 || i == 24)
			{bal = bal - 2000;
			return bal;	}
		else if ( i == 26 || i == 27 || i == 28 || i == 29) {
			bal = bal - 3000;
			return bal;
		}
		else if ( i == 31 || i == 32 || i == 33 || i == 34)
			{bal = bal - 4000;
			return bal;}
		else if (i == 36 || i == 37 || i == 38 || i == 39 ) {
			bal = bal - 5000;
			return bal;
			
		}
		return bal;
	} //allow for a bonus if you land or your land
	public static int landbounus( int p1,  int bal) {
		int i = p1-1;
		
		
		if(i == 1 || i == 2 || i == 3 || i == 4 ) { 
			bal = bal + 200;
      System.out.println("You gain $200");
			return bal;
			
		}
		else if (i == 6 || i == 7 || i == 8 || i == 9) {
			bal = bal + 800;
      System.out.println("You gain $800");
			return bal;
		}
		
		else if (i == 11 || i == 12 || i == 13 || i == 14)
   { System.out.println("You gain $1000");
      bal = bal + 1000;
			return bal;}
		else if(	i == 16 || i == 17 || i == 18 || i == 19 ) {
			bal = bal + 1200;
      System.out.println("You gain $1200");
			return bal;	
		}
		else if ( i == 21 || i == 22 || i == 23 || i == 24){
       System.out.println("You gain $2000");
      bal = bal + 2000;
			return bal;	}
		else if ( i == 26 || i == 27 || i == 28 || i == 29) {
      System.out.println("You gain $3000");
			bal = bal + 3000;
			return bal;
		}
		else if ( i == 31 || i == 32 || i == 33 || i == 34)
			{bal = bal + 4000;
      System.out.println("You gain $4000");
			return bal;}
		else if (i == 36 || i == 37 || i == 38 || i == 39 ) {
      System.out.println("You gain $5000");
			bal = bal + 5000;
			return bal;
			
		}
		return bal;
	}
	//Penalizes you for landing on others property
	public static int landpenal( int p1,  int bal) {
		int i = p1-1;
		
		
		if(i == 1 || i == 2 || i == 3 || i == 4 ) { 
			bal = bal - 250;
			return bal;
			
		}
		else if (i == 6 || i == 7 || i == 8 || i == 9) {
			bal = bal - 850;
			return bal;
		}
		
		else if (i == 11 || i == 12 || i == 13 || i == 14)
			{bal = bal - 1500;
			return bal;}
		else if(	i == 16 || i == 17 || i == 18 || i == 19 ) {
			bal = bal - 1700;
			return bal;	
		}
		else if ( i == 21 || i == 22 || i == 23 || i == 24)
			{bal = bal - 2700;
			return bal;	}
		else if ( i == 26 || i == 27 || i == 28 || i == 29) {
			bal = bal - 3600;
			return bal;
		}
		else if ( i == 31 || i == 32 || i == 33 || i == 34)
			{bal = bal - 4700;
			return bal;}
		else if (i == 36 || i == 37 || i == 38 || i == 39 ) {
			bal = bal - 5500;
			return bal;
			
		}
		return bal;
	}
	// Checks if user won or lost
	  public static int  wincheck (int bal1) { 
		  int bal = bal1;
		 if(bal1 >= 1) {
		  System.out.println("P1's balance is $" + bal1);
		  return bal;
		  }
	  else {
		 
			  System.out.println("Corpbot wins :((((  \n Mr Langopoly: Your fired.............. ");
			  
			  return bal;
		  }
		 
	  }
	  //Shows random word to AI
		 public static int randlangai (String[] languagetrans, String[] language, int bal) {
		  if (bal > 0) {
		  Random rand = new Random ();
		
		  int i = rand.nextInt((9)+1);
		  System.out.println("\n What does "+ language[i]+" mean");
		  int ans = rand.nextInt(6)+1;
		  if (ans == 1){
			  System.out.println("OnIOn");
			  System.out.println("You are wrong, say goodbye to your $200 dollars");
			  int win = -200;
			  return win;
			  
		  }
		  else {
			  System.out.println(languagetrans[i]);
			  System.out.println("You are right, heres your $200 dollars");
			  int win = 200;
			  return win;    
		  }}
		  else {
			  int win = 0;
			 
			  return win; }
			  
		  }







             // Makes the AI decide on if it should buy or not
			public static int yesornoai( int p1, String [] lands, int bal) {
					
				int i = p1-1;
				System.out.println(lands[i]);
				System.out.println("Would you like to buy this property  type no to decline, press anything else to accept");
				
				int ubuy = 0;
				if (i >= 1 && i<= 4 && bal >= 400 ) {
				 ubuy = 1;
				 System.out.println("yes");
				}
				else if (i >= 1 && i<= 4 && bal <= 400 ) {
					 ubuy = 0;
					 System.out.println("no");
					}
				else if (i >= 6 && i<= 9  && bal >= 1200 ) {
					 ubuy = 1;
					 System.out.println("yes");
					}
				else if (i >= 6 && i<= 9  && bal <= 1200 ) {
					 ubuy = 0;
					 System.out.println("no");
					}
				else if (i >= 11 && i<= 14  && bal >= 1000 ) {
					 ubuy = 1;
					 System.out.println("yes");
					}
				else if (i >= 11 && i<= 14  && bal <= 1000 ) {
					 ubuy = 0;
					 System.out.println("no");
					}
				else if (i >= 16 && i<= 19  && bal >= 1400 ) {
					 ubuy = 1;
					 System.out.println("yes");
					}
				else if (i >= 16 && i<= 19  && bal <= 1400 ) {
					 ubuy = 0;
					 System.out.println("no");
					}
				else if (i >= 21 && i<= 24  && bal >= 2200 ) {
					 ubuy = 1;
					 System.out.println("yes");
					}
				else if (i >= 21 && i<= 24  && bal <= 2200 ) {
					 ubuy = 0;
					 System.out.println("no");
					}
				else if (i >= 26 && i<= 29  && bal >= 3200 ) {
					 ubuy = 1;
					 System.out.println("yes");
					}
				else if (i >= 26 && i<= 29  && bal <= 3200 ) {
					 ubuy = 0;
					 System.out.println("no");
					}
				else if (i >= 31 && i<= 34  && bal >= 4200 ) {
					 ubuy = 1;
					 System.out.println("yes");
					}
				else if (i >= 31 && i<= 34  && bal <= 4200 ) {
					 ubuy = 0;
					 System.out.println("no");
					}
				else if (i >= 36 && i<= 39  && bal >= 5200 ) {
					 ubuy = 1;
					 System.out.println("yes");
					}
				else if (i >= 36 && i<= 39  && bal <= 5200 ) {
					 ubuy = 0;
					 System.out.println("no");
					}

				return ubuy;	
			  
		  
	  }
			  public static int wincheckai (int bal1) { 
				  int bal = bal1;
			 if(bal >= 1) {
				  System.out.println("P2's balance is $" + bal);
				  return bal;
				  }
			  else {
				  
					  System.out.println(" \n P1 wins!!!! \n Mr Langopoly: hmmm, looks like you have just earned yourself a promotion!!!!");
					  return bal;
				  
				 }}}
					            
					
						  
					
							  
						
	
	

		
		
		
