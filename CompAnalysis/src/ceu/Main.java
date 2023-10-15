package ceu;
import java.util.Scanner;
import java.io.IOException;
import java.util.Date; 
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main
{
	static Scanner sc = new Scanner( System.in );
	static int rerunCount = 0;
	static InputValidation validation = new InputValidation();

	public static void main( String[] args ) throws IOException
	{
		while ( true )
		{		
			// WELCOME MESSAGE
			System.out.println( "\nPROFILYSIS: COMPREHENSIVE USER ANALYSIS SOFTWARE");
			System.out.println( "\nWelcome! To start your analysis, provide the following details. ");

			// CREATING NEW USER DATA OBJECT
			UserData user = new UserData();

			// FULL NAME INPUT & VALIDATION
			user.setfullName();	
			if ( !validation.FullName( user.getfullName() ) )
			{
				rerunCount++;
				continue;
			};

			// ADDRESS INPUT & VALIDATION
			user.setAddress();
			if ( !validation.Address( user.getAddress() ) )
			{
				rerunCount++;
				continue;
			};

			// COURSE INPUT & VALIDATION
			user.setCourse();
			if ( !validation.Course( user.getCourse() ) )
			{
				rerunCount++;
				continue;
			};

			// FAVE MOVIE INPUT & VALIDATION
			user.setFavMovie();
			if ( !validation.FavMovie( user.getFavMovie() ) )
			{
				rerunCount++;
				continue;
			};

			// FAVE FOOD INPUT & VALIDATION
			user.setFavFood();
			if ( !validation.FavFood( user.getFavFood() ) )
			{
				rerunCount++;
				continue;
			};

			// BIRTH DATE INPUT & VALIDATION
			user.setBirthDate();
			if ( !validation.BirthDate( user.getBirthDate() ) )
			{
				rerunCount++;
				continue;
			};

			// BIRTH PLACE INPUT & VALIDATION
			user.setBirthPlace();
			if ( !validation.BirthPlace( user.getBirthPlace() ) )
			{
				rerunCount++;
				continue;
			};

			// PREFERRED NO. OF CHILDREN INPUT & VALIDATION
			user.setPrefChildCount();
			if ( !validation.PrefChildCount( user.getPrefChildCount() ) )
			{
				rerunCount++;
				continue;
			};
			
			// ASSIGN DETAILS TO RESPECTIVE POJO
			// ObjectMapper objectMapper = new ObjectMapper();
			// objectMapper.writeValue( new File( "userdata.json" ), user );
			
			// GET THE REGION OF USER'S ADDRESS
			// TODO: Place code here
			
			// GET THE CLASSIFICATION OF USER'S COURSE
			// TODO: Place code here
			
			// GET NO. OF CONSONANTS & VOWELS IN USER'S FULL NAME
			String fullNameCheck = user.getfullName().toLowerCase();
			fullNameCheck = fullNameCheck.replaceAll( " ", "" );
			fullNameCheck = fullNameCheck.replaceAll( ".", "" );
			
			int consonantCount = 0;
			int  vowelCount = 0;
			
			for ( char letter : fullNameCheck.toCharArray() )
			{
				String letterString = Character.toString( letter );
				if ( letterString.matches( "[b-df-hj-np-tv-z]" ) )
				{
					consonantCount++;
				}
				else if ( letterString.matches( "[aeiou]" ) )
				{
					vowelCount++;
				}
			}

			// GET NO. OF WORDS IN USER'S FULL NAME
			String fullName = user.getfullName();
			String[] wordsInFullName = fullName.split( "\\s+" );
			int fullNameWordCount = wordsInFullName.length;
			
			// CHECK IF USER'S AGE IS SENIOR, MID, TEENAGER, CHILD, OR BABY
			// TODO: Place code here

			// GET ZODIAC SIGN OF THE USER
			// TODO: Place code here

			// IDENTIFY IF USER'S FAVE MOVIE IS ACTION, COMEDY, DRAMA, OR THRILLER
			// TODO: Place code here

			// IDENTIFY IF USER'S FAVE MOVIE CHARACTER IS A MAIN OR SUPPORTING CHARACTER
			// TODO: Place code here

			// GET THE BINARY, OCTAL, AND HEXADECIMAL VALUES OF FAVE NUMBER
			int favNum = user.getFavNum();
			String binaryValue = Integer.toBinaryString( favNum );
			String octalValue = Integer.toOctalString( favNum );
			String hexadecimalValue = Integer.toHexString( favNum );

			// PROVIDE PSYCH FEEDBACK BASED ON PREFCHILDNUM
			// TODO: Place code here

			
			
			
			// PLACEHOLDER VARIABLES
			String region = null;
			String courseCategory = null;
			String userFirstName = null;
			String ageCategory = null;
			String userZodiacSign = null;
			String movieCategory = null;
			String favMovieChar = null;
			String characterType = null;
			String psychEvaluation = null;
			
			// COMPREHENSIVE USER ANALYSIS REPORT
			System.out.println( "COMPREHENSIVE USER ANALYSIS REPORT" );
			String compAnalysisReport = user.getfullName() + " lives in " + user.getAddress() + "which can be found in " + region + 
										" . Their course, " +  user.getCourse() + " , is classified under " + courseCategory + 
										" . There are " + consonantCount + " consonants and " + vowelCount + " vowels in " + userFirstName + "'s full name. " +
										" There are also " + fullNameWordCount + " words in " + user.getfullName() + " . " + user.getfullName() + "'s age falls under the "
										+ ageCategory + " population. Their zodiac sign is " + userZodiacSign + "The user's favorite movie, " + user.getFavMovie() + ", falls under the " + movieCategory + "genre. "
										+ favMovieChar + ", " + user.getfullName() + "'s favorite movie character, is a " + characterType + " character. Their favorite number, " + user.getFavNum() + ", has a "
										+ "binary value of " + binaryValue + ", an octal value of " + octalValue + ", and a hexadecimal value of " + hexadecimalValue + ". Based on " + user.getfullName() + "'s "
										+ "preferred number of children, which is " + user.getPrefChildCount() + ", they " + psychEvaluation;
			
			// CHECK IF PARAGRAPH IS GREATER THAN 300 LETETRS
			String reportNoWhiteSpace = compAnalysisReport.replaceAll( " ", "" );
			int letterCount = reportNoWhiteSpace.length();
			
			if ( letterCount > 300 )
			{
				System.out.println( "\n" );	
			}
			
			// PROVIDE COMPREHENSIVE USER ANALYSIS REPORT TO USER
			System.out.println( compAnalysisReport );
			
			// GET REPLY FROM USER
			System.out.println( "What do you think about the report?" );
			System.out.println( ">>> " );
			
			String reply = sc.nextLine();
			
			// CHECK IF USER REPLY IS GREATER THAN 30 WORDS
			String[] words = reply.split( "\\s+" ); // Split the string by whitespace
			
			int replyWordCount = words.length; // Count the words
			System.out.println( "Reply word count: " + replyWordCount );	

			if ( replyWordCount > 30 )
			{
				System.out.println( "Do you want to play a game? Yes/No" );
				System.out.println( ">>> " );
				
				String answer = sc.nextLine();
				
				if ( answer.equalsIgnoreCase( "yes" ) )
				{
					AICar.main( args );
				}
				else if ( answer.equalsIgnoreCase( "no" ) )
				{
					System.exit( 0 );
				}
				else
				{
					System.out.println( "Invalid Input." ); // FIXME: Not much of a priority but fix the loop for this if we have spare time.
				}
			}
			else if ( replyWordCount == 30 )
			{
				System.exit( 0 );
			}
			else if ( replyWordCount < 30 )
			{
				MineSweeper minesweeper = new MineSweeper( 8, 8, 10 );
				minesweeper.playGame();			
			}
		}
	}
}
