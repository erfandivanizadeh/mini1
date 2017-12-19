//123456
/****************************

			Author:
			Erfan Divanizadeh - 160618297
			
			Mini-Project: Short Answer Sports Game program
			
*****************************/

import java.util.Random; //for the dice
import java.util.Scanner; //for scanning inputs

//this program is a Game that asks about sports

class mini1
{
	
	public static void main (String[] param)
	{	
		int totalScore = 0; //total scorePerQuestion variable

	
		System.out.println("\nWelcome to the Short Answer Football Game!\n");
		
		String menu = askGame("Please select an option:\n1. Play\n2. Exit\n"); //opening menu 
		
		if (menu.equals("1") || menu.equalsIgnoreCase("Play") || menu.equals("2") || menu.equalsIgnoreCase("Exit"))
		{
			if (menu.equals("1") || menu.equalsIgnoreCase("Play")) //if player decides to play
			{
				System.out.println("\nStarting Game...\n");
				startGame(totalScore);
				
			}//end play if
		
			if (menu.equals("2") || menu.equalsIgnoreCase("Exit")) //if player chooses to exit 
			{
				System.out.println("Exiting...\n");
				System.exit(0);
			}//end exit if
			
		}//end if 
		
		else
		{
			System.out.println("Invalid option. Please select an option from the menu.");
			System.exit(0);
		}//end while wrong
		
	
	}//end main
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void startGame(int totalScore) //starts menu
	{
		final int tries = 3;
		
		int pointsAwarded [][] = new int[5][2]; //arrays are used to assign numbers to the questions
		
        for (int k=0; k<=4; k++)
        {
        	pointsAwarded[k][0] = k + 1;
        } 
        
        
		for (int i=0; i<=4; i++) //for 1 
		{
			//int totalScore = overall;
			int number = questionGenerator();
			
			for (int n=tries; n>=1; n--) //for 2
			{
				boolean result = askQuestion(number);
				
				if (result == true)
				{
					correctAnswer();
					int scorePerQuestion = calculatePoints(result);
					totalScore += scorePerQuestion;
					pointsAwarded[i][1] = scorePerQuestion;
					
					if (scorePerQuestion == 1)
					{
						System.out.println("\nYou have received 1 point from a random dice roll.\n");
					}
					
					else
					{
						System.out.println("\nYou have received " + scorePerQuestion + " points from a random dice roll.\n");
					}
					
					System.out.println("You now have a total score of " + totalScore + " points.\n");
					
					break;
			
				}//end if
				
				else
				{
					if (n > 2)
					{
						System.out.println("Your answer is incorrect. You have 2 attempts left. Please try again.\n");
					}
				
					else if (n == 2)
					{
						System.out.println("Your answer is incorrect. You have 1 attempt left. Please try again.\n");
					}
				
					else if (n == 1)
					{
						System.out.println("You have failed all 3 attempts at this question.\n\n");
						break;
					}
				}//end else
			}//end for 2
			
			if (i == 4)
			{
				System.out.println("\n\nThank you for completing this session!\n");
			}
		}//end for 1
		
		
		pointsAwarded = sortingAlgorithm(pointsAwarded); // bubble sort method passed 
               
        
        // \t\t are used in the printed messages to make space between the words in a way that has a format of a table

        System.out.println("\nPoints Awarded\t\tQuestion Number");
        
        for (int m=0; m<=4; m++) //for loop for printing the table for question number and score for each in order
        {
            System.out.println("\t" + pointsAwarded[m][1] + "\t\t\t" + pointsAwarded[m][0]);
        }
        
        System.out.println("\n\n");
        System.out.println("You have achieved a total score of " + totalScore + " points during this session.");
		System.out.println("\nGoodbye!\nExiting...\n");
                
	}//end startGame()
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 	
 	public static int [][] sortingAlgorithm(int [][] pointsAwarded) //method for sorting the questions
    {
        int temp [] = new int[2]; 
        
        for (int i=0; i<4; i++)
        {
            for (int j=0; j<4-i; j++) 
            {
            	if (pointsAwarded[j][1] < pointsAwarded[j+1][1]) 
              	{
              		temp[0] = pointsAwarded[j][0]; //question
              		temp[1] = pointsAwarded[j][1]; //points given for that question
              		
              		pointsAwarded[j][0] = pointsAwarded[j+1][0]; // these are used to push the lowest scoring question to the bottom of the list
        			pointsAwarded[j][1] = pointsAwarded[j+1][1];
    	   			
    	   			pointsAwarded[j+1][0] = temp[0];
    	  			pointsAwarded[j+1][1] = temp[1];
              	}
            }
        }
        
        return pointsAwarded;
    
    }//end sortingAlgorithm()
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static int calculatePoints(boolean result) //uses 
	{
		if (result == true)
		{
			int number = numberDice(); //method that gives random dice number
			return number;
		}
		
		else
		{
			int number = 0;
			return number; 
		}
	}// end calculatePoints()

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static String askGame(String message) //method for scanning menu option input
	{
		Scanner scanner = new Scanner (System.in);
		String option;
		
		System.out.println(message);
		option = scanner.nextLine();
		
		return option;
	}//end askGame()

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void correctAnswer() //this method will print the following messages and uses the dice method to give points
	{
		final String message1 = "\nCorrect!";
		final String message2 = "Did you guess?";
		
		System.out.println(message1 + " " + message2);
	
	}//end correctAnswwer
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean askQuestion(int number) //this method is for array of records
	{
		
		
		String[][] bank = new String[5][3];
		
		if (number == 0)
		{	
			Game g1 = new Game(); 
			g1 = setQuestion(g1, "Who won 2016-2017 Premier League?");
			System.out.println(getQuestion(g1));
			g1 = setAnswer(g1, g1.answer);
			g1 = setCorrect(g1, "Chelsea");
			
			bank[0][0] = getQuestion(g1);
			bank[0][1] = getAnswer(g1);
			bank[0][2] = getCorrect(g1);
		}
		
		else if (number == 1)
		{
			Game g2 = new Game();
			g2 = setQuestion(g2, "Who won the 2016-2017 UEFA Champions League?");
			System.out.println(getQuestion(g2));
			g2 = setAnswer(g2, g2.answer);
			g2 = setCorrect(g2, "Real Madrid");
			
			bank[1][0] = getQuestion(g2);
			bank[1][1] = getAnswer(g2);
			bank[1][2] = getCorrect(g2);
		}
		
		else if (number == 2)
		{
			Game g3 = new Game();
			g3 = setQuestion(g3, "What team does Gerrard Pique play for this season?");
			System.out.println(getQuestion(g3));
			g3 = setAnswer(g3, g3.answer);
			g3 = setCorrect(g3, "Barcelona");
			
			bank[2][0] = getQuestion(g3);
			bank[2][1] = getAnswer(g3);
			bank[2][2] = getCorrect(g3);
		}
		
		else if (number == 3)
		{
			Game g4 = new Game();
			g4 = setQuestion(g4, "What country won the World Cup in 2010?");
			System.out.println(getQuestion(g4));
			g4 = setAnswer(g4, g4.answer);
			g4 = setCorrect(g4, "Spain");
			
			bank[3][0] = getQuestion(g4);
			bank[3][1] = getAnswer(g4);
			bank[3][2] = getCorrect(g4);
		}
		
		else if (number == 4)
		{
			Game g5 = new Game();
			g5 = setQuestion(g5, "What is the name of Arsenal's stadium?");
			System.out.println(getQuestion(g5));
			g5 = setAnswer(g5, g5.answer);
			g5 = setCorrect(g5, "Emirates");
			
			bank[4][0] = getQuestion(g5);
			bank[4][1] = getAnswer(g5);
			bank[4][2] = getCorrect(g5);
		}
		
		else if (number == 5)
		{
			Game g6 = new Game();
			g6 = setQuestion(g6, "Who won the FA cup in the 2016-2017 season?");
			System.out.println(getQuestion(g6));
			g6 = setAnswer(g6, g6.answer);
			g6 = setCorrect(g6, "Arsenal");
			
			bank[5][0] = getQuestion(g6);
			bank[5][1] = getAnswer(g6);
			bank[5][2] = getCorrect(g6);
		}
		
		boolean outcome;
		outcome = answerEvaluation(bank , number); //takes the values of both the input answer and the correct answer from the array of records
															  //and uses them as arguments in the method for answer evaluation
		return outcome;
		
	}//end askQuestion()
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static int questionGenerator() //generates the random number to use for generating a question
	{
		Random dice = new Random();
		int question = dice.nextInt(5);
		return question;
		
	}//end questionGenerator()
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static int numberDice() //generates the random dice number
	{
		Random dice = new Random();
		int dicethrow = dice.nextInt(6) + 1; //we add 1 to the dice number because we want scores like 1,2,3,4,5,6 rather than 0,1,2,3,4,5
		return dicethrow; //returns value of dice
	
	}//end numberDice()
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean answerEvaluation (String [][] bank, int number) //this method uses these two arguments to know what to do in askQuestion()
	{
		String answer = bank[number][1];
		String correct = bank[number][2];
		
		if (answer.equalsIgnoreCase(correct)) 
		{
			boolean state;
			state = true;
			return state;
		}
		
		else
		{
			boolean state;
			state = false;
			return state;
		}
	
	}//end trueFalse()
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//getter methods
	public static String getQuestion (Game g)
	{
		return g.question;
	}
	
	public static String getAnswer (Game g)
	{
		return g.answer;
	}
	
	public static String getCorrect (Game g)
	{
		return g.correct;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//setter methods
	public static Game setQuestion (Game g, String quizquestion)
	{
		g.question = quizquestion;
		return g;
	}
	
	public static Game setAnswer (Game g, String quizanswer)
	{
		quizanswer = inputString(); //there is a method below for input of answer
		g.answer = quizanswer;
		return g;
	}
	
	public static Game setCorrect (Game g, String quizcorrect)
	{
		g.correct = quizcorrect;
		return g;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static String inputString() //method for inputing answer
	{
		Scanner scanner = new Scanner(System.in);
		
		String answer;
		 
		answer = scanner.nextLine(); //the input is written under the questions
		return answer; //this answer is return to the setAnswer method to store it in the records
	
	}//end inputString()

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
}//end class mini1

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Game //creates new class for records
{
	String question;
	String answer;
	String correct;
	
}//end class Game