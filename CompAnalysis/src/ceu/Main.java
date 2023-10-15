package ceu;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main
{
	static Scanner sc = new Scanner( System.in );
	static int rerunCount = 0;
	static InputValidation validation = new InputValidation();
	static String region;

	public static void main( String[] args ) throws IOException
	{
		while ( true )
		{		
			// WELCOME MESSAGE
			System.out.println( "\nPROFILYSIS: COMPREHENSIVE USER ANALYSIS SOFTWARE");
			System.out.println( "Welcome! To start your analysis, provide the following details. ");

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

			// FAVE NUMBER INPUT & VALIDATION
			user.setFavNum();
			if ( !validation.FavNumber( user.getFavNum() ) )
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
			
			// EVALUATION
			System.out.println( "\nEVALUATION");
			Evaluation evaluate = new Evaluation();

			// GET THE REGION OF USER'S ADDRESS
			// FIXME: Can't run code (access to file denied). Therefore, can't test. Please test.
			evaluate.getRegion( region, user );
			
			// GET THE CLASSIFICATION OF USER'S COURSE
			// FIXME: Add more code here
			String courseCategory = null; // <- use this variable 
			System.out.println( "Course Category: " + courseCategory );

			// GET NO. OF CONSONANTS & VOWELS IN USER'S FULL NAME
			int consonantCount = evaluate.fullNameConsonantCount( user.getfullName() );
			int vowelCount = evaluate.fullNameVowelCount( user.getfullName() );

			// GET NO. OF WORDS IN USER'S FULL NAME
			int wordCount = evaluate.fullNameWordCount( user.getfullName() );
			
			// CHECK IF USER'S AGE IS SENIOR, MID, TEENAGER, CHILD, OR BABY
			String ageCategory = evaluate.getAgeCategory( user );

			// GET ZODIAC SIGN OF THE USER
			// TODO: Place code here
			String userZodiacSign = null;
			String zodiacSign = evaluate.getZodiacSign( user.getBirthDate() );

			// IDENTIFY IF USER'S FAVE MOVIE IS ACTION, COMEDY, DRAMA, OR THRILLER
			// TODO: Place code here
			String movieCategory = null;

			// IDENTIFY IF USER'S FAVE MOVIE CHARACTER IS A MAIN OR SUPPORTING CHARACTER
			// TODO: Place code here
			String characterType = null;

			// GET THE BINARY, OCTAL, AND HEXADECIMAL VALUES OF FAVE NUMBER
			String binaryValue = evaluate.getFavNumBinary( user.getFavNum() );
			String octalValue = evaluate.getFavNumOctal( user.getFavNum() );
			String hexValue = evaluate.getFavNumHex( user.getFavNum() );

			// PROVIDE PSYCH FEEDBACK BASED ON PREFCHILDNUM
			evaluate.getPsychEval( user.getPrefChildCount() );
			String psychEval = evaluate.getPsychEval( user.getPrefChildCount() );
			
			// COMPREHENSIVE USER ANALYSIS REPORT
			System.out.println( "\nCOMPREHENSIVE USER ANALYSIS REPORT" );
			String compAnalysisReport = user.getfullName() + " lives in " + user.getAddress() + " which can be found in " + region + 
										". Their course, " +  user.getCourse() + ", is classified under CEU-Makati's " + courseCategory + 
										" . There are " + consonantCount + " consonants, " + vowelCount + " vowels, and " + wordCount + " words in " + user.getFirstName() + "'s full name." +
										" Their age falls under the " + ageCategory + " category. " + user.getFirstName() + "'s zodiac sign is " + userZodiacSign + 
										". Their favorite movie, " + user.getFavMovie() + ", falls under the " + movieCategory + " genre. "
										+ "Their favorite movie character, " + user.getFavMovieChar() + ", is a " + characterType + " character. Their favorite number ( " + user.getFavNum() + " ), has a "
										+ "binary value of " + binaryValue + ", an octal value of " + octalValue + ", and a hexadecimal value of " + hexValue + 
										". Based on their preferred number of children ( " + user.getPrefChildCount() + " ), " + psychEval;
			
			// CHECK IF PARAGRAPH IS GREATER THAN 300 LETETRS
			String reportNoWhiteSpace = compAnalysisReport.replaceAll( " ", "" );
			int letterCount = reportNoWhiteSpace.length();
			
			if ( letterCount > 300 )
			{
				System.out.println( "\n" );	
			}
			
			// PROVIDE COMPREHENSIVE USER ANALYSIS REPORT TO USER
			System.out.println( compAnalysisReport );
			System.out.println( "\nLetter Count: " + letterCount );
			
			// GET REPLY FROM USER
			System.out.println( "\nWhat do you think about the report?" );
			System.out.print( ">>> " );
			
			String reply = sc.nextLine();
			
			// CHECK IF USER REPLY IS GREATER THAN 30 WORDS
			String[] words = reply.split( "\\s+" );
			
			int replyWordCount = words.length;
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
				System.out.println( "\nMINESWEEPER" );
				MineSweeper minesweeper = new MineSweeper( 8, 8, 10 );
				minesweeper.playGame();			
			}
		}
	}
}
